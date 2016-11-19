package minecrafthelper;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.xml.parsers.ParserConfigurationException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xml.sax.SAXException;

public class Grab {
    public static void main(String[] args) throws Throwable {
        Grab b = new Grab();
        System.out.println();
    }
    public static int time = 0;
    final static String API_KEY = "AIzaSyDqaWTsdBR_ohmgvMV7_JBN392nYruAYBw";

    public Grab() {

    }

    String origens = "";
    String destinations = "";
    String url = "https://maps.googleapis.com/maps/api/distancematrix/json?origins="
            + origens
            + "&destinations="
            + destinations
            + "&mode=walking&language=en&key=" + API_KEY;

    List<String> places = Arrays.asList("Rutgers Academic Building",
            "Allison Road Classroom", "Art History Hall", "Beck Hall",
            "Bishop House", "Biological Sciences", "Blake Hall",
            "Biomedical Engineering Building", "Business Rockafeller Road",
            "Bartlett Hall", "Campbell Hall", "Cook Douglass Lecture Hall",
            "School of Communication and Information", "Civic Square",
            "Davison Hall", "Graduate School of Education",
            "Engineering Building",
            "Environmental & Natural Resources Sciences Building",
            "Floricultural Greenhouse", "Frelinghuysen Hall", "Foran Hall",
            "Food Science Building", "Honors College", "Hickman Hall",
            "Hardenbergh Hall", "Hill Center", "Heldrich Science Building",
            "Janice H. Levin Building",
            "Kathleen W. Ludwig Global Village Learning Center",
            "Labor Education Center", "Lipman Hall",
            "Loree Classroom Building", "Lucy Stone Hall",
            "Lucy Stone Hall Auditorium", "Milledoler Hall", "Murray Hall",
            "Marryott Music Building, Stephanie Morris",
            "Pharmacy Building (William Levin Hall)", "Physics Lecture Hall",
            "Ruth Adams Building", "Rutgers Cinema",
            "Ruth Dill Johnson Crockett Building", "Rehearsal Hall – Douglass",
            "Robert E. Mortensen Hall", "Scott Hall",
            "Science & Engineering Resource Center", "Serin Physics Building",
            "Thompson Hall", "Tillett Hall", "Van Dyck Hall", "Voorhees Hall",
            "Waller Hall", "Wright Rieman Laboratories",
            "May Duff Walters Hall", "Zimmerli Art Museum");

    // College Ave
    Location RutgersSS = new Location(40.503222, -74.4519619,
            "Rutgers Student Center", "rutgerss");
    Location Scott = new Location(40.49957, -74.44824, "Scott Hall", "scott");
    Location StudentActivityCenter = new Location(40.5039, -74.44883,
            "Student Activities Center", "stuactcntr");
    Location StudentActivityCenter2C = new Location(40.50383, -74.44885,
            "Student Activities Center", "stuactcntrs");
    Location Train = new Location(40.4982, -74.44511, "Train Station", "traine");
    Location Zimmerli = new Location(40.4996299, -74.4450499,
            "Zimmerli Arts Museum", "zimmerli_2");

    // Busch
    Location Lot48a = new Location(40.51514, -74.46191, "Visitor Center",
            "lot48a");
    Location Werblinback = new Location(40.5186799, -74.4614699,
            "Weblin Back Entrance", "werblinback");
    Location Hillw = new Location(40.5219151, -74.4632567, "Hill Center",
            "hillw");
    Location Science = new Location(40.523938, -74.4642213, "Science Building",
            "science");
    Location LibraryOfScience = new Location(40.5262, -74.46583,
            "Library of Science", "libofsciw");
    Location Buschse = new Location(40.5258314, -74.4587244, "Busch Suites",
            "buschse");
    Location Busch = new Location(40.5234, -74.45796, "Busch Campus Center",
            "busch");
    Location Buells = new Location(40.52181, -74.4567399, "Buell Apartments",
            "buells");
    Location Werblinm = new Location(40.51871, -74.4599799,
            "Werblin Main Entrance", "werblinm");

