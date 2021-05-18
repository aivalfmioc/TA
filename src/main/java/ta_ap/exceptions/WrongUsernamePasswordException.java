package ta_ap.exceptions;
public class WrongUsernamePasswordException extends Exception {
    private String username;
    private String password;

    public WrongUsernamePasswordException(String username, String password){
        super("The username or the password is incorrect");
        this.username=username;
        this.password=password;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() { return password; }
}
