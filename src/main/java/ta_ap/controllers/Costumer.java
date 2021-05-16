package ta_ap.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import ta_ap.services.TableCostumer;

public class Costumer implements Initializable {

    @FXML
    private Label label;
    @FXML private TextField filterField;
    @FXML private TableView<TableCostumer> tableview;
    @FXML private TableColumn<TableCostumer, String> id;
    @FXML private TableColumn<TableCostumer, String> empName;
    @FXML private TableColumn<TableCostumer, String> empEmail;
    @FXML private TableColumn<TableCostumer, String> department;
    @FXML private TableColumn<TableCostumer, String> salary;
    @FXML public TableColumn<TableCostumer, Button>action;


    //observalble list to store data
    private final ObservableList<TableCostumer> dataList = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle rb) {

        id.setCellValueFactory(new PropertyValueFactory<>("EmpID"));
        empName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        empEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        department.setCellValueFactory(new PropertyValueFactory<>("department"));
        salary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        action.setCellValueFactory(new PropertyValueFactory<>("reserve"));

        TableCostumer acc1 = new TableCostumer(112, "Pensiunea Ana", "beautifu AEIDIRERNFIRECFNREIFRBTR FVRGVTRG VDVl place", "YES", 30000, new Button());
        TableCostumer acc2 = new TableCostumer( 115, "Hotel Galaxy", "beautiful place", "YES", 40000, new Button());
        TableCostumer acc3 = new TableCostumer( 116, "Locanda Del Corso", "beautiful place", "NO", 80000,new Button("a"));
        TableCostumer acc4 = new TableCostumer(117, "Blueish", "beautiful place", "YES", 80000,new Button("a"));

        dataList.addAll(acc1,acc2, acc3, acc4);

        // Wrap the ObservableList in a FilteredList (initially display all data).
        FilteredList<TableCostumer> filteredData = new FilteredList<>(dataList, b -> true);

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
        sortedData.comparatorProperty().bind(tableview.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        tableview.setItems(sortedData);


    }

}
