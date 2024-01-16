package com.example.effectsproject;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public class HelloApplication extends Application {
    public static ArrayList<Employee> employees= new ArrayList<>();
    public static ArrayList<Product> products=new ArrayList<>();
    public static HashMap<String,Integer> deconverter=new HashMap<>();
    @Override
    public void start(Stage stage) throws IOException {
        initiateEmployees();
        initiateStock();

        VBox layout2 = new VBox();
        Scene scene2 = new Scene(layout2, 500, 500);
        VBox layout3 = new VBox();
        Scene scene3 = new Scene(layout3, 500, 500);
        //Layout1
        VBox layout1 = new VBox(10);
        TextField t1 = new TextField();
        Button sellButton = new Button("Confirm transaction");
        Button employeeButton = new Button("Check employee's status");
        Button checkStockButton = new Button("Check Stock");
        Button cancelButton = new Button("Cancel Transaction");
        GridPane grid = new GridPane();
        grid.setGridLinesVisible(false);
        grid.setHgap(10);
        grid.setVgap(1);
        ToggleGroup group = new ToggleGroup();
        RadioButton rbutton1 = new RadioButton("S");rbutton1.setToggleGroup(group);rbutton1.setSelected(true);
        RadioButton rbutton2 = new RadioButton("M");rbutton2.setToggleGroup(group);
        RadioButton rbutton3 = new RadioButton("L");rbutton3.setToggleGroup(group);
        RadioButton rbutton4 = new RadioButton("Xl");rbutton4.setToggleGroup(group);
        grid.add(rbutton1,0,0);
        grid.add(rbutton2,1,0);
        grid.add(rbutton3,2,0);
        grid.add(rbutton4,3,0);
        ToggleGroup group2 = new ToggleGroup();
        RadioButton rbutton5 = new RadioButton("40");rbutton5.setToggleGroup(group2);rbutton5.setSelected(true);
        RadioButton rbutton6 = new RadioButton("41");rbutton6.setToggleGroup(group2);
        RadioButton rbutton7 = new RadioButton("42");rbutton7.setToggleGroup(group2);
        RadioButton rbutton8 = new RadioButton("43");rbutton8.setToggleGroup(group2);
        RadioButton rbutton9 = new RadioButton("44");rbutton9.setToggleGroup(group2);
        RadioButton rbutton10 = new RadioButton("45");rbutton10.setToggleGroup(group2);
        RadioButton rbutton11 = new RadioButton("46");rbutton11.setToggleGroup(group2);

        grid.add(rbutton5,0,1);
        grid.add(rbutton6,1,1);
        grid.add(rbutton7,2,1);
        grid.add(rbutton8,3,1);
        grid.add(rbutton9,4,1);
        grid.add(rbutton10,5,1);
        grid.add(rbutton11,6,1);

        ToggleGroup group3 = new ToggleGroup();
        ArrayList<RadioButton> employeeButtons =new ArrayList<>();
        RadioButton rbutton12 = new RadioButton();rbutton12.setToggleGroup(group3);rbutton5.setSelected(true);
        RadioButton rbutton13 = new RadioButton();rbutton13.setToggleGroup(group3);
        RadioButton rbutton14 = new RadioButton();rbutton14.setToggleGroup(group3);
        RadioButton rbutton15 = new RadioButton();rbutton15.setToggleGroup(group3);
        RadioButton rbutton16 = new RadioButton();rbutton16.setToggleGroup(group3);
        RadioButton rbutton17 = new RadioButton();rbutton17.setToggleGroup(group3);
        employeeButtons.addAll(List.of(new RadioButton[]{rbutton12, rbutton13, rbutton14, rbutton15, rbutton16, rbutton17}));
        int employeeCounter=0;
        for(RadioButton rad : employeeButtons)
        {
            if(employeeCounter>employees.size()-1)
                break;
            rad.setText(employees.get(employeeCounter).getName());
            employeeCounter++;
        }
        grid.add(rbutton12,0,2);
        grid.add(rbutton13,1,2);
        grid.add(rbutton14,2,2);
        grid.add(rbutton15,3,2);
        grid.add(rbutton16,4,2);
        grid.add(rbutton17,5,2);

        Label inputLabel = new Label("Please input the code of a product:");
        Label transactionLabel = new Label(" Code  Name                       Price\n");
        final Integer[] sum = {0};
        final ArrayList<Product> transaction=new ArrayList<>();
        final ArrayList<Integer> transactionShoeSize=new ArrayList<>();
        final ArrayList<Integer> transactionShirtSize=new ArrayList<>();
        final Employee[] emp = {null};
        cancelButton.setOnAction(enter -> {
            transaction.clear();
            transactionShirtSize.clear();
            transactionShoeSize.clear();
            emp[0]=null;
            rbutton17.fire();
            rbutton17.setSelected(false);
            transactionLabel.setText("Code  Name                       Price\n");
        });
        t1.setOnAction(enter -> {

            for(Product p: products)
            {
                if(Objects.equals(t1.getText(), p.getId().toString()))
                {
                    transactionLabel.setText(transactionLabel.getText()+"  "+p.getId()+"  "+p.getName()+"  "+p.getPrice()+"\n");
                    transaction.add(p);
                    if(rbutton1.isSelected())
                    {
                        transactionShirtSize.add(deconverter.get("S"));
                    }
                    if(rbutton2.isSelected())
                    {
                        transactionShirtSize.add(deconverter.get("M"));
                    }
                    if(rbutton3.isSelected())
                    {
                        transactionShirtSize.add(deconverter.get("L"));
                    }
                    if(rbutton4.isSelected())
                    {
                        transactionShirtSize.add(deconverter.get("XL"));
                    }
                    if(rbutton5.isSelected())
                    {
                        transactionShoeSize.add(deconverter.get("40"));
                    }
                    if(rbutton6.isSelected())
                    {
                        transactionShoeSize.add(deconverter.get("41"));
                    }
                    if(rbutton7.isSelected())
                    {
                        transactionShoeSize.add(deconverter.get("42"));
                    }
                    if(rbutton8.isSelected())
                    {
                        transactionShoeSize.add(deconverter.get("43"));
                    }
                    if(rbutton9.isSelected())
                    {
                        transactionShoeSize.add(deconverter.get("44"));
                    }
                    if(rbutton10.isSelected())
                    {
                        transactionShoeSize.add(deconverter.get("45"));
                    }
                    if(rbutton11.isSelected())
                    {
                        transactionShoeSize.add(deconverter.get("46"));
                    }
                    if(rbutton12.isSelected())
                    {
                        emp[0] = employees.get(0);
                    }
                    if(rbutton13.isSelected())
                    {
                        emp[0] = employees.get(1);
                    }
                    if(rbutton14.isSelected())
                    {
                        emp[0] = employees.get(2);
                    }
                    if(rbutton15.isSelected())
                    {
                        emp[0] = employees.get(3);
                    }
                    if(rbutton16.isSelected())
                    {
                        emp[0] = employees.get(4);
                    }
                    if(rbutton17.isSelected())
                    {
                        emp[0] = employees.get(5);
                    }
                    sum[0] = sum[0] +p.getPrice();
                    break;
                }

            }
        });
        sellButton.setOnAction(e->{
            int i=0;
                for(Product p :transaction)
                {
                    if(p instanceof Shoe)
                    {
                        ((Shoe) p).sell(transactionShoeSize.get(i),1, emp[0]);
                    }
                    if(p instanceof Shirt)
                    {
                        ((Shirt) p).sell(transactionShirtSize.get(i),1, emp[0]);
                    }
                    i++;
                }
                transaction.clear();
                transactionShirtSize.clear();
                transactionShoeSize.clear();
                emp[0]=null;
                transactionLabel.setText("Code  Name                       Price\n");
        });

        employeeButton.setOnAction(e -> stage.setScene(scene2));
        checkStockButton.setOnAction(e -> stage.setScene(scene3));
        layout1.getChildren().addAll(inputLabel,t1,grid, sellButton, employeeButton, checkStockButton, cancelButton, transactionLabel);
        //add employeeButton to layout1.getChildren when employee part is done
        Scene scene = new Scene(layout1, 500, 500);


        //Layout2
        Label l2 = new Label();
        l2.setText("Here are the employees:\n");
        l2.setText(l2.getText()+"Name  Sales  Target  Salary\n");
        Button updateButton =new Button("Update progress");
        updateButton.setOnAction(e->
                {
                    l2.setText("");
                    for (Employee empProgress : employees) {
                        l2.setText(l2.getText() + "  " + empProgress.getName() + "  " + empProgress.getSales() +
                                "  " + empProgress.getTarget() + "  " + empProgress.getSalary() + "\n");

                    }
                });
        Button b2 = new Button("Back");
        layout2.getChildren().addAll(b2,updateButton, l2);
        b2.setOnAction(e -> stage.setScene(scene));

        //Layout3

        Button b3 = new Button("Back");
        TextField t3 = new TextField();
        Label l3 = new Label("Product name: ");
        t3.setOnAction(e->
        {
            l3.setText("Product name: ");
            for(Product p: products)
            {
                if(Objects.equals(t3.getText(), p.getId().toString()))
                {
                    l3.setText(l3.getText()+p.getName()+"\n"+"Size  Stock\n");
                    if(p instanceof Shoe)
                    {
                        l3.setText(l3.getText()+((Shoe) p).getStock());
                    }
                    if(p instanceof Shirt)
                    {
                        l3.setText(l3.getText()+((Shirt) p).getStock());
                    }
                }
            }
        });
        layout3.getChildren().addAll(b3, t3, l3);
        b3.setOnAction(e -> stage.setScene(scene));

        //Stage
        stage.setTitle("StoreCheckout!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    private static void initiateStock() {
        deconverter.put("40",40);
        deconverter.put("41",41);
        deconverter.put("42",42);
        deconverter.put("43",43);
        deconverter.put("44",44);
        deconverter.put("45",45);
        deconverter.put("46",46);
        deconverter.put("S",36);
        deconverter.put("M",38);
        deconverter.put("L",40);
        deconverter.put("XL",42);

        Random r = new Random();
        Shoe s1 = new Shoe(2311, "Adidas Duramo-10", 250);
        s1.add(40, r.nextInt(0, 20));
        s1.add(41, r.nextInt(0, 20));
        s1.add(42, r.nextInt(0, 20));
        s1.add(43, r.nextInt(0, 20));
        s1.add(44, r.nextInt(0, 20));
        s1.add(45, r.nextInt(0, 20));
        s1.add(46, 100);
        products.add(s1);
        Shoe s2 = new Shoe(2312, "Adidas Galaxy-6", 150);
        s2.add(40, r.nextInt(0, 20));
        s2.add(41, r.nextInt(0, 20));
        s2.add(42, r.nextInt(0, 20));
        s2.add(43, r.nextInt(0, 20));
        s2.add(44, r.nextInt(0, 20));
        s2.add(45, r.nextInt(0, 20));
        s2.add(46, 100);
        products.add(s2);
        Shoe s3 = new Shoe(2313, "Adidas Speedportal-4", 700);
        s3.add(40, r.nextInt(0, 20));
        s3.add(41, r.nextInt(0, 20));
        s3.add(42, r.nextInt(0, 20));
        s3.add(43, r.nextInt(0, 20));
        s3.add(44, r.nextInt(0, 20));
        s3.add(45, r.nextInt(0, 20));
        s3.add(46, 100);
        products.add(s3);
        Shoe s4 = new Shoe(2314, "Adidas Terrex AX3", 400);
        s4.add(40, r.nextInt(0, 20));
        s4.add(41, r.nextInt(0, 20));
        s4.add(42, r.nextInt(0, 20));
        s4.add(43, r.nextInt(0, 20));
        s4.add(44, r.nextInt(0, 20));
        s4.add(45, r.nextInt(0, 20));
        s4.add(46, 100);
        products.add(s4);
        Shoe s5 = new Shoe(2315, "Nike Revolution-5", 100);
        s5.add(40, r.nextInt(0, 20));
        s5.add(41, r.nextInt(0, 20));
        s5.add(42, r.nextInt(0, 20));
        s5.add(43, r.nextInt(0, 20));
        s5.add(44, r.nextInt(0, 20));
        s5.add(45, r.nextInt(0, 20));
        s5.add(46, 100);
        products.add(s5);
        Shoe s6 = new Shoe(2316, "Nike Quest-4", 200);
        s6.add(40, r.nextInt(0, 20));
        s6.add(41, r.nextInt(0, 20));
        s6.add(42, r.nextInt(0, 20));
        s6.add(43, r.nextInt(0, 20));
        s6.add(44, r.nextInt(0, 20));
        s6.add(45, r.nextInt(0, 20));
        s6.add(46, 100);
        products.add(s6);
        Shoe s7 = new Shoe(2317, "Nike Zoom Vapor", 400);
        s7.add(40, r.nextInt(0, 20));
        s7.add(41, r.nextInt(0, 20));
        s7.add(42, r.nextInt(0, 20));
        s7.add(43, r.nextInt(0, 20));
        s7.add(44, r.nextInt(0, 20));
        s7.add(45, r.nextInt(0, 20));
        s7.add(46, 100);
        products.add(s7);
        Shoe s8 = new Shoe(2318, "Nike Court Vision", 500);
        s8.add(40, r.nextInt(0, 20));
        s8.add(41, r.nextInt(0, 20));
        s8.add(42, r.nextInt(0, 20));
        s8.add(43, r.nextInt(0, 20));
        s8.add(44, r.nextInt(0, 20));
        s8.add(45, r.nextInt(0, 20));
        s8.add(46, 100);
        products.add(s8);

        Shirt t1 = new Shirt(2211, "Adidas Essentials", 200);
        t1.add("S", r.nextInt(0, 10));
        t1.add("M", r.nextInt(0, 10));
        t1.add("L", r.nextInt(0, 10));
        t1.add("XL", r.nextInt(0, 10));
        products.add(t1);
        Shirt t2 = new Shirt(2212, "Champion Crew-neck", 150);
        t2.add("S", r.nextInt(0, 10));
        t2.add("M", r.nextInt(0, 10));
        t2.add("L", r.nextInt(0, 10));
        t2.add("XL", r.nextInt(0, 10));
        products.add(t2);
        Shirt t3 = new Shirt(2213, "Adidas Own The Run", 100);
        t3.add("S", r.nextInt(0, 10));
        t3.add("M", r.nextInt(0, 10));
        t3.add("L", r.nextInt(0, 10));
        t3.add("XL", r.nextInt(0, 10));
        products.add(t3);
        Shirt t4 = new Shirt(2214, "Nike Sportswear Club", 350);
        t4.add("S", r.nextInt(0, 10));
        t4.add("M", r.nextInt(0, 10));
        t4.add("L", r.nextInt(0, 10));
        t4.add("XL", r.nextInt(0, 10));
        products.add(t4);
        Shirt t5 = new Shirt(2215, "Nike Icon Swoosh", 250);
        t5.add("S", r.nextInt(0, 10));
        t5.add("M", r.nextInt(0, 10));
        t5.add("L", r.nextInt(0, 10));
        t5.add("XL", r.nextInt(0, 10));
        products.add(t5);
        Shirt t6 = new Shirt(2216, "Nike Just Do IT", 250);
        t6.add("S", r.nextInt(0, 10));
        t6.add("M", r.nextInt(0, 10));
        t6.add("L", r.nextInt(0, 10));
        t6.add("XL", r.nextInt(0, 10));
        products.add(t6);
        Shirt t7 = new Shirt(2217, "Adidas Boost You Up", 100);
        t7.add("S", r.nextInt(0, 10));
        t7.add("M", r.nextInt(0, 10));
        t7.add("L", r.nextInt(0, 10));
        t7.add("XL", r.nextInt(0, 10));
        products.add(t7);
        Shirt t8 = new Shirt(2218, "Jordan Jumpman", 350);
        t8.add("S", r.nextInt(0, 10));
        t8.add("M", r.nextInt(0, 10));
        t8.add("L", r.nextInt(0, 10));
        t8.add("XL", r.nextInt(0, 10));
        products.add(t8);
        t1.initiateConverter();
    }
    private static void initiateEmployees() {
        Employee e1 = new Employee(2500, 10000, "Robert");
        employees.add(e1);
        Employee e2 = new Employee(2000, 10000, "Marco");
        employees.add(e2);
        Employee e3 = new Employee(2000, 10000, "Laura");
        employees.add(e3);
        Employee e4 = new Employee(3000, 3500, "Alexandra");
        employees.add(e4);
        Employee e5 = new Employee(2500, 10000, "Adrian");
        employees.add(e5);
        Employee e6 = new Employee(2000, 7000, "Florin");
        employees.add(e6);
    }
}