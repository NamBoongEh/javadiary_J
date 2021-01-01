public class ch3{}

class ch3_2 {
    public static void main(String[] args) {
        int numOfApples = 123; // 사과의 개수
        int sizeOfBucket = 10; // ( ) 바구니의 크기 바구니에 담을 수 있는 사과의 개수
        int numOfBucket = ( (int)Math.ceil(numOfApples*1.0/sizeOfBucket) ); // 모든 사과를 담는데 필요한 바구니의 수
        System.out.println("필요한 바구니의 수 :"+numOfBucket);
    }

}

class Exercise3_3 {
    public static void main(String[] args) {
        int num = -2;
        System.out.println( num>0 ? "양수" : (num<0 ? "음수" : 0) );
    }
}

class Exercise3_4 {
    public static void main(String[] args) {
        int num = 456;
        System.out.println(num/100*100);
    }
}

class Exercise3_5 {
    public static void main(String[] args) {
        int num = 333;
        System.out.println(num/10*10+1 );
    }
}

class Exercise3_6 {
    public static void main(String[] args) {
        int num = 24;
        System.out.println(10-num%10);
    }
}

class Exercise3_7 {
    public static void main(String[] args) {
        int fahrenheit = 100;
        float celcius = (int)(5/9f*(fahrenheit-32)*100+0.5)/100f;
        System.out.println("Fahrenheit:"+fahrenheit);
        System.out.println("Celcius:"+celcius);
    }
}

class Exercise3_8 {
    public static void main(String[] args) {
        byte a = 10;
        byte b = 20;
        byte c = (byte) (a+b);
        char ch = 'A';
        ch = 'A' + 2;
        float f = 3 / 2f;
        long l = 3000 * 3000 * 3000l;
        float f2 = 0.1f;
        double d = 0.1;
        boolean result = (float) d==f2;
        System.out.println("c="+c);
        System.out.println("ch="+ch);
        System.out.println("f="+f);
        System.out.println("l="+l);
        System.out.println("result="+result);
    }
}

class Exercise3_9 {
    public static void main(String[] args) {
        char ch = 'z';
        boolean b = ('a'<=ch && ch <='z') || ('A'<=ch && ch<='Z') || ('0'<=ch && ch<='9');
        System.out.println(b);
    }
}

class Exercise3_10 {
    public static void main(String[] args) {
        char ch = 'A';
        char lowerCase = (65<=ch && ch<97) ? (char) (ch+32) : ch;
        System.out.println("ch:"+ch);
        System.out.println("ch to lowerCase:"+lowerCase);
    }
}
