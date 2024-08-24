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


import com.cl.dao.SaishichengjiDao;
import com.cl.entity.SaishichengjiEntity;
import com.cl.service.SaishichengjiService;
import com.cl.entity.view.SaishichengjiView;

@Service("saishichengjiService")
public class SaishichengjiServiceImpl extends ServiceImpl<SaishichengjiDao, SaishichengjiEntity> implements SaishichengjiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SaishichengjiEntity> page = this.selectPage(
                new Query<SaishichengjiEntity>(params).getPage(),
                new EntityWrapper<SaishichengjiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<SaishichengjiEntity> wrapper) {
		  Page<SaishichengjiView> page =new Query<SaishichengjiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<SaishichengjiView> selectListView(Wrapper<SaishichengjiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public SaishichengjiView selectView(Wrapper<SaishichengjiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
