package kr.co.fastcampus.advancedandroid;

import android.app.Activity;
import android.content.Context;

import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Created by DoDo on 2017-06-14.
 */
@RunWith(MockitoJUnitRunner.class)
public class SpyMock {
    @Spy
    private Context context = new Activity();
}
