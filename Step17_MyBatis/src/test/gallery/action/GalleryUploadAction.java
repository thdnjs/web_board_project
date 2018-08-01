package test.gallery.action;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import test.controller.Action;
import test.controller.ActionForward;
import test.gallery.dao.GalleryDao;
import test.gallery.dto.GalleryDto;

public class GalleryUploadAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		
		ServletContext application=request.getServletContext();
		String realPath=application.getRealPath("/upload");

		int sizeLimit=1024*1024*50;
		
		MultipartRequest mr;
		try {
			mr = new MultipartRequest(request,
					realPath,
					sizeLimit,
					"utf-8",
					new DefaultFileRenamePolicy());
			
			//업로드된 파일의 정보는 mr 객체를 이용해서 얻어온다.
			String caption=mr.getParameter("caption"); //파일 정보는 request에 없고 mr에 있다!!
			String saveFileName = mr.getFilesystemName("image");	

			//업로드한 클라이언트의 아이디
			String writer = (String)request.getSession().getAttribute("id");
			
			GalleryDto dto = new GalleryDto();
			dto.setWriter(writer);
			dto.setCaption(caption);
			dto.setImagePath("/upload/"+saveFileName);

			boolean isSuccess = GalleryDao.getInstance().insert(dto);
			
			request.setAttribute("isSuccess", isSuccess);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return new ActionForward("/views/gallery/private/upload.jsp");
	}

}
