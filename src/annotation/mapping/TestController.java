package annotation.mapping;

public class TestController {
    @SimpleMapping("home")
    public void home() {
        System.out.println("TestController.home");
    }

    @SimpleMapping("site1")
    public void page1() {
        System.out.println("TestController.page1");
    }


}
