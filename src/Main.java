import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Card[] arr = {
                new Card(1, 1),
                new Card(1, 2),
                new Card(1, 3),
                new Card(1, 4),
                new Card(1, 5)
        };

        // 객체를 생성한다.
        MainTest test = new MainTest();
        //반환 값을 출력해주자.
        System.out.println("이번 판 결과는 \"" + test.rankCheck(arr) + "\"입니다.");

    }
}
