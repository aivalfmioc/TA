package ta_ap.services;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import  javafx.scene.control.Button;
import java.awt.*;

public class TableCostumer {
    private  final SimpleIntegerProperty ID;
    private  final SimpleStringProperty firstName;
    private  final SimpleStringProperty email;
    private  final SimpleStringProperty department;
    private  final SimpleIntegerProperty salary;


    public TableCostumer(Integer id, String firstname, String mail, String department, Integer salary)
    {
        this.ID = new SimpleIntegerProperty(id);
        this.firstName = new SimpleStringProperty(firstname);
        this.email =  new SimpleStringProperty(mail);
        this.department =  new SimpleStringProperty(department);
        this.salary =  new SimpleIntegerProperty(salary);
    }



    public int getEmpID() {
        return ID.get();
    }

    public void setEmpID(int id) {
        this.ID.set(id);
    }



    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstname) {
        firstName.set(firstname);
    }



    public String getEmail() {
        return email.get();
    }

    public void setEmail(String mail) {
        email.set(mail);
    }


    public String getDepartment() {
        return department.get();
    }

    public void setDepartment(String street) {
        this.department.set(street);
    }



    public int getSalary() {
        return salary.get();
    }

    public void setSalary(int salary) {
        this.salary.set(salary);
    }

}

