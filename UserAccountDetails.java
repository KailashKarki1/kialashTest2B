package com.example.csd214test2bkailash;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class UserAccountDetails {
    public TextField userId;
    public TextField username;
    public TextField emailAddress;
    public TextField password;
    public Label welcome;

    public void logIn(ActionEvent actionEvent) {
        String email = emailAddress.getText();
        String pass = password.getText();

        if (email.isEmpty() && pass.isEmpty()) {
            welcome.setText("Please provide Username and Password");
        } else {
            String jdbcUrl = "jdbc:mysql://localhost:3306/csd214test2bkailash";
            String dbUser = "root";
            String dbPassword = "";

            try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
                String query = "SELECT * FROM logintable WHERE email ='"+email+"' AND password = '"+password+"'";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, email);
                preparedStatement.setString(2, pass);

                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    try {
                        Parent mainScene = FXMLLoader.load(getClass().getResource("hello-view.fxml")); // Adjust path as necessary
                        Stage mainStage = new Stage();
                        mainStage.setTitle("Main Application");
                        mainStage.setScene(new Scene(mainScene));

                        Stage currentStage = (Stage) emailAddress.getScene().getWindow();
                        currentStage.close();

                        mainStage.show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    welcome.setText("Invalid Username or Password");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
