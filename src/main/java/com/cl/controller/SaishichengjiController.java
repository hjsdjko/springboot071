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

import com.cl.entity.SaishichengjiEntity;
import com.cl.entity.view.SaishichengjiView;

import com.cl.service.SaishichengjiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 赛事成绩
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-08 14:45:26
 */
@RestController
@RequestMapping("/saishichengji")
public class SaishichengjiController {
    @Autowired
    private SaishichengjiService saishichengjiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,SaishichengjiEntity saishichengji,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			saishichengji.setXuehao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<SaishichengjiEntity> ew = new EntityWrapper<SaishichengjiEntity>();

		PageUtils page = saishichengjiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, saishichengji), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,SaishichengjiEntity saishichengji, 
		HttpServletRequest request){
        EntityWrapper<SaishichengjiEntity> ew = new EntityWrapper<SaishichengjiEntity>();

		PageUtils page = saishichengjiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, saishichengji), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( SaishichengjiEntity saishichengji){
       	EntityWrapper<SaishichengjiEntity> ew = new EntityWrapper<SaishichengjiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( saishichengji, "saishichengji")); 
        return R.ok().put("data", saishichengjiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(SaishichengjiEntity saishichengji){
        EntityWrapper< SaishichengjiEntity> ew = new EntityWrapper< SaishichengjiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( saishichengji, "saishichengji")); 
		SaishichengjiView saishichengjiView =  saishichengjiService.selectView(ew);
		return R.ok("查询赛事成绩成功").put("data", saishichengjiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        SaishichengjiEntity saishichengji = saishichengjiService.selectById(id);
		saishichengji = saishichengjiService.selectView(new EntityWrapper<SaishichengjiEntity>().eq("id", id));
        return R.ok().put("data", saishichengji);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        SaishichengjiEntity saishichengji = saishichengjiService.selectById(id);
		saishichengji = saishichengjiService.selectView(new EntityWrapper<SaishichengjiEntity>().eq("id", id));
        return R.ok().put("data", saishichengji);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody SaishichengjiEntity saishichengji, HttpServletRequest request){
    	saishichengji.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(saishichengji);
        saishichengjiService.insert(saishichengji);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody SaishichengjiEntity saishichengji, HttpServletRequest request){
    	saishichengji.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(saishichengji);
        saishichengjiService.insert(saishichengji);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody SaishichengjiEntity saishichengji, HttpServletRequest request){
        //ValidatorUtils.validateEntity(saishichengji);
        saishichengjiService.updateById(saishichengji);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        saishichengjiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
