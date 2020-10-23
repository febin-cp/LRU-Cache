package com.cache;

public class CacheMain {
    public static void main(String[] args) {
        LRU lruCache = new LRU(5);

        lruCache.put(1,5);
        lruCache.put(2,6);
        lruCache.put(5,7);

        System.out.println(lruCache);

        System.out.println(lruCache.get(1));
    }
}
