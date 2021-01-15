package com.bootdo.common.utils;


import com.google.common.base.Optional;
import com.google.common.base.Throwables;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import org.springframework.beans.BeanUtils;

import java.util.Collection;
import java.util.List;

/**
 *
 * @author
 * @since version1.0
 */
public class ConvertDomainUtils {

    /**
     * list列表类型转换类
     */
    public final static <S, T> List<T> convertList(List<S> sources, final Class<T> targetClass, final String... filters) {
        Optional<List<S>> absentList = Optional.of(sources);
        if (absentList.isPresent()) {
            Collection<T> transformColl = Collections2.transform(absentList.get(), input -> convertObject(input, targetClass, filters));

            return Lists.newArrayList(transformColl);
        }

        return Lists.newArrayList();
    }

    /**
     * 类型转换类
     */
    public final static <S, T> T convertObject(S source, Class<T> target, String... filters) {
        T t = null;
        try {
            t = target.newInstance();
            BeanUtils.copyProperties(Optional.of(source).get(), t, filters);
        } catch (Exception e) {
            Throwables.propagateIfPossible(e);
        }

        return t;
    }
}