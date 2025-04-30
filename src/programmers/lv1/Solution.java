package programmers.lv1;

// 프로그래머스 Lv.1 유연 근무제
class April30th {

    static int answer = 0, checkDay, checkTime;
    static boolean flag;

    public int solution(int[] schedules, int[][] timelogs, int startday) {

        for (int i = 0; i < schedules.length; i++) {

            flag = true;
            checkDay = startday - 1;
            checkTime = setTime(schedules[i]);

            for (int time : timelogs[i]) {
                checkDay++;
                if (checkDay % 7 == 0 || checkDay % 7 == 6) continue;

                if (time > checkTime) {
                    flag = false;
                    break;
                }
            }

            if (flag) answer++;
        }

        return answer;
    }

    public int setTime(int time) {

        time += 10;

        if (time % 100 >= 60) {
            time = (time / 100 + 1) * 100 + time % 100 % 60;
        }

        return time;
    }
}