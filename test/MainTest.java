import org.junit.Test;

import static org.junit.Assert.*;

    class Card {
        int kind;
        int number;
        Card(int kind, int number){
            this.kind = kind;
            this.number = number;
        }

        Card() {this(1,1);}

        public String toString() {
            return String.format("[%d, %d]", kind, number);
        }
    }

    public class MainTest {
        public static String rankCheck(Card[] cArr) {
            int[] cntArr = new int[14]; // 0~13
            for(int i=0;i<cArr.length;i++)
                cntArr[cArr[i].number]++;

            int pairCnt =0;
            boolean isFourCard = false;
            boolean isThreeCard = false;

            for (int i = 0; i < cntArr.length; i++) {
                if(cntArr[i]==4) isFourCard = true;
                if(cntArr[i]==3) isThreeCard = true;
                if(cntArr[i]==2) pairCnt++;
            }

            boolean num = true;
            int number = 0;
            for(int i=0; i<cntArr.length; i++){
                if(cntArr[i]==1){
                    number = i;
                    break;
                }
            }
            for(int i=number; i<number+5; i++){
                if(cntArr[i]!=1){
                    num = false;
                }
            }

            boolean kind = true;
            for(int i=1; i<cArr.length; i++){
                if(cArr[0].kind!=cArr[i].kind){
                    kind = false;
                }
            }

            if(kind==true && num==true){
                return "STRAIGHT FLUSH";
            }
            else if(kind==true && num==false){
                return "FLUSH";
            }
            else if(kind==false && num==true){
                return "STRAIGHT";
            }

            if(isFourCard==true){
                return "FOUR CARD";
            }
            else if(isThreeCard==true){
                if(pairCnt==0){
                    return "THREE CARD";
                }
                else{
                    return "FULL HOUSE";
                }
            }
            else if(isFourCard==false && isThreeCard==false){
                if(pairCnt==2){
                    return "TWO PAIR";
                }
                else if(pairCnt==1){
                    return "ONE PAIR";
                }
            }

            return "DIE";
        }
        @Test
        public void straightTest1() {
            Card[] cArr = {
                    new Card(1,1),
                    new Card(1,2),
                    new Card(1,3),
                    new Card(2,4),
                    new Card(2,5),
            };
            assertTrue(rankCheck(cArr).equals("STRAIGHT"));
        }
        @Test
        public void straightTest2() {
            Card[] cArr = {
                    new Card(1,5),
                    new Card(1,6),
                    new Card(1,4),
                    new Card(2,7),
                    new Card(2,8),
            };
            assertTrue(rankCheck(cArr).equals("STRAIGHT"));
        }
        @Test
        public void straightTest3() {
            Card[] cArr = {
                    new Card(1,1),
                    new Card(1,1),
                    new Card(1,1),
                    new Card(2,1),
                    new Card(2,8),
            };
            assertTrue(rankCheck(cArr).equals("FOUR CARD"));
        }
        @Test
        public void straightTest4() {
            Card[] cArr = {
                    new Card(1,1),
                    new Card(1,8),
                    new Card(1,1),
                    new Card(2,1),
                    new Card(2,8),
            };
            assertTrue(rankCheck(cArr).equals("FULL HOUSE"));
        }
        @Test
        public void straightTest5() {
            Card[] cArr = {
                    new Card(1,1),
                    new Card(1,3),
                    new Card(1,1),
                    new Card(2,1),
                    new Card(2,8),
            };
            assertTrue(rankCheck(cArr).equals("THREE CARD"));
        }
        @Test
        public void straightTest6() {
            Card[] cArr = {
                    new Card(1,1),
                    new Card(1,3),
                    new Card(1,3),
                    new Card(2,1),
                    new Card(2,8),
            };
            assertTrue(rankCheck(cArr).equals("TWO PAIR"));
        }
        @Test
        public void straightTest7() {
            Card[] cArr = {
                    new Card(1,1),
                    new Card(1,3),
                    new Card(1,6),
                    new Card(2,1),
                    new Card(2,8),
            };
            assertTrue(rankCheck(cArr).equals("ONE PAIR"));
        }
        @Test
        public void straightTest8() {
            Card[] cArr = {
                    new Card(1,1),
                    new Card(1,3),
                    new Card(1,7),
                    new Card(1,6),
                    new Card(1,8),
            };
            assertTrue(rankCheck(cArr).equals("FLUSH"));
        }
        @Test
        public void straightTest9() {
            Card[] cArr = {
                    new Card(1,1),
                    new Card(2,3),
                    new Card(1,2),
                    new Card(1,4),
                    new Card(1,5),
            };
            assertTrue(rankCheck(cArr).equals("STRAIGHT"));
        }
        @Test
        public void straightTest10() {
            Card[] cArr = {
                    new Card(1,1),
                    new Card(1,3),
                    new Card(1,2),
                    new Card(1,4),
                    new Card(1,5),
            };
            assertTrue(rankCheck(cArr).equals("STRAIGHT FLUSH"));
        }
}