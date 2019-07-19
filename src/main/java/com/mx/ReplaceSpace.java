package com.mx;

/**
 * @ClassName ReplaceSpace
 * @Description TODO
 * @Author miaoxu
 * @Date 2019/3/20 14:45
 * @Version 1.0
 **/
public class ReplaceSpace {
    public String replaceSpace(StringBuffer str) {
        String tem = "";
        for (int i = 0 ;i < str.toString().length(); i++)
        {
            char c = str.charAt(i);
            if (c == 32)
            {
                tem += "%";
            }
            else
            {
                tem += c;
            }
        }

        return tem;

    }
}
