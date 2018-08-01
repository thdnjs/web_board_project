SELECT * FROM MEMBER;

CREATE TABLE board_cafe(
		num NUMBER PRIMARY KEY,
		writer VARCHAR2(100) NOT NULL,
		title VARCHAR2(100) NOT NULL,
		content CLOB,
		viewCount NUMBER,
		regdate DATE
);

CREATE SEQUENCE board_cafe_seq;

SELECT * FROM board_cafe;

-- 댓글 정보를 저장할 테이블
CREATE TABLE board_cafe_comment(
	num NUMBER PRIMARY KEY, -- 댓글의 글번호
	writer VARCHAR2(100),-- 댓글 작성자
	content VARCHAR2(500), -- 댓글 내용
	target_id VARCHAR2(100), -- 댓글의 대상이 되는 아이디(글 작성자)
	ref_group NUMBER, --댓글 그룹번호
	comment_group NUMBER, --원글에 달린 댓글 내에서의 그룹 
	regdate DATE ,-- 댓글 등록일 
	isDelete VARCHAR2(10) -- 삭제된 댓글인지 여부
);

DROP table board_cafe_comment;

create TABLE board_cafe_comment_evaluation(
	id VARCHAR2(100),--댓글 평가한 사람 아이디
	likeCommentNum NUMBER DEFAULT 0,--좋아요한 댓글의 번호
	dislikeCommentNum NUMBER DEFAULT 0 --싫어요한 댓글의 번호
);

SELECT c.*, l.cnt
FROM board_cafe_comment c, (SELECT likeCommentNum, count(*) cnt
FROM board_cafe_comment_evaluation
GROUP BY likeCommentNum) l
WHERE c.num = l.likeCommentNum;

SELECT c.*, l.cnt, d.cnt
FROM board_cafe_comment c, 
(SELECT likeCommentNum, count(*) cnt
FROM board_cafe_comment_evaluation
GROUP BY likeCommentNum) l,
(SELECT dislikeCommentNum, count(*) cnt
FROM board_cafe_comment_evaluation) d
WHERE c.num = l.likeCommentNum;

SELECT c.*, l.cnt, d.cnt
FROM board_cafe_comment c
LEFT OUTER JOIN (SELECT likeCommentNum, count(*) cnt
FROM board_cafe_comment_evaluation
GROUP BY likeCommentNum) l
LEFT OUTER JOIN (SELECT dislikeCommentNum, count(*) cnt
FROM board_cafe_comment_evaluation
GROUP BY dislikeCommentNum) d;


SELECT c.num,NVL(l.cnt,0) likeNum ,NVL(d.cnt,0) dislikeNum
	FROM board_cafe_comment c
	LEFT OUTER JOIN (SELECT likeCommentNum, count(*) cnt
	FROM board_cafe_comment_evaluation
	GROUP BY likeCommentNum) l ON (c.num = l.likeCommentNum)
	LEFT OUTER JOIN (SELECT dislikeCommentNum,count(*) cnt 
	FROM board_cafe_comment_evaluation 
	GROUP BY dislikeCommentNum) d ON (c.num = d.dislikeCommentNum) WHERE ref_group = 79 ORDER BY comment_group ASC,num ASC


