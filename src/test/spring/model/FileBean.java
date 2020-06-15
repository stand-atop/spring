package test.spring.model;
import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
@RequestMapping("/file/")
public class FileBean {
	
	@Autowired
	private FileDAO dao = null; //생성한 객체 받아 사용하기 위한 처리
	
	@Autowired
	private FileDTO dto = null; //상동
	
	@RequestMapping("uploadForm.do")
	public String uploadForm() {
		return "/0429/uploadForm";
	}
	
	//파일업로드
	@RequestMapping("uploadPro.do")
	public String uploadPro(MultipartHttpServletRequest request,  String writer) {
							//파일을 업로드 하기 위해 MultipartHttpServletRequest request로 매개변수를 받아야함 
		//form에서 전달된 파일
		MultipartFile mf = request.getFile("save");	//"save"로 전달된 파일을 꺼냄 //원본
		
		String orgName = mf.getOriginalFilename();	//파일원본이름-확장자포함 
		
		/*
		 * //test.aaa.png 확장자 자르는 방법 1 String [] ss = orgName.split("."); String ext =
		 * ss[ss.length-1];
		 */
		
		//test.aaa.png 확장자 자르는 방법 2
		String ext = orgName.substring(orgName.lastIndexOf(".")+1); //확장자
		int max = dao.getMaxNum()+1; //fileDAO에서 max num값을 가져옴. 중복되지 않게 최댓값에 +1함.
		
		//파일이름이 같을 경우 덮어쓰기 되지 않게 하기 위해. : db를 같이 써서(pk이용), 파일이름 처리를 해줌 	
		String sysName = "file_" + max + "." +ext; //이름 지정해줌		
		
		//FileDTO에 넘겨온 값 넣기
		dto.setWriter(writer); //writer - 매개변수 
		dto.setOrgname(orgName); 
		dto.setSysname(sysName); 
		
		//파일업로드
		String path = "d://save//"; //원본 복사해 넣을 파일경로
		
		File fileCopy = new File(path+sysName); //경로와 만든 이름으로.
		
		try {
			mf.transferTo(fileCopy); //파일 복사 실행
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		dao.fileInsert(dto); //파일 업로드 실행
		
		return "/0429/uploadPro";
	}
	/*
	 * //파일을 불러와서 보여줌
	 * 
	 * @RequestMapping("viewFile.do") public String viewFile() {
	 * 
	 * 
	 * return "/0429/viewFile"; }
	 * 
	 */
	
	//파일삭제폼 - DB, 파일 모두 삭제 : 한글파일명처리(한글인코딩 처리)
	@RequestMapping("deleteForm.do")
	public String deleteForm(HttpServletRequest request) {
		List<FileDTO> dto = dao.fileView();
		
		request.setAttribute("list", dto);		
	
		return "/0429/deleteForm";
	}
	
	/*
	 * //파일삭제처리1
	 * 
	 * @RequestMapping("deletePro.do") public String deletePro(HttpServletRequest
	 * request) { try { request.setCharacterEncoding("UTF-8");
	 * 
	 * int num = Integer.parseInt(request.getParameter("num")); String sysName =
	 * request.getParameter("sysname"); //String ext =
	 * sysName.substring(sysName.indexOf(".")); //확장자 뺀 이름
	 * //System.out.println(ext);
	 * 
	 * String filePath = "d://save//" + sysName; boolean delYn = true; File file =
	 * new File(filePath); if(file.exists()) { delYn = file.delete(); if(delYn){
	 * System.out.println("File Delete Success"); //성공 }else{
	 * System.out.println("File Delete Fail"); //실패 } }else{
	 * System.out.println("File Not Found"); //미존재 }
	 * 
	 * dao.deleteFile(num);
	 * 
	 * }catch(Exception e) { e.printStackTrace(); }
	 * 
	 * return "/0429/deletePro"; }
	 */
	
	//파일삭제처리2
		@RequestMapping("deletePro.do")
		public String deletePro(HttpServletRequest request) {
		 
			int num = Integer.parseInt(request.getParameter("num"));
			String sysName = dao.deleteFile(num);
			String filePath = "d://save//" + sysName;
	        File file = new File(filePath);	
	        
	        if(file.exists()) {	        	
	 	        file.delete();
	 	        System.out.println("성공");
	        }else{	 
	            System.out.println("실패");	 
	        }			
					
			return "/0429/deletePro";
		}
}
