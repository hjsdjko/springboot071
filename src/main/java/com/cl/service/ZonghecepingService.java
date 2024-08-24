package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ZonghecepingEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZonghecepingView;


/**
 * 综合测评
 *
 * @author 
 * @email 
 * @date 2024-04-08 14:45:26
 */
public interface ZonghecepingService extends IService<ZonghecepingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZonghecepingView> selectListView(Wrapper<ZonghecepingEntity> wrapper);
   	
   	ZonghecepingView selectView(@Param("ew") Wrapper<ZonghecepingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZonghecepingEntity> wrapper);
   	

}

