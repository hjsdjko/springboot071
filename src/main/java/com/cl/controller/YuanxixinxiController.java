package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.YuanxixinxiEntity;
import com.cl.entity.view.YuanxixinxiView;

import com.cl.service.YuanxixinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 院系信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-08 14:45:26
 */
@RestController
@RequestMapping("/yuanxixinxi")
public class YuanxixinxiController {
    @Autowired
    private YuanxixinxiService yuanxixinxiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YuanxixinxiEntity yuanxixinxi,
		HttpServletRequest request){
        EntityWrapper<YuanxixinxiEntity> ew = new EntityWrapper<YuanxixinxiEntity>();

		PageUtils page = yuanxixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yuanxixinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YuanxixinxiEntity yuanxixinxi, 
		HttpServletRequest request){
        EntityWrapper<YuanxixinxiEntity> ew = new EntityWrapper<YuanxixinxiEntity>();

		PageUtils page = yuanxixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yuanxixinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YuanxixinxiEntity yuanxixinxi){
       	EntityWrapper<YuanxixinxiEntity> ew = new EntityWrapper<YuanxixinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yuanxixinxi, "yuanxixinxi")); 
        return R.ok().put("data", yuanxixinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YuanxixinxiEntity yuanxixinxi){
        EntityWrapper< YuanxixinxiEntity> ew = new EntityWrapper< YuanxixinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yuanxixinxi, "yuanxixinxi")); 
		YuanxixinxiView yuanxixinxiView =  yuanxixinxiService.selectView(ew);
		return R.ok("查询院系信息成功").put("data", yuanxixinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YuanxixinxiEntity yuanxixinxi = yuanxixinxiService.selectById(id);
		yuanxixinxi = yuanxixinxiService.selectView(new EntityWrapper<YuanxixinxiEntity>().eq("id", id));
        return R.ok().put("data", yuanxixinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YuanxixinxiEntity yuanxixinxi = yuanxixinxiService.selectById(id);
		yuanxixinxi = yuanxixinxiService.selectView(new EntityWrapper<YuanxixinxiEntity>().eq("id", id));
        return R.ok().put("data", yuanxixinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YuanxixinxiEntity yuanxixinxi, HttpServletRequest request){
    	yuanxixinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yuanxixinxi);
        yuanxixinxiService.insert(yuanxixinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YuanxixinxiEntity yuanxixinxi, HttpServletRequest request){
    	yuanxixinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yuanxixinxi);
        yuanxixinxiService.insert(yuanxixinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YuanxixinxiEntity yuanxixinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yuanxixinxi);
        yuanxixinxiService.updateById(yuanxixinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yuanxixinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
