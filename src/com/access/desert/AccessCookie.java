package com.access.desert;

/**
 * Created by Kfly on 2016/4/5.
 */
public class AccessCookie {
    public static void main(){
        Cookie c = new Cookie();
        c.bite0();
        c.bite1();
        c.bite2();
        //c.bite3(); private修饰的方法不能被访问
        AccessCookie2 c2 = new AccessCookie2();
        c2.bite0();
        c2.bite1();
        c2.bite2();
        //c2.bite3(); private修饰的方法不能被继承
    }
}
