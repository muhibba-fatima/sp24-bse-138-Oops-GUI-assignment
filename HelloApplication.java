package com.example.assignment2sp24bse138;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.util.ArrayList;
import javafx.scene.control.*;

public class HelloApplication extends Application {

    private ImageView imageView = new ImageView();

    @Override
    public void start(Stage stage) throws Exception {

        ArrayList<Person> personList = new ArrayList<>();

        Label titleLabel = new Label("Application Form");
        titleLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #800080;");
        VBox titleBox = new VBox(titleLabel);
        titleBox.setAlignment(Pos.CENTER);
        titleBox.setPadding(new Insets(10));

        titleBox.setStyle("-fx-border-color: #800080; -fx-border-width: 3px; -fx-border-radius: 10px; -fx-background-color: #FFFFFF;");

        Label nameLabel = new Label("Name");
        nameLabel.setStyle("-fx-text-fill: black; -fx-font-weight: bold");
        TextField nameField = new TextField();

        Label fnameLabel = new Label("Father Name");
        fnameLabel.setStyle("-fx-text-fill: black; -fx-font-weight: bold");

        TextField fnameField = new TextField();

        Label cnic = new Label("CNIC");
        cnic.setStyle("-fx-text-fill: black; -fx-font-weight: bold");
        TextField cnicField = new TextField();

        Label dateLabel = new Label("Date");
        dateLabel.setStyle("-fx-text-fill: black; -fx-font-weight: bold");
        DatePicker datePicker = new DatePicker();

        Label genderLabel = new Label("Gender");
        genderLabel.setStyle("-fx-text-fill: black; -fx-font-weight: bold");
        ToggleGroup genderGroup = new ToggleGroup();
        RadioButton male = new RadioButton("Male");
        RadioButton female = new RadioButton("Female");
        male.setToggleGroup(genderGroup);
        female.setToggleGroup(genderGroup);
        male.setStyle("-fx-text-fill: black;");
        female.setStyle("-fx-text-fill: black;");

        Label cityLabel = new Label("City");
        cityLabel.setStyle("-fx-text-fill: black; -fx-font-weight: bold");
        ComboBox<String> cityBox = new ComboBox<>();
        cityBox.getItems().addAll("Gujranwala", "Lahore", "Karachi", "Islamabad", "Peshawar", "Jehlum", "Faislabad");

        Button saveButton = new Button("Save");
        saveButton.setStyle("-fx-background-color: #800080; -fx-text-fill: white; -fx-font-weight: bold;");
        saveButton.setOnAction(e -> {

            String name = nameField.getText();
            String fatherName = fnameField.getText();
            String cnicNo = cnicField.getText();
            String date = datePicker.getValue().toString();
            String gender = male.isSelected() ? "Male" : "Female";
            String city = cityBox.getValue();

            Person person = new Person(name, fatherName, cnicNo, date, gender, city);
            personList.add(person);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Form saved");
                    alert.setHeaderText(null);
                    alert.setContentText("Form has been saved successfully.");
                    alert.showAndWait();
                    nameField.clear();
                    fnameField.clear();
                    datePicker.setValue(null);
                    male.setSelected(false);
                    female.setSelected(false);
                    cityBox.getSelectionModel().clearSelection();
                    imageView.setImage(null);
            System.out.println("Current Person list : ");
            for(Person p : personList){
                System.out.println(p);
            }
                });
            GridPane gridPane = new GridPane();
            gridPane.setPadding(new Insets(10));
            gridPane.setHgap(10);
            gridPane.setVgap(10);
            gridPane.add(nameLabel, 0, 0);
            gridPane.add(nameField, 1, 0);
            gridPane.add(fnameLabel, 0, 1);
            gridPane.add(fnameField, 1, 1);
            gridPane.add(cnic, 0, 2);
            gridPane.add(cnicField, 1, 2);
            gridPane.add(dateLabel, 0, 3);
            gridPane.add(datePicker, 1, 3);

            HBox genderBox = new HBox(10, male, female);
            gridPane.add(genderLabel, 0, 4);
            gridPane.add(genderBox, 1, 4);
            gridPane.add(cityLabel, 0, 5);
            gridPane.add(cityBox, 1, 5);
            gridPane.add(saveButton, 1, 6);

        VBox imagePane = new VBox(10);
        imagePane.setAlignment(Pos.TOP_CENTER);
        imagePane.setPadding(new Insets(10));

        Label fileLabel = new Label("Select Image:");
        fileLabel.setStyle("-fx-text-fill: black; -fx-font-weight: bold;");
        Button fileButton = new Button("Choose File");
        fileButton.setStyle("-fx-background-color: #800080; -fx-text-fill: white; -fx-font-weight: bold;");

        imageView.setFitWidth(200);
        imageView.setFitHeight(200);
        imageView.setPreserveRatio(true);

        VBox imageBox = new VBox(10);
        imageBox.setStyle("-fx-border-color: #800080; -fx-border-width: 2px; -fx-background-color: #FFFFFF;");

        imageBox.setAlignment(Pos.CENTER);
        imageBox.setPrefSize(220, 220);
        imageBox.setPadding(new Insets(10));

        imageBox.getChildren().add(imageView);

        fileButton.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg"));
            File selectedFile = fileChooser.showOpenDialog(stage);
            if (selectedFile != null) {
                Image image = new Image(selectedFile.toURI().toString());
                imageView.setImage(image);
            }
        });
        imagePane.getChildren().addAll(fileLabel, fileButton, imageBox);
        HBox mainLayout = new HBox(20, gridPane, imagePane);
        mainLayout.setPadding(new Insets(10));

        VBox root = new VBox(10, titleBox, mainLayout);
        root.setAlignment(Pos.TOP_CENTER);
        root.setPadding(new Insets(10));

        root.setStyle("-fx-background-color: #FFECF5;");

        Scene scene = new Scene(root, 800, 500);
            stage.setTitle("User Form");
            stage.setScene(scene);
            stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}