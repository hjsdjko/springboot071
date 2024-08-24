package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ZongheshixiangEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZongheshixiangView;


/**
 * 综合事项
 *
 * @author 
 * @email 
 * @date 2024-04-08 14:45:26
 */
public interface ZongheshixiangService extends IService<ZongheshixiangEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZongheshixiangView> selectListView(Wrapper<ZongheshixiangEntity> wrapper);
   	
   	ZongheshixiangView selectView(@Param("ew") Wrapper<ZongheshixiangEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZongheshixiangEntity> wrapper);
   	

}

