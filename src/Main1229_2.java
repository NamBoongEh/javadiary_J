import java.util.Scanner;

public class Main1229_2 {
    //Q1. arr1, arr2 두 배열 받아서 같을 시 같습니다. 다를 시 다릅니다. 출력

    public static void main(String[] args){
        // arr1, arr2 배열 생성(여기에선 길이를 짧아서 5로 고정한다^-^;;)
        Scanner scan = new Scanner(System.in);
        int[] arr1 = new int[5];
        int[] arr2 = new int[5];

        // arr1, arr2 배열을 Scanner를 이용하여 입력받는다.
        for(int i=0; i<5; i++){
            arr1[i] = scan.nextInt();
        }
        for(int i=0; i<5; i++){
            arr2[i] = scan.nextInt();
        }

        // 객체를 생성한다.
        Main1229_2Test test = new Main1229_2Test();
        //반환 값을 출력해주자.
        System.out.println("Q1. 정답은 " + test.tf(arr1, arr2));
        System.out.println("Q2. 정답은 " + test.same(arr1, arr2));

    }
}
