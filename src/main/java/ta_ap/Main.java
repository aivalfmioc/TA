package ta_ap;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import ta_ap.services.UserService;

import java.util.Objects;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        UserService.loadUsersFromFile();
        primaryStage.getIcons().add(new Image("https://icons.iconarchive.com/icons/wikipedia/flags/1024/RO-Romania-Flag-icon.png"));
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("register.fxml")));
        primaryStage.setTitle("TIMISOARA ACCOMMODATION");
        primaryStage.setScene(new Scene(root, 1000, 640));
        primaryStage.show();
    }
}
