package test.spring.bean;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;

import ch11.logon.LogonDataBean;
public class MemberDAO {
	//mybatis�� ����ϱ� ���� �۾�. mybatis�� ��Ʈ�ѿ� ���õǾ�����.
	//@Autowired�� ����� �� ����. @Controller�� ���� �� @Autowired�� ����� �� ����
	private SqlSessionTemplate sqlSession = null;  
	public MemberDAO(SqlSessionTemplate sqlSession) { //�����ڸ� ���� �޾ƿ�
		this.sqlSession = sqlSession;
	}
	
	//�α���üũ
	public int loginCheck(LogonDataBean dto) {
		int check = (int)sqlSession.selectOne("member.loginCheck", dto);
		return check;
	}
	
	//����
	public void insert(LogonDataBean dto) {
		sqlSession.insert("member.insert", dto);
	}
	
	//id�˻�
	public List<LogonDataBean> search(String search, String ch) {
		//mybatis�� string�� �ϳ��� ���� �� �����Ƿ� map���� �۾��ؼ� ����
		HashMap map = new HashMap();
		map.put("search", search);
		map.put("ch", ch);
		return sqlSession.selectList("member.search", map);
	}
	//���̵� �ߺ�Ȯ��
	public int confirmId(String id) {
		return sqlSession.selectOne("member.confirmId", id);
		
	}
	
	
	public int chat(String id) {
		int check = (int)sqlSession.selectOne("member.chatIdCheck", id);
		return check;
	}
	
	
}
