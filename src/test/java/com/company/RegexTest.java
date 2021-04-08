package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.Test;

public class RegexTest {
    @Test
    public void regexTrimNumberAtTheEnd(){
        final String s = "test vac111";
        System.out.println(s.replaceAll("[0-9]+$", " ").trim());
    }

    @Test
    public void testPattern() {
        final Pattern pattern = Pattern.compile("new", Pattern.UNICODE_CASE);
        final Matcher matcher = pattern.matcher("new world..!!!");
        if (matcher.find()) {
            System.out.println("found");
        }
    }

    @Test
    public void testPatternFromNextCount() {
        final Pattern pattern = Pattern.compile("new", Pattern.UNICODE_CASE);
        final Matcher matcher = pattern.matcher("new world..!!! new");
        // the number input is index of the string from where it should start
        if (matcher.find(16)) {
            System.out.println("found");
        } else {
            System.out.println("Not found");
        }
    }

    @Test
    public void testPatternMatches() {
        final Pattern pattern = Pattern.compile("new", Pattern.UNICODE_CASE);
        final Matcher matcher = pattern.matcher("new");
        // checks whether exact match happened or not between pattern and input
        if (matcher.matches()) {
            System.out.println("matches");
        }
    }

    @Test
    public void testPatternFindStartEndIndex() {
        final Pattern pattern = Pattern.compile("new", Pattern.UNICODE_CASE);
        final Matcher matcher = pattern.matcher("hello new world new ");
        // loop it and then find it
        while (matcher.find()) {
            System.out.println("Matcher group: "+ matcher.group());
            System.out.println(matcher.start());
            System.out.println(matcher.end());
        }
    }
}