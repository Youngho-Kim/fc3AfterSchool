package tdd;
import org.junit.*;

import static org.junit.Assert.*;


/**
 * Created by DoDo on 2017-06-13.
 */
public class TestSamples  {
    int before = 0;
    int after = 0;
    int test = 0;
    static int sBefore = 0;
    static int sAfter = 0;

    {
        // 테스트의 개수 만큼 인스턴스를 만들어서 실행한다.
        System.out.println("create instance");
    }

    //BeforeClass와 AfterClass는 static 메소드로 해당 테스트 클래스가 처음 실행 될 때 1회(BeforeClass), 그리고 완전 종료될 때 1회(AfterClass) 실행된다
    @BeforeClass
    public static void classInitialize(){

    }
    //Before와 After는 매 테스트마다 1회씩 실행된다.
    @Before
    public void initialize(){
        before++;
        sBefore++;
        System.out.println("initialize");
    }
    //테스트 만큼 인스턴스가 생성되며 인스턴스에는 하나의 테스트가 존재한다.
    //메개변수와 반환 값을 넣을 수 없다
    @Test
    public void testSampleMethod1(){
        System.out.println("Calculate First");
        assertTrue(true);
    }
    @Test
    public void testSampleMethod2(){
        System.out.println("Calculate Second");
        assertTrue(true);
    }
    @After
    public void finalize(){
        after++;
        sAfter++;
        System.out.println("finalize..");
        System.out.printf("before: %d, sBefore: %d, after: %d, sAfter: %d, test: %d%n",before,sBefore,after,sAfter,test);
    }
    @AfterClass
    public static void finalizeClass(){
        if(sAfter<5){
            // 테스트를 이런 방식으로 실행할 수도 있음
            org.junit.runner.JUnitCore.runClasses(TestSamples.class);
        }
    }
}
