import java.util.Hashtable;
import java.util.Arrays;
public class Ex1_1 {
    //this algo uses extra data str hashtable and is O(n)
    public static boolean hasDuplicates(String s) {
        Hashtable<Character, Character> table = new Hashtable<Character, Character>(s.length(), (float) 0.75);
        for(int i=0; i<s.length(); i++){
            Character key = Character.valueOf(s.charAt(i));
            Character prevVal = table.put(key, key);
            if (prevVal != null) return true; // or just use method containsKey(key)
        }
        return false;
    }
    //this algo is brute force algo w/ O(n^2)
    public static boolean hasDupl(String s) {
        for(int i=0; i<s.length(); i++) {
            for(int j = i+1; j<s.length(); j++){
                if(s.charAt(i) == s.charAt(j)) {
                    return true;
                }
            }
        }
        return false;
    }
    //this algo is O(nlogn) and consists of sorting the string then checking for 2 identical consecutive characters
    public static boolean uniqueCharacters(String str)
    {
        char[] chArray = str.toCharArray();

        // Using sorting
        // Arrays.sort() uses binarySort in the background
        // for non-primitives which is of O(nlogn) time complexity
        Arrays.sort(chArray);

        for (int i = 0; i < chArray.length - 1; i++) {
            // if the adjacent elements are not
            // equal, move to next element
            if (chArray[i] != chArray[i + 1])
                continue;

                // if at any time, 2 adjacent elements
                // become equal, return false
            else
                return false;
        }
        return true;
    }
    // this algo uses a boolean array for the characters (extra data str)-- O(n)
    // here we assume the string has characters only from the ASCII charac set aka max nb of unique chars is 128
    public static boolean hasDup(String s) {
        if (s.length() > 128) return true;
        // the entries are all set automatically to false
        boolean[] char_set = new boolean[128];
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i);
            if (char_set[index]) { // if the flag corresp to existence of charac i in the alphabet in the input string is true
                return true;
            }
            char_set[index] = true;
        }
        return false;
    }
    // this algo uses a bit vector: same gen idea as above algo exc it dsnt use an extra data str
    // it is only valid if the string uses letters only thru a-z (lowercase letters) so we are able to use just a single int
    public static boolean hasD(String s){
        int checker = 0;
        for( int i=0; i<s.length(); i++){
            int valRelToa = s.charAt(i) - 'a';
            if((checker & (1<<valRelToa)) > 0) {
                return true;
            }
            checker |= (1<<valRelToa);
        }
        return false;
    }
    public static void main(String[] args) {
        String s = "christina";
        String str = "hair";
        System.out.println("String s has duplicate characters:" + hasDuplicates(s));
        System.out.println("String str has duplicate characters:" + hasDuplicates(str));
        System.out.println("String s has duplicate characters:" + hasDupl(s));
        System.out.println("String str has duplicate characters:" + hasDupl(str));
        System.out.println("String s has duplicate characters:" + hasDup(s));
        System.out.println("String str has duplicate characters:" + hasDup(str));
        System.out.println("String s has duplicate characters:" + hasD(s));
        System.out.println("String str has duplicate characters:" + hasD(str));
    }
}
