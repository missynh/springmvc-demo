package com.ynh.myproject.service;

/**
 * 计算字符串最后一个单词的长度，单词以空格隔开。
 *
 * Created by ynh on 2017/9/20.
 */
public class FindLastWordLength {

    private int findLastWordLength(String str) {

        for (int i = str.length()-1; i > 0; i--) {

            if (str.charAt(i) == ' ') {
                return str.substring(i+1, str.length()).length();
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FindLastWordLength test = new FindLastWordLength();
        System.out.print(test.findLastWordLength("Hello World"));
    }

}
