package ta_ap.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;

import java.io.IOException;

public class CostumerHomepage {
    public Button button;
    private FXMLLoader scene;

    public void gotoViewAcom(ActionEvent actionEvent) throws IOException {
        button.getScene().setRoot(FXMLLoader.load(getClass().getResource("/costumer.fxml")));
    }

    public FXMLLoader getScene() {
        return scene;
    }

    public void setScene(FXMLLoader scene) {
        this.scene = scene;
    }

    public void gotoReservation(ActionEvent actionEvent) throws IOException {

        button.getScene().setRoot(FXMLLoader.load(getClass().getResource("/acomodations.fxml")));
    }
}
