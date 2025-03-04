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
 * 综合测评
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-04-08 14:45:26
 */
@TableName("zongheceping")
public class ZonghecepingEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ZonghecepingEntity() {
		
	}
	
	public ZonghecepingEntity(T t) {
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
	 * 学号
	 */
					
	private String xuehao;
	
	/**
	 * 学生姓名
	 */
					
	private String xueshengxingming;
	
	/**
	 * 照片
	 */
					
	private String zhaopian;
	
	/**
	 * 学业成绩
	 */
					
	private Double xueyechengji;
	
	/**
	 * 赛事成绩
	 */
					
	private Double saishichengji;
	
	/**
	 * 实践成绩
	 */
					
	private Double shijianchengji;
	
	/**
	 * 总成绩
	 */
					
	private String zongchengji;
	
	/**
	 * 排名
	 */
					
	private Integer paiming;
	
	/**
	 * 评价
	 */
					
	private String pingjia;
	
	/**
	 * 建议
	 */
					
	private String jianyi;
	
	
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
	 * 设置：学业成绩
	 */
	public void setXueyechengji(Double xueyechengji) {
		this.xueyechengji = xueyechengji;
	}
	/**
	 * 获取：学业成绩
	 */
	public Double getXueyechengji() {
		return xueyechengji;
	}
	/**
	 * 设置：赛事成绩
	 */
	public void setSaishichengji(Double saishichengji) {
		this.saishichengji = saishichengji;
	}
	/**
	 * 获取：赛事成绩
	 */
	public Double getSaishichengji() {
		return saishichengji;
	}
	/**
	 * 设置：实践成绩
	 */
	public void setShijianchengji(Double shijianchengji) {
		this.shijianchengji = shijianchengji;
	}
	/**
	 * 获取：实践成绩
	 */
	public Double getShijianchengji() {
		return shijianchengji;
	}
	/**
	 * 设置：总成绩
	 */
	public void setZongchengji(String zongchengji) {
		this.zongchengji = zongchengji;
	}
	/**
	 * 获取：总成绩
	 */
	public String getZongchengji() {
		return zongchengji;
	}
	/**
	 * 设置：排名
	 */
	public void setPaiming(Integer paiming) {
		this.paiming = paiming;
	}
	/**
	 * 获取：排名
	 */
	public Integer getPaiming() {
		return paiming;
	}
	/**
	 * 设置：评价
	 */
	public void setPingjia(String pingjia) {
		this.pingjia = pingjia;
	}
	/**
	 * 获取：评价
	 */
	public String getPingjia() {
		return pingjia;
	}
	/**
	 * 设置：建议
	 */
	public void setJianyi(String jianyi) {
		this.jianyi = jianyi;
	}
	/**
	 * 获取：建议
	 */
	public String getJianyi() {
		return jianyi;
	}

}
