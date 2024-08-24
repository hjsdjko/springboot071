package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ShehuishijianchengjiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShehuishijianchengjiView;


/**
 * 社会实践成绩
 *
 * @author 
 * @email 
 * @date 2024-04-08 14:45:26
 */
public interface ShehuishijianchengjiService extends IService<ShehuishijianchengjiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShehuishijianchengjiView> selectListView(Wrapper<ShehuishijianchengjiEntity> wrapper);
   	
   	ShehuishijianchengjiView selectView(@Param("ew") Wrapper<ShehuishijianchengjiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShehuishijianchengjiEntity> wrapper);
   	

}

