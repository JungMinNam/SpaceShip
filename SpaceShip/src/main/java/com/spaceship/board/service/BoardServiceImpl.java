package com.spaceship.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.spaceship.board.dao.BoardDAO;
import com.spaceship.board.domain.BoardVO;
import com.spaceship.board.domain.ListVO;
import com.spaceship.card.domain.CardVO;
import com.spaceship.card.domain.ReplyVO;
import com.spaceship.user.domain.UserVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDAO dao;
	
	@Override
	public int create(BoardVO vo) throws Exception {
		dao.create(vo);
		vo = dao.bidx();
		
		return dao.belong(vo);
	}

	@Override
	public BoardVO read(Integer bidx) throws Exception {
		return dao.read(bidx);
	}

	@Override
	public void modify(BoardVO vo) throws Exception {
		dao.update(vo);
	}

	@Override
	public int removeBoard(Integer bidx) throws Exception {
		dao.deleteBoardList(bidx);
		dao.deleteBoardCard(bidx);
		return dao.deleteBoard(bidx);
	}

	@Override
	public List<BoardVO> listAll(String uid) throws Exception {
		return dao.listAll(uid);
	}

	@Override
	public List<UserVO> checkBelong(int bidx) throws Exception {
		return dao.checkBelong(bidx);
	}

	@Override
	public int addMember(BoardVO vo) throws Exception {
		return dao.belong(vo);
	}

	@Override
	public int removeMember(BoardVO vo) throws Exception {
		return dao.deleteBelong(vo);
	}

	@Override
	public int addList(ListVO vo) throws Exception {
		return dao.createList(vo);
	}

	@Override
	public int removeList(Integer lidx) throws Exception {
		dao.deleteListCard(lidx);
		return dao.deleteList(lidx);
	}

	@Override
	public List<ListVO> listAllList(int bidx) throws Exception {
		return dao.listAllList(bidx);
	}

	@Override
	public List<CardVO> listAllCard(int bidx) throws Exception {
		return dao.listAllCard(bidx);
	}

	@Override
	public List<CardVO> listAllAttach(int bidx) throws Exception {
		return dao.listAllAttach(bidx);
	}

	@Override
	public List<ReplyVO> listAllReply(int bidx) throws Exception {
		return dao.listAllReply(bidx);
	}

	@Override
	public List<ReplyVO> listRecentReply(int bidx) throws Exception {
		return dao.listRecentReply(bidx);
	}	

}
