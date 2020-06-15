package test.spring.bean;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;

import ch11.logon.LogonDataBean;
public class MemberDAO {
	//mybatis를 사용하기 위한 작업. mybatis는 컨트롤에 세팅되어있음.
	//@Autowired는 사용할 수 없음. @Controller가 있을 때 @Autowired를 사용할 수 있음
	private SqlSessionTemplate sqlSession = null;  
	public MemberDAO(SqlSessionTemplate sqlSession) { //생성자를 통해 받아옴
		this.sqlSession = sqlSession;
	}
	
	//로그인체크
	public int loginCheck(LogonDataBean dto) {
		int check = (int)sqlSession.selectOne("member.loginCheck", dto);
		return check;
	}
	
	//저장
	public void insert(LogonDataBean dto) {
		sqlSession.insert("member.insert", dto);
	}
	
	//id검색
	public List<LogonDataBean> search(String search, String ch) {
		//mybatis는 string은 하나만 보낼 수 있으므로 map으로 작업해서 보냄
		HashMap map = new HashMap();
		map.put("search", search);
		map.put("ch", ch);
		return sqlSession.selectList("member.search", map);
	}
	//아이디 중복확인
	public int confirmId(String id) {
		return sqlSession.selectOne("member.confirmId", id);
		
	}
	
	
	public int chat(String id) {
		int check = (int)sqlSession.selectOne("member.chatIdCheck", id);
		return check;
	}
	
	
}
