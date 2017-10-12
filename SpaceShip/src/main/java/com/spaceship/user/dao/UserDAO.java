package com.spaceship.user.dao;

import com.spaceship.user.domain.UserVO;
import com.spaceship.user.dto.LoginDTO;

public interface UserDAO {

	public UserVO login(LoginDTO dto) throws Exception;
	
	public int insert(UserVO vo) throws Exception;
	
	public int update(UserVO vo) throws Exception;
	
	public UserVO select(UserVO vo) throws Exception;
	
}
