package com.company;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import org.junit.Test;
import com.company.domain.HelperClass;
import com.company.util.TestUtils;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;

public class Java8Features {
    @Test
    public void BiPredicate() {
        System.out.println(equalPredicate().test("abcd", "adbc"));
    }

    private BiPredicate<String, String> equalPredicate() {
        return (a, b) -> a.contains("a") && b.contains("b");
    }

    @Test
    public void optional() {
        final String s = null;
        System.out.println(Optional.ofNullable(s).orElse("Null value passed"));
    }

    @Test
    public void processMap() {
        final List<HelperClass> helperClasses = Lists.newArrayList(TestUtils.getHelperClass("12", "abc"), TestUtils.getHelperClass("13", "abc"));
        final Map<String, String> stringMap = helperClasses.stream().collect(
                Collectors.toMap(HelperClass::getId, helperClass -> helperClass.getName().toUpperCase()));
        System.out.println(stringMap);
    }

    @Test
    public void processMapWithDuplicateKeyUsingMergeFunction() {
        final List<HelperClass> helperClasses = Lists.newArrayList(TestUtils.getHelperClass("12", "abc"), TestUtils.getHelperClass("12", "xyz"));
        final Map<String, String> stringMap = helperClasses.stream().collect(
                Collectors.toMap(HelperClass::getId, helperClass -> helperClass.getName().toUpperCase(), (first, second) -> first));
        System.out.println(stringMap);
    }

    @Test
    public void testConsumerAccept(){
        checkIfEmpty("", System.out::println);
        checkIfEmpty("test", System.out::println);
    }

    private void checkIfEmpty(final String value, final Consumer<String> function){
        if(!Strings.isNullOrEmpty(value)){
            function.accept(value);
        }
    }
}
