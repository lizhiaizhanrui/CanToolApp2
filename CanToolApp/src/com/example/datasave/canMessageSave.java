package com.example.datasave;
import java.io.BufferedWriter;  
import java.io.File;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.io.OutputStreamWriter;  
import java.sql.Timestamp;  
import java.util.ArrayList;  
import java.util.Iterator;  
import java.util.LinkedHashMap;  
import java.util.List;  
import java.util.Map;  
  
  
public class canMessageSave {  
  
    public static File createCSVFile(List exportData, LinkedHashMap rowMapper,  
            String outPutPath, String filename) {  
  
        File csvFile = null;  
        BufferedWriter csvFileOutputStream = null;  
        try {  
            csvFile = new File(outPutPath + filename + ".csv");  
            // csvFile.getParentFile().mkdir();  
            File parent = csvFile.getParentFile();  
            if (parent != null && !parent.exists()) {  
                parent.mkdirs();  
            }  
            csvFile.createNewFile();  
  
            // GB2312使正确读取分隔符","  
            csvFileOutputStream = new BufferedWriter(new OutputStreamWriter(  
                    new FileOutputStream(csvFile), "GB2312"), 1024);  
            // 写入文件头部  
            for (Iterator propertyIterator = rowMapper.entrySet().iterator(); propertyIterator.hasNext();) {  
                java.util.Map.Entry propertyEntry = (java.util.Map.Entry) propertyIterator  
                        .next();  
                csvFileOutputStream.write("\""  
                        + propertyEntry.getValue().toString() + "\"");  
                if (propertyIterator.hasNext()) {  
                    csvFileOutputStream.write(",");  
                }  
            }  
            csvFileOutputStream.newLine();  
  
             
  
  
            // 写入文件内容  
            for (Iterator iterator = exportData.iterator(); iterator.hasNext();) {    
               // Object row = (Object) iterator.next();    
                LinkedHashMap row = (LinkedHashMap) iterator.next();  
                System.out.println(row);  
               
                for (Iterator propertyIterator = row.entrySet().iterator(); propertyIterator.hasNext();) {    
                    java.util.Map.Entry propertyEntry = (java.util.Map.Entry) propertyIterator.next();    
                   // System.out.println( BeanUtils.getProperty(row, propertyEntry.getKey().toString()));  
                    csvFileOutputStream.write("\""    
                            +  propertyEntry.getValue().toString() + "\"");    
                   if (propertyIterator.hasNext()) {    
                       csvFileOutputStream.write(",");    
                    }    
               }    
                if (iterator.hasNext()) {    
                   csvFileOutputStream.newLine();    
                }    
           }    
            csvFileOutputStream.flush();    
        } catch (Exception e) {    
           e.printStackTrace();    
        } finally {    
           try {    
                csvFileOutputStream.close();    
            } catch (IOException e) {    
               e.printStackTrace();  
           }    
       }    
        return csvFile;  
    }  
  
    public static void main(String[] args) {  
       List exportData = new ArrayList<Map>();  
        Map row1 = new LinkedHashMap<String, String>();  
        row1.put("1", "11");  
        row1.put("2", "12");  
        row1.put("3", "13");  
        row1.put("4", "14");  
        exportData.add(row1);  
        row1 = new LinkedHashMap<String, String>();  
        row1.put("1", "21");  
        row1.put("2", "22");  
        row1.put("3", "23");  
        row1.put("4", "24");  
        exportData.add(row1);  
        List propertyNames = new ArrayList();  
        LinkedHashMap map = new LinkedHashMap();  
        map.put("1", "第一列");  
        map.put("2", "第二列");  
        map.put("3", "第三列");  
        map.put("4", "第四列");  
       canMessageSave.createCSVFile(exportData, map, "d:/", "12");  
    }  
}  