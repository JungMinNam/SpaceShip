package com.spaceship.board.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spaceship.board.domain.BoardVO;
import com.spaceship.board.domain.ListVO;
import com.spaceship.card.domain.CardVO;
import com.spaceship.card.domain.ReplyVO;
import com.spaceship.user.domain.UserVO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Inject
	private SqlSession session;
	
	private static String namespace = "com.spaceship.mapper.BoardMapper";
	
	@Override
	public void create(BoardVO vo) throws Exception {
		session.insert(namespace+".create", vo);
	}
	
	@Override
	public BoardVO bidx() throws Exception {
		return session.selectOne(namespace+".bidx");
	}
	
	@Override
	public int belong(BoardVO vo) throws Exception {
		return session.insert(namespace+".belong", vo);
	}

	@Override
	public int deleteBelong(BoardVO vo) throws Exception {
		return session.delete(namespace+".deleteBelong", vo);
	}

	@Override
	public BoardVO read(Integer bidx) throws Exception {
		return session.selectOne(namespace+".read", bidx);
	}

	@Override
	public void update(BoardVO vo) throws Exception {
		session.update(namespace+".update", vo);
	}

	@Override
	public int deleteBoard(Integer bidx) throws Exception {
		return session.delete(namespace+".deleteBoard", bidx);
	}

	@Override
	public int deleteBoardList(Integer bidx) throws Exception {
		return session.delete(namespace+".deleteBoardList", bidx);
	}

	@Override
	public int deleteBoardCard(Integer bidx) throws Exception {
		return session.delete(namespace+".deleteBoardCard", bidx);
	}

	@Override
	public List<BoardVO> listAll(String uid) throws Exception {
		return session.selectList(namespace+".listAll", uid);
	}

	@Override
	public List<UserVO> checkBelong(int bidx) throws Exception {
		return session.selectList(namespace+".checkBelong", bidx);
	}

	@Override
	public int createList(ListVO vo) throws Exception {
		return session.insert(namespace+".createList", vo);
	}

	@Override
	public int deleteList(Integer lidx) throws Exception {
		return session.delete(namespace+".deleteList", lidx);
	}

	@Override
	public int deleteListCard(Integer lidx) throws Exception {
		return session.delete(namespace+".deleteListCard", lidx);
	}

	@Override
	public List<ListVO> listAllList(int bidx) throws Exception {
		return session.selectList(namespace+".listAllList", bidx);
	}

	@Override
	public List<CardVO> listAllCard(int bidx) throws Exception {
		return session.selectList(namespace+".listAllCard", bidx);
	}

	@Override
	public List<CardVO> listAllAttach(int bidx) throws Exception {
		return session.selectList(namespace+".listAllAttach", bidx);
	}

	@Override
	public List<ReplyVO> listAllReply(int bidx) throws Exception {
		return session.selectList(namespace+".listAllReply", bidx);
	}

	@Override
	public List<ReplyVO> listRecentReply(int bidx) throws Exception {
		return session.selectList(namespace+".listRecentReply", bidx);
	}

}
