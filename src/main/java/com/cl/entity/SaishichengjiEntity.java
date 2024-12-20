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
 * 赛事成绩
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-04-08 14:45:26
 */
@TableName("saishichengji")
public class SaishichengjiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public SaishichengjiEntity() {
		
	}
	
	public SaishichengjiEntity(T t) {
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
	 * 赛事名称
	 */
					
	private String saishimingcheng;
	
	/**
	 * 学期
	 */
					
	private String xueqi;
	
	/**
	 * 年限
	 */
					
	private String nianxian;
	
	/**
	 * 成绩
	 */
					
	private Double chengji;
	
	/**
	 * 班级
	 */
					
	private String banji;
	
	/**
	 * 学号
	 */
					
	private String xuehao;
	
	/**
	 * 学生姓名
	 */
					
	private String xueshengxingming;
	
	
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
	 * 设置：赛事名称
	 */
	public void setSaishimingcheng(String saishimingcheng) {
		this.saishimingcheng = saishimingcheng;
	}
	/**
	 * 获取：赛事名称
	 */
	public String getSaishimingcheng() {
		return saishimingcheng;
	}
	/**
	 * 设置：学期
	 */
	public void setXueqi(String xueqi) {
		this.xueqi = xueqi;
	}
	/**
	 * 获取：学期
	 */
	public String getXueqi() {
		return xueqi;
	}
	/**
	 * 设置：年限
	 */
	public void setNianxian(String nianxian) {
		this.nianxian = nianxian;
	}
	/**
	 * 获取：年限
	 */
	public String getNianxian() {
		return nianxian;
	}
	/**
	 * 设置：成绩
	 */
	public void setChengji(Double chengji) {
		this.chengji = chengji;
	}
	/**
	 * 获取：成绩
	 */
	public Double getChengji() {
		return chengji;
	}
	/**
	 * 设置：班级
	 */
	public void setBanji(String banji) {
		this.banji = banji;
	}
	/**
	 * 获取：班级
	 */
	public String getBanji() {
		return banji;
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

}
