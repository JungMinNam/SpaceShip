package com.spaceship.card.dao;

import java.util.List;

import com.spaceship.card.domain.CardVO;
import com.spaceship.card.domain.ReplyVO;

public interface CardDAO {
	
	public int create(CardVO vo) throws Exception;
	
	public CardVO cidx() throws Exception;
	
	public int belongCard(CardVO vo) throws Exception;
	
	public CardVO read(Integer cidx) throws Exception;
	
	public int update(CardVO vo) throws Exception;
	
	public int updateLabel(CardVO vo) throws Exception;
	
	public int updateFinish(Integer cidx) throws Exception;
	
	public int delete(Integer cidx) throws Exception;
	
	public List<CardVO> listAll(Integer bidx) throws Exception;
	
	public int addAttach(CardVO vo) throws Exception;
	
	public int deleteAttach(String attachname) throws Exception;
	
	public int addReply(ReplyVO vo) throws Exception;
	
	public int deleteReply(Integer ridx) throws Exception;
	
}
