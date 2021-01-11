import java.util.Arrays;

public class ch7 {
}

class SutdaDeck {
    final int CARD_NUM = 20;
    SutdaCard2[] cards = new SutdaCard2[CARD_NUM];
    SutdaDeck() {
        for(int i=0; i< cards.length; i++){
            int num = i%10+1;
            boolean isKwang = (i<10) && (num==1 || num==3 || num==8);
            cards[i] = new SutdaCard2(num, isKwang);
        }
    }
}
class SutdaCard2 {
    int num;
    boolean isKwang;
    SutdaCard2() {
        this(1, true);
    }
    SutdaCard2(int num, boolean isKwang) {
        this.num = num;
        this.isKwang = isKwang;
    }
    // info() 대신 Object 클래스의 toString()을 오버라이딩했다
    public String toString() {
        return num + ( isKwang ? "K":"");
    }
}
class Exercise7_1 {
    public static void main(String args[]) {
        SutdaDeck deck = new SutdaDeck();
        for(int i=0; i < deck.cards.length;i++)
            System.out.print(deck.cards[i]+",");
    }
}


class SutdaDeck3 {
    final int CARD_NUM = 20;
    SutdaCard3[] cards = new SutdaCard3[CARD_NUM];
    SutdaDeck3() {
        for(int i=0;i < cards.length;i++) {
            int num = i%10+1;
            boolean isKwang = (i < 10)&&(num==1||num==3||num==8);
            cards[i] = new SutdaCard3(num,isKwang);
        }
    }
    void shuffle(){
        for(int i=0; i<cards.length; i++){
            int j = (int)(Math.random()*cards.length);
            SutdaCard3 temp = cards[i];
            cards[i] = cards[j];
            cards[j] = temp;
        }
    }
    SutdaCard3 pick(int index){
        return cards[index];
    }
    SutdaCard3 pick(){
        return pick((int)(Math.random()* cards.length));
    }
} // SutdaDeck3
class SutdaCard3 {
    int num;
    boolean isKwang;
    SutdaCard3() {
        this(1, true);
    }
    SutdaCard3(int num, boolean isKwang) {
        this.num = num;
        this.isKwang = isKwang;
    }
    public String toString() {
        return num + ( isKwang ? "K":"");
    }
}
class Exercise7_2 {
    public static void main(String args[]) {
        SutdaDeck3 deck = new SutdaDeck3();
        System.out.println(deck.pick(0));
        System.out.println(deck.pick());
        deck.shuffle();
        for(int i=0; i < deck.cards.length;i++)
            System.out.print(deck.cards[i]+",");
        System.out.println();
        System.out.println(deck.pick(0));
    }
}

class Product
{
    int price; // 제품의 가격
    int bonusPoint; // 제품구매 시 제공하는 보너스점수
    Product(){}
    Product(int price) {
        this.price = price;
        bonusPoint =(int)(price/10.0);
    }
}
class Tv extends Product {
    Tv() {}
    public String toString() {
        return "Tv";
    }
}

class MyTv22 {
    // 아무곳에서도 못건들이게 이 클래스에서만 쓸 수 있는 private으로 바꾼다.
    private boolean isPowerOn;
    private int channel;
    private int volume;
    // 이전 채널 보관소
    private int PrevChannel;
    final int MAX_VOLUME = 100;
    final int MIN_VOLUME = 0;
    final int MAX_CHANNEL = 100;
    final int MIN_CHANNEL = 1;



    // 셋팅을 해야한다. 메서드는 어디에서든 접근할 수 있도록하라고했으니 public 제일 높은걸로 해준다.
    public int setChannel(int channel){
        if(channel>=MIN_CHANNEL && channel<=MAX_CHANNEL) {
            PrevChannel = this.channel;
            this.channel = channel;
        }
        return this.channel;
    }
    public int setVolume(int volume){
        if(volume>=MIN_VOLUME && volume<=MAX_VOLUME) {
            this.volume = volume;
        }
        return this.volume;
    }

    void gotoPrevChannel(){
        setChannel(PrevChannel);
    }

    // 받은 체널값과 볼륨값을 되돌려준다.
    public int getChannel(){
        return channel;
    }
    public int getVolume(){
        return volume;
    }

}
class Exercise7_10 {
    public static void main(String args[]) {
        MyTv22 t = new MyTv22();
        t.setChannel(10);
        System.out.println("CH:"+t.getChannel());
        t.setVolume(20);
        System.out.println("VOL:"+t.getVolume());

        t.setChannel(10);
        System.out.println("CH:"+t.getChannel());
        t.setChannel(20);
        System.out.println("CH:"+t.getChannel());
        t.gotoPrevChannel();
        System.out.println("CH:"+t.getChannel());
        t.gotoPrevChannel();
        System.out.println("CH:"+t.getChannel());
    }
}

class SutdaCard22 {
    final int num;
    final boolean isKwang;
    SutdaCard22() {
        this(1, true);
    }
    SutdaCard22(int num, boolean isKwang) {
        this.num = num;
        this.isKwang = isKwang;
    }
    public String toString() {
        return num + ( isKwang ? "K":"");
    }
}
class Exercise7_14 {
    public static void main(String args[]) {
        SutdaCard card = new SutdaCard(1, true);
    }
}

