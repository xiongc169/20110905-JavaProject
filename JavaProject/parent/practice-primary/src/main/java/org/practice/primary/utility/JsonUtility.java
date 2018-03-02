package org.practice.primary.utility;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.practice.primary.domain.User;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * json序列化
 * 
 * @author Administrator
 * @since 2015-09-30 08:58:04
 * 
 * http://blog.csdn.net/isea533/article/details/7859815
 */
public class JsonUtility {
	public static void main(String[] args) {
		serialize();
	}

	/**
	 * http://blog.csdn.net/lishuangzhe7047/article/details/28880009
	 * http://blog.csdn.net/sjiang2142/article/details/6706097
	 */
	public static void jsonSerializeTest() {
		Map<String, Object> parentnode = new HashMap<String, Object>();
		parentnode.put("id", "001000000000000000");
		parentnode.put("text", "关键词目录树");

		List<Map<String, String>> nodes = new ArrayList<Map<String, String>>();
		Map<String, String> node1 = new HashMap<String, String>();
		node1.put("id", "001001000000000000");
		node1.put("text", "一大队");
		Map<String, String> node2 = new HashMap<String, String>();
		node2.put("id", "001002000000000000");
		node2.put("text", "二大队");
		Map<String, String> node3 = new HashMap<String, String>();
		node3.put("id", "001003000000000000");
		node3.put("text", "三大队");
		nodes.add(node1);
		nodes.add(node2);
		nodes.add(node3);
		parentnode.put("nodes", nodes);

		JSONArray json = JSONArray.fromObject(nodes);
		String contentstree = json.toString();

		JSONArray newJson = JSONArray.fromObject(json.toArray());
		Collection col = JSONArray.toCollection(newJson);
		Object obj = JSONArray.toArray(json);

		try {
			JSONArray array = JSONArray.fromObject(contentstree);
			for (int i = 0; i < array.size(); i++) {
				JSONObject obj2 = array.getJSONObject(i);
				if (obj2.has("id")) {
					String idval = obj2.getString("id");
				}
			}
			JSONObject obj2 = array.getJSONObject(0);
			obj2.getString("");
			JSONArray idarray = array.element("id");
			JSONArray textarray = array.element("text");
			int a = 0;
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			// String tmp = contentstree.replaceAll("\\[\\]", "");
			// JSONObject jobj = JSONObject.fromObject(contentstree);
			// Iterator it = jobj.keys();
			// while(it.hasNext()){
			// String next = it.next().toString();
			// String value = jobj.getString(next);
			// System.out.println(value);
			// }
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void serialize() {
		User tony = new User();
		tony.setIid("iid - 01");
		tony.setName("name - 01");
		tony.setOrgName("orgName - 01");
		tony.setOrgNo("orgNo - 01");
		tony.setUserNo("userNo - 01");

		JSONObject tonyJsonObj = JSONObject.fromObject(tony);
		String tonyJsonStr = tonyJsonObj.toString();
		System.out.println(tonyJsonStr);

		User tonyObj = (User) JSONObject.toBean(tonyJsonObj, User.class);
	}
}
