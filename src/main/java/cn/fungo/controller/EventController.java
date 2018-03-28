package cn.fungo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.StreamingHttpOutputMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.fungo.domain.W12EventSet;
import cn.fungo.domain.W12WorkFlowSet;
import cn.fungo.domain.W3MerchPosition;
import cn.fungo.service.EventService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class EventController {
	
	@Autowired
	private EventService service;
	/**
	 * 查询
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "findAllEvent", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8" })
	public JSONArray findAllWorkFlow(HttpServletRequest request) {
		String name = request.getParameter("name");
		Map<String, String> map = new HashMap<>();
		map.put("name", name);
		List<W12EventSet> workflowList = service.findAllEvent(map);
		return JSONArray.fromObject(workflowList);
	}
	
	/**
	 * 查询所有流程
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "findWorkFlow", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8" })
	public JSONArray findWorkFlow(HttpServletRequest request) {
		List<W12WorkFlowSet> workflowList = service.findWorkFlow();
		return JSONArray.fromObject(workflowList);
	}
	
	/**
	 * 查询所有岗位
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "findPosition", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8" })
	public JSONArray findPosition(HttpServletRequest request) {
		List<W3MerchPosition> workflowList = service.findPosition();
		return JSONArray.fromObject(workflowList);
	}
	
	/**
	 * 新增事件
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "addEvent", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8" })
	public String addEvent(HttpServletRequest request) {
		int id = service.getEventId();
		W12EventSet model = new W12EventSet();
		model.setId(id+"");
		//model.getEventCode("");
		model.setWorkFlowId(request.getParameter("workflowid"));
		model.setEventName(request.getParameter("name"));
		model.setPositionId(request.getParameter("position"));
		model.setParentEventid(request.getParameter("parentid"));
		model.setFinishPeriod(request.getParameter("period"));
		model.setEventLevel(request.getParameter("eventlevel"));
		model.setSorted(request.getParameter("sorted"));
		
		int i = service.addEvent(model);
		return i>0? "1" : "0";
	}
	
	/**
	 * 查询事件
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getEventById", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8" })
	public JSONObject getEventById(HttpServletRequest request) {
		String id = request.getParameter("id");
		W12EventSet model = service.findEventById(id);
		
		return JSONObject.fromObject(model);
	}
	
	/**
	 * 修改事件
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "updateEvent", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8" })
	public String updateEvent(HttpServletRequest request) {
		W12EventSet model = new W12EventSet();
		model.setId(request.getParameter("id"));
		model.setWorkFlowId(request.getParameter("workflowid"));
		model.setEventName(request.getParameter("name"));
		model.setPositionId(request.getParameter("position"));
		model.setParentEventid(request.getParameter("parentid"));
		model.setFinishPeriod(request.getParameter("period"));
		model.setEventLevel(request.getParameter("eventlevel"));
		model.setSorted(request.getParameter("sorted"));
		
		int i = service.updateEvent(model);
		return i> 0 ? "1" :"0";
	}
	
	/**
	 * 删除事件
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "removeEvent", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8" })
	public String removeEvent(HttpServletRequest request) {
		String id = (request.getParameter("id"));
		
		int i = service.removeEvent(id);
		return i> 0 ? "1" :"0";
	}
}
