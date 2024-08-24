package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.YuanxixinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YuanxixinxiView;


/**
 * 院系信息
 *
 * @author 
 * @email 
 * @date 2024-04-08 14:45:26
 */
public interface YuanxixinxiService extends IService<YuanxixinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YuanxixinxiView> selectListView(Wrapper<YuanxixinxiEntity> wrapper);
   	
   	YuanxixinxiView selectView(@Param("ew") Wrapper<YuanxixinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YuanxixinxiEntity> wrapper);
   	

}

