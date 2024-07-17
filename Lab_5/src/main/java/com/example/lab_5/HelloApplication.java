package com.example.lab_5;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import com.google.gson.Gson;

import java.io.IOException;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Lab_5");

        Button button = new Button("Click here to parse JSON");
        button.setOnAction(e -> parseJSON());

        VBox vbox = new VBox(button);
        Scene scene = new Scene(vbox, 120, 120);

        stage.setScene(scene);
        stage.show();
    }
    public void parseJSON(){
        String jsonString="{\"ProductID\":\"1201200\",\"Product_Name\":\"Laptop\",\"Order_Date\":\"17JUL24\",\"Manufacturer\":\"Apple\"}";
        Gson gson = new Gson();
        Product product = gson.fromJson(jsonString, Product.class);
        System.out.println("ProductID: "+product.ProductID);
        System.out.println("Product_Name: "+product.Product_Name);
        System.out.println("Order_Date: "+product.Order_Date);
        System.out.println("Manufacturer: "+product.Manufacturer);

        String jsonOutput=gson.toJson(product);
        System.out.println("The output to JSon" + jsonOutput);
    }

    public class Product{
        public int ProductID;
        public String Product_Name;

        public String Order_Date;
        public String Manufacturer;
    }
    public static void main(String[] args) {
        launch();
    }
}
