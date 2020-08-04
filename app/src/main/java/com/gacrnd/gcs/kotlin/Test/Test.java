package com.gacrnd.gcs.kotlin.Test;

/**
 * 测试java kotlin互相调用
 * @author Jack_Ou  created on 2020/8/4.
 */
public class Test {

    public static void main(String[] args) {
        UtilKt.show("2131232131312");
        new MyUtils().show1(111111+ "");
    }
}
