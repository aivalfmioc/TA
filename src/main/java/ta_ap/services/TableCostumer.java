package ta_ap.services;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class TableCostumer {
    private final SimpleStringProperty name;
    private final SimpleStringProperty desc;

    private final SimpleStringProperty phone;
    public TableCostumer(String name, String desc,  String phone) {
        this.name = new SimpleStringProperty(name);
        this.desc = new SimpleStringProperty(desc);

        this.phone= new SimpleStringProperty(phone);
    }

    public String getName() {
        return name.get();
    }
    public void setName(String name){
        this.name.set(name);
    }
    public String getDesc(){
        return desc.get();
    }
    public void setDescription(String desc) {
        this.desc.set(desc);
    }

    public String getPhone() {
        return phone.get();
    }

    public SimpleStringProperty phoneProperty() {
        return phone;
    }
}

