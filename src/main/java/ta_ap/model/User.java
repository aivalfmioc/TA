package ta_ap.model;

import ta_ap.services.Input;
import java.util.ArrayList;
import java.util.List;

public class User {

    private String username;
    private String password;
    private String role;

    private List<Input> schedule=new ArrayList<>();
    private List<String> reservations=new ArrayList<>();
    public User(){

    }

    public User(String username) {
        this.username=username;
    }

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return this.username;
    }
    public void setUsername(String username) {

        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
        return true;
    } else if (!(o instanceof User)) {
        return false;
    } else {
        User user = (User)o;
        boolean u = false;
        boolean p = false;
        if (this.password.equals(user.password)) {
            u = true;
        }

        if (this.username.equals(user.username)) {
            p = true;
        }

        return u && p;
    }
    }

    @Override
    public int hashCode() {
        int result = username.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + role.hashCode();
        return result;
    }
    @Override
    public String toString() {
        return "UserDTO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
    public List<Input> getSchedule() {
        return schedule;
    }
   // public String<Input> getName(){

  //  }
    public void setSchedule(List<Input> schedule) {
        this.schedule=schedule;
    }

    public List<String> getReservations() {
        return reservations;
    }

    public void setReservations(List<String> reservations) {
        this.reservations = reservations;
    }
}
