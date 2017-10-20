package com.example.dataAnalysis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.util.Log;

//���ڻ�ȡCan��Ϣ���ź��������ݿ�
public class CanDB {
	public static String data;
	public static Map<String,CanMessage> canDbc;
	
	CanDB()
	{
	}
	
	public CanDB(String data)
	{
		this.data = data;
		this.canDbc = getMsgDbc(data);
	}
	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
		canDbc = getMsgDbc(data);
	}

	public Map<String, CanMessage> getCanDbc() {
		return canDbc;
	}

	public void setCanDbc(Map<String, CanMessage> canDbc) {
		this.canDbc = canDbc;
	}
	
	//��ȡcan��Ϣ���ݿ����Ϣ����ת����Map
		public Map<String,CanMessage> getMsgDbc(String result)
		{
//			  StringBuilder result = new StringBuilder();
//		      try{
//		            BufferedReader br = new BufferedReader(new FileReader(file));//����һ��BufferedReader������ȡ�ļ�
//		            String s = null;
//		            while((s = br.readLine())!=null){//ʹ��readLine������һ�ζ�һ��
//		                result.append(System.lineSeparator()+s);
//		            }
//		            br.close();    
//		      }catch(Exception e){
//		            e.printStackTrace();
//		      }
//		      String data[] = result.toString().split("BO_ ");
			  String data[] = result.split("BO_ ");
			  Map<String,CanMessage> dataMap = new HashMap<String,CanMessage>();
			  for(int i = 1;i < data.length;i++)
			  {
				  data[i] = data[i].replaceAll("\r|\n", "");
				  String temp[] = data[i].split(" ");
				  CanMessage message = new CanMessage(temp[0],temp[1].substring(0, temp[1].length() - 1),temp[2].charAt(0),temp[3]);
				  String signals[] = data[i].split("SG_ ");
				  message.setSignalNum(signals.length - 1);
				  List<CanSignal> listSig = new ArrayList<CanSignal>();
				  for(int k = 1;k < signals.length;k++)
				  {
					  String sigTemp[] = signals[k].split(" ");
					  CanSignal sig = new CanSignal();
					  sig.setName(sigTemp[0]);
					  sig.setStart(Integer.parseInt(sigTemp[2].split("\\|")[0]));
					  sig.setLength(Integer.parseInt(sigTemp[2].split("\\|")[1].split("@")[0]));
					  sig.setType(sigTemp[2].split("\\|")[1].split("@")[1]);
					  sig.setA(Double.valueOf(sigTemp[3].substring(1, sigTemp[3].length() - 1).split(",")[0]).doubleValue());
					  sig.setB(Double.valueOf(sigTemp[3].substring(1, sigTemp[3].length() - 1).split(",")[1]).doubleValue());
					  sig.setC(Double.valueOf(sigTemp[4].substring(1, sigTemp[4].length() - 1).split("\\|")[0]).doubleValue());
					  sig.setD(Double.valueOf(sigTemp[4].substring(1, sigTemp[4].length() - 1).split("\\|")[1]).doubleValue());
					  sig.setUnit(sigTemp[5].substring(1, sigTemp[5].length() - 1));
					  sig.setNodeName(sigTemp[sigTemp.length - 1]);
					  listSig.add(sig);
				  }
				  message.setSignalList(listSig);
				  dataMap.put(temp[0],message);
			  }
		      canDbc = dataMap;
			  return dataMap;
		 }
}
