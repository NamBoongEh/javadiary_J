public class ch4 {
}

class Exercise4_1 {
    public static void main(String[] args) {
        int x = 0;
        char a = '0';
        int year = 2021;
        boolean powerOn = false;
        String str = "yes";

        System.out.println((x>10 && x<20) ? true : false);
        System.out.println((a==' ' || a=='\t') ? false : true);
        System.out.println((a=='x' || a=='X') ? true : false);
        System.out.println((a>='0' && a<='9') ? true : false);
        System.out.println(((a>='a' && a<='z')||(a>='A' && a<='Z')) ? true : false);
        System.out.println(((year%400==0 || year%4==0) && year%100==0) ? true : false);
        System.out.println((powerOn==false) ? true : false);
        System.out.println(str.equals("yes") ? true : false);
    }
}

class Exercise4_2 {
    public static void main(String[] args) {
        int sum = 0;
        for(int i=1; i<=20; i++) {
            if (!(i % 2 == 0 || i % 3 == 0)) {
                sum = sum + i;
            }
        }
        System.out.println(sum);
    }
}

class Exercise4_3 {
    public static void main(String[] args) {
        int sum = 0;
        for(int i=1; i<=10; i++) {
            for(int j=1; j<=i; j++) {
                sum = sum + j;
            }
        }
        System.out.println(sum);
    }
}

class Exercise4_4 {
    public static void main(String[] args) {
        int sum = 0;
        int i = 1;

        while(sum<=100){
            if(i%2==1){
                sum = sum + i;
            }
            else{
                sum = sum - i;
            }

            if(sum>=100){
                System.out.println(i);
                break;
            }

            i++;
        }
    }
}

class Exercise4_5 {
    public static void main(String[] args) {
        int i = 0;

        while(i<=10){
            for(int j=0; j<=i; j++){
                System.out.print("*");
            }
            System.out.println();
            ++i;
        }

    } // end of main
} // end of class

class Exercise4_6 {
    public static void main(String[] args) {
        for(int i=1; i<6; i++) {
            System.out.println(i + " " + (6-i));
        }
    }
}

class Exercise4_7 {
    public static void main(String[] args) {
        int value = (int)(Math.random()*6)+1;
        System.out.println("value:"+value);
    }
}

class Exercise4_8 {
    public static void main(String[] args) {
        for(int x=0; x<=10; x++){
            for(int y=0; y<=10; y++){
                if(10-2*x==4*y) {
                    System.out.println("x=" + x + ", y=" + y);
                }
            }
        }
    }
}

class Exercise4_9 {
    public static void main(String[] args) {
        String str = "12345";
        int sum = 0;
        for(int i=0; i < str.length(); i++) {
            sum = sum + Integer.parseInt(""+str.charAt(i));
        }
        System.out.println("sum="+sum);
    }
}

class Exercise4_11 {
    public static void main(String[] args) {
        int num1 = 1;
        int num2 = 1;
        int num3 = 0; // 세번째 값
        System.out.print(num1+","+num2);
        for (int i = 0 ; i < 8 ; i++ ) {
            num3 = num1 + num2;
            System.out.print("," + num3);
            num1 = num2;
            num2 = num3;
        }
    } // end of main
} // end of class

class Exercise4_12 {
    public static void main(String[] args) {
        for (int i = 1 ; i <= 9 ; i++) {
            for (int j = 1; j <= 3; j++) {
                int x = j+1+(i-1)/3*3;
                int y = i%3==0? 3 : i%3 ;
                if(x > 9) //
                    break;
                System.out.print(x+"*"+y+"="+x*y+"\t");
            }
            System.out.println();
            if(i%3==0) System.out.println();
        }
    }
}

class Exercise4_13{
    public static void main(String[] args)    {
        String value = "12o34";
        char ch = ' ';
        boolean isNumber = true;
// charAt(int i) 반복문과 를 이용해서 문자열의 문자를
// 하나씩 읽어서 검사한다.
        for(int i=0; i < value.length() ;i++) {
            if(!('0'<=value.charAt(i) && value.charAt(i)<='9')){
                isNumber = false;
            }
        }
        if (isNumber) {
            System.out.println(value+"는 숫자입니다.");
        } else {
            System.out.println(value+"는 숫자가 아닙니다.");
        }
    } // end of main
} // end of class

class Exercise4_14
{
    public static void main(String[] args)
    {
// 1~100 answer . 사이의 임의의 값을 얻어서 에 저장한다
        int answer = (int)(Math.random()*100+1);
        int input = 0; // 사용자입력을 저장할 공간
        int count = 0; // 시도횟수를 세기위한 변수
// Scanner 화면으로 부터 사용자입력을 받기 위해서 클래스 사용
        java.util.Scanner s = new java.util.Scanner(System.in);
        do {
            count++;
            System.out.print("1과 100 사이의 값을 입력하세요 :");
            input = s.nextInt(); // input . 입력받은 값을 변수 에 저장한다
            if(input==answer){
                System.out.println(count);
                break;
            }
            else{
                if(input>answer){
                    System.out.println("더 작은 수를 입력하세요.");
                }
                else{
                    System.out.println("더 큰 수를 입력하세요.");
                }
            }
        } while(true); // 무한반복문
    } // end of main
} // end of class HighLow