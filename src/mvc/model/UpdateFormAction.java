package mvc.model;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UpdateFormAction implements SuperAction {

	@Override
	public String executeAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("memId");
		
		TestDAO dao = new TestDAO();
		TestDTO dto = dao.selectId(id);
		request.setAttribute("dto", dto);	
		
		return "/WEB-INF/views/test/updateForm.jsp";
	}

}
