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


import com.cl.dao.ShehuishijianchengjiDao;
import com.cl.entity.ShehuishijianchengjiEntity;
import com.cl.service.ShehuishijianchengjiService;
import com.cl.entity.view.ShehuishijianchengjiView;

@Service("shehuishijianchengjiService")
public class ShehuishijianchengjiServiceImpl extends ServiceImpl<ShehuishijianchengjiDao, ShehuishijianchengjiEntity> implements ShehuishijianchengjiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShehuishijianchengjiEntity> page = this.selectPage(
                new Query<ShehuishijianchengjiEntity>(params).getPage(),
                new EntityWrapper<ShehuishijianchengjiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShehuishijianchengjiEntity> wrapper) {
		  Page<ShehuishijianchengjiView> page =new Query<ShehuishijianchengjiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ShehuishijianchengjiView> selectListView(Wrapper<ShehuishijianchengjiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShehuishijianchengjiView selectView(Wrapper<ShehuishijianchengjiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
