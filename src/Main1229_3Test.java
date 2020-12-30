import org.junit.Test;

import static org.junit.Assert.*;

public class Main1229_3Test {

    public int bingo(int[][] arr){
        int answer = 0;
        int count = 0;

        // 행or열이 하나씩 증가시키기 위한 while문 작성
        while(count<5) {
            //빙고게임에 0과 1만 있으니 길이는 2로 해도 된다.
            int[] counting = new int[2];

            // 1) 행 증가
            for (int i = 0; i < 5; i++) {
                counting[arr[count][i]]++;
            }
            // 1-1) 행 증가에 따른 빙고 결과 확인
            if (counting[1] == 5) {
                answer++;
            }

            // 동시에 열 증가도 확인하기위해 counting 배열을 초기화 해준다.
            counting[0] = 0;
            counting[1] = 0;

            // 2) 열 증가
            for (int i = 0; i < 5; i++) {
                counting[arr[i][count]]++;
            }
            if (counting[1] == 5) {
                answer++;
            }

            count++;
        }

        // 3,4) 대각선 두 종류 확인
        int case3 = 0;
        int case4 = 0;
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                // 3) 행=열 행++ 열++     전부 1일 경우 case3는 5가 될 거다.
                if(i==j && arr[i][j]==1){
                    case3++;
                }
                // 4) 행=0; 열=5 행++ 열--
                if(i+j==4 && arr[i][j]==1){
                    case4++;
                }
            }
        }

        //case3과 case4가 5라면 빙고(answer)에 추가
        if(case3==5 && case4==5){
            answer = answer + 2;
        }
        else if(case3==5 || case4==5) {
            answer++;
        }

        return answer;
    }

    @Test
    public void bingo1() {
        int[][] arr = {
                {1,1,1,1,1},
                {1,1,1,1,1},
                {1,1,1,1,1},
                {1,1,1,1,1},
                {1,1,1,1,1}
        };

        assertTrue(bingo(arr)==12);
    }

    @Test
    public void bingo2() {
        int[][] arr = {
                {0,0,0,0,1},
                {0,0,0,1,0},
                {0,0,1,0,0},
                {0,1,0,0,0},
                {1,0,0,0,0}
        };

        assertTrue(bingo(arr)==1);
    }

    @Test
    public void bingo3() {
        int[][] arr = {
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0}
        };

        assertTrue(bingo(arr)==0);
    }
}