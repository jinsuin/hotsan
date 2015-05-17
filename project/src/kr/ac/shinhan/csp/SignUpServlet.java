package kr.ac.shinhan.csp;

import java.io.IOException;
import java.util.List;

import javax.jdo.Query;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SignUpServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String password = req.getParameter("password");

		Query qry = MyPersistenceManager.getManager().newQuery(
				UserAccount.class);

		qry.setFilter("userID == idParam");
		qry.declareParameters("String idParam");

		List<UserAccount> userAccount = (List<UserAccount>) qry.execute(id);

		if (userAccount.size() == 0) {
			UserAccount ua = new UserAccount(id, password, name);

			MyPersistenceManager.getManager().makePersistent(ua);

			resp.sendRedirect("login.html");
		} else {
			resp.getWriter().println("<html>");
			resp.getWriter().println("<body>");
			resp.getWriter().println("Fail to SignUp");
			resp.getWriter().println("<a href='signup.html'>SignUp Again</a>");
			resp.getWriter().println("</body>");
			resp.getWriter().println("</html>");
		}
	}

}