    // Livi
    Location Beck = new Location(40.5251062, -74.4385837, "Livingston Plaza",
            "beck");
    Location Livingston = new Location(40.524, -74.4366299,
            "Livingston Student Center", "livingston");
    Location Quads = new Location(40.5198631, -74.4335671, "Quads", "quads");

    // Cook/Douglas

    Location Traine = new Location(40.49768, -74.4445099, "Train Station",
            "trainn");
    Location Rockoff = new Location(40.4918304, -74.4430403, "Rockoff Hall",
            "rockoff");
    Location Pubsafs = new Location(40.4870546, -74.4398732,
            "Public Safety Building South", "pubsafs");
    Location Cabaret = new Location(40.4842206, -74.4380994, "Cabaret Theatre",
            "cabaret");
    Location RedOak = new Location(40.4830599, -74.43746, "Red Oak Lane",
            "redoak");
    Location Lipman = new Location(40.48129, -74.4362699, "Lipman Hall",
            "lipman");
    Location FoodScience = new Location(40.4789101, -74.4357138,
            "Food Sciences Building", "foodsci");
    Location Biel = new Location(40.4799997, -74.4325217, "Biel Road", "biel");
    Location Henders = new Location(40.4809499, -74.4287199, "Henderson",
            "henders");
    Location Katzenbach = new Location(40.48304, -74.4316, "Katzenbach",
            "katzenbach");
    Location Gibbons = new Location(40.48523, -74.43194, "Gibbons", "gibbons");
    Location College = new Location(40.4858788, -74.4379873, "College Hall",
            "college");
    Location Pubsafn = new Location(40.4876282, -74.4402089,
            "Public Safety Building North", "pubsafn");
    Location Liberty = new Location(40.49325, -74.4434, "Liberty Street",
            "liberty");
    Location Patersonn = new Location(40.495286, -74.443878, "Paterson Street",
            "patersonn");

    // Campus Points

    Location CollegeAvePoint = new Location(40.499632, -74.450656, "", "");
    Location BuschPoint = new Location(40.518868, -74.459576, "", "");
    Location LivingstonPoint = new Location(40.522865, -74.436369, "", "");
    Location DouglassPoint = new Location(40.491985, -74.443466, "", "");
    Location CookPoint = new Location(40.484299, -74.435104, "", "");

    Location[] CA = {
            RutgersSS = new Location(40.503222, -74.4519619,
                    "Rutgers Student Center", "rutgerss"),
            Scott = new Location(40.49957, -74.44824, "Scott Hall", "scott"),
            StudentActivityCenter = new Location(40.5039, -74.44883,
                    "Student Activities Center", "stuactcntr"),
            StudentActivityCenter2C = new Location(40.50383, -74.44885,
                    "Student Activities Center", "stuactcntrs"),
            Train = new Location(40.4982, -74.44511, "Train Station", "traine"),
            Zimmerli = new Location(40.4996299, -74.4450499,
                    "Zimmerli Arts Museum", "zimmerli_2"), };

