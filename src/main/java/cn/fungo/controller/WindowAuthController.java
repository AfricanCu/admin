package cn.fungo.controller;

import java.nio.MappedByteBuffer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.fungo.domain.W12Windows;
import cn.fungo.domain.W3MerchOperationAuth;
import cn.fungo.domain.WindowAuthVO;
import cn.fungo.service.WindowAuthService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class WindowAuthController {
	
	@Autowired
	private WindowAuthService service;
	
	/**
	 * 查询
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "findAuth", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8" })
	public JSONArray findAuth(HttpServletRequest request) {
		String name = request.getParameter("name");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", name);
		List<WindowAuthVO> workflowList = service.findAuth(map);
		return JSONArray.fromObject(workflowList);
	}
	
	/**
	 * 新增窗体
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "addWindow", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8" })
	public String addWindow(HttpServletRequest request) {
		W12Windows windows = new W12Windows();
		windows.setId(service.getWindowId()+"");
		windows.setName(request.getParameter("name"));
		windows.setUrl(request.getParameter("url"));
		
		int i = service.addWindows(windows);
		return i> 0? "1" : "0";
	}
	
	/**
	 * 查询窗体对象
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getWindowById", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8" })
	public JSONObject getWindowById(HttpServletRequest request) {
		String id = request.getParameter("id");
		W12Windows model = service.getWindowById(id);
		
		return JSONObject.fromObject(model);
	}
	
	/**
	 * 修改窗体
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "updateWindow", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8" })
	public String updateWindow(HttpServletRequest request) {
		W12Windows windows = new W12Windows();
		windows.setId(request.getParameter("id"));
		windows.setName(request.getParameter("name"));
		windows.setUrl(request.getParameter("url"));
		
		int i = service.updateWindow(windows);
		return i> 0? "1" : "0";
	}
	
	/**
	 * 查询所有窗体
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "findWindow", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8" })
	public JSONArray findWindow(HttpServletRequest request) {
		List<W12Windows> list = service.findWindow();
		return JSONArray.fromObject(list);
	}
	
	/**
	 * 添加权限
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "addAuth", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8" })
	public String addAuth(HttpServletRequest request) {
		W3MerchOperationAuth model = new W3MerchOperationAuth();
		model.setId(service.getAuthId()+"");
		model.setWindowId(request.getParameter("windowId"));
		model.setAuthName(request.getParameter("authName"));
		int i = service.addAuth(model);
		return i> 0? "1" : "0";
	}
	
	/**
	 * 查询权限对象
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getAuthById", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8" })
	public JSONObject getAuthById(HttpServletRequest request) {
		String id = request.getParameter("id");
		W3MerchOperationAuth model = service.getAuthById(id);
		
		return JSONObject.fromObject(model);
	}
	
	/**
	 * 修改权限
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "updateAuth", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8" })
	public String updateAuth(HttpServletRequest request) {
		W3MerchOperationAuth model = new W3MerchOperationAuth();
		model.setId(request.getParameter("id"));
		model.setWindowId(request.getParameter("windowId"));
		model.setAuthName(request.getParameter("authName"));
		int i = service.updateAuth(model);
		return i> 0? "1" : "0";
	}
	
	/**
	 * 删除权限
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "removeAuth", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8" })
	public String removeAuth(HttpServletRequest request) {
		String id = request.getParameter("id");
		
		int i = service.removeAuth(id);
		return i> 0 ? "1":"0";
	}
	
	/**
	 * 删除权限
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "removeWindow", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8" })
	public String removeWindow(HttpServletRequest request) {
		String id = request.getParameter("id");
		
		int i = service.removeWindow(id);
		return i> 0 ? "1":"0";
	}
}
