package com.mx;

import java.util.Arrays;

/**
 * @ClassName LetterTilePossibilities
 * @Description TODO
 * @Author miaoxu
 * @Date 2019/10/1 19:31
 * @Version 1.0
 **/
public class LetterTilePossibilities {
    int count = 0;

    public int numTilePossibilities(String tiles) {
        char[] chars = tiles.toCharArray();
        Arrays.sort(chars);
        tiles = String.valueOf(chars);
        getTile(0, tiles, new boolean[tiles.length()], "");
        return count;

    }

    private void getTile(int start, String tiles, boolean[] visited, String tem) {
        if (tem.length() >= visited.length){
            return;
        }
        for (int i = 0; i < tiles.length(); i++) {
            if (!visited[i]){
                if (i > 0 && tiles.charAt(i) == tiles.charAt(i - 1) && !visited[i - 1]){
                    continue;
                }
                visited[i] = true;
                count++;
                System.out.println(tem + tiles.charAt(i));
                getTile(i + 1, tiles, visited, tem + tiles.charAt(i));
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        new LetterTilePossibilities().numTilePossibilities("AAB");
    }
}
