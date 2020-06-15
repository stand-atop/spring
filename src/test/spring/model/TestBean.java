package test.spring.model;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/test/")
public class TestBean {
	
	/*
	 * @Autowired private TestDAO dao = null;;
	 */
	
	@Autowired
	private SqlSessionTemplate sqlSession = null; //import필요
	
	@RequestMapping("testAll.do")
	//메소드이름 : 여러개  All(list), 하나  One(DB리스트 중 첫번째 줄만)
	public String testAll(Model model) {
		
		List<TestDTO> list = sqlSession.selectList("test.selectAll");//testSQL.xml에서 mapper로 쓴 것들 중 사용할 mapper의 id 경로?
		
		int max = (int)sqlSession.selectOne("test.maxAge"); //object타입이라 형변환 필요
		//System.out.println(max);
		
		String id = "java4"; //원래는 넘겨받아야 하는 값
		String name = (String)sqlSession.selectOne("test.selectName", id);
		//System.out.println(name);
		
		HashMap map = new HashMap();
		map.put("id", "java4"); //key, value
		map.put("pw", "9999");
		int count = (int)sqlSession.selectOne("test.loginCheck", map); //selectOne(경로, hashmap)
		//System.out.println(count);
		
		list = sqlSession.selectList("test.selectMap");		
		
		model.addAttribute("list", list);	
		
		return "/0501/testAll";
	}
	
	@RequestMapping("form.do")
	public String form() {		
		return "/0428/form";
	}
	
	@RequestMapping("formPro.do")
	public String formPro(TestDTO dto) { 
		
		System.out.println(dto.getName());
		
		sqlSession.insert("test.testInsert",dto); 
		return 	 "/0428/formPro"; 
	}
	
	/*
	 * @RequestMapping("formPro.do") //form에서 보내는 요청 처리 public String
	 * formPro(TestDTO dto) { //돌려줄게 있으면 model등을 활용해 매개변수 지정 dao.insert(dto); return
	 * "/0428/formPro"; }
	 */
	
	/*
	 * @RequestMapping(value="main.do", method=RequestMethod.POST) public String
	 * main() { return ""; }
	 * 
	 * @RequestMapping({"index.do", "test.do", "data.do"}) //여러개 주소를 하나에. public
	 * String index() { return ""; }
	 */
	
	
}
