package ta_ap.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import ta_ap.services.Input;
import ta_ap.services.UserService;

public class Costumer implements Initializable {

    public Button backbutton;
    public TableView <Input>tableviewcostumer;
    public Button reserve;
    @FXML
    private Label label;
    @FXML private TextField filterField;
    @FXML private TableColumn<Input, String> id;
    @FXML private TableColumn<Input, String> empName;
    @FXML private TableColumn<Input, String> empEmail;
    @FXML private TableColumn<Input, String> department;
    @FXML private TableColumn<Input, String> salary;


    //observalble list to store data
   private final ObservableList<Input> dataList = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle rb) {

        id.setCellValueFactory(new PropertyValueFactory<Input,String>("ID"));
        empName.setCellValueFactory(new PropertyValueFactory<Input,String>("Name"));
        empEmail.setCellValueFactory(new PropertyValueFactory<Input,String>("Description"));
        department.setCellValueFactory(new PropertyValueFactory<Input,String>("Pets"));
        salary.setCellValueFactory(new PropertyValueFactory<Input,String>("Price"));
        tableviewcostumer.getItems().addAll( UserService.seeCostumer(RegLogController.getUsernameL()));
    }
    /*
     // Wrap the ObservableList in a FilteredList (initially display all data).
       FilteredList<Input> filteredData = new FilteredList<>(dataList, b -> true);
       filteretData.getText()
        // 2. Set the filter Predicate whenever the filter changes.
        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(employee -> {
                // If filter text is empty, display all persons.

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (employee.getFirstName().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
                    return true; // Filter matches first name.
                } else if (employee.getDepartment().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches last name.
                }
                else if (String.valueOf(employee.getSalary()).indexOf(lowerCaseFilter)!=-1)
                    return true;
                else
                    return false; // Does not match.
            });
        });

        // 3. Wrap the FilteredList in a SortedList.
        SortedList<TableCostumer> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        // 	  Otherwise, sorting the TableView would have no effect.
        sortedData.comparatorProperty().bind(tableviewcostumer.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        tableviewcostumer.setItems(sortedData);


    }
*/
    public void goBack(ActionEvent actionEvent) throws IOException {
        backbutton.getScene().setRoot(FXMLLoader.load(getClass().getResource("/costumer_homepage.fxml")));
    }

    public void reserveAction(ActionEvent actionEvent) throws IOException {

        backbutton.getScene().setRoot(FXMLLoader.load(getClass().getResource("/reserve.fxml")));

    }

}
