package com.scenebuilderproba;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class MainApplication extends Application {

    //This is our PrimaryStage (It contains everything)
    private Stage primaryStage;
    //This is the BorderPane of RootLayout
    private BorderPane rootLayout;
    @Override
    public void start(Stage primaryStage) {
        //1) Declare a primary stage (Everything will be on this stage)
        this.primaryStage = primaryStage;
        //Optional: Set a title for primary stage
        this.primaryStage.setTitle("Employee App Title");
        //2) Initialize RootLayout
        initRootLayout();
        //3) Display the EmployeeOperations View
        showEmployeeOperationsView();
    }
    //Initializes the root layout.
    public void initRootLayout() {
        try {
            //First, load root layout from RootLayout.fxml
            FXMLLoader loader = new FXMLLoader();
            URL url=MainApplication.class.getResource("/RootLayout.fxml");
            System.out.println("url "+url);

            loader.setLocation(MainApplication.class.getResource("/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();
            //Second, show the scene containing the root layout.
            Scene scene = new Scene(rootLayout); //We are sending rootLayout to the Scene.
            primaryStage.setScene(scene); //Set the scene in primary stage.
            //Third, show the primary stage
            primaryStage.show(); //Display the primary stage
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Shows the employee operations view inside the root layout.
    public void showEmployeeOperationsView() {
        try {
            //First, load EmployeeOperationsView from EmployeeView.fxml
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApplication.class.getResource("/EmployeeOperations.fxml"));
            BorderPane employeeOperationsView = (BorderPane) loader.load();
            // Set Employee Operations view into the center of root layout.
            rootLayout.setCenter(employeeOperationsView);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}