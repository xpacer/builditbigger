package com.udacity.gradle.builditbigger;

import android.text.TextUtils;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class EndpointsAsyncTaskTest {

    private CountDownLatch signal = null;
    private String stringResult;

    @Before
    public void setUp() {
        signal = new CountDownLatch(1);
    }

    @After
    public void tearDown() {
        signal.countDown();
    }

    @Test
    public void asyncTaskShouldReturnString() throws InterruptedException {
        EndpointsAsyncTask task = new EndpointsAsyncTask(new EndpointsAsyncTask.TaskListener() {
            @Override
            public void onTaskComplete(String result) {
                stringResult = result;
                signal.countDown();
            }
        });
        task.execute();
        signal.await();

        assertNotNull(stringResult);
        assertFalse(TextUtils.isEmpty(stringResult));
    }

}