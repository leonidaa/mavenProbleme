package com.scenebuilderproba.controller;

import com.scenebuilderproba.model.Employee;
import com.scenebuilderproba.model.EmployeeDataAccessObject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import javafx.scene.control.TableView;
import java.awt.*;
import java.sql.Date;
import java.sql.SQLException;

public class EmployeeController {
    @FXML
    private TableView employeeTable;
    @FXML
    private TextField empIdText;
    @FXML
    private TextArea resultArea;
    @FXML
    private TextField newEmailText;
    @FXML
    private TextField nameText;
    @FXML
    private TextField surnameText;
    @FXML
    private TextField emailText;
    @FXML
    private TableColumn<Employee, Integer> empIdColumn;
    @FXML
    private TableColumn<Employee, String> empNameColumn;
    @FXML
    private TableColumn<Employee, String> empLastNameColumn;
    @FXML
    private TableColumn<Employee, String> empEmailColumn;
    @FXML
    private TableColumn<Employee, String> empPhoneNumberColumn;
    @FXML
    private TableColumn<Employee, Date> empHireDateColumn;

    @FXML
    private void searchEmployee(ActionEvent actionEvent) throws ClassNotFoundException, SQLException {
        try {
            Employee employee = EmployeeDataAccessObject.searchEmployee(empIdText.getText());
            populateAndShowEmployee(employee);
        } catch (SQLException e) {
            e.printStackTrace();
            resultArea.setText("Error occured \n "+e);
            throw e;
        }

    }

    @FXML
    private void populateAndShowEmployee(Employee employee) throws ClassNotFoundException {
        if (employee!=null)
        {
            populateEmployee(employee);
            setEmpInfoToTextArea(employee);
        }
        else {
            resultArea.setText("this employee does not exist\n ");
        }

    }


    private void setEmpInfoToTextArea( Employee employee) {
        resultArea.setText("FirstName"+employee.getFirstName()+" LastName"+employee.getLastName()+"\n");
    }
    @FXML
    private void populateEmployee(Employee employee ) throws ClassNotFoundException{
        ObservableList<Employee> observableList=FXCollections.observableArrayList();
        observableList.add(employee);
        employeeTable.setItems(observableList);

    }

}