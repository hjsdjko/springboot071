package com.cl.entity.view;

import com.cl.entity.XueyechengjiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 学业成绩
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-08 14:45:26
 */
@TableName("xueyechengji")
public class XueyechengjiView  extends XueyechengjiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public XueyechengjiView(){
	}
 
 	public XueyechengjiView(XueyechengjiEntity xueyechengjiEntity){
 	try {
			BeanUtils.copyProperties(this, xueyechengjiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
