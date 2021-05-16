package ta_ap.controllers;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import ta_ap.services.TableCostumer;

import java.net.URL;
import java.util.ResourceBundle;

public class Costumer implements Initializable {

    public TableView<TableCostumer> tbv;
    public TableColumn<TableCostumer, String> name;
    public TableColumn<TableCostumer, String> desc;
    public TableColumn<TableCostumer, String> person;
    public TableColumn<TableCostumer, String> phone;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TableColumn name= new TableColumn<>("Name");
        TableColumn desc= new TableColumn<>("Description");
        TableColumn phone=new TableColumn<>("Phone");
        tbv.getColumns().addAll(name,desc,phone);
        final ObservableList<TableCostumer> list= FXCollections.observableArrayList(
                new TableCostumer("a","b","076543"),
                new TableCostumer("c","d","077654")
        );
        name.setCellValueFactory(new PropertyValueFactory<TableCostumer,String>("name"));
        desc.setCellValueFactory(new PropertyValueFactory<TableCostumer,String>("desc"));
        phone.setCellValueFactory(new PropertyValueFactory<TableCostumer,String>("phone"));
        tbv.setItems(list);

    }

}
