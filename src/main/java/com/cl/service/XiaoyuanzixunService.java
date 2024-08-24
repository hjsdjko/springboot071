package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.XiaoyuanzixunEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XiaoyuanzixunView;


/**
 * 校园资讯
 *
 * @author 
 * @email 
 * @date 2024-04-08 14:45:26
 */
public interface XiaoyuanzixunService extends IService<XiaoyuanzixunEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XiaoyuanzixunView> selectListView(Wrapper<XiaoyuanzixunEntity> wrapper);
   	
   	XiaoyuanzixunView selectView(@Param("ew") Wrapper<XiaoyuanzixunEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XiaoyuanzixunEntity> wrapper);
   	

}

