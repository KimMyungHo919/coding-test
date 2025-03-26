package org.example.codingtest;


// ["..........", ".....#....", "......##..", "...##.....", "....#....."]	[1, 3, 5, 8]
public class Background {

    public int[] solution(String[] wallpaper) {
        int[] answer = {};

        int bottom = Integer.MIN_VALUE, right = Integer.MIN_VALUE;
        int top = Integer.MAX_VALUE, left = Integer.MAX_VALUE;

        for (int i=0; i<wallpaper.length; i++) {
            for (int j=0; j<wallpaper[i].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    top = Math.min(top, i);
                    bottom = Math.max(bottom, i);

                    left = Math.min(left, j);
                    right = Math.max(right, j);
                }
            }
        }

        return new int[]{top, left, bottom + 1, right + 1};
    }
}
