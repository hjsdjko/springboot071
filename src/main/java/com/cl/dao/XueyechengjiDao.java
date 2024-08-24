package com.cl.dao;

import com.cl.entity.XueyechengjiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XueyechengjiView;


/**
 * 学业成绩
 * 
 * @author 
 * @email 
 * @date 2024-04-08 14:45:26
 */
public interface XueyechengjiDao extends BaseMapper<XueyechengjiEntity> {
	
	List<XueyechengjiView> selectListView(@Param("ew") Wrapper<XueyechengjiEntity> wrapper);

	List<XueyechengjiView> selectListView(Pagination page,@Param("ew") Wrapper<XueyechengjiEntity> wrapper);
	
	XueyechengjiView selectView(@Param("ew") Wrapper<XueyechengjiEntity> wrapper);
	

}
