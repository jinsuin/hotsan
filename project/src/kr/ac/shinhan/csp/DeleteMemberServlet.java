package kr.ac.shinhan.csp;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteMemberServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		String key = req.getParameter("key");
		Long longKey = Long.parseLong(key);

		PersistenceManager pm = MyPersistenceManager.getManager();
		TeamMember tm = pm.getObjectById(TeamMember.class, longKey); // 키에 따른 팀
		pm.deletePersistent(tm);
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");

		resp.getWriter().println("<html>");
		resp.getWriter().println("<body>");

		resp.getWriter().println("<h1>" + "삭제가 완료되었습니다!" + "<h2>");
		resp.getWriter().println(
				"<a href=" + "retrive" + ">" + "뒤로가기" + "</a>" + "</br>");
		resp.getWriter().println(
				"<a href=" + "index.html" + ">" + "처음으로" + "</a>" + "</br>");

		resp.getWriter().println("</body>");
		resp.getWriter().println("</html>");

	}

}
