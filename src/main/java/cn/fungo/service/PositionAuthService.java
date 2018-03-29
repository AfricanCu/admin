package cn.fungo.service;

import java.util.List;

import cn.fungo.vo.AuthVO;
import cn.fungo.vo.PositionVO;
import cn.fungo.vo.WindowVO;

public interface PositionAuthService {
	
	List<PositionVO> findPositions(String type);
	
	List<WindowVO> findWindowAuth();
	
	Integer insertPositionAuth(List<AuthVO> list, String positionId,String positionType);

	Integer updatePositionAuth(List<AuthVO> list, String positionId,String positionType);
	

}
