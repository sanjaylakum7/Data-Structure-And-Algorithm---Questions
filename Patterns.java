public class Patterns {
    
    public static void numberPattern(int number){
        char startChar = 'A';
        for(int i = 1; i <= number; i++){
            for (int j = 1; j <= i; j++) {
                System.out.print(startChar);
            }
            startChar++;
            System.out.println();
        }
    } 

    public static void hollowSquarePattern(int number){
        for (int i = 1; i <= number; i++) {
            for (int j = 1; j <= number; j++) {
                if(i == 1 || i == number || j == 1 || j == number){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        hollowSquarePattern(15);
    }
}
