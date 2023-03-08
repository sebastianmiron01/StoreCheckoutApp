package com.example.effectsproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        VBox layout2=new VBox();
        Scene scene2=new Scene(layout2,500,500);
        VBox layout3=new VBox();
        Scene scene3=new Scene(layout3,500,500);
        //Layout1
        VBox layout1= new VBox(10);
        TextField t1=new TextField();
        Button sellButton=new Button("Confirm transaction");
        Button employeeButton=new Button("Check employee's status");
        Button checkStockButton=new Button("Check Stock");
        Label transactionLabel=new Label();
        t1.setOnAction(e-> transactionLabel.setText(transactionLabel.getText()+"\n"+t1.getText()));
        employeeButton.setOnAction(e->stage.setScene(scene2));
        checkStockButton.setOnAction(e->stage.setScene(scene3));
        layout1.getChildren().addAll(t1,sellButton,employeeButton,checkStockButton,transactionLabel);
        Scene scene = new Scene(layout1, 500, 500);


        //Layout2
        Label l2=new Label();
        l2.setText("Here are the employees:");
        Button b2=new Button("Back");
        layout2.getChildren().addAll(b2,l2);
        b2.setOnAction(e->stage.setScene(scene));

        //Layout3
        Button b3=new Button("Back");
        TextField t3=new TextField();
        Label l3=new Label();
        layout3.getChildren().addAll(b3,t3,l3);
        b3.setOnAction(e->stage.setScene(scene));

        //Stage
        stage.setTitle("StoreCheckout!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}