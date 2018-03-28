package cn.fungo.controller;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.fungo.domain.W12User;
import cn.fungo.service.UserService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

@Controller
public class UserController {
	@Autowired
	UserService service;
	
	/**
	 * 查询
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "findUser", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8" })
	public JSONArray findUser(HttpServletRequest request) {
		String name = request.getParameter("name");
		Map<String, String> map = new HashMap<>();
		map.put("name", name);
		List<W12User> workflowList = service.findUser(map);
		return JSONArray.fromObject(workflowList);
	}
	
	/**
	 * 新增用户
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "addUser", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8" })
	public String addUser(HttpServletRequest request) {
		StringBuffer order = new StringBuffer();
		// 获得4位随机数
		String randNum = getRandomNum();
		order.append("CZY").append(getCurrentTime()).append(randNum);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		W12User model = new W12User();
		model.setId(service.generatorPriKey("W12User"));
		model.setOperatorCode(order.toString());
		model.setOperatorName(request.getParameter("name"));
		model.setOperatorPhone(request.getParameter("phone"));
		model.setGesturePwd(request.getParameter("password"));
		model.setPinyinCode(getFirstSpell(request.getParameter("name")));
		model.setLoginNum("0");
		model.setUserType(request.getParameter("userType"));
		model.setUserStatus("00");
		model.setCreateDate(sdf.format(System.currentTimeMillis()));
		model.setUpdateDate(sdf.format(System.currentTimeMillis()));
		model.setRealType("00");
		
		int i = service.addUser(model);
		return i> 0 ? "1" : "0";
	}
	
	/**
	 * 获取用户对象
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getUserInfo", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8" })
	public JSONObject getUserInfo(HttpServletRequest request) {
		String id = request.getParameter("id");
		W12User model = service.getUserInfo(id);
		return JSONObject.fromObject(model);
	}
	
	/**
	 * 修改用户对象
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "updateUser", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8" })
	public String updateUser(HttpServletRequest request) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		W12User model = new W12User();
		model.setId(request.getParameter("id"));
		model.setOperatorName(request.getParameter("name"));
		model.setOperatorPhone(request.getParameter("phone"));
		model.setGesturePwd(request.getParameter("password"));
		model.setPinyinCode(getFirstSpell(request.getParameter("name")));
		model.setUserType(request.getParameter("userType"));
		model.setUpdateDate(sdf.format(System.currentTimeMillis()));
		
		int i = service.updateUser(model);
		return i> 0 ? "1" : "0";
	}
	
	/**
	 * 修改用户对象
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "removeUser", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8" })
	public String removeUser(HttpServletRequest request) {
		String id = request.getParameter("id");
		int i = service.removeUser(id);
		return i> 0 ? "1" : "0";
	}
	
	private static String getRandomNum() {
		int max = 99999;
		int min = 10000;
		Random random = new Random(System.nanoTime());
		int s = random.nextInt(max) % (max - min + 1) + min;

		return String.valueOf(s);
	}
	
	private static String getCurrentTime() {
		Format format = new SimpleDateFormat("yyyyMMddHHmmss");
		String time = format.format(System.currentTimeMillis());
		return time;
	}
	
	public static String getFirstSpell(String chinese) {   
        StringBuffer pybf = new StringBuffer();   
        char[] arr = chinese.toCharArray();   
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();   
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);   
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);   
        for (int i = 0; i < arr.length; i++) {   
                if (arr[i] > 128) {   
                        try {   
                                String[] temp = PinyinHelper.toHanyuPinyinStringArray(arr[i], defaultFormat);   
                                if (temp != null) {   
                                        pybf.append(temp[0].charAt(0));   
                                }   
                        } catch (BadHanyuPinyinOutputFormatCombination e) {   
                                e.printStackTrace();   
                        }   
                } else {   
                        pybf.append(arr[i]);   
                }   
        }   
        return pybf.toString().replaceAll("\\W", "").trim();   
	}   
}
