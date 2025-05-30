package Model.Railways;
import java.util.ArrayList;
/**
 * Identification Comments
 * Name: Atharva Lotankar, Aaryan Shetye, Ishaan Khan, Ronit Sahoo
 * Java Mini Project - Railways and Customers
 * Roll Number - 37, 39, 54, 56
 *
 * @version 1.0
 * Beginning Comments:
 * Filename: Railway.java
 * Overview: This is the Railway Class. In this file we have achieved the following
 * - Created Attributes
 * --- int train_id
 * --- static Railway_Registration
 * --- static Nationality
 * --- String train_name
 * --- String source
 * --- String destination
 * --- String Coach
 * --- int sce_time
 * --- int dest_time
 * --- double duration
 * --- int railw_sug_count
 * --- Implementation of Overall every Java Modules we dealt with
 */
public class Railway implements RailwDesc {
    private static int train_count = 0;
    int train_id;
    public static String Railway_Registration = "IRCTC";
    public static String Nationality = "Indian";
    String train_name;
    String source;
    String destination;
    String coach;
    int sce_time;
    int dest_time;
    double duration;
    int railw_sug_count = 0;
    ArrayList<String> railway_suggestion_list = new ArrayList<>();
    public static int getTrain_count() {
        return train_count;
    }
    public Railway() {
        train_count++;
        this.setTrain_id(train_count);
    }
    public Railway(String train_name, String source, String destination, String coach,
                   int sce_time, int dest_time, double duration) {

        train_count++;
        this.setTrain_id(train_count);
        this.setTrain_name(train_name);
        this.setSource(source);
        this.setDestination(destination);
        this.setCoach(coach);
        this.setSce_time(sce_time);
        this.setDest_time(dest_time);
        this.setDuration(duration);
    }
    public Railway(int train_id, String train_name, String source, String destination,
                   String coach, int sce_time, int dest_time, double duration) {
        train_count++;
        this.setTrain_id(train_id);
        this.setTrain_name(train_name);
        this.setSource(source);
        this.setDestination(destination);
        this.setCoach(coach);
        this.setSce_time(sce_time);
        this.setDest_time(dest_time);
        this.setDuration(duration);
    }
    public void setTrain_id(int train_id) {
        this.train_id = train_id;
    }
    public void setTrain_name(String train_name) {
        this.train_name = train_name;
    }
    public void setSource(String source) {
        this.source = source;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }
    public void setCoach(String coach) {
        this.coach = coach;
    }
    public void setSce_time(int sce_time) {
        this.sce_time = sce_time;
    }
    public void setDest_time(int dest_time) {
        this.dest_time = dest_time;
    }
    public void setDuration(double duration) {
        this.duration = duration;
    }
    public void setRailw_sug_count(int railw_sug_count) {
        this.railw_sug_count = railw_sug_count;
    }
    public int getTrain_id() {
        return train_id;
    }
    public String getTrain_name() {
        return train_name;
    }
    public String getSource() {
        return source;
    }
    public String getDestination() {
        return destination;
    }
    public String getCoach() {
        return coach;
    }
    public int getSce_time() {
        return sce_time;
    }
    public int getDest_time() {
        return dest_time;
    }
    public double getDuration() {
        return duration;
    }

    public int getRailw_sug_count() {
        return railw_sug_count;
    }
    public void display() {
        System.out.println("Train Id: " + getTrain_id());
        System.out.println("Railway Registration done by " + Railway.Railway_Registration);
        System.out.println("Nationality: " + Railway.Nationality);
        System.out.println("Train Name: " + getTrain_name());
        System.out.println("Source: " + getSource());
        System.out.println("Destination: " + getDestination());
        System.out.println("Coach Selected is " + getCoach());
        System.out.println("Scheduled Time to start (Military Time): " + getSce_time());
        System.out.println("Scheduled Time to halt (Military Time): " + getDest_time());
        System.out.println("Duration of the Journey(hr): " + getDuration());
    }
    @Override
    public void addRailwaySuggestion (String suggestion) {
        System.out.println("Adding Railway Suggestion");
        if(getRailw_sug_count() < 5)
        {
            railway_suggestion_list.add(suggestion);
            setRailw_sug_count(getRailw_sug_count() + 1);
            System.out.println("Railway Suggestions added Successfully");
        }
        else
        {
            System.out.println("5 Railway Suggestions Already Added. Cannot Add More");
        }
    }
    @Override
    public void removeRailwaySuggestion (int suggestion_no) {
        if(getRailw_sug_count() > 1)
        {
            System.out.println("Removing Railway Suggestions");
            railway_suggestion_list.remove(suggestion_no);
            System.out.println("Railway Suggestions removed Successfully");
            setRailw_sug_count(getRailw_sug_count() - 1);
        }
        else
        {
            System.out.println("Railway Suggestions Empty");
        }
    }
    @Override
    public void displayRailwaySuggestion () {
        for(int i=0; i<railway_suggestion_list.size(); i++)
        {
            System.out.println(railway_suggestion_list.get(i));
        }
    }
}