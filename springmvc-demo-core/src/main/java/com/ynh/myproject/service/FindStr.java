package com.ynh.myproject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串匹配，此类可以实现可隔断的字符串检索
 *
 * @author ynh on 2017/11/22.
 */
public class FindStr {

    public static void main(String[] args) {

        List<String> dataList = new ArrayList<String>();
        dataList.add("不知道怎么的变速器总是在起步抖");
        dataList.add("更换油封后车辆抖动");
        dataList.add("变速箱2挡时抖动");
        dataList.add("挂D挡抖动共振");
        dataList.add("变速箱抖动挡把跳动");
        dataList.add("变速器起步发抖");
        dataList.add("自动换挡抖动严重");
        dataList.add("行驶中抖动");
        dataList.add("换挡时抖动的厉害");
        dataList.add("双离合变速箱起步抖动");
        dataList.add("三菱正常行驶中挡把抖动");
        dataList.add("DSG问题发动机抖动");
        dataList.add("起步时发抖");
        dataList.add("换挡抖动");
        dataList.add("车辆起步停车时抖动");
        dataList.add("M5中控异响挡位抖动");
        dataList.add("换挡车身抖动");
        dataList.add("行驶时车辆异常抖动明显");
        dataList.add("一挡起步时车身抖动");
        dataList.add("低速行驶抖动厉害");
        dataList.add("2挡抖动厉害");
        dataList.add("行驶中车辆抖动");
        dataList.add("D挡踩刹车抖动明显");
        dataList.add("换挡时抖动");
        dataList.add("冷车起步迟缓抖动脱挡");
        dataList.add("怠速和上坡时抖动");
        dataList.add("变速箱抖动的特别厉害");
        dataList.add("怠速抖动非常严重");
        dataList.add("T600旗舰版五挡时挡把抖动");
        dataList.add("CVT变速箱抖动");
        dataList.add("M5变速箱抖动");
        dataList.add("怠速抖动排挡杆共振");
        dataList.add("四挡时挡把抖动非常厉害");
        dataList.add("在D挡踩刹车时抖动");
        dataList.add("T600五挡时挡把抖动");
        dataList.add("怠速抖动后备箱门油漆剥落");
        dataList.add("D挡抖动低频共振");
        dataList.add("D挡踩刹车明显抖动");
        dataList.add("车辆起步抖动非常厉害");
        dataList.add("低速时和打转向时严重抖动");
        dataList.add("倒车时抖动厉害");
        dataList.add("一挡起步时抖动");

        List<String> matchStrList = new ArrayList<String>();
        matchStrList.add("变速箱抖动");
        matchStrList.add("变速器.*起步.*抖");
        matchStrList.add("发动机抖动");
        matchStrList.add("抖动");
        matchStrList.add("发抖");

        List<String> resultList = new ArrayList<String>();

        for (String attribute : dataList) {

            //循环匹配预设字符串集合
            for (String regx : matchStrList) {

                Pattern p = Pattern.compile(regx);
                Matcher m = p.matcher(attribute);
                //如果匹配成功
                if (m.find()) {

                    StringBuilder resultTemp = new StringBuilder();
                    String[] regxArr;
                    //contains(".*")为了适配正则表达式.*
                    regxArr = regx.contains(".*") ? regx.split("\\.\\*") : new String[]{regx};

                    int index;
                    int endIndex;
                    int preIndex = -1;
                    //为了解决 变速器*抖 此类问题，若匹配 变速器*抖 字符串成功，那么regxArr数组：regxArr[0]="变速器", regxArr[1]="抖"
                    for (String regxTemp : regxArr) {

                        index = attribute.indexOf(regxTemp);
                        endIndex = index + regxTemp.length();

                        if (index != -1) {
                            resultTemp.append((index != 0 && index != preIndex) ? "*" : "");
                            resultTemp.append(attribute.substring(index, endIndex));
                            //如果regxArr只有一个字符串(即没有.*)，且匹配到的字符串最后一位不是整个字符串的最后一位，那么加上*
                            resultTemp.append((regxArr.length == 1 && endIndex != attribute.length()) ? "*" : "");

                            preIndex = endIndex;
                        }
                    }
                    resultList.add(resultTemp.toString());
                    break;
                }
            }
        }

        for (String tempStr : resultList) {
            System.out.println(tempStr);
        }

    }
}
