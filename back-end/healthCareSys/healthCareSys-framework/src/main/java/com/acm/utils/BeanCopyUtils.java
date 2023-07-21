package com.acm.utils;

import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public class BeanCopyUtils {
    private BeanCopyUtils(){

    }

    public static <V> V copyBean(Object source,Class<V> clazz){
        V o = null;
        try {
            o = clazz.newInstance();
            BeanUtils.copyProperties(source,o);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return o;
    }


    public static <O,V> List<V> copyBeanList(List<O> list,Class<V> clazz){
        return list.stream()
                .map(o -> copyBean(o,clazz))
                .collect(Collectors.toList());
    }
}
