package ru.sberbank.school.Homework3;

public class HomeWork3 {

    public static void main(String []args){
        Text text = new Text("text.txt");
        System.out.println(text.getCountWordsInFile() + " разных слов в файле.");
        text.showListAllWords();
        text.showlistCountAllWords();
        text.showRowInReverse();

        System.out.println(text.getSelectedRow(1));
        System.out.println(text.getSelectedRow(3));
        System.out.println(text.getSelectedRow(100));

    }

}
