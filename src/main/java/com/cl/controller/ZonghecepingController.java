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

import com.cl.entity.ZonghecepingEntity;
import com.cl.entity.view.ZonghecepingView;

import com.cl.service.ZonghecepingService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 综合测评
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-08 14:45:26
 */
@RestController
@RequestMapping("/zongheceping")
public class ZonghecepingController {
    @Autowired
    private ZonghecepingService zonghecepingService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZonghecepingEntity zongheceping,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			zongheceping.setXuehao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ZonghecepingEntity> ew = new EntityWrapper<ZonghecepingEntity>();

		PageUtils page = zonghecepingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zongheceping), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZonghecepingEntity zongheceping, 
		HttpServletRequest request){
        EntityWrapper<ZonghecepingEntity> ew = new EntityWrapper<ZonghecepingEntity>();

		PageUtils page = zonghecepingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zongheceping), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZonghecepingEntity zongheceping){
       	EntityWrapper<ZonghecepingEntity> ew = new EntityWrapper<ZonghecepingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zongheceping, "zongheceping")); 
        return R.ok().put("data", zonghecepingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZonghecepingEntity zongheceping){
        EntityWrapper< ZonghecepingEntity> ew = new EntityWrapper< ZonghecepingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zongheceping, "zongheceping")); 
		ZonghecepingView zonghecepingView =  zonghecepingService.selectView(ew);
		return R.ok("查询综合测评成功").put("data", zonghecepingView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZonghecepingEntity zongheceping = zonghecepingService.selectById(id);
		zongheceping = zonghecepingService.selectView(new EntityWrapper<ZonghecepingEntity>().eq("id", id));
        return R.ok().put("data", zongheceping);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZonghecepingEntity zongheceping = zonghecepingService.selectById(id);
		zongheceping = zonghecepingService.selectView(new EntityWrapper<ZonghecepingEntity>().eq("id", id));
        return R.ok().put("data", zongheceping);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZonghecepingEntity zongheceping, HttpServletRequest request){
    	zongheceping.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zongheceping);
        zonghecepingService.insert(zongheceping);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZonghecepingEntity zongheceping, HttpServletRequest request){
    	zongheceping.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zongheceping);
        zonghecepingService.insert(zongheceping);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZonghecepingEntity zongheceping, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zongheceping);
        zonghecepingService.updateById(zongheceping);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zonghecepingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
