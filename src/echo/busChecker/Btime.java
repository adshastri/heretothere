package echo.busChecker;

import java.io.StringReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class Btime {
	public static String getData(String bus, String stop) {
		String response;
		try {
			response = new Scanner(
					new URL("http://webservices.nextbus.com/service/publicXMLFeed?command=predictions&a=rutgers&r="
							+ bus + "&s=" + stop).openStream(),
					"UTF-8").useDelimiter("\\A").next();
			System.out.println(response);
		} catch (Throwable e) {
			return "na";
		}
		if (!response.contains("second"))
			return "na";
		else
			return response;
	}

	public static List<Object> getTimes(String data) throws Throwable {
		List<Object> list = new ArrayList<Object>();
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document document = db.parse(new InputSource(new StringReader(data)));
		NodeList nodeList = document.getElementsByTagName("prediction");
		for (int x = 0, size = nodeList.getLength(); x < size; x++) {
			list.add(Integer.parseInt(nodeList.item(x).getAttributes().getNamedItem("seconds").getNodeValue()));
		}
		return list;
	}

	public static List<Object> getID(String data) throws Throwable {
		List<Object> list = new ArrayList<Object>();
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document document = db.parse(new InputSource(new StringReader(data)));
		NodeList nodeList = document.getElementsByTagName("prediction");
		for (int x = 0, size = nodeList.getLength(); x < size; x++) {
			list.add(Integer.parseInt(nodeList.item(x).getAttributes().getNamedItem("vehicle").getNodeValue()));
		}
		return list;
	}

	public static int calcTime(List<Object> id1, List<Object> time1, List<Object> id2, List<Object> time2) {
		int i1, i2 = 0, id, t1, t2;

		id = (Integer) id1.get(0);
		t1 = (Integer) time1.get(0);
		for (int i = 0; i < id2.size(); i++)
			if ((Integer) id2.get(i) == id) {
				i2 = i;
				if ((Integer) time2.get(i2) > t1)
					break;
			}
		t2 = (Integer) time2.get(i2);
		return t2 - t1;
	}

	public static String bus(String stop1, String stop2) throws Throwable {
		int time = Integer.MAX_VALUE, tempTime = 0;
		String busCode = "";
		for (String b : routes(stop1, stop2)) {
			System.out.println(routes(stop1, stop2));
			String response = getData(b, stop1);
			String response2 = getData(b, stop2);
			List<Object> i1, i2, t1, t2;
			if (response.equals("na") || response2.equals("na"))
				continue;
			i1 = getID(response);
			i2 = getID(response2);
			t1 = getTimes(response);
			t2 = getTimes(response2);
			tempTime = calcTime(i1, t1, i2, t2);
			if (time > tempTime) {
				time = tempTime;
				busCode = b;
			}
		}
		if (busCode.isEmpty()) {
			return "API is currently busy or down. Unable to fetch information.";
		}
		return busCode + " in " + Math.ceil((time + Grab.time) / 60);
	}

	public static List<String> routes(String stop1, String stop2) {
		List<String> r = new ArrayList<String>();
		List<String> wknd1 = Arrays.asList("rutgerss", "scott", "traine", "stuactcntr", "lot48a", "werblinback",
				"hillw", "science", "libofsciw", "buschse", "busch", "beck", "livingston", "quads", "stuactcntrs",
				"pubsafs", "cabaret", "redoak", "lipman", "foodsci", "biel", "henders", "katzenbach", "gibbons",
				"college", "pubsafn", "liberty", "patersonn", "trainn", "zimmerli_2", "stuactcntrn_2", "livingston",
				"quads", "stuactcntrs", "pubsafs", "cabaret", "redoak", "lipman", "foodsci", "biel", "henders",
				"katzenbach", "gibbons", "college", "pubsafn", "liberty", "patersonn", "trainn", "zimmerli_2",
				"stuactcntrn_2", "rutgerss", "scott", "traine", "stuactcntr", "lot48a", "werblinback", "hillw",
				"science", "libofsciw", "buschse", "busch", "beck");
		List<String> wknd2 = Arrays.asList("rutgerss", "scott", "traine", "patersons", "rockoff", "pubsafs", "cabaret",
				"redoak", "lipman", "foodsci", "biel", "henders", "katzenbach", "gibbons", "college", "stuactcntrn",
				"beck", "livingston", "quads", "busch", "davidson", "libofsci", "allison", "hilln", "livingston",
				"quads", "busch", "davidson", "libofsci", "allison", "hilln", "rutgerss", "scott", "traine",
				"patersons", "rockoff", "pubsafs", "cabaret", "redoak", "lipman", "foodsci", "biel", "henders",
				"katzenbach", "gibbons", "college", "stuactcntrn", "beck");
		List<String> lx = Arrays.asList("quads", "rutgerss_a", "scott", "traine", "stuactcntr", "beck", "livingston_a",
				"scott", "traine", "stuactcntr", "beck", "livingston_a", "quads", "rutgerss_a");
		List<String> f = Arrays.asList("scott", "pubsafs", "cabaret", "redoak", "lipman", "foodsci", "biel", "henders",
				"katzenbach", "gibbons", "college_a", "stuactcntr", "rutgerss_a", "henders", "katzenbach", "gibbons",
				"college_a", "stuactcntr", "rutgerss_a", "scott", "pubsafs", "cabaret", "redoak", "lipman", "foodsci",
				"biel");
		List<String> h = Arrays.asList("scott", "traine", "stuactcntr", "werblinm", "buel", "busch_a", "davidson",
				"libofsci", "allison", "hilln", "stadium_a", "rutgerss_a", "scott", "traine", "stuactcntr", "werblinm",
				"buel", "busch_a", "davidson", "libofsci", "allison", "hilln", "stadium_a", "rutgerss_a");
		List<String> a = Arrays.asList("scott", "stuactcntr", "lot48a", "stadium_a", "werblinback", "hillw", "science",
				"libofsciw", "buschse", "busch_a", "buells", "werblinm", "rutgerss_a", "scott", "stuactcntr", "lot48a",
				"stadium_a", "werblinback", "hillw", "science", "libofsciw", "buschse", "busch_a", "buells", "werblinm",
				"rutgerss_a");
		List<String> b = Arrays.asList("quads", "werblinback", "hillw", "science", "libofsci", "buschse", "busch_a",
				"beck", "livingston_a", "quads", "werblinback", "hillw", "science", "libofsci", "buschse", "busch_a",
				"beck", "livingston_a");
		List<String> c = Arrays.asList("werblinback", "hillw", "allison", "hilln", "stadium_a", "allison", "hilln",
				"stadium_a", "werblinback", "hillw");
		List<String> ee = Arrays.asList("scott", "traine", "patersons", "rockoff", "pubsafs", "cabaret", "redoak_a",
				"lipman", "foodsci", "biel", "henders", "katzenbach", "gibbons", "college_a", "pubsafn", "liberty",
				"patersonn", "trainn_a", "zimmerli", "stuactcntr", "rutgerss_a", "henders", "katzenbach", "gibbons",
				"college_a", "pubsafn", "liberty", "patersonn", "trainn_a", "zimmerli", "stuactcntr", "rutgerss_a",
				"scott", "traine", "patersons", "rockoff", "pubsafs", "cabaret", "redoak_a", "lipman", "foodsci",
				"biel");
		List<String> rexl = Arrays.asList("lipman", "college_a", "newstree", "beck", "livingston_a", "pubsafs",
				"rockhall", "cabaret", "redoak_a", "lipman", "college_a", "newstree", "beck", "livingston_a", "pubsafs",
				"rockhall", "cabaret", "redoak_a");
		List<String> rexb = Arrays.asList("lipman", "college_a", "newstree", "hillw", "allison_a", "hilln", "pubsafs",
				"rockhall", "cabaret", "redoak_a", "hilln", "pubsafs", "rockhall", "cabaret", "redoak_a", "lipman",
				"college_a", "newstree", "hillw", "allison_a");
		if (wknd1.contains(stop1) && wknd1.contains(stop2))
			r.add("wknd1");
		if (wknd2.contains(stop1) && wknd2.contains(stop2))
			r.add("wknd2");
		if (lx.contains(stop1) && lx.contains(stop2))
			r.add("lx");
		if (f.contains(stop1) && f.contains(stop2))
			r.add("f");
		if (h.contains(stop1) && h.contains(stop2))
			r.add("h");
		if (a.contains(stop1) && a.contains(stop2))
			r.add("a");
		if (b.contains(stop1) && b.contains(stop2))
			r.add("b");
		if (c.contains(stop1) && c.contains(stop2))
			r.add("c");
		if (ee.contains(stop1) && ee.contains(stop2))
			r.add("ee");
		if (rexl.contains(stop1) && rexl.contains(stop2))
			r.add("rexl");
		if (rexb.contains(stop1) && rexb.contains(stop2))
			r.add("rexb");
		return r;
	}

	public String whichBus(String stop, String stop2) throws Throwable {
		String s = bus(stop, stop2);
		if (s.contains("down"))
			return s;
		else
			return "Take bus: " + s + " minutes. ";
	}
}