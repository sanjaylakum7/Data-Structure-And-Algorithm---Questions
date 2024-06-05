public class BackTracking {

    public static void subSet(String str, String ans, int index){
        if(index == str.length()){
            System.out.println(ans);
            return;
        }

        subSet(str, ans + str.charAt(index), index + 1);
        subSet(str, ans, index + 1);
    } 

    public static void permutations(String str, String ans){
        if(str.isEmpty()){
            System.out.println(ans); 
            return;
        }

        for(int index = 0; index < str.length(); index++){  
            char current = str.charAt(index);
            String remaining = str.substring(0, index) + str.substring(index + 1);
            permutations(remaining, ans + current);
        }
    }   
    public static void main(String[] args) {
        System.out.println("Hello Sanjay Lakum");
    }
}
