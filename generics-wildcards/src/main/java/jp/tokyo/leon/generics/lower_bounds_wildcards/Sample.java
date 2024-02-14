package jp.tokyo.leon.generics.lower_bounds_wildcards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author leon
 * @date 2024/1/14 16:26
 */
public class Sample {
    public static void main(String[] arg) {
        List<Object> strListResult = new ArrayList<>();

        Object a = new ArrayList<>(){
            {
                add(1);
            }
        };

        strListResult.add(a);

//        List<? super String> tmp = strListResult;
//
//        tmp.add("222");
//
//        for (Object tmp1 : tmp) {
//            System.out.println(tmp1);
//        }
        List<?> unknown = strListResult;

        for (Object o : unknown) {
            System.out.println(o);
        }

        List<Integer> bb = new ArrayList<>();

        List<?> aa = bb;
        List<Object> cc = new ArrayList<>();
        cc.add(2);
        cc.add("dsds");



    }





}
