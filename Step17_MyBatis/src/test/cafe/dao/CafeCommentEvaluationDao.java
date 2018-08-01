package test.cafe.dao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import test.cafe.dto.CafeCommentDto;
import test.cafe.dto.CafeCommentEvaluationDto;
import test.mybatis.SqlMapConfig;

public class CafeCommentEvaluationDao {
	
	private static CafeCommentEvaluationDao dao;
	private static SqlSessionFactory factory;
	private CafeCommentEvaluationDao() {}
	
	public static CafeCommentEvaluationDao getInstance() {
		if(dao == null) {
			dao = new CafeCommentEvaluationDao();
			factory = SqlMapConfig.getSqlSession();
		}
		return dao;
	}
	
	//좋아요 누른사람 insert 
	public boolean insert(CafeCommentEvaluationDto dto) {
		SqlSession session = null;
		int flag = 0;
		try {
			session = factory.openSession(true);
			flag = session.insert("CafeCommentEvaluation.insert", dto);
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
	
	public int getlikeSum(int num) {
		SqlSession session = null;
		int likeSum = 0;
		try {
			session = factory.openSession(true);
			likeSum = session.selectOne("CafeCommentEvaluation.select", num);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return likeSum;
		
	}
	
}
