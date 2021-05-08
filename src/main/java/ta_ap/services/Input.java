package ta_ap.services;

import javafx.scene.control.Button;

public class Input {
    String name, description, email;
    Button update;
    public Input(String name, String description, String email, Button update){
        this.name=name;
        this.description=description;
        this.email=email;
        this.update=update;
    }
}
