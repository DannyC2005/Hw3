package application;

import databasePart1.DatabaseHelper;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * The SetupLoginSelectionPage class allows users to choose between setting up a new account
 * or logging into an existing account. It provides two buttons for navigation to the respective pages.
 */
public class SetupLoginSelectionPage {

    private final DatabaseHelper databaseHelper;

    public SetupLoginSelectionPage(DatabaseHelper databaseHelper) {
        this.databaseHelper = databaseHelper;
    }

    public void show(Stage primaryStage) {

        // Buttons to select Login / Setup options that redirect to respective pages
        Button setupButton = new Button("SetUp");
        Button loginButton = new Button("Login");
        Button studentHomePageButton = new Button("Go to Student Home Page");

        // Button actions
        setupButton.setOnAction(a -> {
            new SetupAccountPage(databaseHelper).show(primaryStage);
        });

        loginButton.setOnAction(a -> {
            new UserLoginPage(databaseHelper).show(primaryStage);
        });

        studentHomePageButton.setOnAction(a -> {
            // Create a mock student user for demonstration purposes
            User mockStudentUser = new User("mockStudent", "password123", "student", "mock@student.com", true);
            new StudentHomePage(databaseHelper, mockStudentUser).show(primaryStage);
        });

        // Layout for the page
        VBox layout = new VBox(10);
        layout.setStyle("-fx-padding: 20; -fx-alignment: center;");
        layout.getChildren().addAll(setupButton, loginButton, studentHomePageButton);

        primaryStage.setScene(new Scene(layout, 800, 400));
        primaryStage.setTitle("Account Setup");
        primaryStage.show();
    }
}
