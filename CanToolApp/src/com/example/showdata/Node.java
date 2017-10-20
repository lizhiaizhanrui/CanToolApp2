package com.example.showdata;

import java.util.ArrayList;
import java.util.List;

public class Node {
	
	private int id;
	private int pId=0;//���ڵ�pIdΪ0
	private String name;
	private int level;//��ǰ�ļ���
	private boolean isExpand= false;//�Ƿ�չ��
	private int icon;
	private List<Node> children=new ArrayList<Node>();//��һ������Node
	private Node parent;//��Node
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLevel() {
		return parent==null?0:parent.getLevel()+1;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public boolean isExpand() {
		return isExpand;
	}
	public void setExpand(boolean isExpand) {
		this.isExpand = isExpand;
		if(!isExpand){
			for(Node node :children){
				node.setExpand(isExpand);
			}
		}
	}
	public int getIcon() {
		return icon;
	}
	public void setIcon(int icon) {
		this.icon = icon;
	}
	public List<Node> getChildren() {
		return children;
	}
	public void setChildren(List<Node> children) {
		this.children = children;
	}
	public Node getParent() {
		return parent;
	}
	public void setParent(Node parent) {
		this.parent = parent;
	}
	public Node(int id, int pId, String name) {
		super();
		this.id = id;
		this.pId = pId;
		this.name = name;
	}
	public Node() {
		super();
	}
	//�Ƿ�Ϊ���ڵ�
	public boolean isRoot(){
		return parent==null;
	}
	//�жϸ��ڵ��Ƿ�չ��
	public boolean isParentExpand(){
		if(parent==null)
			return false;
		return parent.isExpand();
	}
	//�Ƿ���Ҷ�ӽڵ�
	public boolean isLeaf(){
		return children.size()==0;
		
	}

	
}
