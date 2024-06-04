package HashTableHomework;

import java.util.ArrayList;

public class Fruits {
    public static void main(String[] args) {
        ArrayList<String> myList = new ArrayList<>();
        myList.add("Apple");
        myList.add("Banana");
        myList.add("Cherry");
        myList.add("Apple");
        myList.add("Banana");

        for (int i = 0; i < myList.size(); i++) {
            int count = 0;
            System.out.print(myList.get(i)+": ");
            for(int j = 0; j < myList.size(); j++){
                if(myList.get(i).equals(myList.get(j))) {
                    count++;
                }
            }
            myList.remove(i);
            System.out.println(count);
        }
    }
}