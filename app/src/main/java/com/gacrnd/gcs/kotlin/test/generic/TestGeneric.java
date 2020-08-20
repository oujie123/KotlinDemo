package com.gacrnd.gcs.kotlin.test.generic;

import com.gacrnd.gcs.kotlin.test.generic.obj.ChildClass;
import com.gacrnd.gcs.kotlin.test.generic.obj.ParentClass;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Jack Ou
 * @CreateDate: 2020/8/20 23:42
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/8/20 23:42
 * @UpdateRemark: 更新说明
 */
public class TestGeneric {
    ParentClass parentClass = new ParentClass();
    ChildClass childClass = new ChildClass();

    public void test(){

        /**************泛型读取模式*****************/
        //? extends ParentClass  自读模式  不能修改
        List<? extends ParentClass> list = new ArrayList<ChildClass>();
        //不能修改
        /*list.add(parentClass);
        list.add(parentClass);*/

        //可以获取
        parentClass = list.get(0);

        //? super ChildClass  只能修改  不能读
        List<? super ChildClass> list1 = new ArrayList<ParentClass>();
        list1.add(childClass);
        list1.add(childClass);

        //不能获取   因为ParentClass返回窄一点，不能填满child
//        childClass = list1.get(0);
    }
}
