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
class Exercise7_5 {
    public static void main(String[] args) {
        Tv t = new Tv();
    }
}