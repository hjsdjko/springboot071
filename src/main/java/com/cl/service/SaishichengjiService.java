package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.SaishichengjiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.SaishichengjiView;


/**
 * 赛事成绩
 *
 * @author 
 * @email 
 * @date 2024-04-08 14:45:26
 */
public interface SaishichengjiService extends IService<SaishichengjiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<SaishichengjiView> selectListView(Wrapper<SaishichengjiEntity> wrapper);
   	
   	SaishichengjiView selectView(@Param("ew") Wrapper<SaishichengjiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<SaishichengjiEntity> wrapper);
   	

}

