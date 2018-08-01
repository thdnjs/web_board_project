package test.gallery.dto;

public class GalleryDto {
	private int num;
	private String writer;
	private String caption;
	private String imagePath;
	private String regdate;
	
	public GalleryDto() {}

	public GalleryDto(int num, String writer, String caption, String imagePath, String regdate) {
		this.num = num; //번호 PRIMARY KEY
		this.writer = writer;//작성자 
		this.caption = caption;//이미지 설명
		this.imagePath = imagePath;//이미지 경로(/upload/kim1.png)
		this.regdate = regdate;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
}
