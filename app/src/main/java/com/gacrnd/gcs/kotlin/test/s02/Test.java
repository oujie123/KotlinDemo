package com.gacrnd.gcs.kotlin.test.s02;


/**
 * @Author: Jack Ou
 * @CreateDate: 2020/8/5 1:17
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/8/5 1:17
 * @UpdateRemark: 更新说明
 */
public class Test {

    public static void main(String[] args) {
        Test1Kt.show("jack ou");
        Test1Kt.show2("123321");
        Test1Kt.showTest();

        //这种要报错，就是不符合java规范的就会报错，否者是可以用的
        //Test1Kt.   ("121123");
        //Test1Kt.4561389789("123312");
    }
}
