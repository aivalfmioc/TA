package ta_ap.services;

import javafx.beans.property.SimpleStringProperty;

public class DescriptionA extends TheImages {
    private SimpleStringProperty description;
   public DescriptionA(String description){
       setDescription(description);
   }
    public String getDescription(){
        return description.get();
    }
    public void  setDescription(String description){
        this.description=new SimpleStringProperty(description);
    }
}

