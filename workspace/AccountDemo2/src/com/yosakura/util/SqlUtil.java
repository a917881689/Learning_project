package com.yosakura.util;

import java.lang.reflect.Field;

public class SqlUtil {
  //import java.lang.reflect.Field;
    /** 获取Object对象，所有成员变量属性值 */
    public static Object[] getObjAttr(Object obj)
    {
    	// 获取对象obj的所有属性域
    	Field[] fields = obj.getClass().getDeclaredFields();
    	Object[] objArrayTemp = new Object[fields.length];
    	int count = 0;
    	for (Field field : fields)
    	{
    		// 对于每个属性，获取属性名
    		// String varName = field.getName();
    		try
    		{
    			// isAccessible() 可访问标志
    			boolean access = field.isAccessible();
    			// 如果为不可访问,设置为可以访问
    			if(!access) { 
    				field.setAccessible(true);
    			}
    			//从obj中获取field变量
    			Object val = field.get(obj);
    			// 判断对象的值是否有效
    			if (null == val || "-1".equals(val.toString()) || "".equals(val.toString()) || "null".equals(val.toString()) ) {
    				objArrayTemp[count] = null;
    			}else {
    				objArrayTemp[count] = val;
    				count++;
				}
    			if(!access) { 
    				field.setAccessible(false);
    			}
    		}
    		catch (Exception ex)
    		{
    			ex.printStackTrace();
    		}
    	}
    	Object[] objArray = new Object[count];
    	for (int i = 0 ;i < count;i++) {
    		objArray[i] = objArrayTemp[i];
    	}
    	return objArray;
    }
}
