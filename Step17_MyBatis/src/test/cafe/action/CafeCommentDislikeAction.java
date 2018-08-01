package test.cafe.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.cafe.dao.CafeCommentEvaluationDao;
import test.cafe.dto.CafeCommentEvaluationDto;
import test.controller.Action;
import test.controller.ActionForward;

public class CafeCommentDislikeAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		String id=(String)request.getSession().getAttribute("id");
		
		int num = Integer.parseInt(request.getParameter("num"));//댓글 넘버
		int num2 = Integer.parseInt(request.getParameter("num2"));//댓글을 쓴 글넘버
		
		CafeCommentEvaluationDto dto = new CafeCommentEvaluationDto();
		dto.setId(id);
		dto.setDislikeCommentNum(num);
		
		CafeCommentEvaluationDao.getInstance().insert(dto);
		
		return new ActionForward("/cafe/detail.do?num="+num2,true);
	}

}
