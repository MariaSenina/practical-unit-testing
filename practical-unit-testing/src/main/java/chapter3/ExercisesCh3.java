package chapter3;

import java.util.ArrayList;
import java.util.List;

public class ExercisesCh3 {
     /*
     3.2 - A developer attempted to write a utility String reversing method.
     The outcome of his attempts is displayed below (write Unit Test(s)):
      */
    public static String reverse(String s) {
        if (s.isEmpty()) {
            throw new IllegalArgumentException("String cannot be empty");
        }
        List<String> tempArray = new ArrayList<String>(s.length());
        for (int i = 0; i < s.length(); i++) {
            tempArray.add(s.substring(i, i+1));
        }
        StringBuilder reversedString = new StringBuilder(s.length());
        for (int i = tempArray.size() -1; i >= 0; i--) {
            reversedString.append(tempArray.get(i));
        }
        return reversedString.toString();
    }
}
