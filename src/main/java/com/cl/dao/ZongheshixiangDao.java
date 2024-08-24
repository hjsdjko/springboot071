package com.cl.dao;

import com.cl.entity.ZongheshixiangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZongheshixiangView;


/**
 * 综合事项
 * 
 * @author 
 * @email 
 * @date 2024-04-08 14:45:26
 */
public interface ZongheshixiangDao extends BaseMapper<ZongheshixiangEntity> {
	
	List<ZongheshixiangView> selectListView(@Param("ew") Wrapper<ZongheshixiangEntity> wrapper);

	List<ZongheshixiangView> selectListView(Pagination page,@Param("ew") Wrapper<ZongheshixiangEntity> wrapper);
	
	ZongheshixiangView selectView(@Param("ew") Wrapper<ZongheshixiangEntity> wrapper);
	

}
