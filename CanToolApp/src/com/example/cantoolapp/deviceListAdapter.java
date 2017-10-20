package com.example.cantoolapp;

import com.example.cantoolapp.R;
import com.example.cantoolapp.chatActivity.deviceListItem;

import java.util.ArrayList;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class deviceListAdapter extends BaseAdapter {
    private ArrayList<deviceListItem> list;
    private LayoutInflater mInflater;
  
    public deviceListAdapter(Context context, ArrayList<deviceListItem> l) {
    	list = l;
		mInflater = LayoutInflater.from(context);
    }

    public int getCount() {
        return list.size();
    }

    public Object getItem(int position) {
        return list.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public int getItemViewType(int position) {
        return position;
    }
    //ListView�е�ÿһ��Item��ʾ����ҪAdapter����һ��getView()�ķ�����
    //��������ᴫ��һ��convertView�Ĳ���������������ص�View�������Item��ʾ��View��
    //�����Item�������㹻����Ϊÿһ��Item������һ��View���󣬱ؽ�ռ�úܶ��ڴ�ռ䣬������View����
    public View getView(int position, View convertView, ViewGroup parent) {
    	ViewHolder viewHolder = null;
    	deviceListItem  item=list.get(position);
        if(convertView == null){
        	convertView = mInflater.inflate(R.layout.list_item, null);          
        	viewHolder=new ViewHolder(
        			(View) convertView.findViewById(R.id.list_child),
        			(TextView) convertView.findViewById(R.id.chat_msg)
        	       );
        	convertView.setTag(viewHolder);
        }
        else{
        	viewHolder = (ViewHolder)convertView.getTag();
        }       
        
        if(item.isSiri)
        {
        	viewHolder.child.setBackgroundResource(R.drawable.msgbox_rec);
        }
        else 
        {
        	viewHolder.child.setBackgroundResource(R.drawable.msgbox_send);
        }
        viewHolder.msg.setText(item.message);    
        
        return convertView;
    }
    //������һ��ViewHolder��Android�Զ������������ʹ�á�
    //Ŀ�ģ��Ż���Դ����ʡ�ռ䣬�����ظ�����view������Ĳ���Ҫ���ڴ���ġ�
    class ViewHolder {
    	  protected View child;
          protected TextView msg;
  
          public ViewHolder(View child, TextView msg){
              this.child = child;
              this.msg = msg;
              
          }
    }
}
