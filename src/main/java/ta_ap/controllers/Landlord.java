package ta_ap.controllers;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import ta_ap.services.DescriptionA;
import ta_ap.services.TheImages;

import javax.swing.text.html.ImageView;
import java.io.*;

public class Landlord {
    @FXML
    public TableView<TheImages> tbv_;
    @FXML
    public TableColumn<TheImages, ImageView> tbc_;
    @FXML
    public TableColumn<DescriptionA,String> tbcn_;
    @FXML
    public TextField tf_imageinfo;
    @FXML
    public TextField tf_description;
    @FXML
    public TextField tf_phone;
    @FXML
    public TableColumn tbcp_;
    @FXML
    Button bt_phone;
    @FXML
    Button bt_submit;
    @FXML
    Button bt_description;

    ObservableList<TheImages> observabs= FXCollections.observableArrayList();
  //   ObservableList<DescriptionA> observabs2= FXCollections.observableArrayList();
    PropertyValueFactory<TheImages,ImageView> propval= new PropertyValueFactory<>("images");
    PropertyValueFactory<DescriptionA,String> propval2= new PropertyValueFactory<>("description");
    public void initialize(){
        tbv_.setItems(observabs);
        tbv_.setPlaceholder(new javafx.scene.control.Label("newlabel"));
        tbc_.setCellValueFactory(propval);
        tbcn_.setCellValueFactory(propval2);

       //bt_submit.setOnAction;
    }

    public void addtocollection(TheImages imgs){
        observabs.add(imgs);
    }
    public void createObj(javafx.event.ActionEvent actionEvent) {
        TheImages imgs= new TheImages(tf_imageinfo.getText());
        addtocollection(imgs);
    }
    public void addtocollection2(DescriptionA des){
        observabs.add(des);
    }
    public void add_description(ActionEvent actionEvent) throws IOException {
        DescriptionA d=new DescriptionA(tf_description.getText());

        File file1= new File("Description.txt");
        FileWriter fw= new FileWriter(file1, true);
        PrintWriter pw=new PrintWriter(fw);
        pw.write(tf_description.getText() + "\n");
        pw.close();
        addtocollection2(d);

    }

    public void btadd_phone(ActionEvent actionEvent) {

        DescriptionA d=new DescriptionA(tf_phone.getText());
        addtocollection2(d);
    }
}
