package minecrafthelper;

import java.io.StringReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
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
					new URL(
							"http://webservices.nextbus.com/service/publicXMLFeed?command=predictions&a=rutgers&r="
									+ bus + "&s=" + stop).openStream(), "UTF-8")
					.useDelimiter("\\A").next();
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
			list.add(Integer.parseInt(nodeList.item(x).getAttributes()
					.getNamedItem("seconds").getNodeValue()));
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
			list.add(Integer.parseInt(nodeList.item(x).getAttributes()
					.getNamedItem("vehicle").getNodeValue()));
		}
		return list;
	}

	public static int calcTime(List<Object> id1, List<Object> time1,
			List<Object> id2, List<Object> time2) {
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
		if (busCode.isEmpty())
			return "API is currently busy or down. Unable to fetch information.";
		return busCode + " in " + Math.ceil((time+Grab.time)/60);
	}

	public static List<String> routes(String stop1, String stop2) {
		List<String> r = new ArrayList<String>();
		List<String> wknd1 = Arrays.asList("rutgerss", "scott", "traine",
				"stuactcntr", "lot48a", "werblinback", "hillw", "science",
				"libofsciw", "buschse", "busch", "beck", "livingston", "quads",
				"stuactcntrs", "pubsafs", "cabaret", "redoak", "lipman",
				"foodsci", "biel", "henders", "katzenbach", "gibbons",
				"college", "pubsafn", "liberty", "patersonn", "trainn",
				"zimmerli_2", "stuactcntrn_2", "livingston", "quads",
				"stuactcntrs", "pubsafs", "cabaret", "redoak", "lipman",
				"foodsci", "biel", "henders", "katzenbach", "gibbons",
				"college", "pubsafn", "liberty", "patersonn", "trainn",
				"zimmerli_2", "stuactcntrn_2", "rutgerss", "scott", "traine",
				"stuactcntr", "lot48a", "werblinback", "hillw", "science",
				"libofsciw", "buschse", "busch", "beck");
		List<String> wknd2 = Arrays.asList("rutgerss", "scott", "traine",
				"patersons", "rockoff", "pubsafs", "cabaret", "redoak",
				"lipman", "foodsci", "biel", "henders", "katzenbach",
				"gibbons", "college", "stuactcntrn", "beck", "livingston",
				"quads", "busch", "davidson", "libofsci", "allison", "hilln",
				"livingston", "quads", "busch", "davidson", "libofsci",
				"allison", "hilln", "rutgerss", "scott", "traine", "patersons",
				"rockoff", "pubsafs", "cabaret", "redoak", "lipman", "foodsci",
				"biel", "henders", "katzenbach", "gibbons", "college",
				"stuactcntrn", "beck");
		if (wknd1.contains(stop1) && wknd1.contains(stop2))
			r.add("wknd1");
		if (wknd2.contains(stop1) && wknd2.contains(stop2))
			r.add("wknd2");
		return r;
	}

	public String whichBus(String stop, String stop2) throws Throwable {
			String s = bus(stop,stop2);
			if(s.contains("down")) 
				return s; 
			else
				return "Take bus: " + s + " minutes. ";
	}
}