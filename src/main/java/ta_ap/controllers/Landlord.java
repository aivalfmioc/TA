package ta_ap.controllers;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import ta_ap.services.Input;
import ta_ap.services.TheImages;

import javax.swing.text.html.ImageView;

public class Landlord {
    @FXML
    TableView<TheImages> tbv_;
    @FXML
    TableColumn<TheImages, ImageView> tbc_;
    @FXML
    TableColumn<Input,String> tbcn_;
    @FXML
    TextField tf_imageinfo;
    @FXML
    Button bt_submit;
    ObservableList<TheImages> observabs= FXCollections.observableArrayList();
    PropertyValueFactory<TheImages,ImageView> propval= new PropertyValueFactory<>("images");

    public void initialize(){
        tbv_.setItems(observabs);
        tbv_.setPlaceholder(new javafx.scene.control.Label("newlabel"));
        tbc_.setCellValueFactory(propval);
     //   bt_submit.setOnAction;
    }
    private void addtocollection(TheImages imgs){
        observabs.add(imgs);
    }
    public void createObj(javafx.event.ActionEvent actionEvent) {
        TheImages imgs= new TheImages(tf_imageinfo.getText());
        addtocollection(imgs);
    }
}
