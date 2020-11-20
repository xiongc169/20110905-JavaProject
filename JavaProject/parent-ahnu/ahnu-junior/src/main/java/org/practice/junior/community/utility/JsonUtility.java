package org.practice.junior.community.utility;

import java.io.StringWriter;
import java.util.*;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;
import org.practice.junior.community.domain.User;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @Desc json序列化
 * <p>
 * @Author yoong
 * <p>
 * @Date 2015-08-30 09:06:00
 * <p>
 * @Version 1.0
 */
public class JsonUtility {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            //json-lib(net.sf.json)
            net_sf_json_1();
            net_sf_json_2();

            //gson
            gson_1();

            //fastjson
            fast_json();

            //jackson
            jackson();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * net.sf.json
     */
    public static void net_sf_json_1() {
        Map<String, Object> parentNode = new HashMap<String, Object>();
        parentNode.put("id", "001000000000000000");
        parentNode.put("text", "关键词目录树");

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
        parentNode.put("nodes", nodes);

        //TODO：net.sf.json 序列化
        System.out.println(JSONArray.fromObject(nodes).toString());
        // System.out.println(JSONObject.fromObject(nodes).toString());// 报错：'object' is an array. Use JSONArray instead
        System.out.println(JSONArray.fromObject(parentNode).toString());
        System.out.println(JSONObject.fromObject(parentNode).toString());

        //TODO：net.sf.json 反序列化
        JSONArray json = JSONArray.fromObject(nodes);
        String contentstree = json.toString();
        try {
            JSONArray array = JSONArray.fromObject(contentstree);
            for (int i = 0; i < array.size(); i++) {
                JSONObject obj2 = array.getJSONObject(i);
                if (obj2.has("id")) {
                    String idval = obj2.getString("id");
                    System.out.println(idval);
                }
            }
            JSONArray idarray = array.element("id");//等效add操作
            JSONArray textarray = array.element("text");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            String tmp = contentstree.replaceAll("[\\[\\]]", "");
            System.out.println(tmp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * net.sf.json
     */
    public static void net_sf_json_2() {
        User tony = new User();
        tony.setIid("iid - 01");
        tony.setName("name - 01");
        tony.setOrgName("orgName - 01");
        tony.setOrgNo("orgNo - 01");
        tony.setUserNo("userNo - 01");

        //序列化
        JSONObject tonyJsonObj = JSONObject.fromObject(tony);
        String tonyJsonStr = tonyJsonObj.toString();
        System.out.println(tonyJsonStr);
        //反序列化
        JSONObject newJsonObj = JSONObject.fromObject(tonyJsonStr);
        User newTony = (User) JSONObject.toBean(newJsonObj, User.class);
        System.out.println(newTony.getName());
    }

    /**
     * gson
     */
    public static void gson_1() {
        User tony = new User();
        tony.setIid("iid - 01");
        tony.setName("name - 01");
        tony.setOrgName("orgName - 01");
        tony.setOrgNo("orgNo - 01");
        tony.setUserNo("userNo - 01");

        Gson gson = new Gson();
        String gsonStr = gson.toJson(tony);
        System.out.println(gsonStr);

        User newTony = gson.fromJson(gsonStr, User.class);
        System.out.println(newTony.getName());
    }

    /**
     * fastjson
     */
    public static void fast_json() {
        User tony = new User();
        tony.setIid("iid - 0333");
        tony.setName("name - 0333");
        tony.setOrgName("orgName - 0333");
        tony.setOrgNo("orgNo - 0333");
        tony.setUserNo("userNo - 0333");

        String gsonStr = JSON.toJSONString(tony);
        System.out.println(gsonStr);
        User newTony = JSON.parseObject(gsonStr, User.class);
        System.out.println(newTony.getName());
    }

    /**
     * jackson
     */
    public static void jackson() {
        User tony = new User();
        tony.setIid("iid - 0333");
        tony.setName("name - 0333");
        tony.setOrgName("orgName - 0333");
        tony.setOrgNo("orgNo - 0333");
        tony.setUserNo("userNo - 0333");

        try {
            ObjectMapper mapper = new ObjectMapper();
            StringWriter sw = new StringWriter();
            JsonGenerator gen = new JsonFactory().createJsonGenerator(sw);
            mapper.writeValue(gen, tony);
            gen.close();
            System.out.println(sw.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
