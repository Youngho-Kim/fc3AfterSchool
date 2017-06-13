package tdd;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by DoDo on 2017-06-13.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({AssertTest.class,TestSamples.class})
public class SuiteTest {
    public static int numbOfTest = 0;
    @BeforeClass
    public static void beforeSuite(){
        System.out.print("Suite starts");
    }
    //안됨
//    @Before
//    public void beforeTest(){
//        System.out.printf("testNumb: %s %n",++numbOfTest);
//    }
    @AfterClass
    public static void afterSuite(){
        System.out.print("Suite ends");
    }
}
