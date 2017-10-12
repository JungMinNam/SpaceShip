package com.spaceship.user.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spaceship.user.domain.UserVO;
import com.spaceship.user.dto.LoginDTO;

@Repository
public class UserDAOImpl implements UserDAO {

	@Inject
	private SqlSession session;
	
	private static String namespace = "com.spaceship.mapper.UserMapper";
	
	@Override
	public UserVO login(LoginDTO dto) throws Exception {
		return session.selectOne(namespace +".login", dto);
	}

	@Override
	public int insert(UserVO vo) throws Exception {
		return session.insert(namespace + ".insert", vo);
	}
	
	@Override
	public int update(UserVO vo) throws Exception {
		return session.update(namespace + ".update", vo);
	}
	
	@Override
	public UserVO select(UserVO vo) throws Exception {
		return session.selectOne(namespace + ".select", vo);
	}
	
}
