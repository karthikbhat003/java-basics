package com.company.util;

import com.company.domain.HelperClass;

public class TestUtils {
    public static HelperClass getHelperClass(final String id, final String name) {
        final HelperClass helperClass = new HelperClass();
        helperClass.setId(id);
        helperClass.setName(name);
        return helperClass;
    }
}
