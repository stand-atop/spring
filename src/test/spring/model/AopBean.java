package test.spring.model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/aop/")
public class AopBean {
	
	@RequestMapping("main.do")
	public String gitMain() {
		System.out.println("main");
		return "/0506/main";
	}
}
