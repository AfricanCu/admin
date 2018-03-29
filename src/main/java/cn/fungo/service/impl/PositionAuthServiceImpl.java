package cn.fungo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.fungo.domain.W2Position;
import cn.fungo.domain.W2PositionAuth;
import cn.fungo.domain.W3MerchPosition;
import cn.fungo.mapper.PositionAuthMapper;
import cn.fungo.mapper.PositionMapper;
import cn.fungo.service.PositionAuthService;
import cn.fungo.vo.AuthVO;
import cn.fungo.vo.PositionVO;
import cn.fungo.vo.WindowVO;

@Service(value = "PositionAuthService")
public class PositionAuthServiceImpl implements PositionAuthService {
    @Autowired
    private PositionMapper positionMapper;
    @Autowired
    private PositionAuthMapper mapper;

    @Override
    public List<PositionVO> findPositions(String type) {
        List<PositionVO> positionList = new ArrayList<>();
        switch (type) {
            case "01":
                List<W3MerchPosition> list = positionMapper.findMerchPositions(null);
                for (W3MerchPosition w : list) {
                    PositionVO obj = new PositionVO();
                    obj.setId(w.getId());
                    obj.setPositionName(w.getPositionName());
                    positionList.add(obj);
                }
                return positionList;
            case "02":
                List<W2Position> list1 = positionMapper.findSupplierPositions(null);
                for (W2Position w : list1) {
                    PositionVO obj = new PositionVO();
                    obj.setId(w.getId());
                    obj.setPositionName(w.getPositionName());
                    positionList.add(obj);
                }
                return positionList;
            default:
                List<W3MerchPosition> list2 = positionMapper.findMerchPositions(null);
                for (W3MerchPosition w : list2) {
                    PositionVO obj = new PositionVO();
                    obj.setId(w.getId());
                    obj.setPositionName(w.getPositionName());
                    positionList.add(obj);
                }
                List<W2Position> list3 = positionMapper.findSupplierPositions(null);
                for (W2Position w : list3) {
                    PositionVO obj = new PositionVO();
                    obj.setId(w.getId());
                    obj.setPositionName(w.getPositionName());
                    positionList.add(obj);
                }
                return positionList;
        }
    }

    /**
     * 查找窗体权限
     */
    @Override
    public List<WindowVO> findWindowAuth() {
        List<WindowVO> list = mapper.findWindowAuth();
        for (WindowVO item : list) {
            List<AuthVO> authList = mapper.findAuthByWindowId(item.getId());
            item.setChildren(authList);
        }
        return list;
    }

    /**
     * 添加岗位权限
     */
    @Override
    public Integer insertPositionAuth(List<AuthVO> list, String positionId, String positionType) {
        List<W2PositionAuth> positionAuthList = new ArrayList<>();
        for (AuthVO w : list) {
            W2PositionAuth obj = new W2PositionAuth();
            obj.setAuthId(w.getId());
            obj.setPositionId(positionId);
            positionAuthList.add(obj);
        }
        if ("01".equals(positionType)){
            Integer cnt1 = mapper.insertW3PositionAuth(positionAuthList);
            return cnt1;
        }else if ("02".equals(positionType)){
            Integer cnt2 = mapper.insertW2PositionAuth(positionAuthList);
            return cnt2;
        }else{
            return 0;
        }
    }

    /**
     * 修改岗位权限
     */
    @Override
    public Integer updatePositionAuth(List<AuthVO> list, String positionId,String positionType) {
        List<W2PositionAuth> positionAuthList = new ArrayList<>();
        for (AuthVO w : list) {
            W2PositionAuth obj = new W2PositionAuth();
            obj.setAuthId(w.getId());
            obj.setPositionId(positionId);
            positionAuthList.add(obj);
        }
        if ("01".equals(positionType)){
            mapper.deleteW3AuthByPositionId(positionId);
            Integer cnt1 = mapper.insertW3PositionAuth(positionAuthList);
            return cnt1;
        }else if ("02".equals(positionType)){
            mapper.deleteW2AuthByPositionId(positionId);
            Integer cnt2 = mapper.insertW2PositionAuth(positionAuthList);
            return cnt2;
        }else{
            return 0;
        }
    }

}
