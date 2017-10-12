package com.spaceship.card.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spaceship.card.domain.CardVO;
import com.spaceship.card.domain.ReplyVO;

@Repository
public class CardDAOImpl implements CardDAO {

	@Inject
	private SqlSession session;
	
	private static String namespace = "com.spaceship.mapper.CardMapper";
	
	@Override
	public int create(CardVO vo) throws Exception {
		return session.insert(namespace+".createCard", vo);
	}

	@Override
	public CardVO cidx() throws Exception {
		return session.selectOne(namespace+".cidx");
	}

	@Override
	public int belongCard(CardVO vo) throws Exception {
		return session.insert(namespace+".belongCard", vo);
	}

	@Override
	public CardVO read(Integer cidx) throws Exception {
		return session.selectOne(namespace+".readCard", cidx);
	}

	@Override
	public int update(CardVO vo) throws Exception {
		return session.update(namespace+".updateCard", vo);
	}

	@Override
	public int updateLabel(CardVO vo) throws Exception {
		return session.update(namespace+".updateCardLabel", vo);
	}

	@Override
	public int updateFinish(Integer cidx) throws Exception {
		return session.update(namespace+".updateCardFinish", cidx);
	}

	@Override
	public int delete(Integer cidx) throws Exception {
		return session.delete(namespace+".deleteCard", cidx);
	}

	@Override
	public List<CardVO> listAll(Integer bidx) throws Exception {
		return session.selectList(namespace+".listAllCard", bidx);
	}

	@Override
	public int addAttach(CardVO vo) throws Exception {
		return session.insert(namespace+".addAttach", vo);
	}

	@Override
	public int deleteAttach(String attachname) throws Exception {
		return session.delete(namespace+".deleteAttach", attachname);
	}

	@Override
	public int addReply(ReplyVO vo) throws Exception {
		return session.insert(namespace+".addReply", vo);
	}

	@Override
	public int deleteReply(Integer ridx) throws Exception {
		return session.delete(namespace+".deleteReply", ridx);
	}

}
