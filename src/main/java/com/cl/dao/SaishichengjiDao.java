package com.cl.dao;

import com.cl.entity.SaishichengjiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.SaishichengjiView;


/**
 * 赛事成绩
 * 
 * @author 
 * @email 
 * @date 2024-04-08 14:45:26
 */
public interface SaishichengjiDao extends BaseMapper<SaishichengjiEntity> {
	
	List<SaishichengjiView> selectListView(@Param("ew") Wrapper<SaishichengjiEntity> wrapper);

	List<SaishichengjiView> selectListView(Pagination page,@Param("ew") Wrapper<SaishichengjiEntity> wrapper);
	
	SaishichengjiView selectView(@Param("ew") Wrapper<SaishichengjiEntity> wrapper);
	

}
