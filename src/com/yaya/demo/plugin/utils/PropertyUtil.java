package com.yaya.demo.plugin.utils;

import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.beans.PropertyDescriptor;

/**
 * 通用setter and getter
 *
 * @author ChW 2016-04-25 13:53:06
 */
public class PropertyUtil {

    public static PropertyDescriptor getPropertyDescriptor(Class clazz, String propertyName) {
        StringBuffer sb = new StringBuffer();//构建一个可变字符串用来构建方法名称
        Method setMethod = null;
        Method getMethod = null;
        PropertyDescriptor pd = null;

        try {
            Field f = clazz.getDeclaredField(propertyName);//根据字段名来获取字段
            if (f != null) {
                //构建方法的后缀
                String methodEnd = StringUtil.firstLetterToUpper(propertyName);
                sb.append("set" + methodEnd);//构建set方法
                //构建set 方法
                setMethod = clazz.getDeclaredMethod(sb.toString(), new Class[]{f.getType()});
                sb.delete(0, sb.length());//清空整个可变字符串
                sb.append("get" + methodEnd);//构建get方法
                //构建get 方法
                getMethod = clazz.getDeclaredMethod(sb.toString(), new Class[]{});
                //构建一个属性描述器 把对应属性 propertyName 的 get 和 set 方法保存到属性描述器中
                pd = new PropertyDescriptor(propertyName, getMethod, setMethod);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return pd;
    }

    public static void setProperty(Object obj, String propertyName, Object value) {
        Class clazz = obj.getClass();//获取对象的类型
        PropertyDescriptor pd = getPropertyDescriptor(clazz, propertyName);//获取 clazz 类型中的 propertyName 的属性描述器
        Method setMethod = pd.getWriteMethod();//从属性描述器中获取 set 方法
        try {
            setMethod.invoke(obj, new Object[]{value});//调用 set 方法将传入的value值保存属性中去
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Object getProperty(Object obj, String propertyName) {
        Class clazz = obj.getClass();//获取对象的类型
        PropertyDescriptor pd = getPropertyDescriptor(clazz, propertyName);//获取 clazz 类型中的 propertyName 的属性描述器
        Method getMethod = pd.getReadMethod();//从属性描述器中获取 get 方法
        Object value = null;
        try {
            value = getMethod.invoke(clazz, new Object[]{});//调用方法获取方法的返回值
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;//返回值
    }

    /**
     * 根据属性名获取属性值
     */
    public static Object getFieldValueByName(String fieldName, Object o) {
        try {
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String getter = "get" + firstLetter + fieldName.substring(1);
            Method method = o.getClass().getMethod(getter, new Class[]{});
            Object value = method.invoke(o, new Object[]{});
            return value;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 获取属性名数组
     */
    public static String[] getFiledName(Object o) {
        Field[] fields = o.getClass().getDeclaredFields();
        String[] fieldNames = new String[fields.length];
        for (int i = 0; i < fields.length; i++) {
            fieldNames[i] = fields[i].getName();
        }
        return fieldNames;
    }

//    /**
//     * 获取属性类型(type)，属性名(name)，属性值(value)的map组成的list
//     */
//    private static List getFiledsInfo(Object o) {
//        Field[] fields = o.getClass().getDeclaredFields();
//        String[] fieldNames = new String[fields.length];
//        List list = new ArrayList();
//        Map infoMap = null;
//        for (int i = 0; i < fields.length; i++) {
//            infoMap = new HashMap();
//            infoMap.put("type", fields[i].getType().toString());
//            infoMap.put("name", fields[i].getName());
//            infoMap.put("value", PropertyUtil.getFieldValueByName(fields[i].getName(), o));
//            list.add(infoMap);
//        }
//        return list;
//    }
//
//    /**
//     * 获取对象的所有属性值，返回一个对象数组
//     */
//    public static Object[] getFiledValues(Object o) {
//        String[] fieldNames = this.getFiledName(o);
//        Object[] value = new Object[fieldNames.length];
//        for (int i = 0; i < fieldNames.length; i++) {
//            value[i] = this.getFieldValueByName(fieldNames[i], o);
//        }
//        return value;
//    }
}
