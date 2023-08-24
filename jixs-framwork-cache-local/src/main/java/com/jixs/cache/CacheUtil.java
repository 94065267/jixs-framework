package com.jixs.cache;

import cn.hutool.core.date.DatePattern;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.RemovalListener;
import com.jixs.common.util.DateUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 说明：文件说明
 *
 * @author jixs_bj
 * @date 2023/8/23 10:49
 */
@Slf4j
public class CacheUtil {
    private static final Cache<String, Object> localCache = CacheBuilder.newBuilder()
            // 存放最大量
            .maximumSize(1000)
            // 设置有效时间
            .expireAfterAccess(3, TimeUnit.HOURS)
            //缓存有效级别
            .concurrencyLevel(Runtime.getRuntime().availableProcessors())
            // 缓存移除监听
            .removalListener((RemovalListener<String, Object>) removalNotification
                    -> {
                String timeStr = DateUtil.format(new Date(), DatePattern.NORM_DATETIME_MS_PATTERN);
                System.out.println(removalNotification.getKey() + "在" + timeStr + "被移除");
            })
            .build();

    /**
     * 根据key值获取缓存
     *
     * @param key
     * @return
     */
    public static Object get(String key) {
        return localCache.getIfPresent(key);
    }

    /**
     * 缓存设置
     *
     * @param key
     * @param value
     */
    public static void set(String key, Object value) {
        localCache.put(key, value);
    }

    /**
     * 根据key值移除缓存
     *
     * @param key
     */
    public static void remove(String key) {
        localCache.invalidate(key);
    }

    /**
     * 缓存全部移除
     */
    public static void removeAll() {
        localCache.invalidateAll();
    }

    public static void main(String[] args) {
        String key = "key";
        String value = "value";
        CacheUtil.set(key, value);
        System.out.println(CacheUtil.get(key));
        CacheUtil.remove(key);
        System.out.println(CacheUtil.get(key));
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(CacheUtil.get(key));
    }


}
