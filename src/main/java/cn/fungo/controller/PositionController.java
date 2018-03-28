package cn.fungo.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.fungo.service.PositionService;
import cn.fungo.vo.PositionVO;
import net.sf.json.JSONArray;

@Controller
public class PositionController {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private PositionService positonService;
	
	/**
	 * 查询岗位
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "findPositions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8" })
	public JSONArray findPositons(HttpServletRequest request) {
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		List<PositionVO> list = positonService.findPositions(type, name);
		logger.info("{}", list);
		return JSONArray.fromObject(list);
	}
	
	/**
	 * 新增岗位
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "addPosition", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8" })
	public Integer addPosition(HttpServletRequest request) {
		String position_type = request.getParameter("position_type");
		String position_code = request.getParameter("position_code");
		String position_name = request.getParameter("position_name");
		String position_level = request.getParameter("position_level");
		Integer cnt = positonService.addPosition(position_type, position_code, position_name, position_level);
		return cnt;
	}
	
	/**
	 * 删除岗位
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "deletePosition", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8" })
	public Integer deletePosition(HttpServletRequest request) {
		int cnt = 0;
		String type = request.getParameter("type");
		String id = request.getParameter("id");
		if(null != type && null != id && !"".equals(type) && !"".equals(id)) {
			cnt = positonService.deletePosition(type, id);
		}
		return cnt;
	}
	
	@ResponseBody
	@RequestMapping(value = "editPosition", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8" })
	public Integer editPosition(HttpServletRequest request) {
		int cnt = 0;
		String type = request.getParameter("type");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String code = request.getParameter("code");
		String level = request.getParameter("level");
		logger.info("{},{},{},{},{}", type, id, name, code, level);
		if(null != type && null != id && !"".equals(type) && !"".equals(id)) {
			cnt = positonService.editPosition(type, id, name, code, level);
		}
		return cnt;
	}
	
	
}
