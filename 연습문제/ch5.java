public class ch5 {
}

class Exercise5_3 {
    public static void main(String[] args)    {
        int[] arr = {10, 20, 30, 40, 50};
        int sum = 0;
        for(int i=0; i<arr.length; i++){
            sum = sum + arr[i];
        }
        System.out.println("sum="+sum);
    }
}

class Exercise5_4 {
    public static void main(String[] args)    {
        int[][] arr = {
                { 5, 5, 5, 5, 5},
                {10,10,10,10,10},
                {20,20,20,20,20},
                {30,30,30,30,30}
        };
        int total = 0;
        float average = 0;

        for(int i=0; i<4; i++){
            for(int j=0; j<5; j++){
                total = total + arr[i][j];
            }
        }
        average = total/20f;

        System.out.println("total="+total);
        System.out.println("average="+average);
    } // end of main
} // end of class

class Exercise5_5 {
    public static void main(String[] args) {
        int[] ballArr = {1,2,3,4,5,6,7,8,9};
        int[] ball3 = new int[3];
// 배열 ballArr의 임의의 요소를 골라서 위치를 바꾼다
        for(int i=0; i< ballArr.length;i++) {
            int j = (int)(Math.random() * ballArr.length);
            int tmp = 0;

            tmp = ballArr[i];
            ballArr[i] = ballArr[j];
            ballArr[j] = tmp;
        }
// 배열 ballArr의 앞에서 3개의 수를 배열 ball3로 복사한다
        for(int i=0; i<3; i++){
            ball3[i] = ballArr[i];
        }
        for(int i=0;i<ball3.length;i++) {
            System.out.print(ball3[i]);
        }
    } // end of main
} // end of class

class Exercise5_6 {
    public static void main(String args[]) {
// 큰 금액의 동전을 우선적으로 거슬러 줘야한다
        int[] coinUnit = {500, 100, 50, 10};
        int money = 2680;
        System.out.println("money="+money);
        for(int i=0;i<coinUnit.length;i++) {
            System.out.println(coinUnit[i] + "원: " + money/coinUnit[i]);
            money = money%coinUnit[i];
        }
    } // main
}
