package test.cafe.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.cafe.dao.CafeCommentDao;
import test.cafe.dao.CafeDao;
import test.cafe.dto.CafeCommentDto;
import test.cafe.dto.CafeDto;
import test.controller.Action;
import test.controller.ActionForward;


//글 자세히 보기 요청 처리

public class CafeDatailAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		int num = Integer.parseInt(request.getParameter("num"));
		
		//검색과 관련되 파라미터를 읽어와 본다.
		String keyword = request.getParameter("keyword");
		String condition = request.getParameter("condition");
		
		CafeDto dto = new CafeDto(); //값이 아무것도 안들어가면 null이 들어있다. 넣어준 것만 null이 아님 뀨
		if(keyword != null) {
			if(condition.equals("titlecontent")) {//제목+내용 검색
				dto.setTitle(keyword);
				dto.setContent(keyword);
				
			}else if(condition.equals("title")) {//제목 검색
				dto.setTitle(keyword);
				
			}else if(condition.equals("writer")) {//작성자 검색
				dto.setWriter(keyword);
			}
			//list.jsp 에서 필요한 내용 담기
			request.setAttribute("condition", condition);
			request.setAttribute("keyword", keyword);
		}
		
		//글 번호도 dto에 담는다.
		dto.setNum(num);
		
		
		CafeDto resultDto = CafeDao.getInstance().getData(dto);
		
		CafeDao.getInstance().addViewCount(num);
		
		request.setAttribute("dto", resultDto);
		String id = (String)request.getSession().getAttribute("id");
		boolean isLogin = false;
		if(id != null) {
			isLogin = true;
		}
		request.setAttribute("isLogin", isLogin);
		
		List<CafeCommentDto> CommentList = new ArrayList<>(); 
		
		CommentList = CafeCommentDao.getInstance().getList(num);//댓글 정보 받아옴
		
	
		
		request.setAttribute("CommentList", CommentList);
		
	
		return new ActionForward("/views/cafe/detail2.jsp");
	}

}
