package tdd;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.*;
/**
 * Created by DoDo on 2017-06-13.
 */
public class AssertTest {
    @Test
    public void testAssertArrayEquals(){
        byte[] expected = "HelloWorld".getBytes();
        byte[] actual = "Hello,World!".getBytes();
        String reason = "failure - two arraies are not same byte array";
        assertArrayEquals(reason,expected,actual);
    }
    //same은 같은 객체(메모리 주소)를 의미한다.
    @Test
    public void testAssertNotSame(){
        Object expected = new Object();
        Object actual = new String();
        String reason = "failure -  two different ojects";
        assertNotSame(reason,expected,actual);
    }
    @Test
    public void testAssertThats(){
        String reason = "failure - matcher return false";
        String subj = "HelloWorld";
        //both().and() 영어 문법처럼
        assertThat(reason,subj,both(containsString("Hello")).and(containsString("World")));
        //리스트의 아이템이 Kim과 Lee를 가지고 있을 경우 성공
        assertThat(reason, Arrays.asList(new String[]{"Kim","Shin","Nam"}),hasItems("kim","Lee"));
        //리스트의 아이템이 모두 문자열 N을 가지고 있을 경우
        assertThat(reason, Arrays.asList(new String[] {"Kim","Shin","Nam"}),everyItem(containsString("N")));

        assertThat(reason,subj,allOf(equalTo(startsWith("Hello")),endsWith("World")));
        //적어도 하나는 실패해야 테스트 성공
        assertThat(reason,subj,not(allOf(equalTo("ByeWorld"),startsWith("World"))));
        assertThat(reason,subj, anyOf(equalTo("HelloWorld"),endsWith("Worlds!")));
    }
}
