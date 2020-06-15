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
	private SqlSessionTemplate sqlSession = null; //import�ʿ�
	
	@RequestMapping("testAll.do")
	//�޼ҵ��̸� : ������  All(list), �ϳ�  One(DB����Ʈ �� ù��° �ٸ�)
	public String testAll(Model model) {
		
		List<TestDTO> list = sqlSession.selectList("test.selectAll");//testSQL.xml���� mapper�� �� �͵� �� ����� mapper�� id ���?
		
		int max = (int)sqlSession.selectOne("test.maxAge"); //objectŸ���̶� ����ȯ �ʿ�
		//System.out.println(max);
		
		String id = "java4"; //������ �Ѱܹ޾ƾ� �ϴ� ��
		String name = (String)sqlSession.selectOne("test.selectName", id);
		//System.out.println(name);
		
		HashMap map = new HashMap();
		map.put("id", "java4"); //key, value
		map.put("pw", "9999");
		int count = (int)sqlSession.selectOne("test.loginCheck", map); //selectOne(���, hashmap)
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
	 * @RequestMapping("formPro.do") //form���� ������ ��û ó�� public String
	 * formPro(TestDTO dto) { //�����ٰ� ������ model���� Ȱ���� �Ű����� ���� dao.insert(dto); return
	 * "/0428/formPro"; }
	 */
	
	/*
	 * @RequestMapping(value="main.do", method=RequestMethod.POST) public String
	 * main() { return ""; }
	 * 
	 * @RequestMapping({"index.do", "test.do", "data.do"}) //������ �ּҸ� �ϳ���. public
	 * String index() { return ""; }
	 */
	
	
}
