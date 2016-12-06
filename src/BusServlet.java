

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import echo.busChecker.*;

/**
 * Servlet implementation class BusServlet
 */
@WebServlet("/BusServlet")
public class BusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BusServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		log("LDGWELGELWGN");
//		String x = request.getParameter("stops");
//		//String[] abc = {x.substring(0, x.indexOf(':')), x.substring(x.indexOf(':')+1, x.length())};
//		Grab a = new Grab();
//		String ans = "";
//		String getOn = "";
//			try {
//				getOn = a.getOn(a.coor(""));
//			} catch (SAXException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (ParserConfigurationException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (Throwable e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//		String getOff = "";
//			try {
//				getOff = a.getOff(a.coor(""));
//			} catch (SAXException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (ParserConfigurationException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (Throwable e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//			try {
//				ans = getOn + "|" + getOff + "|" + Btime.bus(getOn, getOff);
//			} catch (Throwable e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//		
//		response.setContentType("text/plain");
//        response.getWriter().println(ans);
		String output = request.getHeader("stops");
		 		System.out.println(output);
		 		String[] abc = {output.substring(0, output.indexOf(':')), output.substring(output.indexOf(':')+1, output.length())};
		 		String q = "";
		 		try {
		 			Btime.bus(abc[0].toLowerCase(), abc[1].toLowerCase());
		 			System.out.println(q);
		 			q = q.substring(0, q.indexOf("-")-1);
		 		} catch (Throwable e) {
		 			// TODO Auto-generated catch block
		 			e.printStackTrace();
		 		}
		 	PrintWriter out = response.getWriter();
		 	out.println(q);
		 }
	}

}
