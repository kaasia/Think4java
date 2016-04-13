package com.access.desert;

/**
 * Created by Kfly on 2016/4/5.
 */
public class Cookie {
    public Cookie(){
        System.out.println("Cookie constructor");
    }
    public void bite0(){
        System.out.println("bite0");
    }
    protected void bite1(){
        System.out.println("bite2");
    }
    void bite2(){
        System.out.println("bite");
    }
    private void bite3(){
        System.out.println("bite3");
    }
}
