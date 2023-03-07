import java.util.*;

public class Main {
    public static void main(String[] args) {
        initiateEmployees();
        initiateStock();
        boolean nonExit=true;
        String decision;

        while(nonExit)
        {
            Scanner idReader = new Scanner(System.in);
            Scanner commandReader =new Scanner(System.in);
            int productID=0;
            System.out.println("What would you like to do?");
            decision=commandReader.nextLine();
            switch (decision)
            {
                case "search":
                    System.out.println("Type the id of the product you want to search.");
                    try {
                        productID = idReader.nextInt();
                    }
                    catch(InputMismatchException e) {
                        System.out.println("Please input a number as a product id.");
                        System.out.println();
                        break;
                    }

                    boolean found=false;
                    for(Product p :products)
                    {
                        if(p.id==productID)
                        {
                            found=true;
                            if(p instanceof Shoe) {
                                ((Shoe) p).search();
                                break;
                            }
                            else if (p instanceof Shirt) {
                                ((Shirt) p).search();
                                break;
                            }
                        }
                    }
                    if(found==false) {
                        System.out.println("There is no product that has this id.");
                    }
                    break;
                default:
                    System.out.println("This is not an available command.");
                    System.out.println("Here is a list of available commands:");
                    System.out.println("search");
                    System.out.println("sell");
                    System.out.println("display employees");
                    System.out.println("exit");
                    System.out.println();
                    break;
                case "exit":
                    nonExit=false;
                    break;
                case "sell":
                    System.out.println("Type the id of the product you want to sell.");
                    try {
                        productID = idReader.nextInt();
                    }
                    catch(InputMismatchException e) {
                        System.out.println("Please enter a number as a product id.");
                        System.out.println();
                        break;
                    }
                    found=false;
                    for(Product p :products)
                    {
                        if(productID == p.getId())
                        {
                            found=true;

                            Scanner Reader= new Scanner(System.in);
                            if(p instanceof Shoe) {
                                System.out.println("Please enter the size of the product");
                                int size, num;
                                try{
                                    size= Reader.nextInt();
                                }
                                catch(InputMismatchException e) {
                                    System.out.println("Please enter a number as a shoe size.");
                                    System.out.println();
                                    found=false;
                                    break;
                                }
                                System.out.println("Please enter the number of pairs");
                                try{
                                    num= Reader.nextInt();
                                }
                                catch(InputMismatchException e) {
                                    System.out.println("Please enter a number.");
                                    System.out.println();
                                    found=false;
                                    break;
                                }
                                boolean found2=false;
                                Scanner nameReader=new Scanner(System.in);
                                System.out.println("Please enter an employee's name.");
                                String name= nameReader.nextLine();
                                for(Employee e:employees)
                                {
                                    if(Objects.equals(e.getName(), name))
                                    {
                                        found2=true;
                                        ((Shoe) p).sell(size,num,e);
                                        break;
                                    }
                                }
                                if(found2==false)
                                {
                                    System.out.println("There is no employee with this name.");
                                }


                            }
                            else if (p instanceof Shirt) {
                                System.out.println("Please enter the size of the product");
                                int size, num;
                                try{
                                    size= Reader.nextInt();
                                }
                                catch(InputMismatchException e) {
                                    System.out.println("Please enter a number as a shoe size.");
                                    System.out.println();
                                    found=false;
                                    break;
                                }
                                System.out.println("Please enter the number of pairs");
                                try{
                                    num= Reader.nextInt();
                                }
                                catch(InputMismatchException e) {
                                    System.out.println("Please enter a number.");
                                    System.out.println();
                                    found=false;
                                    break;
                                }
                                boolean found2=false;
                                Scanner nameReader=new Scanner(System.in);
                                System.out.println("Please enter an employee's name.");
                                String name= nameReader.nextLine();
                                for(Employee e:employees)
                                {
                                    if(Objects.equals(e.getName(), name))
                                    {
                                        found2=true;
                                        ((Shirt) p).sell(size,num,e);
                                        break;
                                    }
                                }
                                if(found2==false)
                                {
                                    System.out.println("There is no employee with this name.");
                                }

                                break;
                            }
                        }
                    }
                    if(found==false)
                        System.out.println("There is no product that has this id.");
                    break;
                case "display employees":
                    for(Employee e2:employees)
                        System.out.println(e2.getName()+" Sales:"+e2.getSales()+" Target:"+e2.getTarget());
            }
        }
        }

