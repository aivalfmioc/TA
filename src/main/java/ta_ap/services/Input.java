package ta_ap.services;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Button;

public class Input {
    private String id;
    private String name;
    private String description;
    private String pets;
    private String price;
    public Input(){

    }
    /*
    public Input(String id, String name, String description, String pets, String price){
        this.id=id;
        this.name=name;
        this.description=description;
        this.pets=pets;
        this.price=price;
    }*/
    public Input(String id, String name, String description, String pets, String price){
        this.id=id;
        this.name=name;
        this.description=description;
        this.pets=pets;
        this.price=price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {

        System.out.println("b");
        this.name = name;
    }

    public String getPets() {
        return pets;
    }

    public void setPets(String pets) {
        this.pets = pets;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
