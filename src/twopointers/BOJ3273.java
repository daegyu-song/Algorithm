package twopointers;

import java.util.*;
import java.io.*;

public class BOJ3273 {
    static int n, x;
    static int[] nums;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        x = Integer.parseInt(br.readLine());
    }

    static void pro() {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1, cnt = 0;
        while (left < right) {
            if (nums[left] + nums[right] == x) {
                cnt++;
                left++;
                right--;
            } else if (nums[left] + nums[right] < x) left++;
            else right--;
        }
        System.out.println(cnt);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
