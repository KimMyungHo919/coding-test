package org.example.codingtest;

//1	6개 번호가 모두 일치
//2	5개 번호가 일치
//3	4개 번호가 일치
//4	3개 번호가 일치
//5	2개 번호가 일치
//6(낙첨)	그 외

//                lottos	                 win_nums	         result
//        [44, 1, 0, 0, 31, 25]	     [31, 10, 45, 1, 6, 19]	     [3, 5]
//        [0, 0, 0, 0, 0, 0]	     [38, 19, 20, 40, 15, 25]	 [1, 6]
//        [45, 4, 35, 20, 3, 9]	     [20, 9, 3, 45, 4, 35]	     [1, 1]

import java.util.HashMap;
import java.util.Map;

public class Lotto {

    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {};
        Map<Integer, Integer> lotto = new HashMap<>();

        for (int i=1; i<7; i++) {
            lotto.put(7-i , i); // 맞은갯수,등수
        }

        int max = 0; // 최고점수
        int min = 0; // 최저점수
        int zeroCount = 0; // 0 갯수
        int number = 0; // 일치하는 갯수

        // 1. lottos 의 0갯수를 센다.
        for (int i=0; i<lottos.length; i++) {
            if (lottos[i] == 0) { // 0일때
                zeroCount++;
                continue;
            }
            // 2. lottos 에서 0을 제외하고, 나머지 숫자로 win_nums 와 일치하는 갯수를 센다.
            for (int j=0; j< win_nums.length; j++) {
                if (lottos[i] == win_nums[j]) {
                    number++;
                }
            }
        }

        // 3. 최고점수는 <<<2번 + 1번length>>> 최저점수는 <<<2번>>>
        max = number + zeroCount;
        min = number;

        return new int[]{ lotto.getOrDefault(max, 6), lotto.getOrDefault(min, 6) };
    }
}
