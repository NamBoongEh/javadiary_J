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
