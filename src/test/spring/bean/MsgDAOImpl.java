package test.spring.bean;

import java.util.List;

public interface MsgDAOImpl {
	
	public int msgCount(String id); //�� ���� ���� ��
	public List<MsgDTO> msgList(String id); //���� ���
	public List<MsgDTO> msgToList(String id); //���� ����
	public List<MsgDTO> msgSearchToList(String id, String ch); //���� ����
	public List<MsgDTO> msgSendList(String id); //��������
	public List<MsgDTO> msgSearchSendList(String id, String ch); //��������
	public void msgInsert(MsgDTO dto); // ��������
	public void msgDelete(int num); //��������
	public MsgDTO msgContent(int num); //���� ����Ȯ��
	public void state(int num); //���� ���º���[1=������, 0=����]
	
	
}
