package org.example.codingtest;

//두 정수 X, Y의 임의의 자리에서 공통으로 나타나는 정수 k(0 ≤ k ≤ 9)들을 이용하여 만들 수 있는 가장 큰 정수를 두 수의 짝꿍이라 합니다
// (단, 공통으로 나타나는 정수 중 서로 짝지을 수 있는 숫자만 사용합니다).

// X, Y의 짝꿍이 존재하지 않으면, 짝꿍은 -1입니다. X, Y의 짝꿍이 0으로만 구성되어 있다면, 짝꿍은 0입니다.
//
//        예를 들어, X = 3403이고 Y = 13203이라면, X와 Y의 짝꿍은 X와 Y에서 공통으로 나타나는 3, 0, 3으로 만들 수 있는 가장 큰 정수인 330입니다.
//        다른 예시로 X = 5525이고 Y = 1255이면 X와 Y의 짝꿍은 X와 Y에서 공통으로 나타나는 2, 5, 5로 만들 수 있는 가장 큰 정수인 552입니다
//        (X에는 5가 3개, Y에는 5가 2개 나타나므로 남는 5 한 개는 짝 지을 수 없습니다.)

//        두 정수 X, Y가 주어졌을 때, X, Y의 짝꿍을 return하는 solution 함수를 완성해주세요.
//
//        제한사항
//        3 ≤ X, Y의 길이(자릿수) ≤ 3,000,000입니다.
//        X, Y는 0으로 시작하지 않습니다.
//        X, Y의 짝꿍은 상당히 큰 정수일 수 있으므로, 문자열로 반환합니다.

//          X	      Y	         result
//        "100"	   "2345"	     "-1"
//        "100"	   "203045"	      "0"
//        "100"	   "123450"	      "10"
//        "12321"	"42531"	      "321"
//        "5525"	"1255"	      "552"

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Number {

    public String solution(String X, String Y) {
        String answer = "";

        List<String> result = new ArrayList<>();

        String[] splitX = X.split("");
        String[] splitY = Y.split("");

        StringBuilder yString = new StringBuilder();

        for (String number : splitY) {
            yString.append(number);
        }

        for (int i=0; i<splitX.length; i++) {

            for (int j=0; j<yString.length(); j++) {
                if ( splitX[i].equals(String.valueOf(yString.charAt(j))) ) {
                    result.add(splitX[i]);
                    yString.deleteCharAt(j);
                    break;
                }
            }
        }

        result.sort(Collections.reverseOrder());

        answer = String.join("", result);

        if (answer.startsWith("0")) {
            return "0";
        }

        if (answer.equals("")) {
            return "-1";
        }

        return answer;
    }
}
