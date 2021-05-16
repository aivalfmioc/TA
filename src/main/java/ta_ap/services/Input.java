package ta_ap.services;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Button;

public class Input {
    SimpleStringProperty id;
    SimpleStringProperty name;
    SimpleStringProperty description;
    SimpleStringProperty pets;
    SimpleStringProperty price;

    public Input(String id, String name, String description, String pets, String price){
        this.id=new SimpleStringProperty(id);
        this.name=new SimpleStringProperty(name);
        this.description=new SimpleStringProperty(description);
        this.pets=new SimpleStringProperty(pets);
        this.price=new SimpleStringProperty(price);
    }
    public String getID(){
        return id.get();
    }
    public void setId(String id) {
        this.id.set(id);
    }
    public String getName(){
        return name.get();
    }
    public void setName(String name) {
        this.name.set(name);
    }
    public String getDescription() {
        return description.get();
    }
    public void setDescription(String description) {
        this.description.set(description);
    }
    public String getPets() {
        return pets.get();
    }
    public void setPets(String pets) {
        this.pets.set(pets);
    }
    public void setPrice(String price) {
        this.price.set(price);
    }
    public String getPrice(){
        return price.get();
    }
}
