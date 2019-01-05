import java.util.Collection;
import java.util.Hashtable;
import java.lang.Character;

import static java.lang.Character.isUpperCase;

public class Ex1_4 {
    //but this is case sensitive and cannot handle non-letter characters
    public static boolean isPalinPerm(String s) {
        Hashtable<Character, Integer> table = new Hashtable<Character, Integer>(s.length());
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(table.containsKey(c)){
                table.put(c,table.get(c)+1);
            } else table.put(c, 1);
        }
        Collection<Integer> charCounts = table.values();
        int oddCount = 0;
        for(Integer count : charCounts){
            if((count.intValue()%2)!=0){
                oddCount++;
            }
        }
        if(oddCount>1) return false;
        return true;
    }

    public static void main(String[] args){
        String s = "Tactcoa";
        String s1 = "brabra";
        System.out.println("String s is a permutation of a palindrome: " + isPalinPerm(s));
    }
}
