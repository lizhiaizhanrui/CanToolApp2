package com.example.datasave;

import java.io.BufferedWriter;  
import java.io.File;  
import java.io.FileNotFoundException;  
import java.io.FileWriter;  
import java.io.IOException;  
public class saveToCsv {  
    public static void main(String[] args) {  
        try {  
            File csv = new File("E://writers1.csv"); // CSV文件  
            // 追记模式  
            BufferedWriter bw = new BufferedWriter(new FileWriter(csv, true));  
            // 新增一行数据  
            bw.newLine();  
            bw.write("三枪拍案惊奇" + "," + "2009" + "," + "1212");  
            bw.close();  
        } catch (FileNotFoundException e) {  
            // 捕获File对象生成时的异常  
            e.printStackTrace();  
        } catch (IOException e) {  
            // 捕获BufferedWriter对象关闭时的异常  
            e.printStackTrace();  
        }  
    }  
} 