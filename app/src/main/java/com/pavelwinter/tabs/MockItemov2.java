package com.pavelwinter.tabs;

import android.support.annotation.IntRange;

import java.util.Comparator;

/**
 * Created by newuser on 08.03.2017.
 */

public class MockItemov2 {


    String header;
    String describing;
    int priority;

    public MockItemov2(String header, String describing, int priority) {
        this.header = header;
        this.describing = describing;
        this.priority = priority;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getDescribing() {
        return describing;
    }

    public void setDescribing(String describing) {
        this.describing = describing;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(@IntRange(from=0,to=2) int priority) {
        this.priority = priority;
    }





    public static  class TuneOutput implements Comparator<MockItemov2> {
        @Override
        public int compare(MockItemov2 o1, MockItemov2 o2) {
            return (int) o1.getPriority()-o2.getPriority();
        }
    }


}
