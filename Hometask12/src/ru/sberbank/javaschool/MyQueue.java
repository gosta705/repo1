package ru.sberbank.javaschool;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by tanya on 26.10.2016.
 */
public class MyQueue  {
    private List queue = new LinkedList();
    private int  limit;
    private int mySize;

    public MyQueue(int limit){
        this.limit = limit;
    }


    public synchronized void put(Object item) throws InterruptedException  {
        mySize ++;
        while (queue.size() == limit) {
            wait();
        }
        if (queue.size() == 0) {
            notifyAll();
        }
        this.queue.add(item);
    }


    public synchronized Object take() throws InterruptedException{
        while (queue.size() == 0){
            wait();
        }
        if (queue.size() == limit){
            notifyAll();
        }

        return queue.remove(0);
    }


    public int getLimit() {
        return limit;
    }

    public int getSize() {
        return mySize;
    }


}
