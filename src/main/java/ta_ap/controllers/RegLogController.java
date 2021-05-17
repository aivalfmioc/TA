package ta_ap.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import ta_ap.exceptions.UsernameAlreadyExistsException;
import ta_ap.exceptions.UsernameDoesntExistsException;
import ta_ap.services.UserService;

import java.io.IOException;
import java.util.Objects;

public class RegLogController {

    @FXML
    private Text loginMessage;
    @FXML
    public Text registrationMessage;
    @FXML
    public PasswordField passwordField;
    @FXML
    public TextField usernameField;
    @FXML
    public ChoiceBox<String> role;

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
    public void handleLoginAction() {
        if (role.getValue().equals("Costumer")) {
            try {
                UserService.checkUser(usernameField.getText(), passwordField.getText(), role.getValue());
                loginMessage.getScene().setRoot(FXMLLoader.load(getClass().getResource("/costumer.fxml")));
            } catch (UsernameDoesntExistsException e) {
                loginMessage.setText(e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else  {
            try {
                UserService.checkUser(usernameField.getText(), passwordField.getText(), role.getValue());
                loginMessage.getScene().setRoot(FXMLLoader.load(getClass().getResource("/landlord.fxml")));
            } catch (UsernameDoesntExistsException e) {
                loginMessage.setText(e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
