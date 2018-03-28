package cn.fungo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.fungo.domain.W12User;
import cn.fungo.mapper.UserMapper;
import cn.fungo.service.UserService;

@Service(value = "UserService")
public class UserServiceImpl implements UserService{
	@Autowired
	UserMapper mapper;
	
	@Override
	public List<W12User> findUser(Map<String, String> map) {
		return mapper.findUser(map);
	}

	@Override
	public String generatorPriKey(String tableName) {
		return mapper.generatorPriKey(tableName);
	}

	@Override
	public int addUser(W12User model) {
		return mapper.addUser(model);
	}

	@Override
	public W12User getUserInfo(String id) {
		return mapper.getUserInfo(id);
	}

	@Override
	public int updateUser(W12User model) {
		return mapper.updateUser(model);
	}

	@Override
	public int removeUser(String id) {
		return mapper.removeUser(id);
	}

}
