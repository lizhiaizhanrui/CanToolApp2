package com.example.showdata;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import android.app.Activity;

public class ActivityControl {

	public static List<Activity> lists=new ArrayList<Activity>();
    //ÿ������һ��activity����ӵ�������
    public static void addActivity(Activity baseActivity){

        lists.add(baseActivity);

    }
    //ÿ������һ��activity�ʹӼ������Ƴ�
    public static void removeActivity(Activity baseActivity){

        lists.remove(baseActivity);
    }

    //�ҵ�ָ����activityʵ��������
    public Activity getActivity(Class clazz) {

        for (Activity list : lists) {
            if (list.getClass() == clazz) {
                return list;
            }

        }
        return null;
    }

    //ɾ������Activity
    public static void killAllAcitvity(){
        Iterator<Activity> iterator = lists.iterator();

        while (iterator.hasNext()){
            Activity baseActivity = iterator.next();
            baseActivity.finish();
        }

    }
	
}
