package ta_ap.exceptions;

public class UsernameDoesntExistsException extends Throwable {
    private final String username;

    public UsernameDoesntExistsException(String username) {
        super(String.format("An account with the username %s does not exists!", username));
        this.username = username;
    }
    public String getUsername() {
        return username;
    }
}
