package jp.tokyo.leon.generics.error_sample;

/**
 * @author leon
 * @date 2024/1/14 15:57
 */
public class NormalExtends {

    public static void main(String[] args) {
        Integer intVal = 100;
        Float floatVal = 10.5F;
        printNum(intVal);
        printNum(floatVal);
    }

    public static void printNum( Number num ) {
        System.out.println(num);
    }
}
