public class ch6_2 {
}

class SutdaCard11{
    int num;
    boolean isKwang;

    //생성자 공식 : 1. 생성자 이름 = 클래스 이름  2. return 값 없음

    //매개변수 있는 생성자 작성
    SutdaCard11(int num, boolean isKwang){
        //iv는 매개변수 lv의 값을 가진다.
        this.num = num;
        this.isKwang = isKwang;
    }

    //매개변수 없는 생성자 작성
    SutdaCard11(){
        //lv가 없다! iv는 값을 못가졌는데! 그럼 iv를 맨 처음 값(초기값)을 만들어주자.
//        num = 1;
//        isKwang = true;

        //매개변수 있는 생성자대로 행동할거 아니야. 그럼 초기값은 더 압축할 수 있어
        this(1, true);
    }

    //method info 구현해주기 매개변수 안넣었네 그럼 똑같이 매개변수 없애자.
    String info(){
        if(isKwang==false){
            return num+"";
        }
        else{
            return num+"K";
        }
    }
}

class Exercise6_222 {
    public static void main(String args[]) {
        SutdaCard11 card1 = new SutdaCard11(3, false);
        SutdaCard11 card2 = new SutdaCard11();
        System.out.println(card1.info());
        System.out.println(card2.info());
    }
}

class Exercise6_42 {
    public static void main(String args[]) {
        Student22 s = new Student22();
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
class Student22{
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
        return Math.round(getTotal()/3.0*10)/10f;
    }
}

class Exercise6_52 {
    public static void main(String args[]) {
        //new int[]로 새로운 배열로 같은 int끼리 묶었다
        Student33 s = new Student33("홍길동", new int[]{1, 1, 100, 60, 76});
        System.out.println(s.info());
    }
}
class Student33 {
    // rough한 코딩 이제 조금씩 다듬어보자.
//    String iv1;
//    int iv2;
//    int iv3;
//    int iv4;
//    int iv5;
//    int iv6;

    String name;
    int[] iv = new int[5];

//    Student33(String iv1, int iv2, int iv3, int iv4, int iv5, int iv6){
//        this.iv1 = iv1;
//        this.iv2 = iv2;
//        this.iv3 = iv3;
//        this.iv4 = iv4;
//        this.iv5 = iv5;
//        this.iv6 = iv6;
        Student33(String name, int[] iv){
            this.name = name;
            for(int i=0; i<iv.length; i++){
                this.iv[i] = iv[i];
            }
    }

    String info(){
//        return iv1+","+iv2+","+iv3+","+iv4+","+iv5+","+iv6;
             //지역변수 answer를 이름을 기본값으로 받고
            String answer = name;
            //이것은 합과 평균을 구하기위한 기본값이다.
            int sum = 0;
            // 남은 iv를 toString으로 받으며 중간에 ,를 넣어서 answer에 이어붙인다.
            for(int i=0; i<iv.length; i++){
                answer = answer + "," + Integer.toString(iv[i]);
                //중복을 막기위해 2부터는 합과 평균치를 구하는 값으로 if문으로 나눴다.
                if(i>=2){
                    sum = sum + iv[i];
                }
            }

            return answer+","+Integer.toString(sum)+","+((Math.round(sum/3.0*10.0))/10.0);
    }
}

class Exercise6_62 {
    // (x,y) (x1,y1) . 두 점 와 간의 거리를 구한다
    static double getDistance(int x, int y, int x1, int y1) {
        return Math.sqrt(Math.pow(x1-x,2)+Math.pow(y1-y,2));
    }
    public static void main(String args[]) {
        System.out.println(getDistance(1,1,2,2));
    }
}

class MyPoint2 {
    int x;
    int y;
    MyPoint2(int x, int y) {
        this.x = x;
        this.y = y;
    }
    //메서드 반환타입 : double , 메서드명 : getDistance, 매개변수ㅇ : int,int
    double getDistance(int x, int y){
        // p와 2.2의 간의 거리이다.
        // p는 MyPoint2의 객체이다.
        // 객체의 iv를 가져와야하니 static 메서드는 안된다.
        // iv 가져오니 this.iv를 써도 된다.
        return Math.sqrt(Math.pow(this.x-x,2)+Math.pow(this.y-y,2));
    }
}
class Exercise6_72 {
    public static void main(String args[]) {
        MyPoint2 p = new MyPoint2(1,1);
        System.out.println(p.getDistance(2,2));
    }
}

class Exercise6_200{
    static int[] shuffle(int[] arr){
        for(int i=0; i<arr.length; i++){
            int j = (int)(Math.random()*arr.length);

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        return arr;
    }
    public static void main(String[] args)
    {
        int[] original = {1,2,3,4,5,6,7,8,9};
        System.out.println(java.util.Arrays.toString(original));
        int[] result = shuffle(original);
        System.out.println(java.util.Arrays.toString(result));
    }
}

class MyTv2 {
    boolean isPowerOn;
    int channel;
    int volume;
    final int MAX_VOLUME = 100;
    final int MIN_VOLUME = 0;
    final int MAX_CHANNEL = 100;
    final int MIN_CHANNEL = 1;
    void turnOnOff() {
        if(isPowerOn==false){
            isPowerOn = true;
        }
        else{
            isPowerOn = false;
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
class Exercise6_212 {
    public static void main(String args[]) {
        MyTv2 t = new MyTv2();
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

class Exercise6_2222 {
    static boolean isNumber(String str){
        for(int i=0; i<str.length(); i++){
            // 0에서 9 숫자 사이에 들어가면 패스시킨다.
            if('0'<=str.charAt(i) && str.charAt(i)<='9'){
                continue;
            }
            //만약 0~9사이의 숫자가 아닌 다른 것이라면 즉시 stop하고 false를 반환한다.
            else{
                return false;
            }
        }
        //만약 else에서 걸러지지않았다면 for문을 통해 나오는 것은 아무것도 없을 것이다. 그럼 true를 반환하자.
        return true;
    }
    public static void main(String[] args) {
        String str = "123";
        System.out.println(str+"는 숫자입니까 ? "+isNumber(str));
        str = "1234o";
        System.out.println(str+"는 숫자입니까 ? "+isNumber(str));
    }
}

class Exercise6_232{
    static int max(int[] arr){
        // null 또는 크기가 0 둘 다 같은 결과값이라서 합칠 수 있다.
        if(arr==null || arr.length==0){
            return -999999;
        }
        else{
            //아닐경우는 길이가 있다는거니 최댓값 구하는 공식 이용
            int max = arr[0];
            for(int i=0; i<arr.length; i++){
                if(max<arr[i]){
                    max = arr[i];
                }
            }
            return max;
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

class Exercise6_242{
    static int abs(int value){
        return Math.abs(value);
    }
    public static void main(String[] args)
    {
        int value = 5;
        System.out.println(value+"의 절대값 :"+abs(value));
        value = -10;
        System.out.println(value+"의 절대값 :"+abs(value));
    }
}