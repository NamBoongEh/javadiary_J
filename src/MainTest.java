import java.util.Scanner;

public class MainTest {
    public static void main(String[] args){
        Card[] arr = {
                new Card(1, 1),
                new Card(1, 1),
                new Card(1, 1),
                new Card(1, 1),
                new Card(1, 1)
        };

        // 객체를 생성한다.
        MainTestTest test = new MainTestTest();
        //반환 값을 출력해주자.
        System.out.println("정답은 \"" + test.rankCheck(arr) + "\"입니다.");

    }
}
