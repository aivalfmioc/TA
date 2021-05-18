package ta_ap.controllers;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import ta_ap.services.Input;
import ta_ap.services.UserService;

import java.net.URL;
import java.util.ResourceBundle;

public class Landlord implements Initializable {

    public TableView<Input> tableview;
    public TableColumn<Input,String> idc;
    public TableColumn<Input,String> namec;
    public TableColumn<Input,String> descriptionc;
    public TableColumn<Input,String> petsc;
    public TableColumn<Input,String> pricec;
    public TextField id;
    public TextField description;
    public TextField price;
    public Button add;
    public TextField name;
    public TextField pets;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

          tableview.getItems().addAll(UserService.seeTable(RegLogController.getUsernameL()));
          idc.setCellValueFactory(new PropertyValueFactory<>("ID"));
          namec.setCellValueFactory(new PropertyValueFactory<>("Name"));
          descriptionc.setCellValueFactory(new PropertyValueFactory<>("Description"));
          petsc.setCellValueFactory(new PropertyValueFactory<>("Pets"));
          pricec.setCellValueFactory(new PropertyValueFactory<>("Price"));
          tableview.setEditable(true);
          idc.setCellFactory(TextFieldTableCell.forTableColumn());
          namec.setCellFactory(TextFieldTableCell.forTableColumn());
          descriptionc.setCellFactory(TextFieldTableCell.forTableColumn());
          petsc.setCellFactory(TextFieldTableCell.forTableColumn());
          pricec.setCellFactory(TextFieldTableCell.forTableColumn());
          tableview.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }
/*
    private void loadTable() {

        ObservableList<Input> table= FXCollections.observableArrayList();
        table.add(new Input(id.getText(),name.getText(),description.getText(),pets.getText(),price.getText()));
        tableview.setItems(table);
    }*/

    public void addtoTable(ActionEvent actionEvent) {
      Input acc1= new Input(id.getText(),name.getText(),description.getText(),pets.getText(),price.getText());
      tableview.getItems().add(acc1);
        try{
            UserService.saveTable(RegLogController.getUsernameL(), tableview.getItems());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public void deleteRow(ActionEvent actionEvent) {
        ObservableList<Input> sellectedRows, everything;
        everything=tableview.getItems();
        sellectedRows=tableview.getSelectionModel().getSelectedItems();
        for(Input data: sellectedRows){
            everything.remove(data);
        }
    }
}
