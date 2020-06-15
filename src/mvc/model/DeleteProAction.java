package mvc.model;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DeleteProAction implements SuperAction {

	@Override
	public String executeAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		HttpSession session = request.getSession(); //session연결 생성
		
		String id = (String)session.getAttribute("memId");
		String pw = request.getParameter("pw");
		
		TestDAO dao = new TestDAO();
		TestDTO dto = new TestDTO();
			dto.setId(id);
			dto.setPw(pw);
			dao.delete(id, pw);		
		
		return "/WEB-INF/views/test/deletePro.jsp";
		
	}
}

