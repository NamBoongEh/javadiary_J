import java.util.Scanner;

public class Main1229 {
    //Q4. 3개의 정수를 입력받아서 그 중에 중간 크기의 값을 반환하기

    public static void main(String[] args){
        // 3개의 정수는 Scanner를 이용하여 입력받는다.
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        int y = scan.nextInt();
        int z = scan.nextInt();
        // 객체를 생성한다.
        Main1229Test test = new Main1229Test();
        //반환 값을 출력해주자.
        System.out.println(test.mid(x, y, z));
    }
}
