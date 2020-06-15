package mvc.model;

public interface SuperDAO {
	
	//�α��� Ȯ�� ���� - ����(true) ����(false)
	public boolean loginCheck(String id, String pw);
		
	//Test���̺� ����� �Է°� insert
	public void insert(TestDTO dto);
	
	//Test���̺� id/pw �� Ȯ���Ͽ� ���� ����
	public void delete(String id, String pw);
	
	//Test���̺� id �� ���� Ȯ��
	public TestDTO selectId(String id);
	
	//Test���̺� id�� �´� ���� ����
	public void update(TestDTO dto);
}
