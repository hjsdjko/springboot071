package com.cl.dao;

import com.cl.entity.XiaoyuanzixunEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XiaoyuanzixunView;


/**
 * 校园资讯
 * 
 * @author 
 * @email 
 * @date 2024-04-08 14:45:26
 */
public interface XiaoyuanzixunDao extends BaseMapper<XiaoyuanzixunEntity> {
	
	List<XiaoyuanzixunView> selectListView(@Param("ew") Wrapper<XiaoyuanzixunEntity> wrapper);

	List<XiaoyuanzixunView> selectListView(Pagination page,@Param("ew") Wrapper<XiaoyuanzixunEntity> wrapper);
	
	XiaoyuanzixunView selectView(@Param("ew") Wrapper<XiaoyuanzixunEntity> wrapper);
	

}
