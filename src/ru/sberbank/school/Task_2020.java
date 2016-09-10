package ru.sberbank.school;
import java.util.Scanner;

public class Task_2020 {
    public static void main(String []args){
        int n = 0, curr_num = 0, num = 0, count = 0, max_count = 0, max_num = 0;
        Scanner sc;
        sc = new Scanner(System.in);
        n = sc.nextInt();

        for(int i = 0; i<n; ++i){
            num = sc.nextInt();
            if(curr_num == num) count ++;
            else{
                curr_num = num;
                count = 1;
            }

            if(count > max_count){
                max_num = curr_num;
                max_count = count;
            }
        }


        System.out.print(max_num + " " + max_count);
    }
}
