package test.gallery.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import test.gallery.dto.GalleryDto;
import test.mybatis.SqlMapConfig;

public class GalleryDao {
	private static GalleryDao dao;
	private static SqlSessionFactory factory;
	
	private GalleryDao() {}
	public static GalleryDao getInstance() {
		if(dao == null) {
			dao = new GalleryDao();
			factory=SqlMapConfig.getSqlSession();
		}
		return dao;
	}
	
	public boolean delete(int num) {
		SqlSession session = null;
		int flag = 0;
		try {
			session = factory.openSession(true);
			flag=session.delete("gallery.delete", num);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		if (flag > 0) {
			return true;
		} else {
			return false;
		}
		
	}
	
	
	public GalleryDto getData(int num) {
		SqlSession session=null;
		GalleryDto dto=null;
		try {
			session=factory.openSession();
			dto=session.selectOne("gallery.getData", num);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return dto;
		
	}
	
	public boolean insert(GalleryDto dto) {
		
		SqlSession session = null;
		int flag = 0;
		try {
			session = factory.openSession(true);
			flag=session.insert("gallery.insert", dto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		if (flag > 0) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public List<GalleryDto> getList(){
		
		SqlSession session=null;
		List<GalleryDto> list=null;
		try {
			session=factory.openSession();
			/*
			 *  .selectList() 인 경우에는 
			 *  resultType : List 의 Generic type 이다. 
			 */
			list=session.selectList("gallery.getList");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}

		return list;
	}
}
