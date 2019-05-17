package com.zhousx.leetcode;

public class daxi1 {
    //每次循环起始值数组，因为给定t在1~10的12次方之间
    private static final long[] values = {3L, 6L, 12L, 24L, 48L, 96L, 192L, 384L, 768L, 1536L,
            3072L, 6144L, 12288L, 24576L, 49152L, 98304L, 196608L, 393216L, 786432L, 1572864L,
            3145728L, 6291456L, 12582912L, 25165824L, 50331648L, 100663296L, 201326592L,
            402653184L, 805306368L, 1610612736L, 3221225472L, 6442450944L, 12884901888L,
            25769803776L, 51539607552L, 103079215104L, 206158430208L, 412316860416L, 824633720832L};

/*
    private static final long[] times = {1L, 4L, 10L, 22L, 46L, 94L, 190L, 382L, 766L, 1534L,
            3070L, 6142L, 12286L, 24574L, 49150L, 98302L, 196606L, 393214L, 786430L, 1572862L,
            3145726L, 6291454L, 12582910L, 25165822L, 50331646L, 100663294L, 201326590L,
            402653182L, 805306366L, 1610612734L, 3221225470L, 6442450942L, 12884901886L,
            25769803774L, 51539607550L, 103079215102L, 206158430206L, 412316860414L, 824633720830L};
*/

    public static void main(String[] args) {
        System.out.println(strangeCounter(824633720829L));
    }

    public static long strangeCounter(long t){
        int i = values.length-1;
        while (i>0){
            if (t >= values[i]-2L){  //每次循环起始值对应的秒数
                break;
            }
            i--;
        }
        return values[i] - (t-(values[i]-2L));  //起始值减去该次循环间隔秒数
    }
}
