package com.spaceship.board.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spaceship.board.domain.BoardVO;
import com.spaceship.board.domain.ListVO;
import com.spaceship.board.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	private static final Logger logger =
			LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	private BoardService service;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listBoard(@RequestParam("uid") String uid, Model model) throws Exception {
		System.out.println(uid);
		model.addAttribute("list", service.listAll(uid)); 
		
		return "/board/index";
	}
	
	@ResponseBody
	@RequestMapping(value = "/addBoard", method = RequestMethod.POST)
	public int addBoard(BoardVO vo) throws Exception {
		return service.create(vo);
	}
	
	@ResponseBody
	@RequestMapping(value = "/removeBoard/{bidx}", method = RequestMethod.DELETE)
	public int removeBoard(@PathVariable("bidx") Integer bidx) throws Exception {
		return service.removeBoard(bidx);
	}
	
	@RequestMapping(value = "/readBoard", method = RequestMethod.GET)
	public String readBoard(@RequestParam("bidx") int bidx, Model model) throws Exception {
		model.addAttribute("board", service.read(bidx));
		model.addAttribute("member", service.checkBelong(bidx));
		model.addAttribute("list", service.listAllList(bidx));
		model.addAttribute("cardList", service.listAllCard(bidx));
		model.addAttribute("attach", service.listAllAttach(bidx));
		model.addAttribute("reply", service.listAllReply(bidx));
		model.addAttribute("recentReply", service.listRecentReply(bidx));
		
		return "/board/board";
	}
	
	@ResponseBody
	@RequestMapping(value = "/addMember", method = RequestMethod.POST)
	public int addMember(BoardVO vo) throws Exception {
		return service.addMember(vo);
	}
	
	@ResponseBody
	@RequestMapping(value = "/removeMember/{bidx}", method = RequestMethod.GET)
	public int deleteMember(@PathVariable("bidx") Integer bidx, BoardVO vo) throws Exception {
		/* @RequestParam("bidx") Integer rBidx, @RequestParam("uid") String uid */
		/* System.out.println(rBidx);
		System.out.println(uid);
		
		BoardVO vo = new BoardVO();
		vo.setBidx(rBidx);
		vo.setUid(uid); */
		System.out.println(vo.getBidx());
		System.out.println(vo.getUid());
		
		return service.removeMember(vo);
	}
	
	@ResponseBody
	@RequestMapping(value = "/addList", method = RequestMethod.POST)
	public int addList(ListVO vo) throws Exception {
		return service.addList(vo);
	}
	
	@ResponseBody
	@RequestMapping(value = "/removeList/{lidx}", method = RequestMethod.DELETE)
	public int removeList(@PathVariable("lidx") Integer lidx) throws Exception {
		return service.removeList(lidx);
	}
}
