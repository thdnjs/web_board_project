package test.cafe.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.cafe.dao.CafeCommentEvaluationDao;
import test.cafe.dto.CafeCommentEvaluationDto;
import test.controller.Action;
import test.controller.ActionForward;

public class CafeCommentLikeAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		String id=(String)request.getSession().getAttribute("id");//누가 좋아요했는지  
		
		int num = Integer.parseInt(request.getParameter("num"));//댓글 넘버 -> 
		int num2 = Integer.parseInt(request.getParameter("num2"));//댓글을 쓴 글넘버 -> 넘겨주기용
		
		CafeCommentEvaluationDto dto = new CafeCommentEvaluationDto();
		dto.setId(id);
		dto.setLikeCommentNum(num);
		
		CafeCommentEvaluationDao.getInstance().insert(dto);
		
		int likeSum = CafeCommentEvaluationDao.getInstance().getlikeSum(num);
		
		return new ActionForward("/cafe/detail.do?num="+num2,true);
	}

}
