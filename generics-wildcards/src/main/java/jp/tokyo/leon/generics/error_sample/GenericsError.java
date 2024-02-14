package jp.tokyo.leon.generics.error_sample;

import java.util.Arrays;
import java.util.List;

/**
 * @author leon
 * @date 2024/1/14 16:00
 */
public class GenericsError {
    public static void main(String[] args) {

        List<Integer> intList = Arrays.asList(1,2,3,4,5);
        List<Float> floatList = Arrays.asList(3.1F,2.7F,8.3F,11F,15.6F);
        // printNumList(intList);
        // printNumList(floatList);
        // java: 不兼容的类型: java.util.List<java.lang.Integer>无法转换为java.util.List<java.lang.Number>
    }

    public static void printNumList(List<Number> numberList) {
        for(Number item : numberList) {
            System.out.println(item);
        }
    }

    /*
     * 虽然 Integer和Float与Number是IS-A的关系，
     * 但List<Integer>和List<Float>与List<Number>却不是IS-A关系，
     * 因为List<Integer>和List<Float>并非继承至List<Number>
     */
}
