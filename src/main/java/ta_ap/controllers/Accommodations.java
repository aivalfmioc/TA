package ta_ap.controllers;

import com.fasterxml.jackson.databind.util.JSONPObject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import jdk.nashorn.internal.parser.JSONParser;
import ta_ap.model.User;
import ta_ap.services.UserService;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

import static ta_ap.services.UserService.users;

public class Accommodations implements Initializable {
    public TextField txtfield;
    public Button back;
  // public ObservableList<String> names;
    public ListView<String> list;
    public void addtoListview(ActionEvent actionEvent)  {
        if(UserService.checkExistsAccommodation(txtfield.getText()))
            list.getItems().add(txtfield.getText());
    }
    public void goback(ActionEvent actionEvent) throws IOException {
       back.getScene().setRoot(FXMLLoader.load(getClass().getResource("/costumer_homepage.fxml")));
    }
    public void removeListview(ActionEvent actionEvent) {
        int selectedId=list.getSelectionModel().getSelectedIndex();
        list.getItems().remove(selectedId);

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        User u=UserService.getUser();
        List<String> listacm=u.getReservations();
        list.getItems().addAll(listacm);
    }
}
