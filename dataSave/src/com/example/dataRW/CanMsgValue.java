package com.example.dataRW;

import java.io.Serializable;
import java.util.List;

//���ڽ���CanTool����������Ϣ
public class CanMsgValue implements Serializable{
	public String id;
	public String name;
	public char DLC;
	public String Dir;//��Ϊ���͵�Node����
	public String Data;
	public int sigValueNum;
	public List<SignalValue> SigValueList;
	
	public CanMsgValue()
	{
		
	}
	
	public CanMsgValue(String id,String name,char DLC,String Dir,String Data,int sigValueNum,List<SignalValue> SigValueList)
	{
		this.id = id;
		this.name = name;
		this.DLC = DLC;
		this.Dir = Dir;
		this.Data = Data;
		this.sigValueNum = sigValueNum;
		this.SigValueList = SigValueList;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public char getDLC() {
		return DLC;
	}
	public void setDLC(char dLC) {
		DLC = dLC;
	}
	public String getDir() {
		return Dir;
	}
	public void setDir(String dir) {
		Dir = dir;
	}
	public String getData() {
		return Data;
	}
	public void setData(String data) {
		Data = data;
	}
	public int getSigValueNum() {
		return sigValueNum;
	}
	public void setSigValueNum(int sigValueNum) {
		this.sigValueNum = sigValueNum;
	}
	public List<SignalValue> getSigValueList() {
		return SigValueList;
	}
	public void setSigValueList(List<SignalValue> sigValueList) {
		SigValueList = sigValueList;
	}

}
