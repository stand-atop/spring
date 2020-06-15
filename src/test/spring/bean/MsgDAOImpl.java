package test.spring.bean;

import java.util.List;

public interface MsgDAOImpl {
	
	public int msgCount(String id); //안 읽은 쪽지 수
	public List<MsgDTO> msgList(String id); //쪽지 목록
	public List<MsgDTO> msgToList(String id); //받은 쪽지
	public List<MsgDTO> msgSearchToList(String id, String ch); //받은 쪽지
	public List<MsgDTO> msgSendList(String id); //보낸쪽지
	public List<MsgDTO> msgSearchSendList(String id, String ch); //보낸쪽지
	public void msgInsert(MsgDTO dto); // 쪽지쓰기
	public void msgDelete(int num); //쪽지삭제
	public MsgDTO msgContent(int num); //쪽지 내용확인
	public void state(int num); //쪽지 상태변경[1=안읽음, 0=읽음]
	
	
}
