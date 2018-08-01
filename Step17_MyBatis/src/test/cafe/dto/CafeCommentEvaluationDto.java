package test.cafe.dto;

public class CafeCommentEvaluationDto {
	private String id;
	private int likeCommentNum;
	private int dislikeCommentNum;
	
	
	public CafeCommentEvaluationDto() {}


	public CafeCommentEvaluationDto(String id, int likeCommentNum, int dislikeCommentNum) {
		super();
		this.id = id;
		this.likeCommentNum = likeCommentNum;
		this.dislikeCommentNum = dislikeCommentNum;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public int getLikeCommentNum() {
		return likeCommentNum;
	}


	public void setLikeCommentNum(int likeCommentNum) {
		this.likeCommentNum = likeCommentNum;
	}


	public int getDislikeCommentNum() {
		return dislikeCommentNum;
	}


	public void setDislikeCommentNum(int dislikeCommentNum) {
		this.dislikeCommentNum = dislikeCommentNum;
	}
	
	
}
