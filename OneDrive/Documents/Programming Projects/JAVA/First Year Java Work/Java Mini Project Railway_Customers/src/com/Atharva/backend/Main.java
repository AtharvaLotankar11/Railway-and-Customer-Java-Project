package com.Atharva.backend;
import Model.Railways.Railway;
import Model.Railways.manageRailway;
import Model.Customers.Customer;
import Model.Customers.manageCustomer;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import com.Atharva.frontend.*;
import javax.swing.*;
/**
 * Identification Comments:
 * Name: Atharva Lotankar, Aaryan Shetye, Ishaan Khan, Ronit Sahoo
 * Java Mini Project - Railways and Customers
 * Roll Number - 37, 39, 54, 56
 * @version 1.0
 *
 * Beginning Comments:
 * Filename: Main.java
 * Class Main
 * Overview: This is the main class used to created objects for Railway Class and
 * Customer Class. In this file we have achieved the following
 * - Menu Driven Program to create Railway Class
 * - Created a STATIC Variable
 * - Implemented Abstract Class and Methods
 * - String Manipulation using split function for Customer Full Name & Source-Destination
 * - Applied GUI by AWT and Usage of Threading
 */
public class Main {
    //Initialize the Method
    public class Ticket {
        static String bookTicket(String Coachname) {
            return Coachname;
        }
        static int bookTicket(int Distance) {
            return Distance;
        }
        static double bookTicket(double Fare) {
            return Fare;
        }
    }

