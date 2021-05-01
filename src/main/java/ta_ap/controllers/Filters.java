package ta_ap.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class Filters {

    public AnchorPane Filters;

    public void handleFiltersClick() {
        try {

            Filters.getScene().setRoot(FXMLLoader.load(getClass().getResource("/filter_page.fxml")));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
