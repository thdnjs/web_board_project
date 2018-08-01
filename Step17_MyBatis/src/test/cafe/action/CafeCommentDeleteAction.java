package test.cafe.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.cafe.dao.CafeCommentDao;
import test.cafe.dto.CafeCommentDto;
import test.controller.Action;
import test.controller.ActionForward;

public class CafeCommentDeleteAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		int num = Integer.parseInt(request.getParameter("num"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		
		
		CafeCommentDao.getInstance().delete(num);
		
		
		return new ActionForward("/cafe/detail.do?num="+num2,true);
	}

}