    Location[] Bu = {
            Lot48a = new Location(40.51514, -74.46191, "Visitor Center",
                    "lot48a"),
            Werblinback = new Location(40.5186799, -74.4614699,
                    "Werblin Black Entrance", "werblinback"),
            Hillw = new Location(40.5219151, -74.4632567, "Hill Center",
                    "hillw"),
            Science = new Location(40.523938, -74.4642213, "Science Building",
                    "science"),
            LibraryOfScience = new Location(40.5262, -74.46583,
                    "Library of Science", "libofsciw"),
            Buschse = new Location(40.5258314, -74.4587244, "Busch Suites",
                    "buschse"),
            Busch = new Location(40.5234, -74.45796, "Busch Campus Center",
                    "busch"),
            Buells = new Location(40.52181, -74.4567399, "Buell Apartments",
                    "buells"),
            Werblinm = new Location(40.51871, -74.4599799,
                    "Werblin Main Entrance", "werblinm") };
    Location[] Li = {
            Beck = new Location(40.5251062, -74.4385837, "Livingston Plaza",
                    "beck"),
            Livingston = new Location(40.524, -74.4366299,
                    "Livingston Student Center", "livingston"),
            Quads = new Location(40.5198631, -74.4335671, "Quads", "quads") };
    Location[] Co = {
            Traine = new Location(40.49768, -74.4445099, "Train Station",
                    "trainn"),
            Rockoff = new Location(40.4918304, -74.4430403, "Rockoff Hall",
                    "rockoff"),
            Pubsafs = new Location(40.4870546, -74.4398732,
                    "Public Safety Building South", "pubsafs"),
            Liberty = new Location(40.49325, -74.4434, "Liberty Street",
                    "liberty"),
            Patersonn = new Location(40.495286, -74.443878, "Paterson Street",
                    "patersonn") };
    Location[] Doug = {
            Cabaret = new Location(40.4842206, -74.4380994, "Cabaret Theatre",
                    "cabaret"),
            RedOak = new Location(40.4830599, -74.43746, "Red Oak Lane",
                    "redoak"),
            Lipman = new Location(40.48129, -74.4362699, "Lipman Hall",
                    "lipman"),
            FoodScience = new Location(40.4789101, -74.4357138,
                    "Food Sciences Building", "foodsci"),
            Biel = new Location(40.4799997, -74.4325217, "Biel Road", "biel"),
            Henders = new Location(40.4809499, -74.4287199, "Henderson",
                    "henders"),
            Katzenbach = new Location(40.48304, -74.4316, "Katzenbach",
                    "katzenbach"),
            Gibbons = new Location(40.48523, -74.43194, "Gibbons", "gibbons"),
            College = new Location(40.4858788, -74.4379873, "College Hall",
                    "college"),
            Pubsafn = new Location(40.4876282, -74.4402089,
                    "Public Safety Building North", "pubsafn") };
    Location[] CP = {
            CollegeAvePoint = new Location(40.499632, -74.450656, "", ""),
            BuschPoint = new Location(40.518868, -74.459576, "", ""),
            LivingstonPoint = new Location(40.522865, -74.436369, "", ""),
            DouglassPoint = new Location(40.491985, -74.443466, "", ""),
            CookPoint = new Location(40.484299, -74.435104, "", "") };

    public String coor(String s) throws Throwable {
        String response = new Scanner(
                new URL(
                        "https://maps.googleapis.com/maps/api/geocode/json?address="
                                + s.replace(" ", "+") + "+Rutgers+NJ&key="
                                + "AIzaSyB6dqaQ69ydAxpDkWGblDaeqeQ_BU0nwY4")
                        .openStream(),
                "UTF-8").useDelimiter("\\A").next();
        Double lat, lon;
        JSONObject json = new JSONObject(response);
        lat = (json.getJSONArray("results").getJSONObject(0)
                .getJSONObject("geometry").getJSONObject("location")
                .getDouble("lat"));
        lon = json.getJSONArray("results").getJSONObject(0)
                .getJSONObject("geometry").getJSONObject("location")
                .getDouble("lng");
        return lat + "," + lon;
    }

