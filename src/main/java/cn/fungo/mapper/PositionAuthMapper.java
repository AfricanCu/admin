package cn.fungo.mapper;

import java.util.List;

import cn.fungo.domain.W2PositionAuth;
import cn.fungo.vo.AuthVO;
import cn.fungo.vo.WindowVO;

public interface PositionAuthMapper {

    List<WindowVO> findWindowAuth();

    List<AuthVO> findAuthByWindowId(String id);

    //	插入供应商岗位权限
    Integer insertW2PositionAuth(List<W2PositionAuth> list);

    //	插入商户岗位权限
    Integer insertW3PositionAuth(List<W2PositionAuth> list);

    //删除商户权限
    Integer deleteW3AuthByPositionId(String positionId);

    //删除供应商权限
    Integer deleteW2AuthByPositionId(String positionId);

}
