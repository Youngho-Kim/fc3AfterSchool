package tdd;

import org.junit.Test;

/**
 * Created by DoDo on 2017-06-13.
 */
public class TimeoutExpectTest {
    // 10초 내에 테스트를 통과하지 못할 경우 테스트 실패로 간주
    //TestTimeOutException 발생
    @Test(timeout = 10000)
    public void testTimeout(){
    }
    // 특정 예외가 발생할 것으로 예상
    // 예외가 발생하지 않으면 오히려 테스트 실패
    @Test(expected = NullPointerException.class)
    public void testExpected(){

    }
}
