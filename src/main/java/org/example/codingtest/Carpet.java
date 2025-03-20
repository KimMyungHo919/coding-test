package org.example.codingtest;

public class Carpet {

    public int[] solution(int brown, int yellow) {
        // 타일의 총 개수 구하기
        int total = brown + yellow;

        for (int width = total; width>=1; width--) {
            if (total % width == 0) { // 총갯수/길이 나누어떨어질때
                int height = total / width; // 높이

                if ( (width-2) * (height - 2) == yellow ) {
                    return new int[] {width, height};
                }
            }
        }
        return new int[]{0,0};
    }

}
