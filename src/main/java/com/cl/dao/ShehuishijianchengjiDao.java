package com.cl.dao;

import com.cl.entity.ShehuishijianchengjiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShehuishijianchengjiView;


/**
 * 社会实践成绩
 * 
 * @author 
 * @email 
 * @date 2024-04-08 14:45:26
 */
public interface ShehuishijianchengjiDao extends BaseMapper<ShehuishijianchengjiEntity> {
	
	List<ShehuishijianchengjiView> selectListView(@Param("ew") Wrapper<ShehuishijianchengjiEntity> wrapper);

	List<ShehuishijianchengjiView> selectListView(Pagination page,@Param("ew") Wrapper<ShehuishijianchengjiEntity> wrapper);
	
	ShehuishijianchengjiView selectView(@Param("ew") Wrapper<ShehuishijianchengjiEntity> wrapper);
	

}
