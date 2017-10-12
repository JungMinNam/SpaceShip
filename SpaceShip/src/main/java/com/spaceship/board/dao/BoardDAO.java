package com.spaceship.board.dao;

import java.util.List;

import com.spaceship.board.domain.BoardVO;
import com.spaceship.board.domain.ListVO;
import com.spaceship.card.domain.CardVO;
import com.spaceship.card.domain.ReplyVO;
import com.spaceship.user.domain.UserVO;

public interface BoardDAO {

	public void create(BoardVO vo) throws Exception;
	
	public BoardVO bidx() throws Exception;
	
	public int belong(BoardVO vo) throws Exception;
	
	public int deleteBelong(BoardVO vo) throws Exception;
	
	public BoardVO read(Integer bidx) throws Exception;
	
	public void update(BoardVO vo) throws Exception;
	
	public int deleteBoard(Integer bidx) throws Exception;
	
	public int deleteBoardList(Integer bidx) throws Exception;
	
	public int deleteBoardCard(Integer bidx) throws Exception;
	
	public List<BoardVO> listAll(String uid) throws Exception;
	
	public List<UserVO> checkBelong(int bidx) throws Exception;
	
	public int createList(ListVO vo) throws Exception;
	
	public int deleteList(Integer lidx) throws Exception;
	
	public int deleteListCard(Integer lidx) throws Exception;
	
	public List<ListVO> listAllList(int bidx) throws Exception;
	
	public List<CardVO> listAllCard(int bidx) throws Exception;
	
	public List<CardVO> listAllAttach(int bidx) throws Exception;
	
	public List<ReplyVO> listAllReply(int bidx) throws Exception;
	
	public List<ReplyVO> listRecentReply(int bidx) throws Exception;
	
}
