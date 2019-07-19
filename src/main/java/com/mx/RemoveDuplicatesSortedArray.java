package com.mx;

/**
 * @ClassName RemoveDuplicatesSortedArray
 * @Description TODO
 * @Author miaoxu
 * @Date 2019/2/19 11:09
 * @Version 1.0
 **/
public class RemoveDuplicatesSortedArray {
    int l;
    public int removeDuplicates(int[] nums) {
        l = nums.length;
        //双指针解决,i每次跳两个格，表当前不重复的元素
        int i = 0;
        //j代表当前不重复的元素
        int j = 2;
        //代表当前存储的位置，好像用len也可以
        int curindex = 0;
        int len = 0;
        while(true)
        {
            if (check(i))
            {
                if (!check(j))
                {
                    if(check(i + 1))
                    {
                        nums[len] = nums[i];
                        nums[len + 1] = nums[i + 1];
                        len+= 2;
                    }
                    else
                    {
                        nums[len] = nums[i];
                        len +=1;
                    }
                    break;

                }
                if (nums[i] == nums[j])
                {
                    while (check(j) && nums[i] == nums[j])
                    {
                        j++;
                    }
                    nums[len] = nums[i];
                    nums[len + 1] = nums[i];
                    len+= 2;
                    i = j;
                    j = j + 2;

                }
                else
                {
                    if (nums[i + 1] != nums[j])
                    {
                        nums[len] = nums[i];
                        nums[len + 1] = nums[i + 1];
                        len += 2;
                        i = j;
                        j += 2;

                    }
                    else
                    {
                        nums[len] = nums[i];
                        len += 1;
                        i++;
                        j++;

                    }

                }

            }
            else
            {
                break;
            }

        }

        return len;

    }

    public boolean check(int i)
    {
        return i >= 0 && i < l;
//        if (i > 0 && i < l)
//        {
//            return true;
//        }
//        else
//        {
//            return false;
//        }
    }

    public static void main(String[] args) {
//        int[] n = {1,1,1,2,2,3};
//        int[] n = {0,0,1,1,1,1,2,3,3};
        int[] n = {1,2};
        System.out.println( new RemoveDuplicatesSortedArray().removeDuplicates(n));
    }
}
