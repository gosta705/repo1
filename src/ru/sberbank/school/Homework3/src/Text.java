package ru.sberbank.school.Homework3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Text {
    private List <String> textByRows = new ArrayList<>(); ;
    private List <String> textByWord = new ArrayList<>();
    SortedMap<String, Integer> words;

    public Text(String fileName){
        try{
            File file = new File(fileName);
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                textByRows.add(sc.nextLine());
            }
            sc.close();
        }
        catch (FileNotFoundException e){
            System.out.println("Файл не найден");
        }

        for(int i = 0; i<textByRows.size(); ++i) {
            String[] str = textByRows.get(i).split(" ");
            for (int j = 0; j < str.length; ++j) {
                String formatStr = toFormat(str[j]);
                if (formatStr.length() > 0) textByWord.add(formatStr);
            }
        }

        words = new TreeMap<>(new Comparator <String>()
        {
            public int compare(String s1, String s2)
            {
                if(s1.length() > s2.length()) return 1;
                else if (s1.length() < s2.length()) return -1;
                else{
                    for(int i = 0; i<s1.length(); ++i){
                        if(s1.charAt(i) > s2.charAt(i)) return 1;
                        else if(s1.charAt(i) < s2.charAt(i))  return -1;
                    }
                    return 0;
                }
            }
        });

        for(int i = 0; i<textByWord.size(); ++i){
            String key = textByWord.get(i);
            if(words.containsKey(key)){
                words.put(key, words.get(key) + 1);
            }
            else words.put(key, 1);
        }
    }

    public int getCountWordsInFile(){
        return textByWord.size();
    }

    public void showListAllWords(){
        for(Map.Entry<String,Integer> entry : words.entrySet()) {
            String key = entry.getKey();
            System.out.println(key);
        }
        System.out.println();
    }

    public void showlistCountAllWords() {
        for(Map.Entry<String,Integer> entry : words.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(value + " - " + key);
        }
        System.out.println();
    }

    public void showRowInReverse(){
        ListIterator it = listIterator();
        while(it.hasPrevious()) {
            System.out.println(it.previous());
        }
        System.out.println();

    }

    public String getSelectedRow(int num){
        num --;
        if(num > textByRows.size() || num < 0) return "Такого номера нет";
        else return textByRows.get(num);
    }

    public String toFormat(String str){
        str = str.toLowerCase();
        char lastSymb = str.charAt(str.length() - 1);
        if(lastSymb > 'z' || lastSymb < 'a') str = str.substring(0, Math.max(str.length() - 1, 0));
        return str;
    }

    public ListIterator<String> listIterator() {
            ListIterator<String> it = new ListIterator<String>() {
            private int indexFirst = 0, indexLast = textByRows.size() - 1;
                @Override
                public int nextIndex() {
                    return ++indexFirst;
                }
                @Override
                public int previousIndex() {
                    return --indexLast;
                }
                @Override
                public boolean hasNext() {
                    return indexFirst < textByRows.size();
                }
                @Override
                public String next() {
                    return textByRows.get(indexFirst++);
                }
                 public boolean hasPrevious(){
                     return indexLast > -1;
                 }
                 public String previous(){
                     return textByRows.get(indexLast--);
                 }
                @Override
                public void remove() {
                    throw new UnsupportedOperationException();
                }
                @Override
                public void add(String s){
                }
                @Override
                public void set(String s){
                }
        };
        return it;
    }
}



