package mvc.model;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface SuperAction {
	public String executeAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	//controller의 service()를 그대로 가져다 만듬
}
