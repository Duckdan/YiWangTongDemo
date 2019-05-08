package com.example.android.yiwangtongdemo;

import java.util.LinkedList;

/**
 * Created by 80251421 on 2018/6/7.
 */

public class LogManager {
    LinkedList<String> linkedList = new LinkedList<String>();

    private static LogManager instance = null;
    private LogManager(){
    }

    public static synchronized LogManager getInstance(){
        if (instance == null){
            synchronized (LogManager.class) {
                instance = new LogManager();
            }
        }
        return instance;
    }

    public void addFirst(String log){
        linkedList.addFirst(log);
    }

    public int getSize(){
        return linkedList.size();
    }

    public String getFirst(){
        return linkedList.getFirst();
    }

    public String getIndex(int index){
        return linkedList.get(index);
    }

    public boolean isEmpty(){
        return linkedList.isEmpty();
    }

    public void removeLast(){
        linkedList.removeLast();
    }

    public void clear(){
        linkedList.clear();
    }

}
