package com.hxh.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class WebUtils {
    public static <T>T copyParamBean(Map map, T bean){

        try {
            BeanUtils.populate(bean,map);
        } catch (Exception e) {
            e.printStackTrace();

        }
        return bean;
    }
}
