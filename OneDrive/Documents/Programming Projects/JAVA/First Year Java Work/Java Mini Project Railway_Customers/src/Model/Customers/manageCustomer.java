package Model.Customers;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import Model.Displayable;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
public class manageCustomer extends FileHandlingCustomer implements Displayable {
    ArrayList<Customer> customers = new ArrayList<Customer>();
    ObjectMapper objectMapper = new ObjectMapper();
    private int linesBeingDisplayed;
    private int firstLineIndex;
    int lastLineIndex;
    int highlightedLine;
    public manageCustomer() {
        readCustJsonFile("C:/Users/Manoj/OneDrive/Documents/Programming Projects/JAVA/First Year Java Work/Java Mini Project Railway_Customers/src/Model/Customers/Customers.json");
    }
    public ArrayList<Customer> readCustJsonFile(String file_path)
    {
        try {
            JsonNode rootNode = objectMapper.readTree(new File(file_path));
            // Iterate through JSON array
            if(rootNode.isArray()) {
                for(JsonNode node : rootNode) {
                    int cust_id = node.get("customer_id").asInt();
                    String f_name = node.get("fname").asText();
                    String l_name = node.get("lname").asText();
                    int cust_age = node.get("age").asInt();
                    String gender = node.get("gender").asText();
                    String email = node.get("email").asText();
                    String address = node.get("address").asText();
                    String mobile = node.get("mobile").asText();
                    String disab = node.get("disability").asText();
                    double budget = node.get("budget").asDouble();
                    Customer custm = new Customer(cust_id, budget, f_name, l_name,
                            cust_age, gender, email, address, mobile, disab);
                    customers.add(custm);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customers;
    }
    public void writeCustJsonFile(String file_path, ArrayList<Customer> customers) throws IOException {
        objectMapper.writeValue(Paths.get(file_path).toFile(), customers);
    }

    public void setCustomersTable (ArrayList<Customer> customers) {
        this.customers = customers;
    }
    public ArrayList<String> getHeaders() {
        ArrayList<String> headers = new ArrayList<String>();
        headers.add("customer_id");
        headers.add("fname");
        headers.add("lname");
        headers.add("age");
        headers.add("gender");
        headers.add("email");
        headers.add("address");
        headers.add("mobile");
        headers.add("disability");
        headers.add("budget");
        return headers;
    }
    @Override
    public ArrayList<String> getLine(int line) {
        ArrayList<String> customer_details = new ArrayList<String>();

        customer_details.add(String.valueOf(customers.get(line).getCustomer_id()));
        customer_details.add(customers.get(line).getFname());
        customer_details.add(customers.get(line).getLname());
        customer_details.add(String.valueOf(customers.get(line).getage()));
        customer_details.add(customers.get(line).getgender());
        customer_details.add(customers.get(line).getEmail());
        customer_details.add(customers.get(line).getAddress());
        customer_details.add(customers.get(line).getMobile());
        customer_details.add(customers.get(line).getdisability());
        customer_details.add(String.valueOf(customers.get(line).getBudget()));
        return customer_details;
    }

    @Override
    public ArrayList<ArrayList<String>> getLines(int firstLine, int lastLine) {
        ArrayList<ArrayList<String>> customers_subset = new ArrayList<ArrayList<String>>();

        for (int i = firstLine; i <= lastLine; i++) {
            customers_subset.add(getLine(i));
        }
        return customers_subset;
    }

    @Override
    public int getFirstLineToDisplay() {
        return firstLineIndex;
    }

    @Override
    public int getLineToHighlight() {
        return highlightedLine;
    }

    @Override
    public int getLastLineToDisplay() {
        setLastLineToDisplay(getFirstLineToDisplay() + getLinesBeingDisplayed() - 1);
        return lastLineIndex;
    }

    @Override
    public int getLinesBeingDisplayed() {
        return linesBeingDisplayed;
    }

    @Override
    public void setFirstLineToDisplay(int firstLine) {
        this.firstLineIndex = firstLine;
    }

    @Override
    public void setLineToHighlight(int highlightedLine) {
        this.highlightedLine = highlightedLine;
    }

    @Override
    public void setLastLineToDisplay(int lastLine) {
        this.lastLineIndex = lastLine;
    }

    @Override
    public void setLinesBeingDisplayed(int numberOfLines) {
        this.linesBeingDisplayed = numberOfLines;
    }

    public ArrayList<Customer> getTable() {
        return customers;
    }
}
