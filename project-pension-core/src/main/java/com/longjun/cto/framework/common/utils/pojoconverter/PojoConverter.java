package com.longjun.cto.framework.common.utils.pojoconverter;

import org.dozer.DozerBeanMapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author carson deng
 * @date 2019/10/9 21:38
 */
public class PojoConverter {

    private DozerBeanMapper dozerBeanMapper;

    public PojoConverter(String... mappingFiles) {
        dozerBeanMapper = new DozerBeanMapper();
        dozerBeanMapper.setMappingFiles(Arrays.asList(mappingFiles));
    }

    /**
     * 将源对象转换成目标对象
     * @param source 源对象
     * @param targetClass 目标类
     * @param <S> 源类型
     * @param <T> 目标类型
     * @return 目标对象
     */
    public <S, T> T convert(S source, Class<T> targetClass) {
        if (source == null) {
            return null;
        }

        return dozerBeanMapper.map(source, targetClass);
    }

    /**
     * 将源对象列表转换成目标对象列表
     * @param sourceList 源对象列表
     * @param targetClass 目标类
     * @param <S> 源类型
     * @param <T> 目标类型
     * @return 目标对象列表
     */
    public <S, T> List<T> convert(List<S> sourceList, Class<T> targetClass) {
        if (sourceList == null) {
            return new ArrayList<T>();
        }

        List<T> targetList = new ArrayList<T>();
        for (S source : sourceList) {
            targetList.add(convert(source, targetClass));
        }

        return targetList;
    }
}
