package cn.fungo.service;

import java.util.List;
import java.util.Map;

import cn.fungo.domain.W12EventSet;
import cn.fungo.domain.W12WorkFlowSet;
import cn.fungo.domain.W3MerchPosition;

public interface EventService {
	List<W12EventSet> findAllEvent(Map<String, String> map);
	
	List<W12WorkFlowSet> findWorkFlow();
	
	List<W3MerchPosition> findPosition();
	
	int getEventId();
	
	int addEvent(W12EventSet model);
	
	W12EventSet findEventById(String id);
	
	int updateEvent(W12EventSet model);
	
	int removeEvent(String id);
}
