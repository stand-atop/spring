package test.spring.model;

import javax.servlet.http.HttpSession;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import test.spring.bean.MsgDAO;
import test.spring.bean.MsgDTO;

@Controller
@RequestMapping("/msg/")
public class MsgBean {
	
	@Autowired
	private MsgDAO dao = null;
	
	@RequestMapping("form.do")
	public String form() {
		return "/msg/form";
	}
	
	@RequestMapping("formPro.do")
	public String formPro(MsgDTO dto) {
		dao.msgInsert(dto);
		return "/msg/formPro";
	}
	
	@RequestMapping("list.do")
	public String list(HttpSession session, Model model) {
		String id = (String)session.getAttribute("memId");
		//List<MsgDTO> list = dao.msgList(id);
		List<MsgDTO> tolist = dao.msgToList(id);
		List<MsgDTO> sendlist = dao.msgSendList(id);
		//model.addAttribute("list", list);
		model.addAttribute("tolist", tolist);
		model.addAttribute("sendlist", sendlist);
		return "/msg/list";
	}
	
	@RequestMapping("tolist.do")
	public String tolist(HttpSession session, String ch, Model model) {
		String id = (String)session.getAttribute("memId");
		List<MsgDTO> searchtolist = dao. msgSearchToList(id, ch);
		model.addAttribute("tolist", searchtolist);		
		return "/msg/tolist";
	}
	
	@RequestMapping("sendlist.do")
	public String sendlist(HttpSession session, String ch, Model model) {
		String id = (String)session.getAttribute("memId");
		List<MsgDTO> searchsendlist = dao.msgSearchSendList(id, ch);
		model.addAttribute("sendlist", searchsendlist);
		return "/msg/sendlist";
	}
	
	@RequestMapping("count.do")
	public @ResponseBody String count(HttpSession session) { //리턴타입 자체가 결과라는 의미로 @ResponseBody를 사용. String으로 적용됨.
		String id = (String)session.getAttribute("memId");
		//dao.msgCount(id);
		//return dao.msgCount(id);
		
		int count = dao.msgCount(id);
		return count+"";
	}
	
	@RequestMapping("content.do")
	public String content(int num, Model model) {
		MsgDTO dto = dao.msgContent(num);
		dao.state(num);
		model.addAttribute("dto", dto);
		return "/msg/content";
	}
	
	@RequestMapping("delete.do")
	public String delete(int num) {
		dao.msgDelete(num);
		return "/msg/delete";
	}
}
