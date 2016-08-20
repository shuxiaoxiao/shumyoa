package com.shupro.oa.utils.json;

import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

/**
 * Google的Gson
 * 
 * @ClassName: GsonUtil
 * @author shuheng
 * @date 2015-12-9 <br>
 * Gson类：解析json的最基础的工具类<br>
 *       JsonParser类：解析器来解析<br>
 *       JSON到JsonElements的解析树 <br>
 *       JsonElement类：一个类代表的JSON元素<br>
 *       JsonObject类：JSON对象类型 <br>
 *       JsonArray类：JsonObject数组<br>
 *       TypeToken类：用于创建type，比如泛型List<?>
 */
@SuppressWarnings("unchecked")
public class GsonUtil {
	
	/**
	 * 格式化Json
	 * @param obj
	 * @return
	 */
	public static String fromat(String json) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonParser jp = new JsonParser();
		JsonElement je = jp.parse(json);
		json = gson.toJson(je);
		return json;
	}
	
	/**
	 * 该字符串可能转为 JSONObject 或 JSONArray
	 * 
	 * @param string
	 * @return
	 */
	public static boolean maybeJson(String jsonStr) {
		boolean jsonFlag;
		try {
			new JsonParser().parse(jsonStr).getAsJsonObject();
			jsonFlag = true;
		} catch (Exception e) {
			jsonFlag = false;
		}
		return jsonFlag;
	}

	/**
	 * bean转换json<br>
	 * pojo、list、map都可以
	 * 
	 * @param obj
	 * @return
	 */
	public static String obj2Objstr(Object obj) {
		GsonBuilder builder = new GsonBuilder();
		builder.setDateFormat("yyyy-MM-dd HH:mm:ss");
		Gson gson = builder.create();
		// Gson gson = new Gson();
		String json = gson.toJson(obj);
		return json;
	}

	/**
	 * 将json转为map
	 * 
	 * @param jsonStr
	 * @return
	 */
	public static Map<String, Object> json2Map(String jsonStr) {
		Gson gson = new Gson();
		Map<String, Object> map = gson.fromJson(jsonStr, Map.class);
		return map;
	}

	/**
	 * 将json转换成list
	 * 
	 * @param jsonStr
	 * @return
	 */
	public static List<Map<String, Object>> json2List(String jsonStr) {
		Gson gson = new Gson();
		// 将json转换成List(复杂类型的bean),需要使用TypeToken
		List list = gson.fromJson(jsonStr, new TypeToken<List>() {}.getType());
		return list;
	}
	
//	//这样转换反而麻烦了，gson是直接内部处理了复杂情况
//	public static List<Map<String, Object>> json2List(String jsonStr) {
//		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
//		Gson gson = new Gson();
//		// 将json转换成List
//		List jsonList = gson.fromJson(jsonStr, new TypeToken<List>() {
//		}.getType());
//		for (int i = 0, max = jsonList.size(); i < max; i++) {
//			Map<String, Object> map = json2Map(jsonList.get(i).toString());
//			list.add(map);
//		}
//		return list;
//	}

}
