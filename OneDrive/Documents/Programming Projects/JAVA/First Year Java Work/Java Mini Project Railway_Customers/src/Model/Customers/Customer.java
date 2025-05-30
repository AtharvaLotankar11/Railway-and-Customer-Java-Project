package Model.Customers;
/**
 * Identification Comments
 * Name: Atharva Lotankar, Aaryan Shetye, Ishaan Khan, Ronit Sahoo
 * Java Mini Project - Railways and Customers
 * Roll Number - 37, 39, 54, 56
 *
 * @version 1.0
 * Beginning comments:
 * Filename: Customer.java
 * Overview: This is the Customer class. In this file we have achieved the following
 * - Created Attributes
 * --- int customer_id
 * --- String customer_name
 * --- int customer_age
 * --- String customer_gender
 * --- String customer_email
 * --- String customer_address
 * --- String customer_mobile
 * --- String customer_disability
 * --- double customer_budget
 * --- Implementation of Overall every Java Modules we dealt with
 */
public class Customer extends Person{
    private static int customer_count = 0;
    int customer_id;
    double budget;
    public static int getCustomer_count()
    {
        return customer_count;
    }
    public Customer()
    {
        customer_count++;
        this.setCustomer_id(customer_count);
    }
    public Customer(double budget, String
            customer_fname, String customer_lname,int
                            customer_age, String customer_gender, String
                            customer_email, String customer_address, String
                            customer_mobile, String customer_disability)
    {
        super(customer_fname,
                customer_lname,customer_age,customer_gender,
                customer_email, customer_address,
                customer_mobile,customer_disability);
        customer_count++;
        this.setCustomer_id(customer_count);
        this.setBudget(budget);
    }
    public Customer(int customer_id, double
            budget,String customer_fname, String
                            customer_lname,int customer_age, String
                            customer_gender, String customer_email, String
                            customer_address, String customer_mobile, String
                            customer_disability)
    {
        super(customer_fname,
                customer_lname,customer_age,customer_gender,
                customer_email, customer_address,
                customer_mobile,customer_disability);
        customer_count++;
        this.setCustomer_id(customer_id);
        this.setBudget(budget);
    }
    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }
    public void setBudget(double budget) {
        this.budget = budget;
    }
    public int getCustomer_id() {
        return customer_id;
    }
    public double getBudget() {
        return budget;
    }
    public void display()
    {
        System.out.println("Customer Id: "+getCustomer_id());
        System.out.println("Customer Budget: "+getBudget());
        super.display();
    }
}
