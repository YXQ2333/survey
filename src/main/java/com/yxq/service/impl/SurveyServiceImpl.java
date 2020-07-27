package com.yxq.service.impl;

import com.github.pagehelper.PageHelper;
import com.yxq.entity.Survey;
import com.yxq.mapper.SurveyMapper;
import com.yxq.service.SurveyService;
import com.yxq.utils.BeanMapUtils;
import com.yxq.utils.MapParameter;
import com.yxq.utils.Md5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yxq
 * @date 2020/7/27 19:50
 */
@Service
public class SurveyServiceImpl implements SurveyService {
    @Autowired
    private SurveyMapper surveyMapper;

    @Override
    public int create(Survey survey) {
        // 加密
        survey.setPassword(Md5Utils.getMd5(survey.getPassword()));
        return surveyMapper.create(survey);
    }

    @Override
    public int delete(Integer id) {
        Map<String, Object> map = new HashMap<>();
        map.put("id",id);
        return surveyMapper.delete(map);
    }

    @Override
    public int deleteBatch(String ids) {
        int count = 0;
        String[] split = ids.split(",");
        for (String s : split) {
            Map<String,Object> map = new HashMap<>();
            map.put("id",Integer.parseInt(s));
            surveyMapper.delete(map);
            count++;
        }
        return count;
    }

    @Override
    public void updateState() {
        // 查询出来，然后更新状态
        List<Integer> list = surveyMapper.queryByState(Survey.STATE_CREATE);
        for (Integer id : list) {
            Map<String,Object> map = new HashMap<>();
            map.put("updateState",Survey.STATE_EXEC);
            map.put("id",id);
            surveyMapper.update(map);
//            surveyMapper.update(MapParameter.getInstance().add("updateState", Survey.STATE_EXEC).addId(id).getMap());
        }
        List<Integer> list1 = surveyMapper.queryByStateForExec(Survey.STATE_EXEC);
        for (Integer id : list1) {
            Map<String,Object> map = new HashMap<>();
            map.put("updateState",Survey.STATE_OVER);
            map.put("id",id);
            surveyMapper.update(map);
//            surveyMapper.update(MapParameter.getInstance().add("updateState", Survey.STATE_OVER).addId(id).getMap());
        }
    }

    @Override
    public int update(Survey survey) {
        Map<String, Object> map = BeanMapUtils.beanToMapForUpdate(survey);
        map.put("id",survey.getId());
        return surveyMapper.update(map);
    }

    @Override
    public List<Survey> query(Survey survey) {
        PageHelper.startPage(survey.getPage(),survey.getLimit());
        Map<String, Object> map = BeanMapUtils.beanToMap(survey);
        return surveyMapper.query(map);
    }

    @Override
    public Survey detail(Integer id) {
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        return surveyMapper.detail(map);
    }

    @Override
    public int count(Survey survey) {
        Map<String, Object> map = BeanMapUtils.beanToMap(survey);
        return surveyMapper.count(map);
    }

}
