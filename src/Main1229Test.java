import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Main1229Test {
    public int mid(int x, int y, int z){
        //   3개의 변수 합   -   최댓값                 - 최솟값                = 중간값
        return (x+y+z)-Math.max(Math.max(x,y),z)-Math.min(Math.min(x,y),z);
    }

    @Test
    public void mid1() {
        assertTrue(mid(1,2,3)==2);
    }

    @Test
    public void mid2() {
        assertTrue(mid(1,1,1)==1);
    }

    @Test
    public void mid3() {
        assertTrue(mid(2,3,1)==2);
    }

    @Test
    public void mid4() {
        assertTrue(mid(2,1,1)==1);
    }

}