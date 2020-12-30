import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class Main1229_2Test {

    public String tf(int[] arr1, int[] arr2) {
        //equals 이용하여 if문(같을 시) 만족시 같습니다 출력
        if(Arrays.equals(arr1, arr2)){
            return "같습니다.";
        }
        //그 외는 다른 경우 뿐이기에 다릅니다 출력
        else {
            return "다릅니다.";
        }
    }

    @Test
    public void tf1() {
        //도저히 배열을 어떻게 검사해야하는지 모르겠다... 그래서 boolean을 이용하기로 함.
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {1,2,3,4,5};
        // boolean으로 미리 두 객체가 true인지 false인지 해놓는다.
        Boolean answer = Arrays.equals(arr1,arr2);
        //boolean과 method 값이 일치하는지 확인한다.
        assertTrue(answer==true);
    }

    @Test
    public void tf2() {
        int[] arr1 = {1,2,4,5,6};
        int[] arr2 = {1,2,3,5,6};
        Boolean answer = Arrays.equals(arr1,arr2);
        assertTrue(answer==false);
    }

    @Test
    public void tf3() {
        int[] arr1 = {1,3,2,5,6};
        int[] arr2 = {1,2,3,5,6};
        // arr1[1]과 arr2[1]의 값이 일치하지않는다.(각 배열 위치의 값까지 같아야한다.)
        Boolean answer = Arrays.equals(arr1,arr2);
        assertTrue(answer==false);
    }


    public int same(int[] arr1, int[] arr2) {
        // 그럼 arr1,arr2의 길이로 설정하면 오류나기때문에 각 배열의 최댓값을 찾아내야함.
        int max1 = arr1[0];
        int max2 = arr2[0];

        for(int i=0; i<arr1.length; i++){
            if(max1<arr1[i]){
                max1 = arr1[i];
            }
        }
        for(int i=0; i<arr2.length; i++){
            if(max2<arr2[i]){
                max2 = arr2[i];
            }
        }

        //arr1 인덱스 값의 최댓값이 예를 들어 5라면, count1[5]까지 있어야하므로 길이는 그것보다 1 크게 설정해야함.
        int[] count1 = new int[max1+1];
        int[] count2 = new int[max2+1];

        // 카운팅 정렬을 한다.(여기에서 for를 굳이 2번 쓴 이유는 혹시라도 두 배열이 길이를 다르게 입력할 수 있기 때문이다.
        for(int i=0; i<arr1.length; i++){
            count1[arr1[i]]++;
        }
        for(int i=0; i<arr2.length; i++){
            count2[arr2[i]]++;
        }

        int sum = 0;
        //arr1과 arr2의 index 최고번호가 작은쪽으로 해야한다.(큰쪽으로하면 작은쪽에서 index가 없기 때문에 에러가 날거라고 예상한다)
        for(int i=0; i<Math.min(count1.length, count2.length); i++){
            if(count1[i]!=0 && count2[i]!=0){
                // 두 index의 값이 0이 아니라면 겹치는 부분이 있는거고,
                // 만약 중복이 허용된다고해도 Math.min을 통해 작은 수를 더하면 정확하게 겹치는 수량만큼만 계산 될 것이다.
                sum = sum + Math.min(count1[i], count2[i]);
            }
        }
        return sum;
    }

    @Test
    public void same1() {
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {1,2,3,4,5};
        assertTrue(same(arr1, arr2)==5);
    }

    @Test
    public void same2() {
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {1,2,3,4,6};
        assertTrue(same(arr1, arr2)==4);
    }

    @Test
    public void same3() {
        int[] arr1 = {1,72,3,44,5};
        int[] arr2 = {1,2,33,4,65};
        assertTrue(same(arr1, arr2)==1);
    }

    @Test
    public void same4() {
        int[] arr1 = {1,1,1,2,1};
        int[] arr2 = {1,1,1,2,2};
        assertTrue(same(arr1, arr2)==4);
    }

    public String baseball(int[] arr1, int[] arr2) {
        int S = 0;
        int B = 0;

        for(int i=0; i<arr1.length; i++){
            for(int j=0; j<arr2.length; j++){
                // S의 조건(위치, 값 모두 같아야함)
                if(arr1[i]==arr2[j] && i==j){
                    S++;
                }
                // else로 하면 모든 조건이 전부 B로 들어간다. 그렇기에 else if로 조건을 걸어야한다.
                else if(arr1[i]==arr2[j] && i!=j){
                    B++;
                }
            }
        }

        String answer = S+"S"+B+"B";
        return answer;
    }

    @Test
    public void baseball1() {
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {5,4,3,2,1};
        assertTrue(baseball(arr1, arr2).equals("1S4B"));
    }

    @Test
    public void baseball2() {
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {1,2,3,7,8};
        assertTrue(baseball(arr1, arr2).equals("3S0B"));
    }

    @Test
    public void baseball3() {
        int[] arr1 = {1,3,5,7,9};
        int[] arr2 = {2,4,6,8,10};
        assertTrue(baseball(arr1, arr2).equals("0S0B"));
    }
}