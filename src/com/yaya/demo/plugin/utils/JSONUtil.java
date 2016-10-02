package com.yaya.demo.plugin.utils;



import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * json转换相关工具类
 *
 * @author ChW 2016-04-25 13:52:55
 */
public class JSONUtil {


    public static JSONObject jsonEncode(Integer result, Object data) {
        Map<Integer, String> returnInfo = new HashMap<Integer, String>();
        returnInfo.put(0, "failed");
        returnInfo.put(1, "succeed");

        JSONObject jsonObject = new JSONObject();

        Object jsonData = null;
        try {
            jsonData = JSONArray.fromObject(data);
        } catch (Exception e){
            jsonData = data;
        }


        jsonObject.put("result", result);
        jsonObject.put("msg", returnInfo.get(result));
        jsonObject.put("data", jsonData);

        return jsonObject;
    }

}
