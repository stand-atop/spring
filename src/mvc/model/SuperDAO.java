package mvc.model;

public interface SuperDAO {
	
	//로그인 확인 리턴 - 성공(true) 실패(false)
	public boolean loginCheck(String id, String pw);
		
	//Test테이블 사용자 입력값 insert
	public void insert(TestDTO dto);
	
	//Test테이블 id/pw 값 확인하여 정보 삭제
	public void delete(String id, String pw);
	
	//Test테이블 id 값 정보 확인
	public TestDTO selectId(String id);
	
	//Test테이블 id에 맞는 정보 수정
	public void update(TestDTO dto);
}
