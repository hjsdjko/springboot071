package com.cl.dao;

import com.cl.entity.ZonghecepingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZonghecepingView;


/**
 * 综合测评
 * 
 * @author 
 * @email 
 * @date 2024-04-08 14:45:26
 */
public interface ZonghecepingDao extends BaseMapper<ZonghecepingEntity> {
	
	List<ZonghecepingView> selectListView(@Param("ew") Wrapper<ZonghecepingEntity> wrapper);

	List<ZonghecepingView> selectListView(Pagination page,@Param("ew") Wrapper<ZonghecepingEntity> wrapper);
	
	ZonghecepingView selectView(@Param("ew") Wrapper<ZonghecepingEntity> wrapper);
	

}
