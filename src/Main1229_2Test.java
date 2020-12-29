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
        int[] arr1 = {1,2,3};
        int[] arr2 = {1,2,3};
        // boolean으로 미리 두 객체가 true인지 false인지 해놓는다.
        Boolean answer = Arrays.equals(arr1,arr2);
        //boolean과 method 값이 일치하는지 확인한다.
        assertTrue(answer==true);
    }

    @Test
    public void tf2() {
        int[] arr1 = {1,2,4};
        int[] arr2 = {1,2,3};
        Boolean answer = Arrays.equals(arr1,arr2);
        assertTrue(answer==false);
    }
}