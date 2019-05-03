package com.zhousx.leetcode;

/**
 * 172 阶乘后的零
 * 给定一个整数n，返回n!结果尾数中零的数量
 *
 *     首先题目的意思是末尾有几个0
 *     比如6! = 【1* 2* 3* 4* 5* 6】
 *     其中只有2*5末尾才有0，所以就可以抛去其他数据 专门看2 5 以及其倍数 毕竟 4 * 25末尾也是0
 *     比如10！ = 【2*4*5*6*8*10】
 *     其中 4能拆成2*2  10能拆成2*5
 *     所以10！ = 【2*（2*2）*5*（2*3）*（2*2*2）*（2*5）】
 *     一个2和一个5配对 就产生一个0 所以10！末尾2个0
 *
 *     转头一想 2肯定比5多 所以只数5的个数就行了
 *
 *     假若N=31 31里能凑10的5为[5, 2*5, 3*5, 4*5, 25, 6*5] 其中 25还能拆为 5**2
 *     所以 里面的5的个数为 int(31/(5**1)) +  int(31/(5**2))
 *     所以 只要先找个一个 5**x < n 的x的最大数 然后按上面循环加起来
 */
public class leetcode172 {

    public static void main(String[] args) {
        System.out.println(trailingZeroes(13));
    }

    public static int trailingZeroes(int n) {
        if(n<5) {
            return 0;
        }
        else
        {
            return n/5+trailingZeroes(n/5);
        }
        //数值会溢出
      /*  long factorial =  n;
        while (n>1){
            n--;
            factorial *= n;
        }
        String str = String.valueOf(factorial);
        int count = 0;
        for (int i = str.length()-1;i>0;i--){
            if (str.charAt(i)=='0'){
                count++;
            }else {
                break;
            }

        }
        return count;*/
    }
}
