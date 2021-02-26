package com.company;

import org.junit.Test;

public class ThreadTests {
    @Test
    public void getNumberOfCores() {
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
