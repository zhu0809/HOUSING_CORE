package com.bs.housing.utils;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * <p> @类描述：	                </p>
 * <p> @创建人：ZhuRongguo	    </p>
 * <p> @创建时间：2018/11/22 17:50</p>
 */
public class DozerMapper {
    private static Mapper mapper = null;

    private static Mapper getMapper() {
        if (null == mapper) {
            synchronized (DozerMapper.class) {
                if (null == mapper) {
                    mapper = new DozerBeanMapper();
                }
            }
        }
        return mapper;
    }

    public static <T> T mapper(Object o, Class<T> t) {
        T map = getMapper().map(o, t);
        return map;
    }

    public static <T, R> List<R> mapperList(Collection<T> list, Class<R> t) {
        List<R> arrayList = new ArrayList<>();
        for (T ts : list) {
            R mapper = mapper(ts, t);
            arrayList.add(mapper);
        }
        return arrayList;
    }
}
