package com.company;

import java.util.function.BiPredicate;
import org.junit.Test;

public class Java8Features {
    @Test
    public void BiPredicate() {
        System.out.println(equalPredicate().test("abcd", "adbc"));
    }

    private BiPredicate<String, String> equalPredicate() {
        return (a, b) -> a.contains("a") && b.contains("b");
    }
}
