package Model.Customers;
public class Person {
    String fname;
    String lname;
    int age;
    String gender;
    String email;
    String address;
    String mobile;
    String disability;
    public Person()
    {
        System.out.println("Creating a Person");
    }
    public Person(String fname, String lname,int age,
                  String gender, String email, String address, String
                          mobile,String disability)
    {
        this.setFname(fname);
        this.setLname(lname);
        this.setage(age);
        this.setgender(gender);
        this.setEmail(email);
        this.setAddress(address);
        this.setMobile(mobile);
        this.setdisability(disability);
    }
    public void setFname(String fname) {
        this.fname = fname;
    }
    public void setLname(String lname) {
        this.lname = lname;
    }
    public void setage(int age) {this.age = age;
    }
    public void setgender(String gender) {
        this.gender = gender;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public void setdisability(String disability) {
        this.disability = disability;
    }
    public String getFname() {
        return fname;
    }
    public String getLname() {
        return lname;
    }
    public int getage() {
        return age;
    }
    public String getgender() {
        return gender;
    }
    public String getEmail() {
        return email;
    }
    public String getAddress() {
        return address;
    }
    public String getMobile() {
        return mobile;
    }
    public String getdisability() {
        return disability;
    }
    public void display()
    {
        System.out.println("Customer First Name:  "+getFname());
        System.out.println("Customer Last Name: "+getLname());
        System.out.println("Customer Age: "+getage());
        System.out.println("Customer Gender: "+getgender());
        System.out.println("Customer Email: "+getEmail());
        System.out.println("Customer Address: "+getAddress());
        System.out.println("Customer Mobile No: "+getMobile());
        System.out.println("Customer Disability: "+getdisability());
    }
}
