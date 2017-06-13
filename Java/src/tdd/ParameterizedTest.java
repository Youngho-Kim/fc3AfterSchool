package tdd;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.model.TestTimedOutException;

import java.util.Arrays;
import java.util.Collection;

/**
 * 많은 수의 경우의 수를 테스트 하는 것은 좋은 품질의 테스트 시나리오을 만드는 좋은 방법이 될 수 있습니다.
 * 이를 위해서 다양한 데이터를 사용해야하는데 이를 간편하게 해주는 Parameterized를 사용해보겠습니다.
 *
 * 각각의 테스트는 자기만의 독립적인 인스턴스를 갖습니다.
 *
 */
//여러 경우의 수를 만들어서 테스트

@RunWith(Parameterized.class)
public class ParameterizedTest {
    //3. 케이스에서 사용할 전역변수를 선언한다.
    String mLabel, mValue;

    //1. 각각의 경우의 수가 사용할 케이스 데이터를 반환하는 메소드를 만든다
    @Parameterized.Parameters
    public static Collection data(){
        return Arrays.asList(new Object[][]{
                {"parameter1","value1"},{"parameter2", "value2"},{"parameter3", "value3"}
        });
    }

    //3. 위 Parameterized.Parameters의 반환 컬렉션과 동일한 구조를 갖는 생성자를 만들어야 한다
    public ParameterizedTest(String label, String value){
       mLabel = label;
       mValue = value;
    }

    public static int numbOfTestInstances = -1;
    {
        numbOfTestInstances++;
    }
    //여전히 매개변수를 받지는 못한다.
    @Before
    public void beforeTest(){
        System.out.println(numbOfTestInstances + " test case start");
    }
    @Test(timeout = 2000)
    public void TestCase(){
        try {
            //일부로 케이스 실패 만들기
            Thread.sleep(1000*numbOfTestInstances);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("%s:%s%n",mLabel,mValue);
    }
    @After
    public void afterTest(){
        System.out.println("test case end");
    }

}