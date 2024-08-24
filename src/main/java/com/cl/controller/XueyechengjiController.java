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

import com.cl.entity.XueyechengjiEntity;
import com.cl.entity.view.XueyechengjiView;

import com.cl.service.XueyechengjiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 学业成绩
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-08 14:45:26
 */
@RestController
@RequestMapping("/xueyechengji")
public class XueyechengjiController {
    @Autowired
    private XueyechengjiService xueyechengjiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XueyechengjiEntity xueyechengji,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			xueyechengji.setXuehao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("jiaoshi")) {
			xueyechengji.setJiaoshigonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<XueyechengjiEntity> ew = new EntityWrapper<XueyechengjiEntity>();

		PageUtils page = xueyechengjiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xueyechengji), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XueyechengjiEntity xueyechengji, 
		HttpServletRequest request){
        EntityWrapper<XueyechengjiEntity> ew = new EntityWrapper<XueyechengjiEntity>();

		PageUtils page = xueyechengjiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xueyechengji), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XueyechengjiEntity xueyechengji){
       	EntityWrapper<XueyechengjiEntity> ew = new EntityWrapper<XueyechengjiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xueyechengji, "xueyechengji")); 
        return R.ok().put("data", xueyechengjiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XueyechengjiEntity xueyechengji){
        EntityWrapper< XueyechengjiEntity> ew = new EntityWrapper< XueyechengjiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xueyechengji, "xueyechengji")); 
		XueyechengjiView xueyechengjiView =  xueyechengjiService.selectView(ew);
		return R.ok("查询学业成绩成功").put("data", xueyechengjiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XueyechengjiEntity xueyechengji = xueyechengjiService.selectById(id);
		xueyechengji = xueyechengjiService.selectView(new EntityWrapper<XueyechengjiEntity>().eq("id", id));
        return R.ok().put("data", xueyechengji);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XueyechengjiEntity xueyechengji = xueyechengjiService.selectById(id);
		xueyechengji = xueyechengjiService.selectView(new EntityWrapper<XueyechengjiEntity>().eq("id", id));
        return R.ok().put("data", xueyechengji);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XueyechengjiEntity xueyechengji, HttpServletRequest request){
    	xueyechengji.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xueyechengji);
        xueyechengjiService.insert(xueyechengji);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XueyechengjiEntity xueyechengji, HttpServletRequest request){
    	xueyechengji.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xueyechengji);
        xueyechengjiService.insert(xueyechengji);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody XueyechengjiEntity xueyechengji, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xueyechengji);
        xueyechengjiService.updateById(xueyechengji);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xueyechengjiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
