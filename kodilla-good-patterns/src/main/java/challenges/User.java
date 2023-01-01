package challenges;

public class User {

    private final String username;
    private final String name;
    private final String surname;
    private final String address;

    public User(final String username, final String name, final String surname, final String address) {
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

}