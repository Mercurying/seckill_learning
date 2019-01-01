package com.mercury.review.thread.synchronization;

public class SynchronizedObjThread extends Thread {
    private MyObject obj;
    private Service service;

    public SynchronizedObjThread(MyObject obj, Service service) {
        super();
        this.obj = obj;
        this.service = service;
    }

    public void run() {
        super.run();
        service.testMethod1(obj);
    }

    public static void main(String[] args) {
        MyObject obj = new MyObject();
        Service service = new Service();
        SynchronizedObjThread thread = new SynchronizedObjThread(obj, service);
        thread.start();


    }

}
