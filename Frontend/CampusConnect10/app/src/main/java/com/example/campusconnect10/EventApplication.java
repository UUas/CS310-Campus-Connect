package com.example.campusconnect10;

import android.app.Application;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EventApplication extends Application {
    ExecutorService srv = Executors.newCachedThreadPool();
}