    private static void initiateStock() {
        Random r=new Random();
        Shoe s1=new Shoe(2311,"Adidas Duramo-10",250);
        s1.add(40,r.nextInt(0,20));
        s1.add(41,r.nextInt(0,20));
        s1.add(42,r.nextInt(0,20));
        s1.add(43,r.nextInt(0,20));
        s1.add(44,r.nextInt(0,20));
        s1.add(45,r.nextInt(0,20));
        s1.add(46,100);
        products.add(s1);
        Shoe s2=new Shoe(2312,"Adidas Galaxy-6",150);
        s2.add(40,r.nextInt(0,20));
        s2.add(41,r.nextInt(0,20));
        s2.add(42,r.nextInt(0,20));
        s2.add(43,r.nextInt(0,20));
        s2.add(44,r.nextInt(0,20));
        s2.add(45,r.nextInt(0,20));
        s2.add(46,100);
        products.add(s2);
        Shoe s3=new Shoe(2313,"Adidas Speedportal-4",700);
        s3.add(40,r.nextInt(0,20));
        s3.add(41,r.nextInt(0,20));
        s3.add(42,r.nextInt(0,20));
        s3.add(43,r.nextInt(0,20));
        s3.add(44,r.nextInt(0,20));
        s3.add(45,r.nextInt(0,20));
        s3.add(46,100);
        products.add(s3);
        Shoe s4=new Shoe(2314,"Adidas Terrex AX3",400);
        s4.add(40,r.nextInt(0,20));
        s4.add(41,r.nextInt(0,20));
        s4.add(42,r.nextInt(0,20));
        s4.add(43,r.nextInt(0,20));
        s4.add(44,r.nextInt(0,20));
        s4.add(45,r.nextInt(0,20));
        s4.add(46,100);
        products.add(s4);
        Shoe s5=new Shoe(2315,"Nike Revolution-5",100);
        s5.add(40,r.nextInt(0,20));
        s5.add(41,r.nextInt(0,20));
        s5.add(42,r.nextInt(0,20));
        s5.add(43,r.nextInt(0,20));
        s5.add(44,r.nextInt(0,20));
        s5.add(45,r.nextInt(0,20));
        s5.add(46,100);
        products.add(s5);
        Shoe s6=new Shoe(2316,"Nike Quest-4",200);
        s6.add(40,r.nextInt(0,20));
        s6.add(41,r.nextInt(0,20));
        s6.add(42,r.nextInt(0,20));
        s6.add(43,r.nextInt(0,20));
        s6.add(44,r.nextInt(0,20));
        s6.add(45,r.nextInt(0,20));
        s6.add(46,100);
        products.add(s6);
        Shoe s7=new Shoe(2317,"Nike Zoom Vapor",400);
        s7.add(40,r.nextInt(0,20));
        s7.add(41,r.nextInt(0,20));
        s7.add(42,r.nextInt(0,20));
        s7.add(43,r.nextInt(0,20));
        s7.add(44,r.nextInt(0,20));
        s7.add(45,r.nextInt(0,20));
        s7.add(46,100);
        products.add(s7);
        Shoe s8=new Shoe(2318,"Nike Court Vision",500);
        s8.add(40,r.nextInt(0,20));
        s8.add(41,r.nextInt(0,20));
        s8.add(42,r.nextInt(0,20));
        s8.add(43,r.nextInt(0,20));
        s8.add(44,r.nextInt(0,20));
        s8.add(45,r.nextInt(0,20));
        s8.add(46,100);
        products.add(s8);

        Shirt t1=new Shirt(2211,"Adidas Essentials",200);
        t1.add("S",r.nextInt(0,10));
        t1.add("M",r.nextInt(0,10));
        t1.add("L",r.nextInt(0,10));
        t1.add("XL",r.nextInt(0,10));
        products.add(t1);
        Shirt t2=new Shirt(2212,"Champion Crew-neck",150);
        t2.add("S",r.nextInt(0,10));
        t2.add("M",r.nextInt(0,10));
        t2.add("L",r.nextInt(0,10));
        t2.add("XL",r.nextInt(0,10));
        products.add(t2);
        Shirt t3=new Shirt(2213,"Adidas Own The Run",100);
        t3.add("S",r.nextInt(0,10));
        t3.add("M",r.nextInt(0,10));
        t3.add("L",r.nextInt(0,10));
        t3.add("XL",r.nextInt(0,10));
        products.add(t3);
        Shirt t4=new Shirt(2214,"Nike Sportswear Club",350);
        t4.add("S",r.nextInt(0,10));
        t4.add("M",r.nextInt(0,10));
        t4.add("L",r.nextInt(0,10));
        t4.add("XL",r.nextInt(0,10));
        products.add(t4);
        Shirt t5=new Shirt(2215,"Nike Icon Swoosh",250);
        t5.add("S",r.nextInt(0,10));
        t5.add("M",r.nextInt(0,10));
        t5.add("L",r.nextInt(0,10));
        t5.add("XL",r.nextInt(0,10));
        products.add(t5);
        Shirt t6=new Shirt(2216,"Nike Just Do IT",250);
        t6.add("S",r.nextInt(0,10));
        t6.add("M",r.nextInt(0,10));
        t6.add("L",r.nextInt(0,10));
        t6.add("XL",r.nextInt(0,10));
        products.add(t6);
        Shirt t7=new Shirt(2217,"Adidas Boost You Up",100);
        t7.add("S",r.nextInt(0,10));
        t7.add("M",r.nextInt(0,10));
        t7.add("L",r.nextInt(0,10));
        t7.add("XL",r.nextInt(0,10));
        products.add(t7);
        Shirt t8=new Shirt(2218,"Jordan Jumpman",350);
        t8.add("S",r.nextInt(0,10));
        t8.add("M",r.nextInt(0,10));
        t8.add("L",r.nextInt(0,10));
        t8.add("XL",r.nextInt(0,10));
        products.add(t8);
        t1.initiateConverter();
    }

    private static void initiateEmployees() {
        Employee e1=new Employee(2500,10000,"Robert");employees.add(e1);
        Employee e2=new Employee(2000,10000,"Marco");employees.add(e2);
        Employee e3=new Employee(2000,10000,"Laura");employees.add(e3);
        Employee e4=new Employee(3000,3500,"Alexandra");employees.add(e4);
        Employee e5=new Employee(2500,10000,"Adrian");employees.add(e5);
        Employee e6=new Employee(2000,7000,"Florin");employees.add(e6);
    }
    public static ArrayList<Employee> employees= new ArrayList<>();
    public static ArrayList<Product> products=new ArrayList<>();
}