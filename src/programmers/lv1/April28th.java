package programmers.lv1;

// 프로그래머스 Lv.1 택배 상자 꺼내기
class April28th {

    static int[][] arr;
    static int count = 1, result = 1;
    static int a = 0, b = 0;

    public int solution(int n, int w, int num) {

        arr = new int[n / w + 1][w];

        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < arr[0].length; j++) {
                    arr[i][j] = count++;
                }
            } else {
                for (int j = arr[0].length - 1; j >= 0; j--) {
                    arr[i][j] = count++;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == num) {
                    a = i;
                    b = j;
                }
            }
        }

        for (int i = a + 1; i < arr.length; i++) {
            if (arr[i][b] > 0 && arr[i][b] <= n) result++;
        }

        return result;
    }
}
