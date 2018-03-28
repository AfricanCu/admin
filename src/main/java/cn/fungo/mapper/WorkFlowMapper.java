package cn.fungo.mapper;

import java.util.List;
import java.util.Map;

import cn.fungo.domain.W12WorkFlowSet;

public interface WorkFlowMapper {
	
	public List<W12WorkFlowSet> findAllWorkFlow(Map<String, String> map);
	
	
	public int findMaxId(String type);
	public int addWorkFlow(W12WorkFlowSet workflow);
	
	
	public int removeWorkFlow(Integer id);
	
	
	public int editWorkFlow(W12WorkFlowSet workflow);
}
