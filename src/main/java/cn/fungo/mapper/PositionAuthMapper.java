package cn.fungo.mapper;

import java.util.List;

import cn.fungo.domain.W2PositionAuth;
import cn.fungo.vo.AuthVO;
import cn.fungo.vo.WindowVO;

public interface PositionAuthMapper {
	
	List<WindowVO> findWindowAuth();

	List<AuthVO> findAuthByWindowId(String id);

	Integer insertPositionAuth(List<W2PositionAuth> list);

	Integer deleteAuthByPositionId(String positionId);

}
