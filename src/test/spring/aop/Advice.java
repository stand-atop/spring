package test.spring.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class Advice {
	/*
	 * public void before() { System.out.println("before advice"); } public void
	 * after() { System.out.println("after advice"); }
	 */
	
	
	/*before, after의 기능을 다 가지고 있음
		-mvc 흐름 제어 가능
		-ProceedingJoinPoint-흐름을 제어하는 객체
	*/
	public String around(ProceedingJoinPoint jp) throws Throwable {
		/*
		 * System.out.println("around"); //jp.proceed(); //목적지로 이동 //String view =
		 * (String)jp.proceed();//gitMain() System.out.println("after around"); //return
		 * "/error/404error"; //이런 형태의 주소지정도 가능함
		 */
		
		//현재 실행중인 request의 정보를 가져온다.
		//HttpServletRequest/SevletRequest 크게 두가지가 있음. 
		//HttpServletRequest : 평상시 파라미터에서 빼던 request
		//SevletRequest : 서버와 관련된 request
		ServletRequestAttributes sr = (ServletRequestAttributes)RequestContextHolder.currentRequestAttributes();
																					//동작중인 프로젝트의 모든 request 값을 가져옴?
		HttpServletRequest request = sr.getRequest();
		HttpSession session = request.getSession();	
		if(session != null) {
			String id = (String)session.getAttribute("memId"); 
			if(id==null || id.equals("")) {
				return "redirect:/member/loginForm.do";//다시 .do로 보냄
			}
		}
		return (String)jp.proceed();
	}
}
