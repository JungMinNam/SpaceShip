package com.spaceship.card.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.spaceship.card.domain.CardVO;
import com.spaceship.card.domain.ReplyVO;
import com.spaceship.card.service.CardService;
import com.spaceship.card.util.MediaUtils;
import com.spaceship.card.util.UploadFileUtils;

@Controller
@RequestMapping("/card/*")
public class CardController {
	
	private static final Logger logger =
			LoggerFactory.getLogger(CardController.class);

	@Inject
	private CardService service;
	
	@Resource(name = "uploadPath")
	private String uploadPath;
	
	@ResponseBody
	@RequestMapping(value = "/addCard", method = RequestMethod.POST)
	public int addCard(CardVO vo) throws Exception {
		return service.addCard(vo);
	}
	
	@ResponseBody
	@RequestMapping(value = "/addCardMember", method = RequestMethod.POST)
	public int addCardMember(CardVO vo) throws Exception {
		return service.belongCard(vo);
	}
	
	@ResponseBody
	@RequestMapping(value = "/readCard", method = RequestMethod.GET)
	public CardVO readCard(int cidx) throws Exception {
		return service.readCard(cidx);
	}
	
	@ResponseBody
	@RequestMapping(value = "/deleteCard/{cidx}", method = RequestMethod.DELETE)
	public int deleteCard(@PathVariable("cidx") Integer cidx) throws Exception {
		return service.deleteCard(cidx);
	}
	
	@ResponseBody
	@RequestMapping(value = "/updateCardFinish/{cidx}", method = RequestMethod.PUT)
	public int updateCardFinish(@PathVariable("cidx") Integer cidx) throws Exception {
		return service.updateCardFinish(cidx);
	}
	
	@ResponseBody
	@RequestMapping(value = "/updateCardLabel/{cidx}", method = RequestMethod.PUT)
	public int updateCardFinish(@PathVariable("cidx") Integer cidx, @RequestBody CardVO vo) throws Exception {
		vo.setCidx(cidx);
		return service.updateCardLabel(vo);
	}
	
	@ResponseBody
	@RequestMapping(value = "/uploadAjax", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public ResponseEntity<String> uploadAjax(MultipartFile file, Integer cidx, Integer bidx) throws Exception {
		logger.info("originalName: " + file.getOriginalFilename());
		
		ResponseEntity<String> str = new ResponseEntity<>(
				UploadFileUtils.uploadFile(uploadPath, 
						file.getOriginalFilename(), 
						file.getBytes()),
				HttpStatus.CREATED);
		
		String attachname = str.toString().substring(13, str.toString().length()-4);
		String originalname = attachname.substring(attachname.indexOf("_")+1);
		//String  = tempname.substring(tempname.indexOf("_")+1);
		
		System.out.println(originalname);
		
		CardVO vo = new CardVO();
		
		System.out.println(cidx);
		System.out.println(bidx);
		
		vo.setAttachname(attachname);
		vo.setOriginalname(originalname);
		vo.setCidx(cidx);
		vo.setBidx(bidx);
		
		service.addCardAttach(vo);
		
		return str;
		
	}
	
	@ResponseBody
	@RequestMapping("/displayFile")
	public ResponseEntity<byte[]> displayFile(String fileName) throws Exception {
		
		InputStream in = null;
		ResponseEntity<byte[]> entity = null;
		
		logger.info("FILE NAME : " + fileName);
		
		try {
			String formatName = fileName.substring(fileName.lastIndexOf(".")+1);
			
			MediaType mType = MediaUtils.getMediaType(formatName);
			
			HttpHeaders headers = new HttpHeaders();
			
			in = new FileInputStream(uploadPath+fileName);
			
			/*if(mType != null) {
				headers.setContentType(mType);
			} else {
				fileName = fileName.substring(fileName.indexOf("_")+1);
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				headers.add("Content-Disposition", "attachment; filename=\""+
					new String(fileName.getBytes("UTF-8"), "ISO-8859-1")+"\"");
			} */
			
			fileName = fileName.substring(fileName.indexOf("_")+1);
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			headers.add("Content-Disposition", "attachment; filename=\""+
				new String(fileName.getBytes("UTF-8"), "ISO-8859-1")+"\"");
			
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
		} catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		} finally {
			in.close();
		}
		
		return entity;
	}
	
	@ResponseBody
	@RequestMapping(value="/deleteFile", method=RequestMethod.POST)
	public ResponseEntity<String> deleteFile(String fileName) throws Exception {
		
		logger.info("delete file: " + fileName);
		
		String formatName = fileName.substring(fileName.lastIndexOf(".")+1);
		
		MediaType mType = MediaUtils.getMediaType(formatName);
		
		if(mType != null) {
			String front = fileName.substring(0, 12);
			String end = fileName.substring(14);
			new File(uploadPath + (front+end).replace('/', File.separatorChar)).delete();
		}
		
		new File(uploadPath + fileName.replace('/', File.separatorChar)).delete();
		
		String attachname = fileName;
		
		service.deleteCardAttach(attachname);
		
		return new ResponseEntity<String>("deleted", HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value = "/addCardReply", method = RequestMethod.POST)
	public int addCardReply(ReplyVO vo) throws Exception {
		return service.addCardReply(vo);
	}
	
	@ResponseBody
	@RequestMapping(value = "/deleteCardReply/{ridx}", method = RequestMethod.DELETE)
	public int deleteCardReply(@PathVariable("ridx") Integer ridx) throws Exception {
		return service.deleteCardReply(ridx);
	}

}
