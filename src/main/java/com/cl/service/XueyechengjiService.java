package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.XueyechengjiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XueyechengjiView;


/**
 * 学业成绩
 *
 * @author 
 * @email 
 * @date 2024-04-08 14:45:26
 */
public interface XueyechengjiService extends IService<XueyechengjiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XueyechengjiView> selectListView(Wrapper<XueyechengjiEntity> wrapper);
   	
   	XueyechengjiView selectView(@Param("ew") Wrapper<XueyechengjiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XueyechengjiEntity> wrapper);
   	

}

