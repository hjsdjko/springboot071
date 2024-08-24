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


import com.cl.dao.XiaoyuanzixunDao;
import com.cl.entity.XiaoyuanzixunEntity;
import com.cl.service.XiaoyuanzixunService;
import com.cl.entity.view.XiaoyuanzixunView;

@Service("xiaoyuanzixunService")
public class XiaoyuanzixunServiceImpl extends ServiceImpl<XiaoyuanzixunDao, XiaoyuanzixunEntity> implements XiaoyuanzixunService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XiaoyuanzixunEntity> page = this.selectPage(
                new Query<XiaoyuanzixunEntity>(params).getPage(),
                new EntityWrapper<XiaoyuanzixunEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XiaoyuanzixunEntity> wrapper) {
		  Page<XiaoyuanzixunView> page =new Query<XiaoyuanzixunView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<XiaoyuanzixunView> selectListView(Wrapper<XiaoyuanzixunEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XiaoyuanzixunView selectView(Wrapper<XiaoyuanzixunEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
