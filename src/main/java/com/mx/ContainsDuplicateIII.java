package com.mx;

import java.util.*;

/**
 * @ClassName ContainsDuplicateIII
 * @Description TODO
 * @Author miaoxu
 * @Date 2019/6/24 23:56
 * @Version 1.0
 **/
public class ContainsDuplicateIII {
    static int n = 5;
    static List<Integer> list = new ArrayList<>();
    static HashMap<Integer, String> map = new HashMap<>();

    public static void main(String[] args) {
//        int[] array={4, 5, 6 ,7, 8,9};
//        allSort(array, 0, array.length-1);
//        Collections.sort(list, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2 - o1;
//            }
//        });
//        System.out.println(list);
//        System.out.println(map.get(3316));

        int[] a = new int[10];
        a[0] = 0;
        a[1] = 1;
        a[2] = 2;
        a[3] = 3;
        a[4] = 4;
        System.arraycopy(a, 2, a, 3, 3);
        a[2]=99;
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }


    }
    static void allSort(int[] array,int begin,int end){
//    ／／打印数组的内容
        if(begin==end){
            int n1 = array[0] * 100 + array[1] * 10 + array[2] ;
            int n2 = array[1] * 100 + array[2] * 10 + array[3] ;
            int n3 = array[2] * 100 + array[3] * 10 + array[4] ;
            int n4 = array[3] * 100 + array[4] * 10 + array[5] ;
            if (n1 + n2 + n3 + n4 == 3316)
            {
                for (int i = 0; i < array.length; i++) {
                    System.out.print(n1 + " ");
                    System.out.print(n2 + " ");
                    System.out.print(n3 + " ");
                    System.out.print(n4 + " ");
                }
                System.out.println();
            }

//            System.out.println();
            String tem = "";
            for (int i = 0; i < array.length; i++) {
                tem += array[i];
            }
            map.put(n1 + n2 + n3 + n4, tem);
            list.add(n1 + n2 + n3 + n4);
            return;
        }
//    ／／把子数组的第一个元素依次和第二个、第三个元素交换位置
        for(int i=begin;i<=end;i++){
            swap(array,begin,i );
            allSort(array, begin+1, end);
//        ／／交换回来
            swap(array,begin,i );
        }
    }

    static void swap(int[] array,int a,int b){
        int tem=array[a];
        array[a]=array[b];
        array[b]=tem;
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeMap<Long, Boolean> treeMap = new TreeMap<>();
        //遍历hashset，维持长度为k的滑动窗口
        for (int i = 0; i < nums.length; i++) {
           if (treeMap.ceilingKey((long)((long)nums[i] - t)) != null && treeMap.ceilingKey((long)(nums[i] - t)) <= ((long)nums[i] + (long)t))
           {
               return true;
           }
           treeMap.put((long)nums[i], true);
           if (treeMap.size() == k + 1)
           {
               treeMap.remove((long)nums[i - k]);
           }
        }
    return false;
    }



//    public static void main(String[] args) {
//        int[] n1 = {1,2,3,1};
//        int[] n2 = {1,0,1,1};
//        int[] n3 = {1,5,9,1,5,9};
//        int[] n4 = {0,2147483647};
//        int[] n5 = {-2147483648,-2147483647};
//        System.out.println((n5[1] - n5[0]));
////        System.out.println(new ContainsDuplicateIII().containsNearbyAlmostDuplicate(n1, 3, 0));
////        System.out.println(new ContainsDuplicateIII().containsNearbyAlmostDuplicate(n2, 1, 2));
////        System.out.println(new ContainsDuplicateIII().containsNearbyAlmostDuplicate(n3, 2, 3));
////        System.out.println(new ContainsDuplicateIII().containsNearbyAlmostDuplicate(n4, 1, 2147483647));
////        System.out.println(new ContainsDuplicateIII().containsNearbyAlmostDuplicate(n5, 3, 3));
//
////        int s = 0;
////        for (int i = 1;  i <= 1004; i++)
////        {
////            int tem = i;
////            int an = 2009 - i;
////            if (i %2 != 0)
////            {
////                tem = -tem;
////            }
////            s += (tem * an);
////        }
////
////        System.out.println(s);
//
////        Scanner sc = new Scanner(System.in);
////        n = sc.nextInt();
////        arr = new int[n+1];
////        brr = new int[n+1];
//        dfs(0);
//
//    }
}
