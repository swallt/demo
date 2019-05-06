package com.zhousx.leetcode;

/**
 * 195 第十行
 * 给定一个文本文件 file.txt，请只打印这个文件中的第十行。
 * 示例:
 * 假设 file.txt 有如下内容：
 * Line 1
 * Line 2
 * Line 3
 * Line 4
 * Line 5
 * Line 6
 * Line 7
 * Line 8
 * Line 9
 * Line 10
 * 你的脚本应当显示第十行：
 * Line 10
 */
public class leetcode195 {
    /**
     * 方法1：
     * sed -n '10p' file.txt
     * 方法2：
     * #/bin/bash
     * count=`cat file.txt | wc -l`
     * out=`cat file.txt | head -10 | tail -1`
     * if [ $count -lt 10 ]
     * then
     *     echo ""
     * else echo $out
     * fi
     * 方法3：
     * awk "NR==10" file.txt
     */
}
