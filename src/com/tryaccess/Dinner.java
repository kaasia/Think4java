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
        //c.bite();  ������ʾ��bite()�������ǹ������޷�����
        //c.bite2(); protected���εķ������ܱ�����
        AccessCookie2 c2 = new AccessCookie2();
        c2.bite0();
        //c2.bite();
        //c2.bite2(); ��public�Բ��ܷ���
        //c2.bite3();
        AccessCookie3 c3 = new AccessCookie3();
        c3.bite0();
        c3.bite1();
    }
}
