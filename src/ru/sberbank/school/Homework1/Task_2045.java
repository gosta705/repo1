package ru.sberbank.school;
import java.util.ArrayList;
        import java.util.Scanner;

public class Task_2045 {
    public static void main(String []args){
        ArrayList <Character> text = new ArrayList<>();
        Character space = new Character(' ');
        Character dot = new Character('.');
        Character query = new Character('?');
        Character comma = new Character(',');
        Character exclamation_point = new Character('!');

        String str;
        Scanner sc = new Scanner(System.in);
        str = sc.nextLine();
        for(int i = 0; i<str.length(); ++i){
            text.add(new Character(str.charAt(i)));
        }

        for(int i = 0; i<text.size(); ++i){
            if(text.get(i).equals(dot) || text.get(i).equals(query) ||
                    text.get(i).equals(comma) || text.get(i).equals(exclamation_point)){
                text.add(i + 1, space);//!!!!
            }
        }


        for(int i = 0; i<text.size(); ++i){
            if(text.get(i).equals(space))
            {
                while(i + 1 < text.size() && text.get(i + 1).equals(space)){
                    text.remove(i + 1);
                }
            }
            else if(text.get(i).equals(dot) || text.get(i).equals(query) ||
                    text.get(i).equals(comma) || text.get(i).equals(exclamation_point)){
                if(i - 1 >= 0 && text.get(i - 1).equals(space)){
                    text.remove(i - 1);
                    i --;
                }

            }
        }
        

        for(int i = 0; i<text.size(); ++i){

            System.out.print(text.get(i));
        }

    }
}
