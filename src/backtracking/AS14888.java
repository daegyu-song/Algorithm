import java.util.*;
import java.io.*;
public class AS14888 {
    static int N;
    static int[] numbers;
    static int[] operators = new int[4];
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    static void solution(int answer, int k) {
        if (k == N) {
            if (answer > max) max = answer;
            if (answer < min) min = answer;
        } else {
            for (int i = 0; i < operators.length; i++) {
                if (operators[i] == 0) continue;
                operators[i]--;
                switch (i) {
                    case 0:
                        solution(answer + numbers[k], k + 1);
                        break;
                    case 1:
                        solution(answer - numbers[k], k + 1);
                        break;
                    case 2:
                        solution(answer * numbers[k], k + 1);
                        break;
                    case 3:
                        solution(answer / numbers[k], k + 1);
                        break;
                }
                operators[i]++;
            }
        }

    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        numbers = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < operators.length; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        solution(numbers[0], 1);
        System.out.println(max + "\n" + min);
    }
}
