package com.reusing;

/**
 * Created by Kfly on 2016/4/6.
 */
class Insect {
    private int i = printInit("what");
    protected int j;
    Insect(){
        System.out.println("i="+i+",j="+j);
        j = 39;
    }
    private static int x1 = printInit("static Insect.x1 initialized");
    static int printInit(String s){
        System.out.println(s);
        return 47;
    }
}
public class Bettle extends Insect {
    private int k = printInit("Beetle.k initialized");
    private int a = getA();
    public Bettle(){
        //System.out.println("k="+k);
        System.out.println("j=" + j);
    }
    public int getA(){
        return 10;
    }
    private static int x2 = printInit("static Bettle.k initialized");
    public static void main(String args[]){
        System.out.println("Bettle constructor()");
        Bettle b = new Bettle();
    }
}
