package Model.Utils;

// Import the File class
import java.io.File;

// Import the IOException class to handle errors
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class textFileHandling {
    public static void main(String[] args) {
        try {
            File Obj = new File("C:/Users/Manoj/OneDrive/Documents/Java Projects/First Year Java Work/Java Mini Project Railway_Customers/src/Model/Utils/myFile.txt");
            if (Obj.createNewFile()) {
                System.out.println("File created: "
                        + Obj.getName());
            }
            else {
                System.out.println("File already exists.");
            }
        }
        catch (IOException e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }

        try {
            FileWriter Writer
                    = new FileWriter("C:/Users/Manoj/OneDrive/Documents/Java Projects/First Year Java Work/Java Mini Project Railway_Customers/src/Model/Utils/myFile.txt");
            Writer.write(
                    "Files in Java are seriously good!!");
            Writer.close();
            System.out.println("Successfully written.");
        }
        catch (IOException e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }

        try {
            File Obj = new File("C:/Users/Manoj/OneDrive/Documents/Java Projects/First Year Java Work/Java Mini Project Railway_Customers/src/Model/Utils/myFile.txt");
            Scanner Reader = new Scanner(Obj);
            while (Reader.hasNextLine()) {
                String data = Reader.nextLine();
                System.out.println(data);
            }
            Reader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }
    }
}
