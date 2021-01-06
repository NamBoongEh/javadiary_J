import java.util.Random;

public class ch6 {
}

class Exercise6_1 {
    public static void main(String[] args) {
        int num;
        boolean isKwang;
    }
}

class Exercise6_2 {
    public static void main(String args[]) {
        SutdaCard card1 = new SutdaCard(3, false);
        SutdaCard card2 = new SutdaCard();
        System.out.println(card1.info());
        System.out.println(card2.info());
    }
}
class SutdaCard {
    int num;
    boolean isKwang;

    SutdaCard(){
        this(1, true);
    }

    SutdaCard(int num, boolean isKwang){
        this.num = num;
        this.isKwang = isKwang;
    }

    String info(){
        if(isKwang==true){
            return num+"K";
        }
        else{
            return num+"";
        }
    }
}

class Exercise6_3 {
    public static void main(String[] args) {
        String name;
        int ban;
        int no;
        int kor;
        int eng;
        int math;
    }
}

class Exercise6_4 {
    public static void main(String args[]) {
        Student s = new Student();
        s.name = "홍길동";
        s.ban = 1;
        s.no = 1;
        s.kor = 100;
        s.eng = 60;
        s.math = 76;
        System.out.println("이름 :"+s.name);
        System.out.println("총점 :"+s.getTotal());
        System.out.println("평균 :"+s.getAverage());
    }
}
class Student {
    String name;
    int ban;
    int no;
    int kor;
    int eng;
    int math;

    int getTotal(){
        return kor+eng+math;
    }

    float getAverage(){
        return Math.round((kor+eng+math)/3.0*10)/10.0f;
    }

}

class Exercise6_5 {
    public static void main(String args[]) {
        Student2 s = new Student2("홍길동",1,1,100,60,76);
        System.out.println(s.info());
    }
}
class Student2 {
    String name;
    int a;
    int a2;
    int a3;
    int a4;
    int a5;

    Student2(String name, int a, int a2, int a3, int a4, int a5){
        this.name = name;
        this.a = a;
        this.a2 = a2;
        this.a3 = a3;
        this.a4 = a4;
        this.a5 = a5;
    }

    String info(){
        return name+","+a+","+a2+","+a3+","+a4+","+a5+","+(a3+a4+a5)+","+(Math.round((a3+a4+a5)/3.0*10))/10.0;
    }
}

class Exercise6_6 {
    // (x,y) (x1,y1) . 두 점 와 간의 거리를 구한다
    static double getDistance(int x, int y, int x1, int y1) {
        return Math.sqrt(Math.pow(x1-x, 2)+Math.pow(y1-y, 2));
    }
    public static void main(String args[]) {
        System.out.println(getDistance(1,1,2,2));
    }
}

class MyPoint {
    int x;
    int y;
    MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    double getDistance(int x1, int y1){
        return Math.sqrt(Math.pow(x1-x,2)+Math.pow(y1-y,2));
    }
}
class Exercise6_7 {
    public static void main(String args[]) {
        MyPoint p = new MyPoint(1,1);
// p (2,2) . 와 의 거리를 구한다
        System.out.println(p.getDistance(2,2));
    }
}

class PlayingCard {
    int kind; // 인스턴스변수
    int num; // 인스턴스변수
    static int width; // static변수
    static int height; // static변수
    PlayingCard(int k , int n) { // 지역변수
        kind = k;
        num = n;
    }
    public static void main(String args[]) {
        PlayingCard card = new PlayingCard(1,1);
    }
}

class Marine {
    int x=0, y=0; // Marine (x,y) 의 위치좌표
    int hp = 60; // 현재 체력
    static int weapon = 6; // 공격력 // 1 공방은 모든 마린 캐릭터가 똑같아야하기 때문에
    static int armor = 0; // 방어력  // 2 공방은 모든 마린 캐릭터가 똑같아야하기 때문에
    static void weaponUp() { // 3 모든 마린 캐릭터가 똑같이 올라야하기 때문에
        weapon++;
    }
    static void armorUp() { // 4 모든 마린 캐릭터가 똑같이 올라야하기 때문에
        armor++;
    }
    void move(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Exercise6_20{
    static int[] shuffle(int[] original){
        int[] arr = new int[original.length];
        for(int i=0; i<original.length; i++){
            arr[i] = original[i];
        }

        for(int i=0; i<original.length; i++){
            int j = (int)(Math.random()*original.length);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        return arr;
    }
    public static void main(String[] args)    {
        int[] original = {1,2,3,4,5,6,7,8,9};
        System.out.println(java.util.Arrays.toString(original));
        int[] result = shuffle(original);
        System.out.println(java.util.Arrays.toString(result));
    }
}

class MyTv {
    boolean isPowerOn;
    int channel;
    int volume;
    final int MAX_VOLUME = 100;
    final int MIN_VOLUME = 0;
    final int MAX_CHANNEL = 100;
    final int MIN_CHANNEL = 1;
    void turnOnOff() {
        if(isPowerOn=true){
            isPowerOn = false;
        }
        else{
            isPowerOn = true;
        }
    }
    void volumeUp() {
        if(volume<MAX_VOLUME){
            volume++;
        }
    }
    void volumeDown() {
        if(volume>MIN_VOLUME){
            volume--;
        }
    }
    void channelUp() {
        if(channel==MAX_CHANNEL){
            channel = MIN_CHANNEL;
        }
        else{
            channel++;
        }
    }
    void channelDown() {
        if(channel==MIN_CHANNEL){
            channel = MAX_CHANNEL;
        }
        else{
            channel--;
        }
    }
} // class MyTv
class Exercise6_21 {
    public static void main(String args[]) {
        MyTv t = new MyTv();
        t.channel = 100;
        t.volume = 0;
        System.out.println("CH:"+t.channel+", VOL:"+ t.volume);
        t.channelDown();
        t.volumeDown();
        System.out.println("CH:"+t.channel+", VOL:"+ t.volume);
        t.volume = 100;
        t.channelUp();
        t.volumeUp();
        System.out.println("CH:"+t.channel+", VOL:"+ t.volume);
    }
}

class Exercise6_22 {
    static boolean isNumber(String str){
        boolean b = true;

        for(int i=0; i<str.length(); i++){
            if(!('0'<=str.charAt(i) && str.charAt(i)<='9')){
                b = false;
            }
        }
        return b;
    }
    public static void main(String[] args) {
        String str = "123";
        System.out.println(str+" 는 숫자입니까? "+isNumber(str));
        str = "1234o";
        System.out.println(str+" 는 숫자입니까? "+isNumber(str));
    }
}

class Exercise6_23{
    static int max(int[] data){
        if(data==null || data.length==0){
            return -999999;
        }
        else{
            int max = data[0];
            for(int i=0; i<data.length; i++){
                if(max<data[i]){
                    max = data[i];
                }
            }
            return  max;
        }
    }
    public static void main(String[] args){
        int[] data = {3,2,9,4,7};
        System.out.println(java.util.Arrays.toString(data));
        System.out.println("최대값 :"+max(data));
        System.out.println("최대값 :"+max(null));
        System.out.println("최대값 :"+max(new int[]{})); // 크기가 0인 배열
    }
}

class Exercise6_24{
    static int abs(int value){
        return Math.abs(value);
    }
    public static void main(String[] args)    {
        int value = 5;
        System.out.println(value+"의 절대값 :"+abs(value));
        value = -10;
        System.out.println(value+"의 절대값 :"+abs(value));
    }
}