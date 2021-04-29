package ta_ap.controllers;

import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import ta_ap.exceptions.UsernameAlreadyExistsException;
import ta_ap.services.UserService;

import java.io.IOException;
import java.util.Objects;

public class RegLogController {

    @FXML
    private Text loginMessage;
    @FXML
    private Text registrationMessage;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameField;
    @FXML
    private ChoiceBox<String> role;

    private JFXPanel btnScene1;

    public void initialize() {
        role.getItems().addAll("Costumer", "Landlord");
    }

    public void handleRegisterAction() {
        try {

            UserService.addUser(usernameField.getText(), passwordField.getText(), role.getValue());

            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("register.fxml")));
            registrationMessage.setText("Account created successfully!");
        } catch (UsernameAlreadyExistsException e) {
            registrationMessage.setText(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void handleLoginAction(ActionEvent e) {
        try {
            loginMessage.getScene().setRoot(FXMLLoader.load(getClass().getResource("/page1.fxml")));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
