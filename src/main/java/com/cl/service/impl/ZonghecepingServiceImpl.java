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


import com.cl.dao.ZonghecepingDao;
import com.cl.entity.ZonghecepingEntity;
import com.cl.service.ZonghecepingService;
import com.cl.entity.view.ZonghecepingView;

@Service("zonghecepingService")
public class ZonghecepingServiceImpl extends ServiceImpl<ZonghecepingDao, ZonghecepingEntity> implements ZonghecepingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZonghecepingEntity> page = this.selectPage(
                new Query<ZonghecepingEntity>(params).getPage(),
                new EntityWrapper<ZonghecepingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZonghecepingEntity> wrapper) {
		  Page<ZonghecepingView> page =new Query<ZonghecepingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ZonghecepingView> selectListView(Wrapper<ZonghecepingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZonghecepingView selectView(Wrapper<ZonghecepingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
