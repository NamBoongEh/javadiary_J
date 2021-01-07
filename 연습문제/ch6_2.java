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
