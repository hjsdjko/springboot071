package com.cl.dao;

import com.cl.entity.YuanxixinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YuanxixinxiView;


/**
 * 院系信息
 * 
 * @author 
 * @email 
 * @date 2024-04-08 14:45:26
 */
public interface YuanxixinxiDao extends BaseMapper<YuanxixinxiEntity> {
	
	List<YuanxixinxiView> selectListView(@Param("ew") Wrapper<YuanxixinxiEntity> wrapper);

	List<YuanxixinxiView> selectListView(Pagination page,@Param("ew") Wrapper<YuanxixinxiEntity> wrapper);
	
	YuanxixinxiView selectView(@Param("ew") Wrapper<YuanxixinxiEntity> wrapper);
	

}
