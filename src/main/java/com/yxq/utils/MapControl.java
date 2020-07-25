package com.yxq.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用于简化controller层返回结果的操作
 * @author yxq
 * @date 2020/7/26 3:11
 */
public class MapControl {
    private static final int SUCCESS_CODE = 200;
    private static final int ERROR_CODE = 500;

    private Map<String, Object> paramMap = new HashMap<>();

    private MapControl() {

    }

    public static MapControl getInstance() {
        return new MapControl();
    }

    public Map<String, Object> getMap() {
        return paramMap;
    }

    public MapControl put(Map<String, Object> map) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            paramMap.put(entry.getKey(), entry.getValue());
        }
        return this;
    }

    public MapControl put(String key, Object val) {
        paramMap.put(key, val);
        return this;
    }

    public MapControl add(String key, Object val) {
        return this.put(key, val);
    }

    public MapControl success() {
        return this.put("msg", "操作成功").put("code", SUCCESS_CODE);
    }

    public MapControl error() {
        return this.put("msg", "操作失败").put("code", ERROR_CODE);
    }

    public MapControl success(String str) {
        return this.put("msg", str).put("code", SUCCESS_CODE);
    }

    public MapControl error(String str) {
        return this.put("msg", str).put("code", ERROR_CODE);
    }

    public MapControl page(List<?> data, Integer count) {
        return this.put("msg", "返回成功").put("code", SUCCESS_CODE).put("count", count).put("data", data);
    }

    public MapControl page(List<?> data, Integer count, int code) {
        return this.put("msg", "返回成功").put("code", code).put("count", count).put("data", data);
    }

    public static void main(String[] args) {
        Map<String, Object> map = MapControl.getInstance().put("name", "hua").put("age", 30).getMap();
        System.out.println(map);
    }

}
