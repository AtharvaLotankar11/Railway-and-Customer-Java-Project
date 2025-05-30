package Model.Railways;
import Model.Railways.Railway;
import java.io.IOException;
import java.util.ArrayList;

public abstract class FileHandlingRailway {
    protected abstract ArrayList<Railway> readRailwayJsonFile(String file_path);
    protected abstract void writeRailwayJsonFile(String file_path, ArrayList<Railway>
            railways) throws IOException;
}
