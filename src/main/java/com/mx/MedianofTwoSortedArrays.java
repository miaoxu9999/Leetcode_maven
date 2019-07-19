package com.mx;

/**
 * @ClassName MedianofTwoSortedArrays
 * @Description TODO
 * @Author miaoxu
 * @Date 2018/11/25 20:10
 * @Version 1.0
 **/
public class MedianofTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0)
        {
            if (nums2.length % 2 == 0)
            {
                return ((double) nums2[nums2.length / 2 - 1] + (double)nums2[nums2.length / 2 ]) / 2;
            }
            else
            {
                return nums2[nums2.length / 2];
            }
        }
        if (nums2.length == 0)
        {
            if (nums1.length % 2 == 0)
            {
                return (nums1[nums1.length / 2 - 1] + nums1[nums1.length / 2 ]) / 2;
            }
            else
            {
                return nums1[nums1.length / 2];
            }
        }
        double res = nums1[0];
        int count = 0;
        int i = 0;
        int j = 0;
        int n1, n2;
        int middle;
        //排名第i的数字
        int inum = Math.min(nums1[0], nums2[0]);
        //排名第i + 1的数字
        int i1num = Math.max(nums1[0], nums2[0]);
        int totallen = nums1.length + nums2.length;
        if ((totallen) % 2 == 0)
        {
            int t1 = findnum(totallen / 2, nums1, nums2);
            int t2 = findnum(totallen / 2 + 1, nums1, nums2);
            return (t1 + t2) / 2;
        }
        else
        {
            return (double) findnum(totallen / 2 + 1, nums1, nums2);
        }

    }

    public int findnum(int i, int[] nums1, int[] nums2)
    {

        int k = 0;
        int j = 0;
        int count = 0;
        int res = 0;
        while (count != i)
        {
            int n1,n2;
            if (k < nums1.length)
            {
                n1 = nums1[k];
            }
            else
            {
                n1 = Integer.MAX_VALUE;
            }
            if (j < nums2.length)
            {
                n2 =  nums2[j];
            }
            else
            {
                n2 = Integer.MAX_VALUE;
            }
            if (n1 < n2)
            {
                k++;
                res = n1;
            }
            else
            {
                j++;
                res = n2;
            }
            count++;
        }


        return res;
    }
}

