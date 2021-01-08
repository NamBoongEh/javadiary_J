import org.junit.Test;

import java.util.Objects;

import static org.junit.Assert.*;

class Card{
    int kind;
    int number;
    Card(int kind, int number){
        this.kind = kind;
        this.number = number;
    }
    Card(){
        this(1,1);
    }

    public String toString(){
        return String.format("[%d, %d]", kind, number);
    }
}
public class MainTestTest {
    public static String rankCheck(Card[] cArr) {
//        int[] changeNum = new int[14];
//        int[] changeKind = new int[4];
//
//        for(int i=0; i<cArr.length; i++){
//            changeNum[cArr[i].number]++;
//        }
//
//        for(int i=0; i<cArr.length; i++){
//            changeKind[cArr[i].kind]++;
//        }
//
//
//        // 5개의 배열을 받기위해 String으로 변환해 받을 배열 설정
//        String[] arr = new String[5];
//        for(int i=0; i<5; i++){
//            arr[i] = cArr.toString();
//        }
//
//        // 배열의 charAt으로 kind와 number에 해당하는 부분만 추출
//        int[] num = new int[cArr.length];
//        int[] kind = new int[cArr.length];
//
//        for(int i=0; i< cArr.length; i++){
//            kind[i] = arr[i].charAt(1);
//            num[i] = arr[i].charAt(5);
//        }
//
//        // kind와 num 카운팅 정렬 필요
//        int[] changeKind = new int[cArr.length];
//        int[] changeNum = new int[cArr.length];
//        for(int i=0; i< kind.length; i++){
//            changeKind[kind[i]]++;
//        }
//        for(int i=0; i<num.length; i++){
//            changeNum[num[i]]++;
//        }
//
//        // 123 묶어서 판별          ***switch로 바꿀 수 있을 것 같다. int로 반환해서 1일 경우, 2일 경우, 3일 경우 생성
//        // 1번은 changeNum[i]가 1일때, i ~ i+4까지 계속 1인지 판별
//        //type1(changeNum)
//
//        // 2번은 index 값 중 5가 있다면 해당
//        //type2(changeKind)
//
//        // 3번은 1번과 2번의 교집합
//        if(type1(changeNum)==true && type2(changeKind)==true){
//            return "STRAIGHT FLUSH";
//        }
//        else if(type1(changeNum)==true && type2(changeKind)==false){
//            return "STRAIGHT";
//        }
//        else if(type1(changeNum)==false && type2(changeKind)==true){
//            return "FLUSH";
//        }
//        else{
//            // 45678 묶어서 판별
//            // 가장 좁은 범위부터하면 쉬울 것 같다.
//            return typePair(changeNum);
//        }
//    }
//    static boolean type1(int[] changeNum){
//        for(int i=0; i<changeNum.length; i++){
//            if(changeNum[i]>=2){
//                return false;
//            }
//            else if(changeNum[i]==1){
//                for(int j=1; j<5; j++){
//                    if(changeNum[i+j]!=1){
//                        return false;
//                    }
//                }
//            }
//        }
//
//        return true;
//    }
//    static boolean type2(int[] changeKind){
//        boolean answer = false;
//
//        for(int i=0; i<changeKind.length; i++){
//            if(changeKind[i]==5){
//                answer = true;
//            }
//        }
//
//        return answer;
//    }
//    static String typePair(int[] changeNum){
//        int[] arr = {0, 0, 0, 0};
//        String answer = "DIE";
//
//        // 1개만 같은 것, 2개만 같은 것, 3개만 같은 것 몇 개 씩 있는지 확인
//        for(int i=0; i<changeNum.length; i++){
//            for(int j=0; j<4; j++){
//                if(changeNum[i]==j+1){
//                    arr[j]++;
//                }
//            }
//        }
//
//        // 같은 갯수끼리의 조합에 따른 결과 도출
//        if(arr[0]==1){
//            // 5번
//            if(arr[1]==2){
//                answer = "2 PAIR";
//            }
//            // 7번
//            else if(arr[3]==1){
//                answer = "FOUR CARD";
//            }
//        }
//        else if(arr[1]==1){
//            // 4번
//            if(arr[0]==3){
//                answer = "1 PAIR";
//            }
//            // 8번
//            else if(arr[2]==1){
//                answer = "FULL HOUSE";
//            }
//        }
//        //6번
//        else if(arr[0]==2 && arr[2]==1){
//            answer = "THREE CARD";
//        }
//        else{
//            answer = "DIE";
//        }
//
//        return answer;
//    }
        int[] arr = new int[14];
        for (int i = 0; i < cArr.length; i++) {
            arr[cArr[i].number]++;
        }

        int pair = 0;
        boolean three = false;
//        boolean four = false;
        String answer = "DIE";

        for (int i = 0; i < cArr.length; i++) {
            if (arr[i] == 2) {
                pair++;
            }
        }

        for (int i = 0; i < cArr.length; i++) {
            //4의 경우는 한개뿐이니 그냥 answer에 바로 넣어도 될 것 같다.
            if (arr[i] == 4) {
                answer = "FOUR CARD";
            }
            if (arr[i] == 3) {
                three = true;
                if (three == true && pair == 0) {
                    answer =  "THREE CARD";
                }
                else if (pair >= 1) {
                    if (pair == 1) {
                        answer =  "1 PAIR";
                    } else if (pair == 2) {
                        if (three == true) {
                            answer =  "FULL HOUSE";
                        } else {
                            answer =  "2 PAIR";
                        }
                    }
                }
            }
        }

        // boolean으로 스위치처럼 바뀌게 만들어주자. 둘 다 true가 되면 스트레이트 플러쉬가 될 수 있도록
        boolean samekind = true;
        boolean samenum = true;

        for(int i=0; i<cArr.length; i++){
            if(cArr[0].kind==cArr[i].kind) {
                continue;
            }
            else{
                samekind = false;
                break;
            }
        }
        for(int i=0; i<cArr.length-1; i++){
            if(arr[i]==1 && arr[i+1]==1){
                continue;
            }
            else{
                samenum = false;
                break;
            }
        }

        if(samekind==true && samenum==true){
            answer = "STRAIGHT FLUSH";
        }
        else{
            if(samekind==true){
                answer = "FLUSH";
            }
            else if(samenum==true){
                answer = "STRAIGHT";
            }
        }


        return answer;
    }

    @Test
    public void straightTest1(){
        Card[] cArr = {
                new Card(1, 1),
                new Card(1, 2),
                new Card(1, 3),
                new Card(1, 4),
                new Card(1, 5)
        };
        assertTrue(rankCheck(cArr).equals("STRAIGHT"));
    }

    @Test
    public void straightTest2(){
        Card[] cArr = {
                new Card(1, 5),
                new Card(1, 6),
                new Card(1, 7),
                new Card(1, 8),
                new Card(1, 9)
        };
        assertTrue(rankCheck(cArr).equals("STRAIGHT"));
    }
}