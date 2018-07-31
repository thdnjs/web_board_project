package test.cafe.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.cafe.dao.CafeDao;
import test.cafe.dto.CafeDto;
import test.controller.Action;
import test.controller.ActionForward;

public class CafeUpdateformAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		CafeDto dto = new CafeDto();
		dto.setNum(num);
		
		CafeDto resultDto = CafeDao.getInstance().getData(dto);
		
		request.setAttribute("dto", dto);
		
		return new ActionForward("/views/cafe/updateform.jsp");
	}
	

}
