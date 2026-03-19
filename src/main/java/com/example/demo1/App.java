package com.example.demo1;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class App extends Application {

    private Stage primaryStage;
    private Scene loginScene, registryScene;
    private ObservableList<Vehicle> vehicleList = FXCollections.observableArrayList();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Vehicle Management System");

        createLoginScene();
        createRegistryScene();

        primaryStage.setScene(loginScene);
        primaryStage.show();
    }

    private void createLoginScene() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(15);
        grid.setPadding(new Insets(25));

        Text title = new Text("System Login");
        title.setFont(Font.font("Ariel", FontWeight.BOLD, 24));
        grid.add(title, 0, 0, 2, 1);

        grid.add(new Label("User:"), 0, 1);
        TextField userField = new TextField();
        grid.add(userField, 1, 1);

        grid.add(new Label("Password:"), 0, 2);
        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);

        Button loginBtn = new Button("Login");
        Text statusTxt = new Text();
        statusTxt.setFill(Color.FIREBRICK);

        loginBtn.setOnAction(e -> {
            if (userField.getText().equals("admin") && pwBox.getText().equals("123456")) {
                primaryStage.setScene(registryScene);
            } else {
                statusTxt.setText("Access Denied.");
            }
            if (userField.getText().equals("ralph") && pwBox.getText().equals("hello")) {
                primaryStage.setScene(registryScene);
            } else {
                statusTxt.setText("Access Denied.");
            }
            if (userField.getText().equals("sir") && pwBox.getText().equals("2025")) {
                primaryStage.setScene(registryScene);
            } else {
                statusTxt.setText("Access Denied.");

            }
            if (userField.getText().equals("Joe") && pwBox.getText().equals("300")) {
                primaryStage.setScene(registryScene);
            } else {
                statusTxt.setText("Access Denied.");

        });

        grid.add(loginBtn, 1, 4);
        grid.add(statusTxt, 1, 5);

        loginScene = new Scene(grid, 400, 350);
    }

    private void createRegistryScene() {
        VBox layout = new VBox(15);
        layout.setPadding(new Insets(20));

        GridPane form = new GridPane();
        form.setHgap(10);
        form.setVgap(8);

        TextField makeIn = new TextField();
        TextField modelIn = new TextField();
        TextField yearIn = new TextField();
        TextField plateIn = new TextField();
        TextField fuelIn = new TextField();
        TextField colorIn = new TextField();
        TextField ownerIn = new TextField();

        form.add(new Label("Make:"), 0, 0); form.add(makeIn, 1, 0);
        form.add(new Label("Model:"), 0, 1); form.add(modelIn, 1, 1);
        form.add(new Label("Year:"), 0, 2); form.add(yearIn, 1, 2);
        form.add(new Label("Plate:"), 2, 0); form.add(plateIn, 3, 0);
        form.add(new Label("Fuel:"), 2, 1); form.add(fuelIn, 3, 1);
        form.add(new Label("Color:"), 2, 2); form.add(colorIn, 3, 2);
        form.add(new Label("Owner:"), 0, 3); form.add(ownerIn, 1, 3);

        Button addBtn = new Button("Add Vehicle");
        Button aboutBtn = new Button("About System");

        TableView<Vehicle> table = new TableView<>(vehicleList);

        TableColumn<Vehicle, String> c1 = new TableColumn<>("Make");
        c1.setCellValueFactory(new PropertyValueFactory<>("make"));

        TableColumn<Vehicle, String> c2 = new TableColumn<>("Model");
        c2.setCellValueFactory(new PropertyValueFactory<>("model"));

        TableColumn<Vehicle, String> c3 = new TableColumn<>("Year");
        c3.setCellValueFactory(new PropertyValueFactory<>("year"));

        TableColumn<Vehicle, String> c4 = new TableColumn<>("Plate");
        c4.setCellValueFactory(new PropertyValueFactory<>("plateNumber"));

        table.getColumns().addAll(c1, c2, c3, c4);

        addBtn.setOnAction(e -> {
            vehicleList.add(new Vehicle(makeIn.getText(), modelIn.getText(), yearIn.getText(),
                    plateIn.getText(), fuelIn.getText(), colorIn.getText(), ownerIn.getText()));

            makeIn.clear(); modelIn.clear(); yearIn.clear();
            plateIn.clear(); fuelIn.clear(); colorIn.clear(); ownerIn.clear();
        });

        aboutBtn.setOnAction(e -> {
            Stage secondStage = new Stage();
            secondStage.setTitle("Info");
            VBox box = new VBox(10, new Text("Vehicle Manager v1.0"), new Text("Developed for Assignment"));
            box.setAlignment(Pos.CENTER);
            secondStage.setScene(new Scene(box, 250, 150));
            secondStage.show();
        });

        HBox btnBox = new HBox(10, addBtn, aboutBtn);
        layout.getChildren().addAll(new Label("Register New Vehicle"), form, btnBox, table);

        registryScene = new Scene(layout, 750, 600);
    }
}