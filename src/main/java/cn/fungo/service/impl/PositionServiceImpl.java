package cn.fungo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.fungo.domain.W2Position;
import cn.fungo.domain.W3MerchPosition;
import cn.fungo.mapper.PositionMapper;
import cn.fungo.service.PositionService;
import cn.fungo.vo.PositionVO;

@Service(value = "PositionService")
public class PositionServiceImpl implements PositionService {
	@Autowired
	PositionMapper mapper;
	
	/**
	 * 查询岗位
	 */
	@Override
	public List<PositionVO> findPositions(String type, String name) {
		List<PositionVO> positionList = new ArrayList<>();
		if("01".equals(type)) {
			List<W3MerchPosition> merchPositions = mapper.findMerchPositions(name);
			if (merchPositions != null && merchPositions.size() > 0) {
				for(W3MerchPosition w : merchPositions) {
					PositionVO obj = new PositionVO();
					obj.setType("商户");
					obj.setId(w.getId());
					obj.setPositionName(w.getPositionName());
					obj.setPositionCode(w.getPositionCode());
					obj.setPositionType(w.getPositionType());
					positionList.add(obj);
				}
			}
			return positionList;
		}else if("02".equals(type)) {
			List<W2Position> supplierPositions = mapper.findSupplierPositions(name);
			if(supplierPositions !=null && supplierPositions.size() > 0) {
				for(W2Position w : supplierPositions) {
					PositionVO obj = new PositionVO();
					obj.setType("供应商");
					obj.setId(w.getId());
					obj.setPositionName(w.getPositionName());
					obj.setPositionCode(w.getPositionCode());
					obj.setPositionType(w.getPositionType());
					positionList.add(obj);
				}
			}
			return positionList;
		}else {
			List<W3MerchPosition> merchPositions = mapper.findMerchPositions(name);
			if (merchPositions != null && merchPositions.size() > 0) {
				for(W3MerchPosition w : merchPositions) {
					PositionVO obj = new PositionVO();
					obj.setType("商户");
					obj.setId(w.getId());
					obj.setPositionName(w.getPositionName());
					obj.setPositionCode(w.getPositionCode());
					obj.setPositionType(w.getPositionType());
					positionList.add(obj);
				}
			}
			List<W2Position> supplierPositions = mapper.findSupplierPositions(name);
			if(supplierPositions !=null && supplierPositions.size() > 0) {
				for(W2Position w : supplierPositions) {
					PositionVO obj = new PositionVO();
					obj.setType("供应商");
					obj.setId(w.getId());
					obj.setPositionName(w.getPositionName());
					obj.setPositionCode(w.getPositionCode());
					obj.setPositionType(w.getPositionType());
					positionList.add(obj);
				}
			}
			return positionList;
		}
	}
	
	/**
	 * 添加岗位
	 */
	@Override
	public Integer addPosition(String type, String code, String name, String level) {
		
		if("1".equals(type)) {	//1为添加商户岗位
			Integer maxId = mapper.findMaxIdFromW3MerchPosition();
			W3MerchPosition position = new W3MerchPosition();
			position.setId(maxId + 1 + "");
			position.setPositionCode(code);
			position.setPositionName(name);
			position.setPositionType(level);
			Integer cnt = mapper.insertMerchPosition(position);
			return cnt;
		}else if("2".equals(type)) {	//2为添加供应商岗位
			Integer maxId = mapper.findMaxIdFromW2Position();
			W2Position position = new W2Position();
			position.setId(maxId + 1 + "");
			position.setPositionCode(code);
			position.setPositionName(name);
			position.setPositionType(level);
			Integer cnt = mapper.insertSupplierPosition(position);
			return cnt;
		}
		return 0;
	}
	
	/**
	 * 删除岗位
	 */
	@Override
	public Integer deletePosition(String type, String id) {
		if("商户".equals(type)) {
			return mapper.deleteMerchPosition(id);
		}else if("供应商".equals(type)) {
			return mapper.deleteW2PositionById(id);
		}else {
			return 0;
		}
	}
	
	/**
	 * 修改岗位
	 */
	@Override
	public Integer editPosition(String type, String id, String name, String code, String level) {
		if("商户".equals(type)) {
			W3MerchPosition position = new W3MerchPosition();
			position.setId(id);
			position.setPositionCode(code);
			position.setPositionName(name);
			position.setPositionType(level);
			return mapper.editMerchPosition(position);
		}else if("供应商".equals(type)) {
			W2Position position = new W2Position();
			position.setId(id);
			position.setPositionCode(code);
			position.setPositionName(name);
			position.setPositionType(level);
			return mapper.editW2PositionById(position);
		}else {
			return 0;
		}
		
	}
}