    public static void main(String[] args) throws IOException {
        // Create the main JFrame
        JFrame frame = new JFrame("Railway Customer App");
        // Create the RailwayCustomerApp
        RailwayCustomerApp app = new RailwayCustomerApp(frame);
        // Create the panels
        SwingCustomer customerPanel = new SwingCustomer(app);
        SwingRailway railwayPanel = new SwingRailway(app);
        // Add panels to RailwayCustomerApp
        app.addCustomerPanel(customerPanel);
        app.addRailwayPanel(railwayPanel);
        // Initially show the Customer panel
        app.switchToCustomerPanel();

        //Backend
        ArrayList<Railway> railways = new ArrayList<Railway>();
        manageRailway mr1 = new manageRailway();
        railways = mr1.readRailwayJsonFile("C:/Users/Manoj/OneDrive/Documents/Programming Projects/JAVA/First Year Java Work/Java Mini Project Railway_Customers/src/Model/Railways/Railways.json");

        ArrayList<Customer> customers = new ArrayList<Customer>();
        manageCustomer mc1 = new manageCustomer();
        customers = mc1.readCustJsonFile("C:/Users/Manoj/OneDrive/Documents/Programming Projects/JAVA/First Year Java Work/Java Mini Project Railway_Customers/src/Model/Customers/Customers.json");

        ObjectMapper mapper = new ObjectMapper();
        int idx_railway, idx_customer;
        //Creating a Scanner Object to take input
        Scanner sc = new Scanner(System.in);
        //Creating Railway & Customer Object Array
        Railway railw_arr[] = new Railway[600];
        Customer cust_arr[] = new Customer[600];

        int choice; //display menu & get user's choice
        do {
            System.out.println("1. Add a Railway Info");
            System.out.println("2. View the Railway Details");
            System.out.println("3. View All Railway Details");
            System.out.println("4. Add a Customer");
            System.out.println("5. View Customer Details");
            System.out.println("6. View All Customer Details");
            System.out.println("7. View Ticket Prices by Coach");
            System.out.println("8. Add Any Railway Suggestions");
            System.out.println("9. Remove Any Railway Suggestions");
            System.out.println("10. View All Railway Suggestions");
            System.out.println("11. Updation in Railway Info");
            System.out.println("12. Displaying of Railway Info");
            System.out.println("13. Displaying of All Railway Info");
            System.out.println("14. Deletion in Railway Info");
            System.out.println("15. Updation in Customer Info");
            System.out.println("16. Displaying of Customer Info");
            System.out.println("17. Displaying of All Customer Info");
            System.out.println("18. Deletion in Customer Info");
            System.out.println("19. Exit");
            System.out.print("Enter your choice: ");
            try {
                choice = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input. Need a Numeric Value");
                sc.nextLine();
                choice = -1;
            }
//Execute the selected operation
            switch (choice) {
                case 1:
                    System.out.println("How do you wish to create your Railway ID: ");
                    System.out.println("A. Auto Generate Id and Add no other Details");
                    System.out.println("B. Auto Generate Id and Add other Details");
                    System.out.println("C. Provide Railway ID");
                    System.out.println("Enter you Choice: ");
                    char rail_id_choice = sc.next().charAt(0);
                    sc.nextLine();

                    if (rail_id_choice == 'A') {

                        railw_arr[Railway.getTrain_count()] = new Railway();
                    } else if (rail_id_choice == 'B') {
                        System.out.println("Enter Train Name: ");
                        String name = sc.nextLine();
                        System.out.println("Enter the Source and Destination: ");
                        String snd = sc.nextLine();
                        String[] snd_split = snd.split(" ");
                        System.out.println("Enter the Coach: ");
                        String coach = sc.nextLine();
                        System.out.println("Scheduled Time to Start: ");
                        int st = sc.nextInt();
                        System.out.println("Scheduled Time to Halt: ");
                        int dt = sc.nextInt();
                        System.out.println("Enter the Duration (hrs): ");
                        double duration = sc.nextDouble();
                        railw_arr[Railway.getTrain_count()] = new Railway(name, snd_split[0],

                                snd_split[1], coach, st, dt, duration);
                    } else if (rail_id_choice == 'C') {
                        System.out.println("Enter Train ID: ");
                        int train_id = sc.nextInt();
//To Avoid unnecessary skip of Input
                        sc.nextLine();
                        System.out.println("Enter Train Name: ");
                        String name = sc.nextLine();
                        System.out.println("Enter the Source and Destination: ");
                        String snd = sc.nextLine();
                        String[] snd_split = snd.split(" ");
                        System.out.println("Enter the Coach: ");
                        String coach = sc.nextLine();
                        System.out.println("Scheduled Time to Start: ");
                        int st = sc.nextInt();
                        System.out.println("Scheduled Time to Halt: ");
                        int dt = sc.nextInt();
                        System.out.println("Enter the Duration (hrs): ");
                        double duration = sc.nextDouble();
                        railw_arr[Railway.getTrain_count()] = new Railway(train_id, name,
                                snd_split[0], snd_split[1], coach, st, dt, duration);
                    }
                    break;
                case 2:
                    System.out.println("Enter Railway Array Position Index: ");
                    int idx_rail = sc.nextInt();
                    railw_arr[idx_rail + 560].display();
                    break;
                case 3:
                    for (int k = 0; k < Railway.getTrain_count(); k++) {
                        if (railw_arr[k] != null) {
                            System.out.println("Details of Railway: " + (k + 1 - 560)) ;
                            railw_arr[k].display();
                            System.out.println(" ");
                        }
                    }
                    break;
                case 4:
                    System.out.println("How do you wish to create the Customer Id: ");
                    System.out.println("A. Auto Generate Id and Add no other Details");
                    System.out.println("B. Auto Generate Id and Add other Details");
                    System.out.println("C. Provide Customer Id");
                    System.out.print("Enter your choice: ");
                    int cust_id_choice = sc.next().charAt(0);
                    sc.nextLine();
                    if (cust_id_choice == 'A') {
                        cust_arr[Customer.getCustomer_count()] = new Customer();
                    } else if (cust_id_choice == 'B') {
                        System.out.println("Enter Customer First Name and Last Name: ");
                        String name = sc.nextLine();
                        String[] name_split = name.split(" ");
                        System.out.println("Enter Age: ");
                        int age = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter Gender: ");
                        String gender = sc.nextLine();
                        System.out.println("Enter Customer Email: ");
                        String email = sc.nextLine();
                        System.out.println("Enter Customer Address: ");
                        String addr = sc.nextLine();
                        System.out.println("Enter Customer Mobile No: ");
                        String mob_no = sc.nextLine();
                        System.out.println("Are you Disabled: ");
                        String disability = sc.nextLine();
                        System.out.println("Enter Budget: ");
                        double budget = sc.nextDouble();
                        cust_arr[Customer.getCustomer_count()] = new Customer(budget, name_split[0], name_split[1],
                                age, gender, email, addr, mob_no, disability);
                    } else if (cust_id_choice == 'C') {
                        System.out.println("Enter Customer Id: ");
                        int cust_id = sc.nextInt();
                        // To avoid unnecessary skip of input
                        sc.nextLine();
                        System.out.println("Enter Customer First Name and Last Name: ");
                        String name = sc.nextLine();
                        String[] name_split = name.split(" ");
                        System.out.println("Enter Age: ");
                        int age = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter Gender: ");
                        String gender = sc.nextLine();
                        System.out.println("Enter Customer Email: ");
                        String email = sc.nextLine();
                        System.out.println("Enter Customer Address: ");
                        String addr = sc.nextLine();
                        System.out.println("Enter Customer Mobile No: ");
                        String mob_no = sc.nextLine();
                        System.out.println("Are you Disabled: ");
                        String disability = sc.nextLine();
                        System.out.println("Enter Budget: ");
                        double budget = sc.nextDouble();
                        cust_arr[Customer.getCustomer_count()] = new Customer(cust_id, budget, name_split[0],
                                name_split[1], age, gender, email, addr, mob_no, disability);
                    }
                    break;

                case 5:
                    System.out.println("Enter Customer Array Position Index: ");
                    int idx_cust = sc.nextInt();
                    cust_arr[idx_cust + 286].display();
                    break;

                case 6:
                    for (int k = 0; k < Customer.getCustomer_count(); k++) {
                        if (cust_arr[k] != null) {
                            System.out.println("Details of Customers: " + (k + 1 - 286));
                            cust_arr[k].display();
                            System.out.println(" ");
                        }
                    }
                    break;

                //Use of Method Overloading
                case 7:
                    System.out.println("a. Vista Dome (Lean)");
                    System.out.println("b. Vista Dome (Peak)");
                    System.out.println("c. AC 2-Tier (Lean)");
                    System.out.println("d. AC 2-Tier (Peak)");
                    System.out.println("e. AC 3-Tier");
                    System.out.println("f. AC Economy (Duronto)");
                    System.out.println("g. Sleeper Class");
                    System.out.println("Enter Coach Choice: ");
                    char cc = sc.next().charAt(0);
                    System.out.println(" ");
                    switch (cc) {
                        case 'a':
                            System.out.println("Coach is " + Ticket.bookTicket("Vista Dome (L)"));
                            System.out.println("Distance Min. " + Ticket.bookTicket(300) + " km");
                            System.out.println("Base Fare at Min. Distance is Rs. " +
                                    Ticket.bookTicket(998.00));
                            break;
                        case 'b':
                            System.out.println("Coach is " + Ticket.bookTicket("Vista Dome (P)"));
                            System.out.println("Distance Min. " + Ticket.bookTicket(300) + " km");
                            System.out.println("Base Fare at Min. Distance is Rs. " +
                                    Ticket.bookTicket(1059.00));
                            break;
                        case 'c':
                            System.out.println("Coach is " + Ticket.bookTicket("AC 2-Tier (L)"));
                            System.out.println("Distance Min. " + Ticket.bookTicket(300) + " km");
                            System.out.println("Base Fare at Min. Distance is Rs. " +
                                    Ticket.bookTicket(605.00));
                            break;
                        case 'd':
                            System.out.println("Coach is " + Ticket.bookTicket("AC 2-Tier (P)"));
                            System.out.println("Distance Min. " + Ticket.bookTicket(300) + " km");
                            System.out.println("Base Fare at Min. Distance is Rs. " +
                                    Ticket.bookTicket(625.00));
                            break;
                        case 'e':
                            System.out.println("Coach is " + Ticket.bookTicket("AC 3-Tier"));
                            System.out.println("Distance Min. " + Ticket.bookTicket(300) + " km");
                            System.out.println("Base Fare at Min. Distance is Rs. " +
                                    Ticket.bookTicket(440.00));
                            break;

                        case 'f':
                            System.out.println("Coach is " + Ticket.bookTicket("AC Economy " +
                                    "(Duronto)"));
                            System.out.println("Distance Min. " + Ticket.bookTicket(300) + " km");
                            System.out.println("Base Fare at Min. Distance is Rs. " +
                                    Ticket.bookTicket(470.00));
                            break;
                        case 'g':
                            System.out.println("Coach is " + Ticket.bookTicket("Sleeper Class"));
                            System.out.println("Distance Min. " + Ticket.bookTicket(200) + " km");
                            System.out.println("Base Fare at Min. Distance is Rs. " +
                                    Ticket.bookTicket(124.00));
                            break;
                        default:
                            System.out.println("Invalid Coach Choice");
                            break;
                    }

                    System.out.println(" ");

                    break;
                case 8:
                    System.out.println("Enter Your Train Name: ");
                    String tname = sc.nextLine();
                    System.out.println("Train Name recorded as " + tname);
                    System.out.println("Enter Railway Array Position Index: ");
                    idx_railway = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter Any Railway Suggestions: ");
                    String railw_sug = sc.nextLine();
                    railw_arr[idx_railway + 560].addRailwaySuggestion(railw_sug);

                    break;
                case 9:
                    System.out.println("Enter Railway Array Position Index: ");
                    idx_railway = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter Railway Suggestive Index to Delete: ");
                    int idx_railw_sug = sc.nextInt();
                    railw_arr[idx_railway + 560].removeRailwaySuggestion(idx_railw_sug);
                    break;
                case 10:
                    System.out.println("Enter Railway Array Position Index: ");
                    idx_railway = sc.nextInt();
                    sc.nextLine();
                        System.out.println("Accessing railway suggestion at index " + idx_railway);
                        railw_arr[idx_railway + 560].displayRailwaySuggestion();
                    break;

                case 11:
                    System.out.println("Enter Railway Index to Update: ");
                    int rail_idx = sc.nextInt();

                    sc.nextLine();
                    int choice_to_change;
                    do {

                        System.out.println("(+) Update Train ID");
                        System.out.println("(-) Update Train Name");
                        System.out.println("(*) Update Source");
                        System.out.println("(/) Update Destination");
                        System.out.println("(&) Update Coach");
                        System.out.println("(#) Update Sce_Time");
                        System.out.println("(%) Update Dest_Time");
                        System.out.println("(^) Update Duration");
                        System.out.println("(E) Exit Updation");
                        System.out.print("Enter your choice: ");
                        choice_to_change = sc.next().charAt(0);
                        sc.nextLine();
                        switch (choice_to_change) {

                            case '+':
                                System.out.print("Enter Train ID: ");
                                int train_id = sc.nextInt();
                                railways.get(rail_idx).setTrain_id(train_id);
                                mr1.writeRailwayJsonFile("C:/Users/Manoj/OneDrive/Documents/Programming Projects/JAVA/First Year Java Work/Java Mini Project Railway_Customers/src/Model/Railways/Railways.json", railways);
                                break;
                            case '-':
                                System.out.print("Enter Train Name: ");
                                String train_name = sc.nextLine();
                                railways.get(rail_idx).setTrain_name(train_name);
                                mr1.writeRailwayJsonFile("C:/Users/Manoj/OneDrive/Documents/Programming Projects/JAVA/First Year Java Work/Java Mini Project Railway_Customers/src/Model/Railways/Railways.json", railways);
                                break;
                            case '*':
                                System.out.print("Enter Source: ");
                                String source = sc.nextLine();
                                railways.get(rail_idx).setSource(source);
                                mr1.writeRailwayJsonFile("C:/Users/Manoj/OneDrive/Documents/Programming Projects/JAVA/First Year Java Work/Java Mini Project Railway_Customers/src/Model/Railways/Railways.json", railways);
                                break;

                            case '/':
                                System.out.print("Enter Destination: ");
                                String destination = sc.nextLine();
                                railways.get(rail_idx).setDestination(destination);
                                mr1.writeRailwayJsonFile("C:/Users/Manoj/OneDrive/Documents/Programming Projects/JAVA/First Year Java Work/Java Mini Project Railway_Customers/src/Model/Railways/Railways.json", railways);
                                break;
                            case '&':
                                System.out.print("Enter Coach: ");
                                String coach = sc.nextLine();
                                railways.get(rail_idx).setCoach(coach);
                                mr1.writeRailwayJsonFile("C:/Users/Manoj/OneDrive/Documents/Programming Projects/JAVA/First Year Java Work/Java Mini Project Railway_Customers/src/Model/Railways/Railways.json", railways);
                                break;
                            case '#':
                                System.out.print("Enter Scheduled Time (Military) ");
                                int sce_time = sc.nextInt();
                                railways.get(rail_idx).setSce_time(sce_time);
                                mr1.writeRailwayJsonFile("C:/Users/Manoj/OneDrive/Documents/Programming Projects/JAVA/First Year Java Work/Java Mini Project Railway_Customers/src/Model/Railways/Railways.json", railways);
                                break;
                            case '%':
                                System.out.print("Enter Destination Time (Military): ");
                                int dest_time = sc.nextInt();
                                railways.get(rail_idx).setDest_time(dest_time);
                                mr1.writeRailwayJsonFile("C:/Users/Manoj/OneDrive/Documents/Programming Projects/JAVA/First Year Java Work/Java Mini Project Railway_Customers/src/Model/Railways/Railways.json", railways);
                                break;
                            case '^':
                                System.out.print("Duration (hours): ");
                                double duration = sc.nextDouble();
                                railways.get(rail_idx).setDuration(duration);
                                mr1.writeRailwayJsonFile("C:/Users/Manoj/OneDrive/Documents/Programming Projects/JAVA/First Year Java Work/Java Mini Project Railway_Customers/src/Model/Railways/Railways.json", railways);
                                break;
                            default:
                                System.out.println("Invalid choice. Try again.");
                                break;
                        }
                    } while (choice_to_change != 'E');
                    break;
                case 12:
                    railways = mr1.readRailwayJsonFile("C:/Users/Manoj/OneDrive/Documents/Programming Projects/JAVA/First Year Java Work/Java Mini Project Railway_Customers/src/Model/Railways/Railways.json");
                    System.out.print("Enter Railway Index to Display: ");
                    rail_idx = sc.nextInt();
                    sc.nextLine();
                    railways.get(rail_idx).display();
                    break;
                case 13:
                    railways = mr1.readRailwayJsonFile("C:/Users/Manoj/OneDrive/Documents/Programming Projects/JAVA/First Year Java Work/Java Mini Project Railway_Customers/src/Model/Railways/Railways.json");
                    for (int i = 0; i < railways.size(); i++) {
                        railways.get(i).display();
                    }
                    break;

                case 14:
                    System.out.print("Enter Railway Index to Delete: ");
                    int rail_idx_delete = sc.nextInt();
                    sc.nextLine();
                    int train_id = railways.get(rail_idx_delete).getTrain_id();
                    String train_name = railways.get(rail_idx_delete).getTrain_name();
                    String source = railways.get(rail_idx_delete).getSource();
                    String destination = railways.get(rail_idx_delete).getDestination();
                    String coach = railways.get(rail_idx_delete).getCoach();
                    int sce_time = railways.get(rail_idx_delete).getSce_time();
                    int dest_time = railways.get(rail_idx_delete).getDest_time();
                    double duration = railways.get(rail_idx_delete).getDuration();
                    System.out.println("Train ID: " + train_id + " and name " + train_name + " has been deleted");
                    System.out.println("Deletion in Source + Destination : " + source + " " + destination);
                    System.out.println("The Coach Selection " + coach + " has been deleted");
                    System.out.println("All the Time Coverage is eliminated as Source, Dest and Duration = " + sce_time + "," + dest_time + ","
                            + duration);
                    railways.remove(rail_idx_delete);
                    mr1.writeRailwayJsonFile("C:/Users/Manoj/OneDrive/Documents/Programming Projects/JAVA/First Year Java Work/Java Mini Project Railway_Customers/src/Model/Railways/Railways.json", railways);
                    break;

                case 15:
                    System.out.println("Enter Customer Index to Update: ");
                    int cust_idx = sc.nextInt();
                    sc.nextLine();
                    int choice_cust;
                    do {
                        System.out.println("(+) Update Customer ID");
                        System.out.println("(-) Update Customer First Name");
                        System.out.println("(*) Update Customer Last Name");
                        System.out.println("(/) Update Customer Age");
                        System.out.println("(&) Update Gender");
                        System.out.println("(#) Update Customer Email");
                        System.out.println("(%) Update Customer Address");
                        System.out.println("(^) Update Mobile Number");
                        System.out.println("(D) Update Disability Status?");
                        System.out.println("(B) Update Customer Budget");
                        System.out.println("(E) Exit Updation");
                        System.out.print("Enter your choice: ");
                        choice_to_change = sc.next().charAt(0);
                        sc.nextLine();
                        switch (choice_to_change) {

                            case '+':
                                System.out.print("Enter Customer ID: ");
                                int cust_id = sc.nextInt();
                                customers.get(cust_idx).setCustomer_id(cust_id);
                                mc1.writeCustJsonFile("C:/Users/Manoj/OneDrive/Documents/Programming Projects/JAVA/First Year Java Work/Java Mini Project Railway_Customers/src/Model/Customers/Customers.json", customers);
                                break;
                            case '-':
                                System.out.print("Enter First Name: ");
                                String f_name = sc.nextLine();
                                customers.get(cust_idx).setFname(f_name);
                                mc1.writeCustJsonFile("C:/Users/Manoj/OneDrive/Documents/Programming Projects/JAVA/First Year Java Work/Java Mini Project Railway_Customers/src/Model/Customers/Customers.json", customers);
                                break;
                            case '*':
                                System.out.print("Enter Last Name: ");
                                String l_name = sc.nextLine();
                                customers.get(cust_idx).setLname(l_name);
                                mc1.writeCustJsonFile("C:/Users/Manoj/OneDrive/Documents/Programming Projects/JAVA/First Year Java Work/Java Mini Project Railway_Customers/src/Model/Customers/Customers.json", customers);
                                break;

                            case '/':
                                System.out.print("Enter Customer Age: ");
                                int age = sc.nextInt();
                                customers.get(cust_idx).setage(age);
                                mc1.writeCustJsonFile("C:/Users/Manoj/OneDrive/Documents/Programming Projects/JAVA/First Year Java Work/Java Mini Project Railway_Customers/src/Model/Customers/Customers.json", customers);
                                break;
                            case '&':
                                System.out.print("Enter Gender: ");
                                String gndr = sc.nextLine();
                                customers.get(cust_idx).setgender(gndr);
                                mc1.writeCustJsonFile("C:/Users/Manoj/OneDrive/Documents/Programming Projects/JAVA/First Year Java Work/Java Mini Project Railway_Customers/src/Model/Customers/Customers.json", customers);
                                break;
                            case '#':
                                System.out.print("Enter Email: ");
                                String email = sc.nextLine();
                                customers.get(cust_idx).setEmail(email);
                                mc1.writeCustJsonFile("C:/Users/Manoj/OneDrive/Documents/Programming Projects/JAVA/First Year Java Work/Java Mini Project Railway_Customers/src/Model/Customers/Customers.json", customers);
                                break;
                            case '%':
                                System.out.print("Enter Customer Address:  ");
                                String caddress = sc.nextLine();
                                customers.get(cust_idx).setAddress(caddress);
                                mc1.writeCustJsonFile("C:/Users/Manoj/OneDrive/Documents/Programming Projects/JAVA/First Year Java Work/Java Mini Project Railway_Customers/src/Model/Customers/Customers.json", customers);
                                break;
                            case '^':
                                System.out.print("Enter Mobile Number:  ");
                                String mobileNum = sc.nextLine();
                                customers.get(cust_idx).setMobile(mobileNum);
                                mc1.writeCustJsonFile("C:/Users/Manoj/OneDrive/Documents/Programming Projects/JAVA/First Year Java Work/Java Mini Project Railway_Customers/src/Model/Customers/Customers.json", customers);
                                break;
                            case 'D':
                                System.out.println("Enter Disability Status? ");
                                String dis = sc.nextLine();
                                customers.get(cust_idx).setdisability(dis);
                                mc1.writeCustJsonFile("C:/Users/Manoj/OneDrive/Documents/Programming Projects/JAVA/First Year Java Work/Java Mini Project Railway_Customers/src/Model/Customers/Customers.json", customers);
                                break;
                            case 'B':
                                System.out.println("Enter Customer Budget: ");
                                double budgt = sc.nextDouble();
                                customers.get(cust_idx).setBudget(budgt);
                                mc1.writeCustJsonFile("C:/Users/Manoj/OneDrive/Documents/Programming Projects/JAVA/First Year Java Work/Java Mini Project Railway_Customers/src/Model/Customers/Customers.json", customers);
                                break;
                            default:
                                System.out.println("Invalid choice. Try again.");
                                break;
                        }
                    } while (choice_to_change != 'E');
                    break;

                case 16:
                    customers = mc1.readCustJsonFile("C:/Users/Manoj/OneDrive/Documents/Programming Projects/JAVA/First Year Java Work/Java Mini Project Railway_Customers/src/Model/Customers/Customers.json");
                    System.out.print("Enter Customer Index to Display: ");
                    cust_idx = sc.nextInt();
                    sc.nextLine();
                    customers.get(cust_idx).display();
                    break;

                case 17:
                    customers = mc1.readCustJsonFile("C:/Users/Manoj/OneDrive/Documents/Programming Projects/JAVA/First Year Java Work/Java Mini Project Railway_Customers/src/Model/Customers/Customers.json");
                    for (int i = 0; i < customers.size(); i++) {
                        customers.get(i).display();
                    }
                    break;

                case 18:
                    System.out.print("Enter Customer Index to Delete: ");
                    int cust_idx_delete = sc.nextInt();
                    sc.nextLine();
                    int cust_id = customers.get(cust_idx_delete).getCustomer_id();
                    String f_name = customers.get(cust_idx_delete).getFname();
                    String l_name = customers.get(cust_idx_delete).getLname();
                    int age = customers.get(cust_idx_delete).getage();
                    String gender = customers.get(cust_idx_delete).getgender();
                    String email = customers.get(cust_idx_delete).getEmail();
                    String address = customers.get(cust_idx_delete).getAddress();
                    String mnum = customers.get(cust_idx_delete).getMobile();
                    String disa = customers.get(cust_idx_delete).getdisability();
                    double budgt = customers.get(cust_idx_delete).getBudget();
                    System.out.println("Customer ID: " + cust_id + " and name " + f_name + " " + l_name + " has been deleted");
                    System.out.println("Deletion in Age, Gender, Email, Mobile as: " + age + gender + email + mnum);
                    System.out.println("The Address: " + address + " is deleted");
                    System.out.println("Disability Status: " + disa + " with Budget Rs. " + budgt + " is deleted");
                    customers.remove(cust_idx_delete);
                    mc1.writeCustJsonFile("C:/Users/Manoj/OneDrive/Documents/Programming Projects/JAVA/First Year Java Work/Java Mini Project Railway_Customers/src/Model/Customers/Customers.json", customers);
                    break;

                case 19:
                    System.exit(0); //To exit Program without showing default case statement
                    break;
                default:
                    System.out.println("Invalid Choice, Please Try Again");
                    break;
            }
        }
            while (choice != 19) ;
    }
}
