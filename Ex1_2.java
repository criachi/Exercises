import java.util.Hashtable;

public class Ex1_2 {
    //my algo uses hashtable where keys are chars in string and values are the char count
    // it is O(n)
    public static boolean isPermutation(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        Hashtable<Character, Integer> table1 = new Hashtable<Character, Integer>(s1.length(), (float) 0.75);
        Hashtable<Character, Integer> table2 = new Hashtable<Character, Integer>(s2.length(), (float) 0.75);
        for(int i=0; i<s1.length(); i++) { //O(n)
            Character ch1 = Character.valueOf(s1.charAt(i));
            if(table1.containsKey(s1.charAt(i))) table1.put(ch1, table1.get(ch1)+1);
            else table1.put(ch1, 1);
        }
        for(int i=0; i<s2.length(); i++) { //O(n)
            Character ch2 = Character.valueOf(s2.charAt(i));
            if(table1.put(ch2, 1) == null) return false;
        }
        return true;
    }
    // this algo is O(nlogn); split into 2 functions to have modular code!
    public static String sort(String s) { //O(nlogn) because the sort method from Arrays class is O(nlogn)
        char[] arr = s.toCharArray();
        java.util.Arrays.sort(arr);
        return new String(arr);
    }
    public static boolean isPerm(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        return sort(s1).equals(sort(s2));
    }
    // this method is O(n)
    public static boolean isP(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        int[] letters = new int[128]; // assumption that character set is ASCII
        for(int i=0; i<s1.length(); i++) {
            int c = s1.charAt(i);
            letters[c]++; //counting nb of each char in s1
        }
        for(int j=0; j<s2.length(); j++) {
            int c = s2.charAt(j);
            letters[c]--;
            if(letters[c] < 0) return false; // or u cldve checked if positive
        }
        return true;
    }
    public static void main(String[] args) {
        String s1 = "hair";
        String s2 = "hiar";
        String s3 = "harr";
        String s4 = "HaIR";
        System.out.println("s1 and s2 are permutations:" + isPermutation(s1,s2));
        System.out.println("s1 and s2 are permutations:" + isPerm(s1,s2));
        System.out.println("s1 and s2 are permutations:" + isP(s1,s2));

        System.out.println("s1 and s3 are permutations:" + isPermutation(s1,s3));
        System.out.println("s1 and s3 are permutations:" + isPerm(s1,s3));
        System.out.println("s1 and s3 are permutations:" + isP(s1,s3));

        System.out.println("s1 and s4 are permutations:" + isPermutation(s1,s4));
        System.out.println("s1 and s4 are permutations:" + isPerm(s1,s4));
        System.out.println("s1 and s4 are permutations:" + isP(s1,s4));
    }
}
