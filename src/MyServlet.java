
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This is my first servlet example.
 */
@WebServlet("/hello")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MyServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*response.setContentType("text/html");*/

		PrintWriter out = response.getWriter();
		UserDAO userDAO= new UserDAO();

		userDAO.insertUsers();
		
		out.println("<h1>" + "Users List" + "</h1>");
		ArrayList<UserBean> users = new ArrayList<>();
		users =userDAO.GetUsers();
		UserBean d = new UserBean();
//		d.setIduser(1);
//		d.setFirstName("John");
//		d.setLastName("asa");
//		d.setFirstName("asa");
//		d.setPassword("asa");
		
		//userDAO.setFirstName("asa");
		for (UserBean user : users)
		{
			out.println("<br/> User id "+ user.getIduser());
			out.println("<br/>User firtName " + user.getFirstName());
			out.println("<br/>User lastName "+ user.getLastName());
			out.println("<br/>username " + user.getUsername());
			out.println("<br/>password "+ user.getPassword());
		}
		
		
		/*RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/mypage.html");
		rd.forward(request, response);*/
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
