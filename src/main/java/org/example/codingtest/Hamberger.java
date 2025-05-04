package org.example.codingtest;

//        [2, 1, 1, 2, 3, 1, 2, 3, 1]	결과 : 2
//        [1, 3, 2, 1, 2, 1, 3, 1, 2]	결과 : 0

import java.util.Stack;

public class Hamberger {

    public int solution(int[] ingredient) {
        Stack<Integer> stack = new Stack<>();
        int count = 0;

        for (int i : ingredient) {
            stack.push(i);

            if (stack.size() >= 4) {
                int size = stack.size();
                if (stack.get(size - 4) == 1 &&
                        stack.get(size - 3) == 2 &&
                        stack.get(size - 2) == 3 &&
                        stack.get(size - 1) == 1) {

                    for (int j = 0; j < 4; j++) {
                        stack.pop();
                    }
                    count++;
                }
            }
        }

        return count;
    }

}
