/*
复写的TabHost方法基本思想：
	 *1、 创建对象时，将其实体化，可创建任意多个滑动模块使用addTab()方法
	 *2、ViewHold中的View贴图片
	 *3、两个滑动模块实现连接与对话模块的分离
	 * 
	
 */
package com.example.cantoolapp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.TabHost;

public class AnimationTabHost extends TabHost{
	
	private int mCurrentTabID = 0;//当前的tabID
	private final long durationMillis = 400;//动画时间
		
	public AnimationTabHost(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	public AnimationTabHost(Context context, AttributeSet attrs) {
		super(context, attrs);
	}	
	
	/*切换动画*/
	@Override
	public void setCurrentTab(int index) {	
		//向右平移		
		if(index > mCurrentTabID)
		{
			//判断动画开始点与当前位置的差值，index的值，在实体化时根据模块位置自己给定，使其就默认进入index=0的界面
        	 TranslateAnimation translateAnimation = new TranslateAnimation      
             (      // x和y轴的起始和结束位置  
                     Animation.RELATIVE_TO_SELF, 0f,       
                     Animation.RELATIVE_TO_SELF, -1.0f,       
                     Animation.RELATIVE_TO_SELF, 0f,      
                     Animation.RELATIVE_TO_SELF, 0f      
             );
        	 translateAnimation.setDuration(durationMillis);  
        	  //不写会造成松手滑回，注意    
             getCurrentView().startAnimation(translateAnimation); 
		}
		//向左平移
		else if(index < mCurrentTabID)
		{
        	 TranslateAnimation translateAnimation = new TranslateAnimation      
             (      //x和y轴的起始和结束位置  
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
			//开始是进入界面时什么都不做
		}

		super.setCurrentTab(index);

		//View target=(View)findViewById(android.R.id.tabcontent);//android.R.id.tabhost
		if(index > mCurrentTabID)
		{
        	 TranslateAnimation translateAnimation = new TranslateAnimation      
             (      // x和y轴的起始和结束位置  
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
             (      // x和y轴的起始和结束位置  
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
