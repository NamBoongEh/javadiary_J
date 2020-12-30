import java.util.Scanner;

public class Main1229_3 {
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        int[][] arr = new int[5][5];
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                arr[i][j] = scan.nextInt();
            }
        }

        Main1229_3Test test = new Main1229_3Test();

        System.out.println("빙고결과 " + test.bingo(arr) + "입니다.");
        scan.close();
    }
}
