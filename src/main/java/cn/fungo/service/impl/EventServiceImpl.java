package cn.fungo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

import cn.fungo.domain.W12EventSet;
import cn.fungo.domain.W12WorkFlowSet;
import cn.fungo.domain.W3MerchPosition;
import cn.fungo.mapper.EventMapper;
import cn.fungo.service.EventService;

@Service(value = "EventService")
public class EventServiceImpl implements EventService{

	@Autowired
	private EventMapper mapper;
	
	@Override
	public List<W12EventSet> findAllEvent(Map<String, String> map) {
		List<W12EventSet> list = mapper.findAllEvent(map);
		return list;
	}

	@Override
	public List<W12WorkFlowSet> findWorkFlow() {
		List<W12WorkFlowSet> list = mapper.findWorkFlow();
		return list;
	}

	@Override
	public List<W3MerchPosition> findPosition() {
		List<W3MerchPosition> list = mapper.findPosition();
		return list;
	}

	@Override
	public int getEventId() {
		int id = mapper.getEventId();
		return id;
	}

	@Override
	public int addEvent(W12EventSet model) {
		int i = mapper.addEvent(model);
		return i;
	}

	@Override
	public W12EventSet findEventById(String id) {
		return mapper.findEventById(id);
	}

	@Override
	public int updateEvent(W12EventSet model) {
		return mapper.updateEvent(model);
	}

	@Override
	public int removeEvent(String id) {
		return mapper.removeEvent(id);
	}


}
