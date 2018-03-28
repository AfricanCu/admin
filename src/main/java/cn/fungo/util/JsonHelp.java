package cn.fungo.util;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Json帮助类
 * @author tanjian
 *
 */
public class JsonHelp {
	public static Object convertToObject(String json, Class<?> beanClass) {
		JSONObject obj = JSONObject.fromObject(json);
		return JSONObject.toBean(obj, beanClass);
	}
	
	public static Object convertToArray(String json, Class<?> beanClass){
		JSONArray array = JSONArray.fromObject(json);
		Object list = JSONArray.toArray(array, beanClass);
		return list;
	}
}

