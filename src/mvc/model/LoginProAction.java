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
		String pw = request.getParameter("pw"); //loginForm에서 넘긴 정보를 받아줌
		TestDAO dao = new TestDAO(); //DAO작업을 위한 선언		
		//결과를 view로 보냄
		boolean ch = dao.loginCheck(id, pw); //SuperDAO 인터페이스에 정의해 놓은 것 활용
		
		if(ch == true) { //true일때 session 연결
			HttpSession session = request.getSession(); //session연결 생성
			session.setAttribute("memId", id);
		}
		//false일 때 로그인 확인 메시지 보냄 - pro에서 처리
		request.setAttribute("ch", ch);

		return "/WEB-INF/views/test/loginPro.jsp"; //정보를 loginPro.jsp로 보냄
	}
}
