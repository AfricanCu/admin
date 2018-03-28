package cn.fungo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.fungo.domain.W12WorkFlowSet;
import cn.fungo.service.WorkFlowService;
import net.sf.json.JSONArray;

@Controller
public class WorkFlowController {
	private static Logger logger = LoggerFactory.getLogger(WorkFlowController.class);
	@Autowired
	private WorkFlowService service;
	
	/**
	 * 新增
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "addWorkFlow", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8" })
	public Integer addWorkFlow(HttpServletRequest request) {
		int cnt = 0;
		String type = request.getParameter("type");
		String name = request.getParameter("name");
		String level = request.getParameter("level");
		String sort = request.getParameter("sort");
		if(!"".equals(type) && null != type) {
			int maxId = service.findMaxId(type);
			W12WorkFlowSet workflow = new W12WorkFlowSet();
			workflow.setId(String.valueOf(++maxId));
			workflow.setWorkFlowName(name);
			workflow.setSystemType(type);
			workflow.setWorkFlowLevel(level);
			workflow.setSorted(sort);
			cnt = service.addWorkFlow(workflow);
		}
		return cnt;
	}
	
	
	/**
	 * 修改
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "editWorkFlow", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8" })
	public Integer editWorkFlow(HttpServletRequest request) {
		int cnt = 0;
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String level = request.getParameter("level");
		String sort = request.getParameter("sort");
		if(!"".equals(id) && null != id) {
			W12WorkFlowSet workflow = new W12WorkFlowSet();
			workflow.setId(id);
			workflow.setWorkFlowName(name);
			workflow.setWorkFlowLevel(level);
			workflow.setSorted(sort);
			cnt = service.editWorkFlow(workflow);
		}
		return cnt;
	}
	
	/**
	 * 删除
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "removeWorkFlow", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8" })
	public Integer removeWorkFlow(HttpServletRequest request) {
		int cnt = 0;
		String id = request.getParameter("id");
		if(!"".equals(id) && null != id) {
			cnt = service.removeWorkFlow(Integer.parseInt(id));
		}
		return cnt;
	}

	/**
	 * 查询
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "findAllWorkFlow", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8" })
	public JSONArray findAllWorkFlow(HttpServletRequest request) {
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		Map<String, String> map = new HashMap<>();
		map.put("name", name);
		map.put("type", type);
		List<W12WorkFlowSet> workflowList = service.findAllWorkFlow(map);
		logger.info(workflowList.size() + "");
		return JSONArray.fromObject(workflowList);
	}
}
