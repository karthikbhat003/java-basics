package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.Test;

public class RegexTest {
    @Test
    public void regexTrimNumberAtTheEnd() {
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
            System.out.println("Matcher group: " + matcher.group());
            System.out.println(matcher.start());
            System.out.println(matcher.end());
        }
    }

    @Test
    public void testPatternGroup() {
        final Pattern pattern = Pattern.compile("\\$\\{.*?}", Pattern.UNICODE_CASE);
        final Matcher matcher = pattern.matcher("${DEV_TOKEN}  hello ${APP_TOKEN}");
        // loop it and then find it
        while (matcher.find()) {
            System.out.println("Matcher group: " + matcher.group(0));
        }
    }

    // https://www.geeksforgeeks.org/pattern-quotestring-method-in-java-with-examples/
    @Test
    public void testPatternGroupWithQuote() {
        String testString = "${TOKEN1} hello ${TOKEN2}";

        final Pattern pattern = Pattern.compile("\\$\\{.*?}", Pattern.UNICODE_CASE);
        final Matcher matcher = pattern.matcher(testString);
        // loop it and then find it
        while (matcher.find()) {
            System.out.println("Matcher group: " + matcher.group(0));

            Pattern subexpr = Pattern.compile(Pattern.quote(matcher.group(0)));

            // \Q and \E mark the beginning and end of the quoted part of the string.
            System.out.println(subexpr);

            testString = subexpr.matcher(testString).replaceAll("replaced..!!");
        }

        System.out.println(testString);
    }

    @Test
    public void emailValidationTest() {
        final Pattern pattern = Pattern.compile("\\w+@[a-zA-Z.-]+", Pattern.UNICODE_CASE);
        final Matcher matcher = pattern.matcher("karthik123@gmail.com");
        if (matcher.find()) {
            System.out.println("found");
            System.out.println("Start: " + matcher.start() + " End: " + matcher.end());
        }
    }
}
