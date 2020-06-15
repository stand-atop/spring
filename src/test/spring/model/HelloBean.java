package test.spring.model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.RequestMapping; 

@Controller 
public class HelloBean{ 
	
	/*
	 * @Autowired //클래스, 메서드, 변수에 선행적으로 선언해주면 부가적 특징을 부여해준 것. //직접 생성하지 않고 연결
	 * 받겠다.-컨트롤에서.:변수 이름과 컨트롤에서 작성한 id를 맞춰 찾아옴 private TestDTO dto5 = null; //객체생성
	 * 한것 아님
	 * 
	 * @RequestMapping("hello.do") //requestmapping = 경로 public String hello(){ //
	 * 액션태그 안에서 처리하던 내용들을 작성하면 됨. System.out.println(dto5.getId());
	 * System.out.println(dto5.getDay());//객체생성하지 않은 상태에서 바로 출력
	 * 
	 * return "/WEB-INF/views/0427/hello.jsp"; }
	 */

} 
