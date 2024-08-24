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


import com.cl.dao.XueyechengjiDao;
import com.cl.entity.XueyechengjiEntity;
import com.cl.service.XueyechengjiService;
import com.cl.entity.view.XueyechengjiView;

@Service("xueyechengjiService")
public class XueyechengjiServiceImpl extends ServiceImpl<XueyechengjiDao, XueyechengjiEntity> implements XueyechengjiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XueyechengjiEntity> page = this.selectPage(
                new Query<XueyechengjiEntity>(params).getPage(),
                new EntityWrapper<XueyechengjiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XueyechengjiEntity> wrapper) {
		  Page<XueyechengjiView> page =new Query<XueyechengjiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<XueyechengjiView> selectListView(Wrapper<XueyechengjiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XueyechengjiView selectView(Wrapper<XueyechengjiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
