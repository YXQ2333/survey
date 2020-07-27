package com.yxq.utils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.cglib.beans.BeanMap;

import java.util.List;
import java.util.Map;

/**
 * 通过Guava实现Bean和Map的转化
 *
 * @author yxq
 * @date 2020/7/25 14:21
 */
public class BeanMapUtils {
    /**
     * 使用Guava将Bean转换成Map
     *
     * @param bean 要转换的Bean
     * @return 转换后的Map
     */
    public static <T> Map<String, Object> beanToMap(T bean) {
        Map<String, Object> map = Maps.newHashMap();
        if (bean != null) {
            BeanMap beanMap = BeanMap.create(bean);
            for (Object key : beanMap.keySet()) {
                map.put(key + "", beanMap.get(key));
            }
        }
        return map;
    }

    /**
     * 将Bean转换成适合进行update的Map的格式
     *
     * @param bean 要修改的Bean
     * @return 转换后的Map
     */
    public static <T> Map<String, Object> beanToMapForUpdate(T bean) {
        Map<String, Object> map = Maps.newHashMap();
        if (bean != null) {
            BeanMap beanMap = BeanMap.create(bean);
            for (Object key : beanMap.keySet()) {
                map.put("update" + upperFirstLetter(key + ""), beanMap.get(key));
            }
        }
        return map;
    }

    /**
     * 将Map转换成需要的Bean
     *
     * @param map  需要转换的Map
     * @param bean 需要转换的Bean类型
     * @return 转换后的Bean
     */
    public static <T> T mapToBean(Map<String, Object> map, T bean) {
        BeanMap beanMap = BeanMap.create(bean);
        beanMap.putAll(map);
        return bean;
    }


    /**
     * 将List<T>转换为List<Map<String, Object>>
     *
     * @param beanList 需要转换的Bean队列
     * @return 转换后的List<Map < String, Object>>
     */
    public static <T> List<Map<String, Object>> beansToMaps(List<T> beanList) {
        List<Map<String, Object>> list = Lists.newArrayList();
        if (beanList != null && beanList.size() > 0) {
            Map<String, Object> map = null;
            T bean = null;
            for (int i = 0, size = beanList.size(); i < size; i++) {
                bean = beanList.get(i);
                map = beanToMap(bean);
                list.add(map);
            }
        }
        return list;
    }

    /**
     * 将List<Map<String,Object>>转换成List<T>
     *
     * @param maps  需要转换的List<Map>
     * @param clazz 要转换的Bean的类
     * @return
     */
    public static <T> List<T> mapsToBeans(List<Map<String, Object>> maps, Class<T> clazz) throws IllegalAccessException, InstantiationException {
        List<T> list = Lists.newArrayList();
        if (maps != null && maps.size() > 0) {
            Map<String, Object> map = null;
            T bean = null;
            for (int i = 0, size = maps.size(); i < size; i++) {
                map = maps.get(i);
                bean = clazz.newInstance();
                mapToBean(map, bean);
                list.add(bean);
            }
        }
        return list;
    }

    /**
     * 将传入的字符串第一字符改成大写的
     *
     * @param letter 需要修改的字符串
     * @return 修改后的字符串
     */
    private static String upperFirstLetter(String letter) {
        char[] chars = letter.toCharArray();
        // 如果是小写字母则需要转换
        if (chars[0] >= 'a' && chars[0] <= 'z') {
            chars[0] = (char) (chars[0] - 32);
        }
        return new String(chars);
    }

}
