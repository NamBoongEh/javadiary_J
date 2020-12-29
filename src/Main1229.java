import java.util.Scanner;

public class Main1229 {

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        int x = scan.nextInt();
        int y = scan.nextInt();
        int z = scan.nextInt();

        Q1Test test = new Q1Test();
        
        System.out.println(test.mid(x, y, z));
    }
}
