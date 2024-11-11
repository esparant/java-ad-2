package annotation.basic;

@AnnoMeta
public class MetaData {

    private String id;

    @AnnoMeta
    public void call() {

    }

    public static void main(String[] args) throws NoSuchMethodException {
        AnnoMeta annotation = MetaData.class.getAnnotation(AnnoMeta.class);
        System.out.println("class annotation = " + annotation);

        AnnoMeta annotation1 = MetaData.class.getMethod("call").getAnnotation(AnnoMeta.class);
        System.out.println("method annotation = " + annotation1);

    }
}
