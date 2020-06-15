package mvc.model;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class InfoAction implements SuperAction {

	@Override
	public String executeAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("memId");
		
		TestDTO dto = new TestDTO();
		TestDAO dao = new TestDAO();
		
		dto = dao.selectId(id);
		
		request.setAttribute("dto", dto); //정보를 보내줌
		
		return "/WEB-INF/views/test/info.jsp";
	}
	
}