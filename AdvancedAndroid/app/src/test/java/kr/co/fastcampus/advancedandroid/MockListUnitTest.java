package kr.co.fastcampus.advancedandroid;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import java.util.List;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by DoDo on 2017-06-14.
 */
@RunWith(MockitoJUnitRunner.class)
public class MockListUnitTest {
    //mock()방식으로 mock을 만들 수 있음
    List mockedList = mock(List.class);
    //mock 객체기 때문에 실제로는 아무것도 일어나지 않음.
    @Test
    public void verifyUnoperateable(){
        mockedList.add(new Object());
        assertThat(mockedList.size(),not(is(0)));
    }

    @Test
    public void testList(){
        mockingList();
        String result = (String)mockedList.get(0);
        //메소드 실행 여부 확인 가능
        //mockedList 의 get(0)이 1회 실행되었는지 확인
        verify(mockedList,times(1)).get(0);
        //모든 int에 대해 get(0)이 호출됨을 확인함
        verify(mockedList,times(1)).get(anyInt());
        assertThat(result, is("string"));
    }

    private void mockingList(){
        // Mock 객체는 기본적으로 모든 메소드에 기본 값을 반환함, null 기본 자료형 원형 등등
        when(mockedList.get(0)).thenReturn("string");
    }
}
