package ru.sberbank.school;
import java.util.ArrayList;
import java.util.Scanner;

public class Task_2026 {
    public static void main(String []args){
        int n;
        ArrayList <Integer> array;
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        array = new ArrayList<Integer>(n);

        for(int i = 0; i<n; ++i){
            array.add(sc.nextInt());
        }

        for(int i = 0; i < array.size(); ++i) {
            Integer cur_num = array.get(i);
            for (int j = i + 1; j < array.size(); ++j) {
                if (cur_num.compareTo(array.get(j)) == -1) {
                    array.set(i, array.get(j));
                    break;
                }
            }
            if (array.get(i).equals(cur_num)) array.set(i, new Integer(0));
        }

        for(int i = 0; i<array.size(); ++i){
            System.out.print(array.get(i) + " ");
        }
    }
}