class Marine2 extends Unit { // 보병
    void move(int x, int y) {
        // 지정 위치로 이동
    }
    void stimPack() { /* 스팀팩을 사용한다.*/}
}
class Tank extends Unit { // 탱크
    void move(int x, int y) {
        // 지정 위치로 이동
    }
    void changeMode() { /* 공격모드를 변환한다. */}
}
class Dropship extends Unit { // 수송선
    void move(int x, int y) {
        // 지정 위치로 이동
    }
    void load() { /* 선택된 대상을 태운다.*/ }
    void unload() { /* 선택된 대상을 내린다.*/ }
}
abstract class Unit{
    int x, y; // 현재 위치
    abstract void move(int x, int y);
    void stop() { /* 현재 위치에 정지 */ }
}

class Exercise7_18 {
    static void action(Robot r){
            if(r instanceof DanceRobot){
                ((DanceRobot) r).dance();
            }
            else if(r instanceof SingRobot){
                ((SingRobot) r).sing();
            }
            else if(r instanceof DrawRobot){
                ((DrawRobot) r).draw();
            }
    }
    public static void main(String[] args) {
        Robot[] arr = { new DanceRobot(), new SingRobot(), new DrawRobot()};
        for(int i=0; i< arr.length;i++)
            action(arr[i]);
    } // main
}
class Robot {}
class DanceRobot extends Robot {
    void dance() {
        System.out.println("춤을 춥니다.");
    }
}
class SingRobot extends Robot {
    void sing() {
        System.out.println(" 노래를 합니다.");
    }
}
class DrawRobot extends Robot {
    void draw() {
        System.out.println(" 그림을 그립니다.");
    }
}


class Exercise7_19 {
    public static void main(String args[]) {
        Buyer b = new Buyer();
        b.buy(new Tv2());
        b.buy(new Computer());
        b.buy(new Tv2());
        b.buy(new Audio());
        b.buy(new Computer());
        b.buy(new Computer());
        b.buy(new Computer());
        b.summary();
    }
}
class Buyer {
    int money = 1000;
    Product2[] cart = new Product2[3]; // 구입한 제품을 저장하기 위한 배열
    int i = 0; // Product cart index 배열 에 사용될
    void buy(Product2 p) {
        if(money>= p.price){
            //1.2 , 가진 돈이 충분하면 제품의 가격을 가진 돈에서 빼고
            money = money - p.price;
            //1.3 장바구니에 구입한 물건을 담는다.(add 메서드 호출)
            add(p);
        }
        //1.1 . 가진 돈과 물건의 가격을 비교해서 가진 돈이 적으면 메서드를 종료한다
        else{
            System.out.println("돈이 없당");
            return;
        }

    }
    void add(Product2 p) {
        //1.1 i의 값이 장바구니의 크기보다 같거나 크면
        if(i>=cart.length){
            //1.1.1 2 . 기존의 장바구니보다 2배 큰 새로운 배열을 생성한다
            Product2[] newcart = new Product2[cart.length*2];
            //1.1.2 . 기존의 장바구니의 내용을 새로운 배열에 복사한다
            for(int i=0; i< cart.length; i++){
                newcart[i] = cart[i];
            }

            // 1.1.3 . 새로운 장바구니와 기존의 장바구니를 바꾼다
            cart = newcart;
            //1.2 물건을 장바구니 (cart)에 저장한다 그리고 i의 1값을 증가시킨다
            cart[i] = p;
            i++;
        }
        //카트 자리가 충분하다면 그냥 카트 i번째에 상품을 넣고 i++을 해주자
        else{
            cart[i] = p;
            i++;
        }

    }
    void summary() {
        //1.1 . 장바구니에 담긴 물건들의 목록을 만들어 출력한다
        String list = "";
        //1.2 . 장바구니에 담긴 물건들의 가격을 모두 더해서 출력한다
        int sum = 0;
        for(int i=0; i<cart.length; i++){
            list = list + cart[i] + " ";
            sum = sum + cart[i].price;
        }
        System.out.println(list);
        System.out.println("사용한 금액 : " + sum);

        //1.3  . 물건을 사고 남은 금액(money) 를 출력한다
        System.out.println("남은 금액 : " + money);
    } // summary()
}
class Product2 {
    int price; // 제품의 가격
    Product2(int price) {
        this.price = price;
    }
}
class Tv2 extends Product2 {
    Tv2() { super(100); }
    public String toString() { return "Tv"; }
}
class Computer extends Product2 {
    Computer() { super(200); }
    public String toString() { return "Computer";}
}
class Audio extends Product2 {
    Audio() { super(50); }
    public String toString() { return "Audio"; }
}


abstract class Shape {
    Point2 p;
    Shape() {
        this(new Point2(0,0));
    }
    Shape(Point2 p) {
        this.p = p;
    }
    abstract double calcArea(); // 도형의 면적을 계산해서 반환하는 메서드
    Point2 getPosition() {
        return p;
    }
    void setPosition(Point2 p) {
        this.p = p;
    }
}
class Point2 {
    int x;
    int y;
    Point2() {
        this(0,0);
    }
    Point2(int x, int y) {
        this.x=x;
        this.y=y;
    }
    public String toString() {
        return "["+x+","+y+"]";
    }
}
class Circle extends Shape{
    double r;

    double calcArea() {
        return r*r*3.14;
    }
}
class Rectangle extends Shape{
    double width;
    double height;

    double calcArea(){
        return width*height;
    } // 도형의 면적을 계산해서 반환하는 메서드

    boolean isSquare(){
        if(width==height){
            return true;
        }
        else{
            return false;
        }
    }
}