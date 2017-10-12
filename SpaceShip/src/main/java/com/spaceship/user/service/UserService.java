package com.spaceship.user.service;

import com.spaceship.user.domain.UserVO;
import com.spaceship.user.dto.LoginDTO;

public interface UserService {
	
	public UserVO login(LoginDTO dto) throws Exception;
	
	public int insertUser(UserVO vo) throws Exception;
	
	public int updateUser(UserVO vo) throws Exception;
	
	public UserVO duplcheck(UserVO vo) throws Exception;
	
}
