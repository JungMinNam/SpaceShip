package com.spaceship.board.service;

import java.util.List;

import com.spaceship.board.domain.BoardVO;
import com.spaceship.board.domain.ListVO;
import com.spaceship.card.domain.CardVO;
import com.spaceship.card.domain.ReplyVO;
import com.spaceship.user.domain.UserVO;

public interface BoardService {

	public int create(BoardVO vo) throws Exception;
	
	public BoardVO read(Integer bidx) throws Exception;
	
	public void modify(BoardVO vo) throws Exception;
	
	public int removeBoard(Integer bidx) throws Exception;
	
	public List<BoardVO> listAll(String uid) throws Exception;
	
	public List<UserVO> checkBelong(int bidx) throws Exception;
	
	public int addMember(BoardVO vo) throws Exception;
	
	public int removeMember(BoardVO vo) throws Exception;
	
	public int addList(ListVO vo) throws Exception;
	
	public int removeList(Integer lidx) throws Exception;
	
	public List<ListVO> listAllList(int bidx) throws Exception;
	
	public List<CardVO> listAllCard(int bidx) throws Exception;
	
	public List<CardVO> listAllAttach(int bidx) throws Exception;
	
	public List<ReplyVO> listAllReply(int bidx) throws Exception;
	
	public List<ReplyVO> listRecentReply(int bidx) throws Exception;
	
}
