/*
��д��TabHost��������˼�룺
	 *1�� ��������ʱ������ʵ�廯���ɴ�������������ģ��ʹ��addTab()����
	 *2��ViewHold�е�View��ͼƬ
	 *3����������ģ��ʵ��������Ի�ģ��ķ���
	 * 
	
 */
package com.example.cantoolapp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.TabHost;

public class AnimationTabHost extends TabHost{
	
	private int mCurrentTabID = 0;//��ǰ��tabID
	private final long durationMillis = 400;//����ʱ��
		
	public AnimationTabHost(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	public AnimationTabHost(Context context, AttributeSet attrs) {
		super(context, attrs);
	}	
	
	/*�л�����*/
	@Override
	public void setCurrentTab(int index) {	
		//����ƽ��		
		if(index > mCurrentTabID)
		{
			//�ж϶�����ʼ���뵱ǰλ�õĲ�ֵ��index��ֵ����ʵ�廯ʱ����ģ��λ���Լ�������ʹ���Ĭ�Ͻ���index=0�Ľ���
        	 TranslateAnimation translateAnimation = new TranslateAnimation      
             (      // x��y�����ʼ�ͽ���λ��  
                     Animation.RELATIVE_TO_SELF, 0f,       
                     Animation.RELATIVE_TO_SELF, -1.0f,       
                     Animation.RELATIVE_TO_SELF, 0f,      
                     Animation.RELATIVE_TO_SELF, 0f      
             );
        	 translateAnimation.setDuration(durationMillis);  
        	  //��д��������ֻ��أ�ע��    
             getCurrentView().startAnimation(translateAnimation); 
		}
		//����ƽ��
		else if(index < mCurrentTabID)
		{
        	 TranslateAnimation translateAnimation = new TranslateAnimation      
             (      //x��y�����ʼ�ͽ���λ��  
                     Animation.RELATIVE_TO_SELF, 0f,       
                     Animation.RELATIVE_TO_SELF, 1.0f,       
                     Animation.RELATIVE_TO_SELF, 0f,      
                     Animation.RELATIVE_TO_SELF, 0f      
             );
        	 translateAnimation.setDuration(durationMillis);      
             getCurrentView().startAnimation(translateAnimation); 
		}
		else
		{
			//��ʼ�ǽ������ʱʲô������
		}

		super.setCurrentTab(index);

		//View target=(View)findViewById(android.R.id.tabcontent);//android.R.id.tabhost
		if(index > mCurrentTabID)
		{
        	 TranslateAnimation translateAnimation = new TranslateAnimation      
             (      // x��y�����ʼ�ͽ���λ��  
                     Animation.RELATIVE_TO_PARENT, 1.0f,//RELATIVE_TO_SELF
                     Animation.RELATIVE_TO_PARENT, 0f,       
                     Animation.RELATIVE_TO_PARENT, 0f,      
                     Animation.RELATIVE_TO_PARENT, 0f      
             );
        	 translateAnimation.setDuration(durationMillis);      
        	 getCurrentView().startAnimation(translateAnimation); 
        	 //target.startAnimation(translateAnimation);
		}
		else if(index < mCurrentTabID)
		{
        	 TranslateAnimation translateAnimation = new TranslateAnimation      
             (      // x��y�����ʼ�ͽ���λ��  
                     Animation.RELATIVE_TO_PARENT, -1.0f,       
                     Animation.RELATIVE_TO_PARENT, 0f,       
                     Animation.RELATIVE_TO_PARENT, 0f,      
                     Animation.RELATIVE_TO_PARENT, 0f      
             );
        	 translateAnimation.setDuration(durationMillis);      
        	 getCurrentView().startAnimation(translateAnimation); 
        	 //target.startAnimation(translateAnimation);
		}
		mCurrentTabID = index;
	}
	
}
