package cn.fungo.mapper;

import java.util.List;

import cn.fungo.domain.W2Position;
import cn.fungo.domain.W3MerchPosition;

public interface PositionMapper {
	/**查询供应商岗位**/
	List<W2Position> findSupplierPositions(String name);
	/**查询商户岗位**/
	List<W3MerchPosition> findMerchPositions(String name);
	
	/**添加商户岗位**/
	Integer findMaxIdFromW3MerchPosition();
	Integer insertMerchPosition(W3MerchPosition position);
	
	/**添加供应商岗位**/
	Integer findMaxIdFromW2Position();
	Integer insertSupplierPosition(W2Position position);
	
	/**删除供应商岗位**/
	Integer deleteW2PositionById(String id);
	/**删除商户岗位*/
	Integer deleteMerchPosition(String id);
	
	/**修改商户岗位**/
	Integer editMerchPosition(W3MerchPosition position);
	/**修改供应商岗位**/
	Integer editW2PositionById(W2Position position);

}
