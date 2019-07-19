package com.mx;

import java.util.Scanner;

/**
 * @ClassName VisitMageicCountry
 * @Description TODO
 * @Author miaoxu
 * @Date 2019/6/22 11:27
 * @Version 1.0
 **/
public class VisitMageicCountry {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
             int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(b + 1);
        }
    }
}
