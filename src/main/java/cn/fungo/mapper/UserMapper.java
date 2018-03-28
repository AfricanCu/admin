package cn.fungo.mapper;

import java.util.List;
import java.util.Map;

import cn.fungo.domain.W12User;

public interface UserMapper {
	List<W12User> findUser(Map<String, String> map);
	
	String generatorPriKey(String tableName);
	
	int addUser(W12User model);
	
	W12User getUserInfo(String id);
	
	int updateUser(W12User model);
	
	int removeUser(String id);
}
