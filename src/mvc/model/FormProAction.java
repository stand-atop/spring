package mvc.model;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormProAction implements SuperAction{

	@Override
	public String executeAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		
		TestDAO dao = new TestDAO();
		TestDTO dto = new TestDTO();
			dto.setId(id);
			dto.setPw(pw);
			dto.setName(name);
			dto.setAge(age);	
			dao.insert(dto);
	
		return "/WEB-INF/views/test/formPro.jsp";
	}

}
