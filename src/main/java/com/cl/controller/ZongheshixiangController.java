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

import com.cl.entity.ZongheshixiangEntity;
import com.cl.entity.view.ZongheshixiangView;

import com.cl.service.ZongheshixiangService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 综合事项
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-08 14:45:26
 */
@RestController
@RequestMapping("/zongheshixiang")
public class ZongheshixiangController {
    @Autowired
    private ZongheshixiangService zongheshixiangService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZongheshixiangEntity zongheshixiang,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			zongheshixiang.setXuehao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ZongheshixiangEntity> ew = new EntityWrapper<ZongheshixiangEntity>();

		PageUtils page = zongheshixiangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zongheshixiang), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZongheshixiangEntity zongheshixiang, 
		HttpServletRequest request){
        EntityWrapper<ZongheshixiangEntity> ew = new EntityWrapper<ZongheshixiangEntity>();

		PageUtils page = zongheshixiangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zongheshixiang), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZongheshixiangEntity zongheshixiang){
       	EntityWrapper<ZongheshixiangEntity> ew = new EntityWrapper<ZongheshixiangEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zongheshixiang, "zongheshixiang")); 
        return R.ok().put("data", zongheshixiangService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZongheshixiangEntity zongheshixiang){
        EntityWrapper< ZongheshixiangEntity> ew = new EntityWrapper< ZongheshixiangEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zongheshixiang, "zongheshixiang")); 
		ZongheshixiangView zongheshixiangView =  zongheshixiangService.selectView(ew);
		return R.ok("查询综合事项成功").put("data", zongheshixiangView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZongheshixiangEntity zongheshixiang = zongheshixiangService.selectById(id);
		zongheshixiang = zongheshixiangService.selectView(new EntityWrapper<ZongheshixiangEntity>().eq("id", id));
        return R.ok().put("data", zongheshixiang);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZongheshixiangEntity zongheshixiang = zongheshixiangService.selectById(id);
		zongheshixiang = zongheshixiangService.selectView(new EntityWrapper<ZongheshixiangEntity>().eq("id", id));
        return R.ok().put("data", zongheshixiang);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZongheshixiangEntity zongheshixiang, HttpServletRequest request){
    	zongheshixiang.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zongheshixiang);
        zongheshixiangService.insert(zongheshixiang);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZongheshixiangEntity zongheshixiang, HttpServletRequest request){
    	zongheshixiang.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zongheshixiang);
        zongheshixiangService.insert(zongheshixiang);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZongheshixiangEntity zongheshixiang, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zongheshixiang);
        zongheshixiangService.updateById(zongheshixiang);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<ZongheshixiangEntity> list = new ArrayList<ZongheshixiangEntity>();
        for(Long id : ids) {
            ZongheshixiangEntity zongheshixiang = zongheshixiangService.selectById(id);
            zongheshixiang.setSfsh(sfsh);
            zongheshixiang.setShhf(shhf);
            list.add(zongheshixiang);
        }
        zongheshixiangService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zongheshixiangService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
