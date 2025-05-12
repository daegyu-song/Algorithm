package programmers.lv1;

import java.util.*;

// 프로그래머스 Lv.1 가장 많이 받은 선물
class May12th {

    private int[][] giftTable;
    private int[] giftNum, prediction;
    private int answer;

    public int solution(String[] friends, String[] gifts) {

        giftTable = new int[friends.length][friends.length];
        giftNum = new int[friends.length];
        prediction = new int[friends.length];

        // map 사용 -> 주고 받은 표와 선물 지수를 한 번에
        /* Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < friends.length; i++) {
            map.put(friends[i], i);
        }

        for (String gift : gifts) {
            String[] splitArr = gift.split(" ");
            giftNum[map.get(splitArr[0])]++;
            giftNum[map.get(splitArr[1])]--;
            giftTable[map.get(splitArr[0])][map.get(splitArr[1])]++;
        } */

        // create giftTable 
        for (int i = 0; i < friends.length; i++) {
            for (int j = 0; j < friends.length; j++) {
                if (i == j) continue;
                for (int k = 0; k < gifts.length; k++) {
                    String[] test = gifts[k].split(" ");
                    if (friends[i].equals(test[0])) {
                        if (friends[j].equals(test[1])) {
                            giftTable[i][j]++;
                        }
                    }
                }
            }
        }

        // create giftNum 
        for (int i = 0; i < friends.length; i++) {
            for (int j = 0; j < friends.length; j++) {
                if (i == j) continue;
                giftNum[i] += giftTable[i][j];
                giftNum[i] -= giftTable[j][i];
            }
        }

        // process 
        for (int i = 0; i < friends.length; i++) {
            for (int j = 0; j < friends.length; j++) {
                if (i == j) continue;
                if (giftTable[i][j] > giftTable[j][i]) {
                    prediction[i]++;
                } else if (giftTable[i][j] == giftTable[j][i]) {
                    if (giftNum[i] > giftNum[j]) prediction[i]++;
                }
            }
        }

        // max
        for (int i = 0; i < friends.length; i++) {
            answer = Math.max(answer, prediction[i]);
        }

        return answer;
    }
}