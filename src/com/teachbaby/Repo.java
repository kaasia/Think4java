package com.teachbaby;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kfly on 2016/4/11.
 */
public class Repo {
    private  List<HuoWuBase> huoWus=new ArrayList<HuoWuBase>();
    public int saveHuoWu(HuoWuBase hwb){

        for(int i=0;i<huoWus.size();i++){
            HuoWuBase hw = huoWus.get(i);
            int count= hwb.getCount();
            if (hwb.getName().equals(hw.getName())){
                huoWus.get(i).setCount(hwb.getCount()+count);
                return 1;
            }
        }
        huoWus.add(hwb);
        return 1;
    }
    public int getHuoWu(String name){
        for(int i=0;i<huoWus.size();i++){
            HuoWuBase hw = huoWus.get(i);
            if(hw.getName().equals(name)){
                if(hw.getIsOk()){
                    if(hw.getCount()>=1){
                        return hw.getCount();
                    }
                    return 0;
                }
                return 0;
            }
        }
        return 0;
    }
}