    public String getOn(String s) throws MalformedURLException, IOException, SAXException, ParserConfigurationException {

        StringTokenizer st = new StringTokenizer(s, ",");
        Location current = new Location(Double.parseDouble(st.nextToken()),
                Double.parseDouble(st.nextToken()), "", "");
        String closest = findClosestCampus(current);
        switch (closest) {

        case "College Ave":
            for (Location l : CA) {
                destinations = destinations + "|" + l.toString();
            }
            break;
        case "Busch":
            for (Location l : Bu) {
                destinations = destinations + "|" + l.toString();
            }
            break;
        case "Livingston":
            for (Location l : Li) {
                destinations = destinations + "|" + l.toString();
            }
            break;
        case "Cook":
            for (Location l : Co) {
                destinations = destinations + "|" + l.toString();
            }
            break;
        case "Douglas":
            for (Location l : Doug) {
                destinations = destinations + "|" + l.toString();
            }
            break;
        default:
            break;

        }

        url = "https://maps.googleapis.com/maps/api/distancematrix/json?origins="
                + current.toString()
                + "&destinations="
                + destinations
                + "&mode=walking&language=en&key=" + API_KEY;
        String response = new Scanner(new URL(url).openStream(), "UTF-8")
                .useDelimiter("\\A").next();
        List<Object> list = getValues(response);
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int x = 0; x < list.size(); x++) {
            if ((Integer) list.get(x) < min)
                index = x;
        }
        time=0;
        time+=(Integer) list.get(index);
        switch (closest) {
        case "College Ave":
            return CA[index].getbCode();
        case "Busch":
            return Bu[index].getbCode();
        case "Livingston":
            return Li[index].getbCode();
        case "Cook":
            return Co[index].getbCode();
        case "Douglas":
            return Doug[index].getbCode();
        default:
            break;
        }
        return "na";
    }

    public String getOff(String s) throws MalformedURLException, IOException,
            JSONException, SAXException, ParserConfigurationException {

        StringTokenizer st = new StringTokenizer(s, ",");
        Location end = new Location(Double.parseDouble(st.nextToken()),
                Double.parseDouble(st.nextToken()), "", "");
        String closest = findClosestCampus(end);
        switch (closest) {

        case "College Ave":
            for (Location l : CA) {
                origens = origens + "|" + l.toString();
            }
            break;
        case "Busch":
            for (Location l : Bu) {
                origens = origens + "|" + l.toString();
            }
            break;
        case "Livingston":
            for (Location l : Li) {
                origens = origens + "|" + l.toString();
            }
            break;
        case "Cook":
            for (Location l : Co) {
                origens = origens + "|" + l.toString();
            }
            break;
        case "Douglas":
            for (Location l : Doug) {
                origens = origens + "|" + l.toString();
            }
            break;
        default:
            break;

        }

        url = "https://maps.googleapis.com/maps/api/distancematrix/json?origins="
                + origens
                + "&destinations="
                + end
                + "&mode=walking&language=en&key=" + API_KEY;

        String response = new Scanner(new URL(url).openStream(), "UTF-8")
                .useDelimiter("\\A").next();
        List<Object> list = getValues(response);
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int x = 0; x < list.size(); x++) {
            if ((Integer) list.get(x) < min)
                index = x;
        }
        time+=(Integer) list.get(index);
        switch (closest) {
        case "College Ave":
            return CA[index].getbCode();
        case "Busch":
            return Bu[index].getbCode();
        case "Livingston":
            return Li[index].getbCode();
        case "Cook":
            return Co[index].getbCode();
        case "Douglas":
            return Doug[index].getbCode();
        default:
            break;
        }
        return "na";
    }

    public List<Object> getValues(String js) throws SAXException, IOException,
            ParserConfigurationException {
        List<Object> list = new ArrayList<Object>();
        JSONObject json = new JSONObject(js);
        JSONArray arr = json.getJSONArray("rows");
        for (int i = 0; i < arr.length(); i++) {
            list.add(arr.getJSONObject(i).getJSONArray("elements")
                    .getJSONObject(0).getJSONObject("duration").getInt("value"));
        }
        return list;
    }

    public String findClosestCampus(Location cur) {

        Location go = new Location(0, 0, "", "");
        Double min = Double.MAX_VALUE;
        for (Location l : CP) {
            Double temp = findDiag(Math.abs(cur.lat - l.lat),
                    Math.abs(cur.lng - l.lng));
            if (go == null || min > temp) {
                min = temp;
                go = l;
            }
        }

        if (CP[0] == go)
            return "College Ave";
        if (CP[1] == go)
            return "Busch";
        if (CP[2] == go)
            return "Livingston";
        if (CP[3] == go)
            return "Cook";
        if (CP[4] == go)
            return "Douglas";

        return "";
    }

    public double findDiag(double d1, double d2) {

        return Math.sqrt(d1 * d1 + d2 * d2);

    }

}

class Location {

    double lat, lng;
    String name;
    String bCode;

    Location(double lat, double lng, String name, String bCode) {

        this.lat = lat;
        this.lng = lng;
        this.name = name;
        this.bCode = bCode;

    }

    public String getbCode() {
        return this.bCode;
    }

    public String toString() {

        return lat + "," + lng;
    }

}