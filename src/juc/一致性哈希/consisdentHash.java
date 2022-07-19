package juc.一致性哈希;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class consisdentHash {
    private String[] servers = new String[]{"192.168.10.1", "192.168.10.2", "192.168.10.3"};
    // 存放key 与 服务器节点，这里将node简化为Map
    SortedMap<Integer, Map<String, String>> map = new TreeMap<>();

    public consisdentHash() {
        // 初始化服务器节点到哈希环
        for (int i = 0; i < servers.length; i++) {
            int k = getHash(servers[i]);
            map.put(k, new HashMap<>());
        }
    }

    /**
     * 为数据分配节点
     */
    public void put(String key, String value) {
        Map<String, String> node = getClosestNode(key);
        // map的hashCode 放入元素后改变，所以这里打印内存地址
        System.out.println("数据key= "+key +"最近的节点内存地址为 "+System.identityHashCode(node));
        node.put(key, value);
    }

    /**
     * 从节点中取数据
     */
    public String get(String key) {
        Map<String, String> node = getClosestNode(key);

        System.out.println("数据key= "+key +"从最近节点内存地址为"+ System.identityHashCode(node)+"拿数据");
        return node.get(key);
    }

    /**
     * 根据key顺时针寻找最近的节点
     */
    private Map<String, String> getClosestNode(String key) {
        int k = getHash(key);
        // 获取key>k 的所有节点
        SortedMap<Integer, Map<String, String>> subMap = map.tailMap(k);
        if (subMap != null) {
            return subMap.get(subMap.firstKey());
        }
        // 如果没有大于k 的节点，返回第一个节点（哈希环）
        return map.get(map.firstKey());

    }
    /**
     * todo 增加/减少节点时，需要重新分配涉及路径上的节点数据
     */


    //使用FNV1_32_HASH算法计算服务器的Hash值
    private int getHash(String str) {
        final int p = 16777619;
        int hash = (int) 2166136261L;
        for (int i = 0; i < str.length(); i++) {
            hash = (hash ^ str.charAt(i)) * p;
        }
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;

        // 如果算出来的值为负数则取其绝对值
        if (hash < 0) {
            hash = Math.abs(hash);
        }
        return hash;
    }

    public static void main(String[] args) {

        consisdentHash consisdentHash = new consisdentHash();
        consisdentHash.put("aaa","aaaaaaaaaaaaaaaa");
        consisdentHash.put("bbb","bbbbbbbbbbbbbbbb");
        consisdentHash.put("ccc","cccccccccccccccc");
        System.out.println(consisdentHash.get("aaa"));
        System.out.println(consisdentHash.get("bbb"));
        System.out.println(consisdentHash.get("ccc"));
    }
}
