import java.util.*;

public class Matrix { 
    public static int numberOfBeams(String[] bank) {
        ArrayList<Integer> list = new ArrayList<>();
        int totalBeams = 0;

        for (int i = 0; i < bank.length; i++) {
            int current = 0;
            for (int j = 0; j < bank[i].length(); j++) if(bank[i].charAt(j) == '1')current++;
            if(current != 0) list.add(current);
        }
        if(list.size() < 2) return 0;
        for(int index = 0; index < list.size() - 1; index++) totalBeams += list.get(index) * list.get(index + 1);
        return totalBeams;
    }

    // ! it seems like confusing i can't sovle it at a movement i'll solve it
    public static int[][] matrixBlockSum(int[][] mat, int k) {  
        int[][] answer = new int[mat.length][mat[0].length];

        for(int row = 0; row < mat.length; row++){
            for(int col = 0; col < mat[row].length; col++){
                int blockSum = 0;
                for(int innerRow = row - k; innerRow <= row + k; innerRow++){
                    
                }
                answer[row][col] = blockSum;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println("Hello");
    }
}
