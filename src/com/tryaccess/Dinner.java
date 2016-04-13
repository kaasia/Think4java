package com.tryaccess;

import com.access.desert.AccessCookie2;
import com.access.desert.Cookie;

/**
 * Created by Kfly on 2016/4/5.
 */
public class Dinner {
    public static void main(){
        Cookie c = new Cookie();
        c.bite0();
        //c.bite();  错误提示，bite()方法不是公共的无法访问
        //c.bite2(); protected修饰的方法不能被访问
        AccessCookie2 c2 = new AccessCookie2();
        c2.bite0();
        //c2.bite();
        //c2.bite2(); 非public皆不能访问
        //c2.bite3();
        AccessCookie3 c3 = new AccessCookie3();
        c3.bite0();
        c3.bite1();
    }
}
