package ta_ap.controllers;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import ta_ap.services.DescriptionA;
import ta_ap.services.Input;
import ta_ap.services.TheImages;

import javax.swing.text.html.ImageView;
import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Landlord implements Initializable {
    public TextField id;
    public TableView<Input> tableview;
    public TableColumn<Input,String> idc;
    public TableColumn<Input,String> namec;
    public TableColumn<Input,String> descriptionc;
    public TableColumn<Input,String> petsc;
    public TableColumn<Input,String> pricec;
    public TextField description;
    public TextField price;
    public Button add;
    public TextField name;
    public TextField pets;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
          idc.setCellValueFactory(new PropertyValueFactory<>("ID"));
          namec.setCellValueFactory(new PropertyValueFactory<>("Name"));
          descriptionc.setCellValueFactory(new PropertyValueFactory<>("Description"));
          petsc.setCellValueFactory(new PropertyValueFactory<>("Pets"));
          pricec.setCellValueFactory(new PropertyValueFactory<>("Price"));
    }
    public void addtoTable(ActionEvent actionEvent) {
        Input acc1= new Input(id.getText(),name.getText(),description.getText(),pets.getText(),price.getText());
        tableview.getItems().add(acc1);
    }


}
