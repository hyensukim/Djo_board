package commons.DB;

import java.util.List;

public interface SelectQuery {
	
	// 게시판 목록 조회
	<T,R> List<R> boardList(String mapper, T t);
	<R> List<R> boardList(String mapper);
	
	//게시판 개별 조회
	<T,R> R boardOne(String mapper, T t);
	<R> R boardOne(String mapper);
	
	//게시판 아이디 중복 확인
	<T> int count(String mapper, T t);
	
}
