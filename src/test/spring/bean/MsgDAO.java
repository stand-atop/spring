package test.spring.bean;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

public class MsgDAO implements MsgDAOImpl{

	private SqlSessionTemplate sqlSession= null;
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public int msgCount(String id) {
		/*int count = (int)sqlSession.selectOne("msg.count", id);
		return count;*/
		return (int)sqlSession.selectOne("msg.count", id);
	}
	
	@Override
	public List<MsgDTO> msgList(String id) {
		return sqlSession.selectList("msg.msgAll", id);
	}
	
	@Override
	public List<MsgDTO> msgToList(String id){
		return sqlSession.selectList("msg.msgTo", id);
	}

	@Override
	public List<MsgDTO> msgSendList(String id) {
		return sqlSession.selectList("msg.msgSend", id);
	}
	

	@Override
	public void msgInsert(MsgDTO dto) {
		sqlSession.insert("msg.insert", dto);
	}

	@Override
	public void msgDelete(int num) {
		sqlSession.delete("msg.delete", num);
	}


	@Override
	public MsgDTO msgContent(int num) {
		return (MsgDTO)sqlSession.selectOne("msg.selectNum", num);
	}
	

	@Override
	public void state(int num) {
		sqlSession.update("msg.state", num);
	}

	@Override
	public List<MsgDTO> msgSearchToList(String id, String ch) {
		HashMap map = new HashMap();
		map.put("search",  id);
		map.put("ch", ch);
		return sqlSession.selectList("msg.search", map);
	}

	@Override
	public List<MsgDTO> msgSearchSendList(String id, String ch) {
		HashMap map = new HashMap();
		map.put("search", id);
		map.put("ch", ch);
		return sqlSession.selectList("msg.search", map);
	}





}
