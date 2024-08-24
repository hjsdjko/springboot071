package com.cl.entity.view;

import com.cl.entity.ShehuishijianchengjiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 社会实践成绩
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-08 14:45:26
 */
@TableName("shehuishijianchengji")
public class ShehuishijianchengjiView  extends ShehuishijianchengjiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ShehuishijianchengjiView(){
	}
 
 	public ShehuishijianchengjiView(ShehuishijianchengjiEntity shehuishijianchengjiEntity){
 	try {
			BeanUtils.copyProperties(this, shehuishijianchengjiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
