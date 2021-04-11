/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.homedepot.Utilities;

/**
 *
 * @author java docs
 */
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.isNull;
import java.util.Scanner;

public class ReadTxtFile {
    public static String[][] txtFileread(String path) throws IOException {

        FileReader inputStream = null;
        String str;
        List<Integer> strarray = new ArrayList<Integer>();
        List<String> strarray1 = new ArrayList<String>();
        String[][] diyoptionslist = null;
        int index, index1;
        try {
            Scanner sc = new Scanner(new FileReader(path));
            sc.useDelimiter(",\r\n");//default delimiter is \n
            index = 0; index1 = 0;
            
            while(sc.hasNext()){
                str = (String)sc.next();
                if(index1 == 0){
                    int len = Integer.parseInt(str, 10);
                    if(len > 0){
                        strarray.add(len);
                        index1 = len;
                    }
                    else{
                        System.out.println("Error in parsing file ");
                        return null;
                    }
                }
                else{
                    str = str.replaceAll("\"", "");
                    strarray1.add(str);
                    index1--;
                }
                System.out.println(str + "\n");
                index++;
            }
            
            System.out.println("index1 " + index1);
            System.out.println("index " + index);
            
            //Total number of lists
            index1 = strarray.size();
            int ind = 0;
            diyoptionslist = new String[index1][];
            if(index > 0 && index1 >0){
                for(int i = 0; i < index1; i++){
                    index = strarray.get(i);
                    diyoptionslist[i] = new String[index];                    
                    for(int j = 0; j < index ; j++){
                        diyoptionslist[i][j] = strarray1.get(ind++);
                    }
                }
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return diyoptionslist;
    }
    
    //function to test the utility file read operation
    public static void main(String[] args){
        try{
            //.\\src\\test\\java\\com\\mycompany\\TestData\\diylistheader.csv
            String[][] diylistheader = txtFileread(".\\src\\test\\java\\com\\homedepot\\TestData\\diylistheader.txt");
            System.out.println("File read and write complete");
            if(!isNull(diylistheader)){
                for(int i = 0; i <diylistheader.length; i++){
                    for(int j = 0; j< diylistheader[i].length; j++ ){
                        System.out.println("diylistheader i = " + i + " j " + j + " " + diylistheader[i][j]);
                    }
                }
            }

            String[][] diyoptionslist = txtFileread(".\\src\\test\\java\\com\\homedepot\\TestData\\diylistoptions.txt");
            System.out.println("File read and write complete");
            if(!isNull(diyoptionslist)){
                for(int i = 0; i <diyoptionslist.length; i++){
                    for(int j = 0; j< diyoptionslist[i].length; j++ ){
                        System.out.println("diyoptionslist i = " + i + " j " + j + " " + diyoptionslist[i][j]);
                    }
                }
            }

            String[][] diypageheading = txtFileread(".\\src\\test\\java\\com\\homedepot\\TestData\\diypageheading.txt");
            System.out.println("File read and write complete");
            if(!isNull(diypageheading)){
                for(int i = 0; i <diypageheading.length; i++){
                    for(int j = 0; j< diypageheading[i].length; j++ ){
                        System.out.println("diypageheading i = " + i + " j " + j + " " + diypageheading[i][j]);
                    }
                }
            }
            
        }
        catch(IOException e){
            System.out.println("Exception message " + e.getMessage());
        }
    }
}

