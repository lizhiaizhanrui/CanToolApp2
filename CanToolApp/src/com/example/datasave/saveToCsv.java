package com.example.datasave;

import java.io.BufferedWriter;  
import java.io.File;  
import java.io.FileNotFoundException;  
import java.io.FileWriter;  
import java.io.IOException;  
public class saveToCsv {  
    public static void main(String[] args) {  
        try {  
            File csv = new File("E://writers1.csv"); // CSV�ļ�  
            // ׷��ģʽ  
            BufferedWriter bw = new BufferedWriter(new FileWriter(csv, true));  
            // ����һ������  
            bw.newLine();  
            bw.write("��ǹ�İ�����" + "," + "2009" + "," + "1212");  
            bw.close();  
        } catch (FileNotFoundException e) {  
            // ����File��������ʱ���쳣  
            e.printStackTrace();  
        } catch (IOException e) {  
            // ����BufferedWriter����ر�ʱ���쳣  
            e.printStackTrace();  
        }  
    }  
} 