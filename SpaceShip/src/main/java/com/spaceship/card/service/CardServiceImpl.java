package com.spaceship.card.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.spaceship.card.dao.CardDAO;
import com.spaceship.card.domain.CardVO;
import com.spaceship.card.domain.ReplyVO;

@Service
public class CardServiceImpl implements CardService {

	@Inject
	private CardDAO dao;
	
	@Override
	public int addCard(CardVO vo) throws Exception {
		dao.create(vo);
		vo = dao.cidx();
		
		return dao.belongCard(vo);
	}

	@Override
	public int belongCard(CardVO vo) throws Exception {
		return dao.belongCard(vo);
	}

	@Override
	public CardVO readCard(Integer cidx) throws Exception {
		return dao.read(cidx);
	}

	@Override
	public int updateCard(CardVO vo) throws Exception {
		return dao.update(vo);
	}

	@Override
	public int updateCardLabel(CardVO vo) throws Exception {
		return dao.updateLabel(vo);
	}

	@Override
	public int updateCardFinish(Integer cidx) throws Exception {
		return dao.updateFinish(cidx);
	}

	@Override
	public int deleteCard(Integer cidx) throws Exception {
		return dao.delete(cidx);
	}

	@Override
	public List<CardVO> listAllCard(Integer bidx) throws Exception {
		return dao.listAll(bidx);
	}

	@Override
	public int addCardAttach(CardVO vo) throws Exception {
		return dao.addAttach(vo);
	}

	@Override
	public int deleteCardAttach(String attachname) throws Exception {
		return dao.deleteAttach(attachname);
	}

	@Override
	public int addCardReply(ReplyVO vo) throws Exception {
		return dao.addReply(vo);
	}

	@Override
	public int deleteCardReply(Integer ridx) throws Exception {
		return dao.deleteReply(ridx);
	}

}
