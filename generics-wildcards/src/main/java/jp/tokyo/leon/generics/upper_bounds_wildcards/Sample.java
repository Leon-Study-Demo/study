package jp.tokyo.leon.generics.upper_bounds_wildcards;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author leon
 * @date 2024/1/14 16:05
 */
public class Sample {
    public static void main(String[] args) {

        List<Integer> l1 = new ArrayList<>();
        l1.add(111);
                //li.add（"骚气的我）；泛型会报错
        try {
            Method method = l1.getClass().getDeclaredMethod("add", Object.class);
            method.invoke(l1,"骚气的我 又出现了");
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (Object i : l1) {
            System.out.println(i);
        }





    }

    public static void printNumList(List<? extends Number> numberList) {
        // numberList.add(2.1);
        numberList.add(null);
        for(Number item : numberList) {
            System.out.println(item);
        }
    }

    /*
     * 上界通配符有它的缺陷， 凡是类型为<? Extends T>的泛型对象，都无法被设置除Null以外的值。
     */

}
