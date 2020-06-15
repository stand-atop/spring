package mvc.model;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginProAction implements SuperAction {

	@Override
	public String executeAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw"); //loginForm���� �ѱ� ������ �޾���
		TestDAO dao = new TestDAO(); //DAO�۾��� ���� ����		
		//����� view�� ����
		boolean ch = dao.loginCheck(id, pw); //SuperDAO �������̽��� ������ ���� �� Ȱ��
		
		if(ch == true) { //true�϶� session ����
			HttpSession session = request.getSession(); //session���� ����
			session.setAttribute("memId", id);
		}
		//false�� �� �α��� Ȯ�� �޽��� ���� - pro���� ó��
		request.setAttribute("ch", ch);

		return "/WEB-INF/views/test/loginPro.jsp"; //������ loginPro.jsp�� ����
	}
}
