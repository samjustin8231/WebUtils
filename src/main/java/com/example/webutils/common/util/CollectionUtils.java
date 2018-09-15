package com.example.webutils.common.util;

import java.util.Collection;

/**
 * 类的实现描述：CollectionUtils
 *
 * @author sunyajun 2018/9/15 20:33
 */
public class CollectionUtils {

    /**
     * 判断集合是否为空
     *
     * @param collection
     * @return
     */
    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.size() == 0;
    }
}
