package cn.fungo.service;

import java.util.List;

import cn.fungo.vo.PositionVO;

public interface PositionService {
	
	List<PositionVO> findPositions(String type, String name);
	
	Integer addPosition(String type, String code, String name, String level);
	
	Integer deletePosition(String type, String id);

	Integer editPosition(String type, String id, String name, String code, String level);

}
