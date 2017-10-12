package com.spaceship.card.service;

import java.util.List;

import com.spaceship.card.domain.CardVO;
import com.spaceship.card.domain.ReplyVO;

public interface CardService {

	public int addCard(CardVO vo) throws Exception;
	
	public int belongCard(CardVO vo) throws Exception;
	
	public CardVO readCard(Integer cidx) throws Exception;
	
	public int updateCard(CardVO vo) throws Exception;
	
	public int updateCardLabel(CardVO vo) throws Exception;
	
	public int updateCardFinish(Integer cidx) throws Exception;	
	
	public int deleteCard(Integer cidx) throws Exception;
	
	public List<CardVO> listAllCard(Integer bidx) throws Exception;
	
	public int addCardAttach(CardVO vo) throws Exception;
	
	public int deleteCardAttach(String attachname) throws Exception;
	
	public int addCardReply(ReplyVO vo) throws Exception;
	
	public int deleteCardReply(Integer ridx) throws Exception;
	
}
