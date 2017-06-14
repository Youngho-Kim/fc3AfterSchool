package kr.co.fastcampus.advancedandroid;

import android.app.Activity;
import android.content.Context;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.OngoingStubbing;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(MockitoJUnitRunner.class)
public class MockUnitTest {

    private static final String TEST_STRING = "testString";

    @Mock
    Context mContext;

    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testMockContext(){
        //재귀적으로 Mock화 할 수는 없음
        when(mContext.getString(R.string.sample_string)).thenReturn(TEST_STRING);
        //이건 NullPointerException getResources()가 정의되지 않았기 때문
        //when(mContext.getResources().getString(R.string.sample_string)).thenReturn...;
        String testResult = mContext.getString(R.string.sample_string);
        assertThat(testResult,is(TEST_STRING));
    }


}
