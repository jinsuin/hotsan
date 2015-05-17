package kr.ac.shinhan.csp;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RetriveTeamMemberServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		PersistenceManager pm = MyPersistenceManager.getManager();
		Query qry = pm.newQuery(TeamMember.class);
		List<TeamMember> memberList = (List<TeamMember>) qry.execute();

		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");

		resp.getWriter().println("<html>");
		resp.getWriter().println("<body>");
		resp.getWriter().println("<table border='1'>");
		resp.getWriter().println("<tr>");
		resp.getWriter().println("<th>" + "이름" + "</th>"); // 맨처음행
		resp.getWriter().println("<th>" + "학번" + "</th>");
		resp.getWriter().println("<th>" + "전화번호" + "</th>");
		resp.getWriter().println("<th>" + "메일주소" + "</th>");
		resp.getWriter().println("<th>" + "카카오톡 아이디" + "</th>");
		resp.getWriter().println("<th>" + "팀장여부" + "</th>");
		resp.getWriter().println("<th>" + "GitHub ID" + "</th>");
		resp.getWriter().println("<th>" + "회원삭제" + "</th>");
		resp.getWriter().println("</tr>");

		for (TeamMember tm : memberList) {
			resp.getWriter().println("<tr>");
			resp.getWriter().println(
					"<td>" + "<a href =/readteammember?key=" + tm.getKey()
							+ ">" + tm.getName() + "</td>");
			resp.getWriter().println("<td>" + tm.getid() + "</td>");
			resp.getWriter().println("<td>" + tm.getNum() + "</td>");
			resp.getWriter().println("<td>" + tm.getEmail() + "</td>");
			resp.getWriter().println("<td>" + tm.getKakaoid() + "</td>");
			if (tm.isChkinfo() == true)
				resp.getWriter().println("<td>" + "팀장" + "</td>");
			else
				resp.getWriter().println("<td>" + "팀원입니다" + "</td>");
			resp.getWriter().println("<td>" + tm.getGitid() + "</td>");
			resp.getWriter().println(
					"<td>" + "<a href =/deletemember?key=" + tm.getKey() + ">"
							+ "삭제" + "</td>");
			resp.getWriter().println("</tr>");
		}
		resp.getWriter().println("</table>");
		resp.getWriter().println("</body>");
		resp.getWriter().println("</html>");
	}

}
