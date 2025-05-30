package Model.Railways;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import Model.Displayable;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
public class manageRailway extends FileHandlingRailway implements Displayable {
    ArrayList<Railway> railways = new ArrayList<Railway>();
    ObjectMapper objectMapper = new ObjectMapper();
    private int linesBeingDisplayed;
    private int firstLineIndex;
    int lastLineIndex;
    int highlightedLine;
    public manageRailway(){
        readRailwayJsonFile("C:/Users/Manoj/OneDrive/Documents/Programming Projects/JAVA/First Year Java Work/Java Mini Project Railway_Customers/src/Model/Railways/Railways.json");
    }
    public ArrayList<Railway> readRailwayJsonFile(String file_path)
    {
        try {
            JsonNode rootNode = objectMapper.readTree(new File(file_path));
// Iterate through JSON array
            if (rootNode.isArray()) {
                for (JsonNode node : rootNode) {
                    int train_id = node.get("train_id").asInt();
                    String train_name = node.get("train_name").asText();
                    String Source = node.get("source").asText();
                    String Destination = node.get("destination").asText();
                    String Coach = node.get("coach").asText();
                    int sce_time = node.get("sce_time").asInt();
                    int dest_time = node.get("dest_time").asInt();
                    double duration = node.get("duration").asDouble();
                    Railway rail = new Railway(train_id, train_name,
                            Source, Destination, Coach, sce_time, dest_time, duration);
                    railways.add(rail);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return railways;
    }
    public void writeRailwayJsonFile(String file_path, ArrayList<Railway> railways) throws
            IOException {
        objectMapper.writeValue(Paths.get(file_path).toFile(), railways);
    }
    public void setRailwaysTable(ArrayList<Railway> railways) {
        this.railways = railways;
    }

    public ArrayList<String> getHeaders() {
        ArrayList<String> headers = new ArrayList<String>();
        headers.add("train_id");
        headers.add("train_name");
        headers.add("source");
        headers.add("destination");
        headers.add("coach");
        headers.add("sce_time");
        headers.add("dest_time");
        headers.add("duration");
        return headers;
    }
    @Override
    public ArrayList<String> getLine(int line) {
        ArrayList<String> railway_details = new ArrayList<String>();
        railway_details.add(String.valueOf(railways.get(line).getTrain_id()));
        railway_details.add(railways.get(line).getTrain_name());
        railway_details.add(railways.get(line).getSource());
        railway_details.add(railways.get(line).getDestination());
        railway_details.add(railways.get(line).getCoach());
        railway_details.add(String.valueOf(railways.get(line).getSce_time()));
        railway_details.add(String.valueOf(railways.get(line).getDest_time()));
        railway_details.add(String.valueOf(railways.get(line).getDuration()));
        return railway_details;
    }
    @Override
    public ArrayList<ArrayList<String>> getLines(int firstLine, int lastLine) {
        ArrayList<ArrayList<String>> railways_subset = new ArrayList<ArrayList<String>>();
        for (int i = firstLine; i <= lastLine; i++) {
            railways_subset.add(getLine(i));
        }
        return railways_subset;
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
    public ArrayList table() {
        return railways;
    }
}