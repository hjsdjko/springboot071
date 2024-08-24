package com.cl.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 综合事项
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-04-08 14:45:26
 */
@TableName("zongheshixiang")
public class ZongheshixiangEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ZongheshixiangEntity() {
		
	}
	
	public ZongheshixiangEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 综合事项名称
	 */
					
	private String zongheshixiangmingcheng;
	
	/**
	 * 综合事项描述
	 */
					
	private String zongheshixiangmiaoshu;
	
	/**
	 * 事项申请时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date shixiangshenqingshijian;
	
	/**
	 * 照片
	 */
					
	private String zhaopian;
	
	/**
	 * 学号
	 */
					
	private String xuehao;
	
	/**
	 * 学生姓名
	 */
					
	private String xueshengxingming;
	
	/**
	 * 是否审核
	 */
					
	private String sfsh;
	
	/**
	 * 回复内容
	 */
					
	private String shhf;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：综合事项名称
	 */
	public void setZongheshixiangmingcheng(String zongheshixiangmingcheng) {
		this.zongheshixiangmingcheng = zongheshixiangmingcheng;
	}
	/**
	 * 获取：综合事项名称
	 */
	public String getZongheshixiangmingcheng() {
		return zongheshixiangmingcheng;
	}
	/**
	 * 设置：综合事项描述
	 */
	public void setZongheshixiangmiaoshu(String zongheshixiangmiaoshu) {
		this.zongheshixiangmiaoshu = zongheshixiangmiaoshu;
	}
	/**
	 * 获取：综合事项描述
	 */
	public String getZongheshixiangmiaoshu() {
		return zongheshixiangmiaoshu;
	}
	/**
	 * 设置：事项申请时间
	 */
	public void setShixiangshenqingshijian(Date shixiangshenqingshijian) {
		this.shixiangshenqingshijian = shixiangshenqingshijian;
	}
	/**
	 * 获取：事项申请时间
	 */
	public Date getShixiangshenqingshijian() {
		return shixiangshenqingshijian;
	}
	/**
	 * 设置：照片
	 */
	public void setZhaopian(String zhaopian) {
		this.zhaopian = zhaopian;
	}
	/**
	 * 获取：照片
	 */
	public String getZhaopian() {
		return zhaopian;
	}
	/**
	 * 设置：学号
	 */
	public void setXuehao(String xuehao) {
		this.xuehao = xuehao;
	}
	/**
	 * 获取：学号
	 */
	public String getXuehao() {
		return xuehao;
	}
	/**
	 * 设置：学生姓名
	 */
	public void setXueshengxingming(String xueshengxingming) {
		this.xueshengxingming = xueshengxingming;
	}
	/**
	 * 获取：学生姓名
	 */
	public String getXueshengxingming() {
		return xueshengxingming;
	}
	/**
	 * 设置：是否审核
	 */
	public void setSfsh(String sfsh) {
		this.sfsh = sfsh;
	}
	/**
	 * 获取：是否审核
	 */
	public String getSfsh() {
		return sfsh;
	}
	/**
	 * 设置：回复内容
	 */
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	/**
	 * 获取：回复内容
	 */
	public String getShhf() {
		return shhf;
	}

}
