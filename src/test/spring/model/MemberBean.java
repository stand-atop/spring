package test.spring.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.omg.CORBA.DynAnyPackage.Invalid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ch11.logon.LogonDataBean;

import test.spring.bean.MemberDAO;

@Controller
@RequestMapping("/member/")
public class MemberBean {

	private List chattingOnList = new ArrayList();

	@Autowired
	// private SqlSessionTemplate sqlSession = null;
	private MemberDAO dao = null;

	@RequestMapping("main.do")
	public String main() {
		return "/member/main";
	}

	@RequestMapping("loginForm.do")
	public String loginForm() {
		return "/member/loginForm";
	}

	@RequestMapping("loginPro.do")
	public String loginPro(LogonDataBean dto, HttpSession session, Model model) {
		// int check = (int)sqlSession.selectOne("member.loginCheck", dto); //결과값 하나기
		// 때문에 selectOne
		int check = dao.loginCheck(dto);

		if (check == 1) {
			session.setAttribute("memId", dto.getId());
		}
		model.addAttribute("check", check);
		return "/member/loginPro";
	}

	@RequestMapping("inputForm.do")
	public String inputForm() {
		return "/member/inputForm";
	}

	@RequestMapping("confirmId.do")
	public String confirmId(String id, Model model) {
		int check = (int) dao.confirmId(id);
		model.addAttribute("check", check);
		model.addAttribute("id", id);
		return "/member/confirmId";
	}

	@RequestMapping("inputPro.do")
	public String inputPro(LogonDataBean dto) {
		// sqlSession.insert("member.insert", dto);//mybatis의 insert메서드
		dao.insert(dto);
		return "/member/inputPro";
	}

	@RequestMapping("modify.do")
	public String gitmodify() {
		return "/member/modify";
	}

	@RequestMapping("modifyForm.do")
	public String gitmodifyForm(HttpSession session, Model model) {
		String id = (String) session.getAttribute("memId");
		//List<LogonDataBean> list = sqlSession.selectList("member.select", id);
		//model.addAttribute("list", list);
		LogonDataBean dto = dao.modifyForm(id);
		model.addAttribute("dto",dto);
		return "/member/modifyForm";
	}

	@RequestMapping("modifyPro.do")
	public String gitmodifyPro(LogonDataBean dto) {
		//sqlSession.update("member.update", dto);
		dao.modifyPro(dto);
		return "/member/modifyPro";
	}

	@RequestMapping("deleteForm.do")
	public String gitdeleteForm() {
		return "/member/deleteForm";
	}

	/*
	@RequestMapping("deletePro.do")
	public String gitdeltePro(LogonDataBean dto, HttpSession session, Model model) {
		String id = (String) session.getAttribute("memId");
		dto.setId(id);

		int check = sqlSession.selectOne("member.deleteCheck", dto);
		if (check == 1) {
			sqlSession.delete("member.delete", dto);
		}
		model.addAttribute("check", check);
		return "/member/deletePro";
	}
	*/
	
	@RequestMapping("deletePro.do")	
	public String gitdeletePro(HttpSession session, Model model, String passwd) {		// AOP조건 O
		String id = (String)session.getAttribute("memId");
		LogonDataBean dto = new LogonDataBean();
		dto.setId(id);
		dto.setPasswd(passwd);
		
		//int check = (int)sqlSession.selectOne("member.loginCheck",dto);
		int check = dao.loginCheck(dto);
		if(check == 1) {
			//sqlSession.delete("member.deletePro", dto);
			dao.deletePro(dto);
			session.removeAttribute("memId");
		}
		model.addAttribute("check", check);
		
		return "/member/deletePro";
	}
	
	
	@RequestMapping("logout.do")
	public String gitlogout(HttpSession session) {
		session.invalidate();
		return "/member/main";
	}

	@RequestMapping("search.do")
	public String search(String search, String ch, Model model) {
		List<LogonDataBean> list = dao.search(search, ch);
		model.addAttribute("list", list);
		return "/member/main";
	}

	// 채팅
	@RequestMapping("chat.do")
	public String chat(HttpSession session, Model model) {
		String id = (String) session.getAttribute("memId");
		if (id == null) {
			return "/member/main";
		}
		int check = dao.chat(id);
		if (check == 1) {
			 if(chattingOnList.size() != 0) {
				 for(int i=0; i<chattingOnList.size(); i++){
					 if(!chattingOnList.contains(id)) { //contains add한 아이디가 기존에 있는지 중복체크함
						 chattingOnList.add(id);
					 }
				 }
			 }else { 
				 chattingOnList.add(id); 
			 } 
			session.setAttribute("chattingOnList", chattingOnList);
			model.addAttribute("chattingOnList", chattingOnList);
			model.addAttribute("id", id);
			return "/chat/chatting";
		}
		return "/member/main";
	}

	/*// 채팅참여자리스트
	@RequestMapping("chattingOnList.do")
	public String chatlist(HttpSession session) {
		String id = (String) session.getAttribute("memId");
		 if(chattingOnList.size() != 0) {
			 for(int i=0; i<chattingOnList.size(); i++){
				 if(!chattingOnList.contains(id)) { //contains add한 아이디가 기존에 있는지 중복체크함
					 chattingOnList.add(id);
				 }
			 }
		 }else { 
			 chattingOnList.add(id); 
		 } 
		session.setAttribute("chattingOnList", chattingOnList);
		return "/member/chatting";
	}*/
	
	@RequestMapping("chattingOnList.do")
	public @ResponseBody String chatlist(HttpSession session) {
		String id = (String) session.getAttribute("memId");
		 if(chattingOnList.size() != 0 ) {
			 for(int i=0; i<chattingOnList.size(); i++){
				 if(!chattingOnList.contains(id)) { //contains add한 아이디가 기존에 있는지 중복체크함
					 chattingOnList.add(id);
				 }
			 }
		 }else { 
			 chattingOnList.add(id); 
		 }
		session.setAttribute("chattingOnList", chattingOnList);
		return chattingOnList+"";
	}

}
