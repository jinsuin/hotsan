package kr.ac.shinhan.csp;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class GetandPostReportServlet extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		String name = req.getParameter("name");
		String id = req.getParameter("id");
		String num = req.getParameter("num");
		String email = req.getParameter("email");
		String kakaoid = req.getParameter("kakaoid");
		String gitid = req.getParameter("gitid");
		boolean check = req.getParameter("chk_info") != null;

		// database insert
		TeamMember tm = new TeamMember(name, id, num, email, kakaoid, gitid,
				check);
		PersistenceManager pm = MyPersistenceManager.getManager();
		pm.makePersistent(tm);

		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");

		resp.getWriter().println("<html>");
		resp.getWriter().println("<body>");
		resp.getWriter().println("<h1>" + "다음과 같은 새로운 팀원이 등록되었습니다" + "</h1>");
		resp.getWriter().println("<table border=1>");
		resp.getWriter().println(
				"<tr>" + "<td>" + "이름  " + "</td>" + "<td>" + name + "</td>"
						+ "</tr>");
		resp.getWriter().println(
				"<tr>" + "<td>" + "학번  " + "</td>" + "<td>" + id + "</td>"
						+ "</tr>");
		resp.getWriter().println(
				"<tr>" + "<td>" + "전화번호 : " + "</td>" + "<td>" + num + "</td>"
						+ "</tr>");
		resp.getWriter().println(
				"<tr>" + "<td>" + "메일주소 : " + "</td>" + "<td>" + email
						+ "</td>" + "</tr>");
		resp.getWriter().println(
				"<tr>" + "<td>" + "카카오톡 아이디 : " + "</td>" + "<td>" + kakaoid
						+ "</td>" + "</tr>");
		if (check != true)
			resp.getWriter().println(
					"<tr>" + "<td>" + "팀장여부" + "</td>" + "<td>" + "팀원입니다"
							+ "</td>" + "</tr>");
		else
			resp.getWriter().println(
					"<tr>" + "<td>" + "팀장여부" + "</td>" + "<td>" + "팀장"
							+ "</td>" + "</tr>");
		resp.getWriter().println(
				"<tr>" + "<td>" + "GitHub ID" + "</td>" + "<td>" + gitid
						+ "</td>" + "</tr>");
		resp.getWriter().println("</table>");
		resp.getWriter().println("</body>");
		resp.getWriter().println("</html>");
	}

}
