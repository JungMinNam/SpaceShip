package com.spaceship.user.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.spaceship.user.dao.UserDAO;
import com.spaceship.user.domain.UserVO;
import com.spaceship.user.dto.LoginDTO;

@Service
public class UserServiceImpl implements UserService {

	@Inject 
	private UserDAO dao;
	
	@Override
	public UserVO login(LoginDTO dto) throws Exception {
		return dao.login(dto);
	}

	@Override
	public int insertUser(UserVO vo) throws Exception {
		return dao.insert(vo);
	}
	
	@Override
	public int updateUser(UserVO vo) throws Exception {
		return dao.update(vo);
	}
	
	@Override
	public UserVO duplcheck(UserVO vo) throws Exception {
		return dao.select(vo);
	}

}
