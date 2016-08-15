package com.ppro.p_choi.yg_pos_new;

import android.graphics.drawable.Drawable;

/**
 * Created by p on 2016-08-10.
 */
public class M_ListItem {
    private String iconDrawable;
    private String titleStr;
    private String descStr;
    private String[] mData;

    public M_ListItem(String icon, String[] obj){
        iconDrawable = icon;
        mData = obj;
    }
    public M_ListItem(String icon, String obj01, String obj02){
        iconDrawable = icon;

        mData=new String[3];
        mData[0]=obj01;
        mData[1]=obj02;
        //mData[2]=obj03;
    }
    public void setIcon(String icon){
        iconDrawable=icon;
    }
    public void setTitle(String title){
        titleStr=title;
    }
    public void setDesc(String desc){
        descStr=desc;
    }

    public String[] getmData(){
        return mData;
    }
    public String getData(int index){
        if (mData==null||index>=mData.length) {
            return null;
        }

        return mData[index];
    }
    public String getIcon(){
        return this.iconDrawable;
    }
    public String getTitle(){
        return this.titleStr;
    }
    public String getDesc(){
        return this.descStr;
    }
}
