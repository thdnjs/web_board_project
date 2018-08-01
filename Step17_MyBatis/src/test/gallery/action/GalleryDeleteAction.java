package test.gallery.action;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.gallery.dao.GalleryDao;
import test.gallery.dto.GalleryDto;

public class GalleryDeleteAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
	
		int num = Integer.parseInt(request.getParameter("num"));
		
		//파일 시스템에서 삭제하기 위해서는 지정된 파일명을 알아야 한다.
		GalleryDto dto = GalleryDao.getInstance().getData(num);
		String saveFileName= dto.getImagePath();
		//세션의 아이디와 삭제할 글의 작성자와 같은지 한번 더 확인
		String id = (String)request.getSession().getAttribute("id");
		
		if(!id.equals(dto.getWriter())){
			/*
				response.sendErro(에러코드,"에러메세지");
			*/
			//금지된 요청이라고 에러를 응답한다
			try {
				response.sendError(HttpServletResponse.SC_FORBIDDEN);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//서비스 메소드 종료
			return null;
		}
			
		//DB 에서 파일 정보 삭제
		GalleryDao.getInstance().delete(num);
		
		//2. WebContent/upload 폴더에서 실제 파일 삭제 
		ServletContext application=request.getServletContext();
		String path = application.getRealPath("/upload")+File.separator+saveFileName;
		
		//File 객체를 생성해서 삭제
		new File(path).delete();
		
	
		return new ActionForward("/gallery/list.do",true);
	}

}
