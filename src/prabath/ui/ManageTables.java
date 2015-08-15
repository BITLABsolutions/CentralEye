/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prabath.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author prabath s
 */
public class ManageTables {
    int k;
    String s;
    JTable table;
    int x,y;
    public ManageTables(JTable table,int x,int y){
        this.table=table;
        this.x=x;
        this.y=y;
    }
    public String encodeDataFormTable() {
        s = "";

        List<String> list = new ArrayList<>();
        for (int i = 0; i < y; i++) {
            System.out.println("error:" + table.getValueAt(i, 0));

            for (int j = 0; j < x; j++) {
                try {
                    if (table.getValueAt(i, j).equals("")) {
                        System.out.println("error1:" + table.getValueAt(i, j));
                    }
                } catch (NullPointerException e) {
                }
                if (j == x-1) {
                    s = s + table.getValueAt(i, j);
                } else {
                    s = s + table.getValueAt(i, j) + "#";
                }
            }
            list.add(s);

            s = "";
        }
        for (int i = 0; i < y; i++) {
            if (i != y-1) {
                s = s + list.get(i) + "%";
            } else {
                s = s + list.get(i);
            }
        }
        System.out.println("s:" + s);
        return s;
    }

    public Object[] decodeDataToTable(String s) {
        String[] tokens;
        Object[] tokens1;
        String[] tokens3;
        String delims = "%";
        tokens = s.split(delims);
        System.out.println(s);
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < y; i++) {
            tokens3 = tokens[i].split("#");
            list.addAll(Arrays.asList(tokens3));
            System.out.println(list.get(i));

        }
        tokens1 = list.toArray();
        addTo2DArray(tokens1);
        System.out.println(tokens1[0]);
        System.out.println(tokens1[1]);
        System.out.println(tokens1[2]);
        return tokens1;
    }

    public String[][] addTo2DArray(Object[] tokens) {
        String[][] arr = new String[10][5];
        int k = 0;
       // System.out.println(tokens[0]);
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                System.out.println(tokens[k]);
                arr[i][j] = tokens[k].toString();
                k++;
            }
        }
        System.out.println(arr[0][0]);
        System.out.println(arr[0][1]);
        System.out.println(arr[0][2]);
        return arr;
    }

    public void loadToTable(String s) {
        Object[] tokens=decodeDataToTable(s);
        String[][] arr=addTo2DArray(tokens);
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (arr[i][j].equals("null")) {
                    table.setValueAt(null, i, j);
                } else {
                    table.setValueAt(arr[i][j], i, j);
                }
            }
        }
    }
    
    public String getS(){
        return this.s;
    }
    
    public int getK(){
        return this.k;
    }
    
    public void setK(){
        k=1;
    }

}
