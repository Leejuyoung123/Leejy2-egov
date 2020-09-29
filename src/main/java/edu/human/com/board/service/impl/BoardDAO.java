package edu.human.com.board.service.impl;

import org.springframework.stereotype.Repository;

import edu.human.com.common.EgovComAbstractMapper;

@Repository
public class BoardDAO extends EgovComAbstractMapper{
	public void deleteBoard(long NTT_ID) {
		delete("boardMapper.deleteBoard",NTT_ID);
	// 쿼리 네임스페이스 : 보드매퍼  , 쿼리 아이디값 , 매개변수) 
	}
}
