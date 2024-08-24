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

import com.cl.entity.ShehuishijianchengjiEntity;
import com.cl.entity.view.ShehuishijianchengjiView;

import com.cl.service.ShehuishijianchengjiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 社会实践成绩
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-08 14:45:26
 */
@RestController
@RequestMapping("/shehuishijianchengji")
public class ShehuishijianchengjiController {
    @Autowired
    private ShehuishijianchengjiService shehuishijianchengjiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShehuishijianchengjiEntity shehuishijianchengji,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			shehuishijianchengji.setXuehao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("jiaoshi")) {
			shehuishijianchengji.setJiaoshigonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ShehuishijianchengjiEntity> ew = new EntityWrapper<ShehuishijianchengjiEntity>();

		PageUtils page = shehuishijianchengjiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shehuishijianchengji), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShehuishijianchengjiEntity shehuishijianchengji, 
		HttpServletRequest request){
        EntityWrapper<ShehuishijianchengjiEntity> ew = new EntityWrapper<ShehuishijianchengjiEntity>();

		PageUtils page = shehuishijianchengjiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shehuishijianchengji), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShehuishijianchengjiEntity shehuishijianchengji){
       	EntityWrapper<ShehuishijianchengjiEntity> ew = new EntityWrapper<ShehuishijianchengjiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shehuishijianchengji, "shehuishijianchengji")); 
        return R.ok().put("data", shehuishijianchengjiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShehuishijianchengjiEntity shehuishijianchengji){
        EntityWrapper< ShehuishijianchengjiEntity> ew = new EntityWrapper< ShehuishijianchengjiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shehuishijianchengji, "shehuishijianchengji")); 
		ShehuishijianchengjiView shehuishijianchengjiView =  shehuishijianchengjiService.selectView(ew);
		return R.ok("查询社会实践成绩成功").put("data", shehuishijianchengjiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShehuishijianchengjiEntity shehuishijianchengji = shehuishijianchengjiService.selectById(id);
		shehuishijianchengji = shehuishijianchengjiService.selectView(new EntityWrapper<ShehuishijianchengjiEntity>().eq("id", id));
        return R.ok().put("data", shehuishijianchengji);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShehuishijianchengjiEntity shehuishijianchengji = shehuishijianchengjiService.selectById(id);
		shehuishijianchengji = shehuishijianchengjiService.selectView(new EntityWrapper<ShehuishijianchengjiEntity>().eq("id", id));
        return R.ok().put("data", shehuishijianchengji);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShehuishijianchengjiEntity shehuishijianchengji, HttpServletRequest request){
    	shehuishijianchengji.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shehuishijianchengji);
        shehuishijianchengjiService.insert(shehuishijianchengji);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShehuishijianchengjiEntity shehuishijianchengji, HttpServletRequest request){
    	shehuishijianchengji.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shehuishijianchengji);
        shehuishijianchengjiService.insert(shehuishijianchengji);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ShehuishijianchengjiEntity shehuishijianchengji, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shehuishijianchengji);
        shehuishijianchengjiService.updateById(shehuishijianchengji);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<ShehuishijianchengjiEntity> list = new ArrayList<ShehuishijianchengjiEntity>();
        for(Long id : ids) {
            ShehuishijianchengjiEntity shehuishijianchengji = shehuishijianchengjiService.selectById(id);
            shehuishijianchengji.setSfsh(sfsh);
            shehuishijianchengji.setShhf(shhf);
            list.add(shehuishijianchengji);
        }
        shehuishijianchengjiService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shehuishijianchengjiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
