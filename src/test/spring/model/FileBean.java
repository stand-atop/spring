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
	private FileDAO dao = null; //������ ��ü �޾� ����ϱ� ���� ó��
	
	@Autowired
	private FileDTO dto = null; //��
	
	@RequestMapping("uploadForm.do")
	public String uploadForm() {
		return "/0429/uploadForm";
	}
	
	//���Ͼ��ε�
	@RequestMapping("uploadPro.do")
	public String uploadPro(MultipartHttpServletRequest request,  String writer) {
							//������ ���ε� �ϱ� ���� MultipartHttpServletRequest request�� �Ű������� �޾ƾ��� 
		//form���� ���޵� ����
		MultipartFile mf = request.getFile("save");	//"save"�� ���޵� ������ ���� //����
		
		String orgName = mf.getOriginalFilename();	//���Ͽ����̸�-Ȯ�������� 
		
		/*
		 * //test.aaa.png Ȯ���� �ڸ��� ��� 1 String [] ss = orgName.split("."); String ext =
		 * ss[ss.length-1];
		 */
		
		//test.aaa.png Ȯ���� �ڸ��� ��� 2
		String ext = orgName.substring(orgName.lastIndexOf(".")+1); //Ȯ����
		int max = dao.getMaxNum()+1; //fileDAO���� max num���� ������. �ߺ����� �ʰ� �ִ񰪿� +1��.
		
		//�����̸��� ���� ��� ����� ���� �ʰ� �ϱ� ����. : db�� ���� �Ἥ(pk�̿�), �����̸� ó���� ���� 	
		String sysName = "file_" + max + "." +ext; //�̸� ��������		
		
		//FileDTO�� �Ѱܿ� �� �ֱ�
		dto.setWriter(writer); //writer - �Ű����� 
		dto.setOrgname(orgName); 
		dto.setSysname(sysName); 
		
		//���Ͼ��ε�
		String path = "d://save//"; //���� ������ ���� ���ϰ��
		
		File fileCopy = new File(path+sysName); //��ο� ���� �̸�����.
		
		try {
			mf.transferTo(fileCopy); //���� ���� ����
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		dao.fileInsert(dto); //���� ���ε� ����
		
		return "/0429/uploadPro";
	}
	/*
	 * //������ �ҷ��ͼ� ������
	 * 
	 * @RequestMapping("viewFile.do") public String viewFile() {
	 * 
	 * 
	 * return "/0429/viewFile"; }
	 * 
	 */
	
	//���ϻ����� - DB, ���� ��� ���� : �ѱ����ϸ�ó��(�ѱ����ڵ� ó��)
	@RequestMapping("deleteForm.do")
	public String deleteForm(HttpServletRequest request) {
		List<FileDTO> dto = dao.fileView();
		
		request.setAttribute("list", dto);		
	
		return "/0429/deleteForm";
	}
	
	/*
	 * //���ϻ���ó��1
	 * 
	 * @RequestMapping("deletePro.do") public String deletePro(HttpServletRequest
	 * request) { try { request.setCharacterEncoding("UTF-8");
	 * 
	 * int num = Integer.parseInt(request.getParameter("num")); String sysName =
	 * request.getParameter("sysname"); //String ext =
	 * sysName.substring(sysName.indexOf(".")); //Ȯ���� �� �̸�
	 * //System.out.println(ext);
	 * 
	 * String filePath = "d://save//" + sysName; boolean delYn = true; File file =
	 * new File(filePath); if(file.exists()) { delYn = file.delete(); if(delYn){
	 * System.out.println("File Delete Success"); //���� }else{
	 * System.out.println("File Delete Fail"); //���� } }else{
	 * System.out.println("File Not Found"); //������ }
	 * 
	 * dao.deleteFile(num);
	 * 
	 * }catch(Exception e) { e.printStackTrace(); }
	 * 
	 * return "/0429/deletePro"; }
	 */
	
	//���ϻ���ó��2
		@RequestMapping("deletePro.do")
		public String deletePro(HttpServletRequest request) {
		 
			int num = Integer.parseInt(request.getParameter("num"));
			String sysName = dao.deleteFile(num);
			String filePath = "d://save//" + sysName;
	        File file = new File(filePath);	
	        
	        if(file.exists()) {	        	
	 	        file.delete();
	 	        System.out.println("����");
	        }else{	 
	            System.out.println("����");	 
	        }			
					
			return "/0429/deletePro";
		}
}
