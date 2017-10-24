package com.example.dataSave;

/*DOM4J ��ʽ����XML*/

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.example.dataAnalysis.CanMsgValue;
import com.example.dataAnalysis.SignalValue;

public class readXml {
	
   public static CanMsgValue xmlToCanMsgValue(){
		
		CanMsgValue canmsgvalue1=new CanMsgValue();
		SignalValue signalValue1=new SignalValue();
		List<SignalValue> SigValueList1=new ArrayList<SignalValue>();
		
		 // ����xml�ļ�
        // ����SAXReader�Ķ���reader
        SAXReader reader = new SAXReader();
        try {
        	//CanMsgValue canmsgvalue1;
            // ͨ��reader�����read��������xml�ļ�,��ȡdocuemnt����
            Document document = reader.read(new File("data/data/com.example.dataSave/longdata.xml"));
            // ͨ��document�����ȡ���ڵ�canmsgvalues
            Element canmsgvalues = document.getRootElement();
            // ͨ��element�����elementIterator������ȡ������
            Iterator it = canmsgvalues.elementIterator();
            // ��������������ȡ�����ӽڵ��е���Ϣ��canmsgvalue��
            while (it.hasNext()) {
                 // System.out.println("=====��ʼ����ĳ��canmsgvalue=====");
                  Element canmsgvalue = (Element) it.next();
                 // ��ȡcanmsgvalue���������Լ� ����ֵ,��ֵ��canmsgvalue1��id�ֶ�
                 List<Attribute> canmsgAttrs = canmsgvalue.attributes();
                 for (Attribute attr : canmsgAttrs) {
                       //System.out.println("��������" + attr.getName() + "--����ֵ��" + attr.getValue());
            	        canmsgvalue1.setId(attr.getValue());
                  }
            
            
                 // ���ݽڵ�����ȡcanmsgvalue���ӽڵ�ֵ ,����ֵ��canmsgvalue1
                  canmsgvalue1.setName(canmsgvalue.elementText("name"));
                  canmsgvalue1.setDLC(canmsgvalue.elementText("DLC").charAt(0));
                  canmsgvalue1.setDir(canmsgvalue.elementText("Dir"));
                  canmsgvalue1.setData(canmsgvalue.elementText("Date"));
                  canmsgvalue1.setSigValueNum(Integer.parseInt(canmsgvalue.elementText("sigValueNum")));
             
                  //��ȡSignalValues��ǩ
                  Element signals =canmsgvalue.element("SignalValues");
                  // Element signalx =signals.element("SignalValue");
                  //��ȡ����SignalValue��ǩ������signalList��
                  List<Element> signalList =signals.elements();
                  //ѭ����signalValue���ӱ�ǩ����Ӧ��ֵ����ֵ��signalValue1������ֶ�
                  Element signalx;
                  for(int i=0;i<signalList.size();i++){
            	      signalx =signalList.get(i);
            	     //SignalValue signalValue1;
            	      signalValue1.setName(signalx.elementText("signame"));
            	      signalValue1.setUnit(signalx.elementText("unit"));
            	      signalValue1.setValue(signalx.elementText("value"));
            	      signalValue1.setNodeName(signalx.elementText("nodename"));
            	      signalValue1.setC(Double.parseDouble(signalx.elementText("c")));
            	      signalValue1.setD(Double.parseDouble(signalx.elementText("d")));
            	      //signalValue1����SigValueList1��
            	      SigValueList1.add(signalValue1);
                   }
                  //SigValueList1��ֵ��canmsgvalue1����Ӧ�ֶ�
                   canmsgvalue1.setSigValueList(SigValueList1);  
           }
         
         
       } catch (DocumentException e) {
           e.printStackTrace();
       }
        return canmsgvalue1;	 
  }
}
