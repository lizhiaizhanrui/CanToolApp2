package com.example.showdata;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;

public abstract class TreeListViewAdapter<T> extends BaseAdapter{

	protected Context mContext;
	
	//�洢���пɼ���Node
	protected List<Node> mNodes;
	protected LayoutInflater mInflater;
	//�洢���е�Node
	protected List<Node> mAllNodes;
	//����Ļص��ӿ�
	private OnTreeNodeClickListener onTreeNodeClickListener;
	
	public interface OnTreeNodeClickListener{
		void onClick(Node node,int position);
	}
	public void setOnTreeNodeClickListener
		(OnTreeNodeClickListener onTreeNodeClickListener){
		this.onTreeNodeClickListener=onTreeNodeClickListener;
	}
	
	public TreeListViewAdapter(ListView mTree,Context context,List<T> datas,int defaultExpandLevel)throws IllegalArgumentException,IllegalAccessException{
		
		mContext=context;
		//�����е�NOde��������
		mAllNodes=TreeHelper.getSortedNodes(datas,defaultExpandLevel);
		//���˳��ɼ���Node
		mNodes=TreeHelper.filterVisibleNode(mAllNodes);
		mInflater=LayoutInflater.from(context);
		//���ýڵ���ʱ������չ���Լ��رգ����ҽ�itemClick�¼��������⹫��
		mTree.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// TODO Auto-generated method stub
				expandOrCollapse(position);
				if(onTreeNodeClickListener!=null){
					onTreeNodeClickListener.onClick(mNodes.get(position), position);
				}
			}
		});
		
	}
	
	//��Ӧ��ListView�ĵ���¼���չ����ر�ĳ�ڵ�
	public void expandOrCollapse(int position){
		Node n = mNodes.get(position);
		if(n!=null){
			if(!n.isLeaf()){
				n.setExpand(!n.isExpand());
				mNodes=TreeHelper.filterVisibleNode(mAllNodes);
				notifyDataSetChanged();//ˢ����ͼ
			}
		}
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mNodes.size();
	}
	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return mNodes.get(position);
	}
	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		
		Node node=mNodes.get(position);
		convertView=getConvertView(node,position,convertView,parent);
		convertView.setPadding(node.getLevel()*30, 3, 3, 3);
		
		return convertView;
	}
	public abstract View getConvertView(Node node,int position,
		View convertView,ViewGroup parent);
	
}
