package test.cafe.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.cafe.dao.CafeCommentDao;
import test.cafe.dto.CafeCommentDto;
import test.controller.Action;
import test.controller.ActionForward;

public class CafeCommentUpdateAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		String writer = request.getParameter("writer");
		int ref_group = Integer.parseInt(request.getParameter("ref_group"));
		String target_id = request.getParameter("target_id");
		String content = request.getParameter("content");
		int num = Integer.parseInt(request.getParameter("num"));
		
		//null이면 원글에 단 댓글이다.
		String comment_group = request.getParameter("comment_group");
		//저장할 댓글의 번호를 미리 얻어낸다.
		int seq = CafeCommentDao.getInstance().getSequence();
		
		CafeCommentDto dto = new CafeCommentDto();
		dto.setNum(num);
		dto.setWriter(writer);
		dto.setTarget_id(target_id);
		dto.setContent(content);
		dto.setRef_group(ref_group);
		if(comment_group == null) {
			dto.setComment_group(seq);
		}else { //댓글의 댓글인 경우
			dto.setComment_group(Integer.parseInt(comment_group));
		}
		
		CafeCommentDao.getInstance().update(dto);
		
	
		//리다이렉트 이동 응답
		return new ActionForward("/cafe/detail.do?num="+ref_group,true);
	}

}
