package com.example.presentation.common;

public class ApplicationContext {
    private static int loggedInUserId;

    public static int getLoggedInUserId() {
        return loggedInUserId;
    }

    public static void setLoggedInUserId(int loggedInUserId) {
        ApplicationContext.loggedInUserId = loggedInUserId;
    }
}
