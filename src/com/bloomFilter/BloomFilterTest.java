package com.bloomFilter;


import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

/**
 * @Author: xs
 * @describe:
 * @date 2022/2/13 17:57
 */
public class BloomFilterTest {

    /**gl
     * @describe: 预期大小
     */
    private static int SIZE = 1000000;

    /**
     * @describe: 预期误判率
     */
    private static double FPP = 0.03;

    private static com.google.common.hash.BloomFilter<Integer> bloomFilter = com.google.common.hash.BloomFilter.create(Funnels.integerFunnel(), SIZE, FPP);

    /**
     * @describe: 测试数据
     */
    private static int total = 1000000;

    public static void main(String[] args) {
        for (int i = 0; i < total; i++) {
            bloomFilter.put(i);
        }
        int counts = 0;
        for (int i = total; i < total + 100000; i++) {
            if (bloomFilter.mightContain(i)) {
                counts++;
            }
        }
        System.out.println("被误判了：" + counts + " 次！");
    }
}
