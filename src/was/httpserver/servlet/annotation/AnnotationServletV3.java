package was.httpserver.servlet.annotation;

import java.lang.ModuleLayer.Controller;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import was.httpserver.HttpRequest;
import was.httpserver.HttpResponse;
import was.httpserver.HttpServlet;
import was.httpserver.PageNotFoundException;

public class AnnotationServletV3 implements HttpServlet {

    private final Map<String, ControllerMethod> pathMap;

    public AnnotationServletV3(List<Object> controllers) {
        this.pathMap = new HashMap<>();
        initializePathMap(controllers);
    }

    private void initializePathMap(List<Object> controllers) {
        for (Object controller : controllers) {
            for (Method method : controller.getClass().getDeclaredMethods()) {
                if (method.isAnnotationPresent(Mapping.class)) {
                    String value = method.getAnnotation(Mapping.class).value();

                    if (pathMap.containsKey(value)) {
                        ControllerMethod controllerMethod = pathMap.get(value);
                        throw new IllegalStateException(
                                "path duplication: " + value +
                                ", method: " + method +
                                ", already existing method: " + controllerMethod.method);
                    }


                    pathMap.put(value, new ControllerMethod(controller, method));
                }
            }

        }
    }

    @Override
    public void service(HttpRequest request, HttpResponse response) {
        String path = request.getPath();
        ControllerMethod controllerMethod = pathMap.get(path);

        if (controllerMethod == null) {
            throw new PageNotFoundException("request = " + path);
        }

        controllerMethod.invoke(request, response);
    }

    private class ControllerMethod {
        private final Object controller;
        private final Method method;

        private ControllerMethod(Object controller, Method method) {
            this.controller = controller;
            this.method = method;
        }

        public void invoke(HttpRequest request, HttpResponse response) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            Object[] args = new Object[parameterTypes.length];

            for (int i = 0; i < parameterTypes.length; i++) {
                if (parameterTypes[i] == HttpRequest.class) {
                    args[i] = request;
                } else if (parameterTypes[i] == HttpResponse.class) {
                    args[i] = response;
                } else {
                    throw new IllegalArgumentException("unknown parameter type: " + parameterTypes[i]);
                }
            }
            try {
                method.invoke(controller, args);
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
