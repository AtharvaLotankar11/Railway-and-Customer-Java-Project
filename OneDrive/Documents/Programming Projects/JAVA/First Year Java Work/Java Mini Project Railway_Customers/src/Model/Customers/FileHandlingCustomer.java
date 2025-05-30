package Model.Customers;
import Model.Customers.Customer;
import Model.Railways.Railway;
import java.io.IOException;
import java.util.ArrayList;

public abstract class FileHandlingCustomer {
    protected abstract ArrayList<Customer> readCustJsonFile(String file_path);
    protected abstract void writeCustJsonFile(String file_path, ArrayList<Customer>
            customers) throws IOException;
}
