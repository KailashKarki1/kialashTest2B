package com.example.csd214test2bkailash;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    public TableColumn<Customer_Order_Details, Integer> OrderID;
    @FXML
    public TableColumn<Customer_Order_Details, String> ProductName;
    @FXML
    public TableColumn<Customer_Order_Details, Integer> Quantity;
    @FXML
    public TableColumn<Customer_Order_Details, Integer> TotalPrice;
    @FXML
    public TextField xTotalPrice;
    @FXML
    public TextField xQuantity;
    @FXML
    public TextField xOrderID;
    @FXML
    public TextField xProductName;
    @FXML
    public TableView<Customer_Order_Details> tableView;
    ObservableList<Customer_Order_Details> list = FXCollections.observableArrayList();

    @FXML
    private Label welcomeText;

    public HelloController() throws SQLException {
    }

    @FXML
    public void Read(ActionEvent actionEvent) {
        String OrderID = xOrderID.getText();
        String jdbcUrl = "jdbc:mysql://localhost:3306/csd214test2bkailash";
        String dbUser = "root";
        String dbPassword = "";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "SELECT * FROM Customer_Order_Details WHERE OrderID='" + OrderID + "'";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            // Populate the table with data from the database
            while (resultSet.next()) {
                String productName = resultSet.getString("ProductName");
                String quantity = resultSet.getString("Quantity");
                String totalPrice = resultSet.getString("TotalPrice");

                xProductName.setText(productName);
                xQuantity.setText(quantity);
                xTotalPrice.setText(totalPrice);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void Load(ActionEvent actionEvent) {
        populateTable();
    }

    public void populateTable() {
        list.clear();

        String jdbcUrl = "jdbc:mysql://localhost:3306/csd214test2bkailash";
        String dbUser = "root";
        String dbPassword = "";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "SELECT * FROM Customer_Order_Details";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            // Populate the table with data from the database
            while (resultSet.next()) {
                int orderID = resultSet.getInt("OrderID");
                String productName = resultSet.getString("ProductName");
                int quantity = resultSet.getInt("Quantity");
                int totalPrice = resultSet.getInt("TotalPrice");
                list.add(new Customer_Order_Details(orderID, productName, quantity, totalPrice));
            }
            tableView.setItems(list);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        OrderID.setCellValueFactory(new PropertyValueFactory<>("OrderID"));
        ProductName.setCellValueFactory(new PropertyValueFactory<>("ProductName"));
        Quantity.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
        TotalPrice.setCellValueFactory(new PropertyValueFactory<>("TotalPrice"));
        tableView.setItems(list);
    }

    @FXML
    public void Create(ActionEvent actionEvent) {
        String productName = xProductName.getText();
        int quantity = Integer.parseInt(xQuantity.getText());
        int totalPrice = Integer.parseInt(xTotalPrice.getText());

        String jdbcUrl = "jdbc:mysql://localhost:3306/csd214test2bkailash";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "INSERT INTO `Customer_Order_Details` (`ProductName`, `Quantity`, `TotalPrice`) VALUES ('" + productName + "', '" + quantity + "', '" + totalPrice + "')";
            Statement statement = connection.createStatement();
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void Update(ActionEvent actionEvent) {
        String orderID = xOrderID.getText();
        String productName = xProductName.getText();
        int quantity = Integer.parseInt(xQuantity.getText());
        int totalPrice = Integer.parseInt(xTotalPrice.getText());

        String jdbcUrl = "jdbc:mysql://localhost:3306/csd214test2bkailash";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "UPDATE `Customer_Order_Details` SET `ProductName`='" + productName + "', `Quantity`='" + quantity + "', `TotalPrice`='" + totalPrice + "' WHERE `OrderID`='" + orderID + "'";
            Statement statement = connection.createStatement();
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void Delete(ActionEvent actionEvent) {
        String orderID = xOrderID.getText();

        String jdbcUrl = "jdbc:mysql://localhost:3306/csd214test2bkailash";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "DELETE FROM `Customer_Order_Details` WHERE `OrderID`='" + orderID + "'";
            Statement statement = connection.createStatement();
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
