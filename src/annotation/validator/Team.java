package annotation.validator;

public class Team {

    @NotEmpty(message = "no no it's empty")
    private String name;

    @Range(message = "0 < memberCount < 1000 plz", min = 1, max = 999)
    private int memberCount;

    public Team(String name, int memberCount) {
        this.name = name;
        this.memberCount = memberCount;
    }

    public String getName() {
        return name;
    }

    public int getMemberCount() {
        return memberCount;
    }
}
