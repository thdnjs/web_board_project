package test.file.action;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import test.controller.Action;
import test.controller.ActionForward;
import test.file.dao.FileDao;
import test.file.dto.FileDto;

public class FileUploadAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		//servletContext 객체는 request 객체로부터 얻어낼 수 있다.
		ServletContext application = request.getServletContext();
		String realPath=application.getRealPath("/upload");

		//최대 업로드 사이즈 값 지정
		int sizeLimit=1024*1024*50; //50 Mbyte
		/*
			WEB-INF/lib/cos.jar 파일이 있어야 아래의 MultipartRequest,
			DefaultFileRenamePolicy 클래스를 import 해서 사용할수 있다.
		*/
		
		// MultipartRequest 객체를 생성한다.
		// 객체가 성공적으로 생성되면 클라이언트가 업로드한 파일이
		// WebContent/upload 폴더에 저장된다. 
		try {
			MultipartRequest mr=new MultipartRequest(request,
					realPath,
					sizeLimit,
					"utf-8",
					new DefaultFileRenamePolicy());
			//업로드된 파일의 정보는 mr 객체를 이용해서 얻어온다.
			String title=mr.getParameter("title"); //파일 정보는 request에 없고 mr에 있다!!
			//원본 파일명
			String orgFileName=mr.getOriginalFileName("myFile");
			//파일 시스템에 저장된 파일명
			String saveFileName=mr.getFilesystemName("myFile");
			//파일의 크기 
			long fileSize=mr.getFile("myFile").length();
			
			
			//업로드한 클라이언트의 아이디
			String writer = (String)request.getSession().getAttribute("id");
			
			FileDto dto = new FileDto();
			dto.setWriter(writer);
			dto.setTitle(title);
			dto.setOrgFileName(orgFileName);
			dto.setSaveFileName(saveFileName);
			dto.setFileSize(fileSize);
			
			boolean isSuccess = FileDao.getInstance().insert(dto);
			
			request.setAttribute("isSuccess", isSuccess);
			
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
		
		
		return new ActionForward("/views/file/upload.jsp");
		
	}

}
