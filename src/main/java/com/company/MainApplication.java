package com.company;

import com.company.service.ThreadService;

public class MainApplication {
    public static void main(String[] args) {
        new ThreadService().testSynchronisedBlock();
    }
}
