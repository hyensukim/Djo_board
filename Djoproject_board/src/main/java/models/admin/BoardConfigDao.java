package models.admin;

import java.util.List;

import commons.DB.QueryExecutor;

public class BoardConfigDao {
	private QueryExecutor qe = null;
	
	// 의존성 부여
	// BoardDao() 객체 생성해야 쿼리 실행 기능 사용가능.
	public BoardConfigDao() {
		qe = new QueryExecutor(); 
	}
	
	/**
	 * 게시판 설정 목록
	 */
	public List<BoardConfig> getConfigs(BoardConfig boardConfig){
		List<BoardConfig> configs = qe.boardList("BoardConfigMapper.configs", boardConfig);
		return configs;
	}
	
	/**
	 * 게시판 개별 설정 조회
	 */
	
	public BoardConfig getConfig(BoardConfig boardConfig) {
		BoardConfig config = qe.boardOne("BoardConfigMapper.config", boardConfig);
		return config;
	}
	
	/**
	 * 게시판 설정 아이디 중복 체크 후 중복 시 수정, 없으면 생성
	 * count -> 아이디로 동일 게시판 존재 유무 확인
	 * 		- O -> update
	 * 		- X -> insert
	 */
	public boolean update(BoardConfig boardConfig) {
		int result = 0;
		int cnt = qe.count("BoardConfigMapper", boardConfig);
		if( cnt >0) {
			result = qe.update("BoardConfigMapper.update", boardConfig);
		}
		result = qe.insert("BoardConfigMapper.insert", boardConfig);
		return result > 0;
	}
	
	
	/**
	 * 게시판 설정 삭제
	 */
	public boolean delete(BoardConfig boardConfig) {
		int cnt = qe.delete("BoardConfigMapper.delete", boardConfig);
		return cnt >0;
	}
	
	
}
