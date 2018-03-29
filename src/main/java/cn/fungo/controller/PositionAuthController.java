package cn.fungo.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.fungo.service.PositionAuthService;
import cn.fungo.util.JsonHelp;
import cn.fungo.vo.AuthVO;
import cn.fungo.vo.PositionVO;
import cn.fungo.vo.WindowVO;
import net.sf.json.JSONArray;

@Controller
@RequestMapping(value="position_auth")
public class PositionAuthController {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private PositionAuthService service;
	
	/**
	 * 查找岗位
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "findPositions")
	public JSONArray findPositions(HttpServletRequest request) {
		String position_type = request.getParameter("position_type");
		if(null == position_type) {
			position_type = "";
		}
		logger.info("enter auth backstage {}", position_type);
		List<PositionVO> list = service.findPositions(position_type);
		logger.info("positionList {}", list);
		return JSONArray.fromObject(list);
	}
	
	@ResponseBody
	@RequestMapping(value = "findWindowAuth")
	public JSONArray findWindowAuth(HttpServletRequest request) {
		List<WindowVO> list = service.findWindowAuth();
		logger.info("window_auth {}", list);
		JSONArray ary = JSONArray.fromObject(list);
		return ary;
	}
	
	/***
	 * 新增岗位权限
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "insertPositionAuth", method=RequestMethod.POST, produces = {"application/json;charset=UTF-8" })
	public Integer insertPositionAuth(HttpServletRequest request) {
		String data = request.getParameter("data");
		String positionId = request.getParameter("positionId");
		String positionType = request.getParameter("position_type");
		if("".equals(positionId) || null == positionId) {
			return 0;
		}
		List<AuthVO> list = Arrays.asList((AuthVO[]) JsonHelp.convertToArray(data, AuthVO.class));
		Integer cnt = service.insertPositionAuth(list,positionId,positionType);
		return cnt;
	}
	
	/**
	 * 修改岗位权限
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "updatePositionAuth", method=RequestMethod.POST, produces = {"application/json;charset=UTF-8" })
	public Integer updatePositionAuth(HttpServletRequest request) {
		String data = request.getParameter("data");
		String positionId = request.getParameter("positionId");
		String positionType = request.getParameter("position_type");
		if("".equals(positionId) || null == positionId) {
			return 0;
		}
		List<AuthVO> list = Arrays.asList((AuthVO[]) JsonHelp.convertToArray(data, AuthVO.class));
		Integer cnt = service.updatePositionAuth(list,positionId,positionType);
		return cnt;
	}

}
