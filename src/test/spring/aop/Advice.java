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
	
	
	/*before, after�� ����� �� ������ ����
		-mvc �帧 ���� ����
		-ProceedingJoinPoint-�帧�� �����ϴ� ��ü
	*/
	public String around(ProceedingJoinPoint jp) throws Throwable {
		/*
		 * System.out.println("around"); //jp.proceed(); //�������� �̵� //String view =
		 * (String)jp.proceed();//gitMain() System.out.println("after around"); //return
		 * "/error/404error"; //�̷� ������ �ּ������� ������
		 */
		
		//���� �������� request�� ������ �����´�.
		//HttpServletRequest/SevletRequest ũ�� �ΰ����� ����. 
		//HttpServletRequest : ���� �Ķ���Ϳ��� ���� request
		//SevletRequest : ������ ���õ� request
		ServletRequestAttributes sr = (ServletRequestAttributes)RequestContextHolder.currentRequestAttributes();
																					//�������� ������Ʈ�� ��� request ���� ������?
		HttpServletRequest request = sr.getRequest();
		HttpSession session = request.getSession();	
		if(session != null) {
			String id = (String)session.getAttribute("memId"); 
			if(id==null || id.equals("")) {
				return "redirect:/member/loginForm.do";//�ٽ� .do�� ����
			}
		}
		return (String)jp.proceed();
	}
}
