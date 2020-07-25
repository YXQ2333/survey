package com.yxq.utils;

import com.yxq.entity.Admin;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * 测试BeanMapUtils类
 *
 * @author yxq
 * @date 2020/7/25 14:57
 */
public class BeanMapUtilsTest {

    @Test
    public void beanToMap() {
        Admin admin = new Admin();
        admin.setId(1);
        admin.setName("张三");
        Map<String, Object> map = BeanMapUtils.beanToMap(admin);
        System.out.println(map);
    }

    @Test
    public void beanToMapForUpdate() {
        Admin admin = new Admin();
        admin.setId(1);
        admin.setName("张三");
        Map<String, Object> map = BeanMapUtils.beanToMapForUpdate(admin);
        System.out.println(map);
    }

    @Test
    public void mapToBean() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", 134);
        map.put("account", "张三");
        map.put("password", "123456");
        Admin admin = new Admin();
        admin = BeanMapUtils.mapToBean(map, admin);
        System.out.println(admin);
    }

    @Test
    public void beansToMaps() {
        Admin admin = new Admin();
        admin.setId(1);
        admin.setName("张三");
        Admin admin1 = new Admin();
        admin1.setId(2);
        admin1.setName("李四");
        List<Admin> list = new ArrayList<>();
        list.add(admin);
        list.add(admin1);
        List<Map<String, Object>> maps = BeanMapUtils.beansToMaps(list);
        for (Map<String, Object> map : maps) {
            System.out.println(map);
        }

    }

    @Test
    public void mapsToBeans() {
        List<Map<String,Object>> maps = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("id", 134);
        map.put("account", "张三");
        map.put("password", "123456");
        Map<String, Object> map2 = new HashMap<>();
        map2.put("id", 33333);
        map2.put("account", "老王");
        map2.put("password", "666666");
        maps.add(map);
        maps.add(map2);
        List<Admin> list = null;
        try {
            list = BeanMapUtils.mapsToBeans(maps, Admin.class);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        for (Admin admin : list) {
            System.out.println(admin);
        }
    }
}