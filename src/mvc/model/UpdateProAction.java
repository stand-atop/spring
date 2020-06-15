package mvc.model;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UpdateProAction implements SuperAction {

	@Override
	public String executeAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession(); //session연결 생성		
		String id = (String)session.getAttribute("memId");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		
		TestDAO dao = new TestDAO();
		TestDTO dto = new TestDTO();
			dto.setId(id);
			dto.setPw(pw);
			dto.setName(name);
			dto.setAge(age);
			dao.update(dto);		
		
		return "/WEB-INF/views/test/updatePro.jsp";
	}

}
