package annotation.validator;

public class User {

    @NotEmpty(message = "this is empty")
    private String name;

    @Range(message = "1 < age < 100 plz", min = 1, max = 100)
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
