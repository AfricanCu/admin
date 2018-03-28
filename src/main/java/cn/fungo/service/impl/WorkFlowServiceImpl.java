package cn.fungo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.fungo.domain.W12WorkFlowSet;
import cn.fungo.mapper.WorkFlowMapper;
import cn.fungo.service.WorkFlowService;

@Service(value = "WorkFlowService")
public class WorkFlowServiceImpl implements WorkFlowService {
	@Autowired
	private WorkFlowMapper mapper;

	@Override
	public List<W12WorkFlowSet> findAllWorkFlow(Map<String,String> map) {
		List<W12WorkFlowSet> workFlowList = mapper.findAllWorkFlow(map);
		return workFlowList;
	}

	@Override
	public int addWorkFlow(W12WorkFlowSet workflow) {
		int cnt = mapper.addWorkFlow(workflow);
		return cnt;
	}
	@Override
	public int findMaxId(String type) {
		int maxId = mapper.findMaxId(type);
		return maxId;
	}

	@Override
	public int removeWorkFlow(Integer id) {
		return mapper.removeWorkFlow(id);
	}

	
	@Override
	public int editWorkFlow(W12WorkFlowSet workflow) {
		return mapper.editWorkFlow(workflow);
	}

}
