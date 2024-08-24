package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.ZongheshixiangDao;
import com.cl.entity.ZongheshixiangEntity;
import com.cl.service.ZongheshixiangService;
import com.cl.entity.view.ZongheshixiangView;

@Service("zongheshixiangService")
public class ZongheshixiangServiceImpl extends ServiceImpl<ZongheshixiangDao, ZongheshixiangEntity> implements ZongheshixiangService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZongheshixiangEntity> page = this.selectPage(
                new Query<ZongheshixiangEntity>(params).getPage(),
                new EntityWrapper<ZongheshixiangEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZongheshixiangEntity> wrapper) {
		  Page<ZongheshixiangView> page =new Query<ZongheshixiangView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ZongheshixiangView> selectListView(Wrapper<ZongheshixiangEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZongheshixiangView selectView(Wrapper<ZongheshixiangEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
