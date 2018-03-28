package cn.fungo.service;

import java.util.List;
import java.util.Map;

import cn.fungo.domain.W12WorkFlowSet;

public interface WorkFlowService {
	/**
	 * 查询
	 * @param map
	 * @return
	 */
	public List<W12WorkFlowSet> findAllWorkFlow(Map<String,String> map);
	
	/**
	 * 新增
	 * @param workflow
	 * @return
	 */
	public int addWorkFlow(W12WorkFlowSet workflow);
	public int findMaxId(String type);
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public int removeWorkFlow(Integer id);
	
	
	public int editWorkFlow(W12WorkFlowSet workflow);

}
