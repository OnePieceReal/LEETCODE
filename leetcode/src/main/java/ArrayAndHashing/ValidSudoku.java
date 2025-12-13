package ArrayAndHashing;

import java.util.HashSet;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        // //go through each columns
        HashSet<Character> set = new HashSet<>();
        for(int i=0;i<9;i++){
            set = new HashSet<>(); //reset
            for(int j=0;j<9;j++)
            {
                char val = board[i][j];
                if(val != '.' && set.contains(val)){
                    return false;
                }
                set.add(val);
            }
        }
        //go through each rows
        for(int i=0;i<9;i++){
            set = new HashSet<>(); //reset
            for(int j=0;j<9;j++)
            {
                char val = board[j][i];
                if(val != '.' && set.contains(val)){
                    return false;
                }
                set.add(val);
            }
        }

        //go through each cell/sub-boxes
        int x =0;
        int y=0;
        for(int i=0;i<9;i++){
            //dheck each 3x3 box
            int a=x;
            int b=y;
            set = new HashSet<>();
            for(int j=0;j<9;j++){

                char val = board[a][b];
                // System.out.println(val+" ");
                if(val != '.' && set.contains(val)){
                    return false;
                }

                set.add(val);

                if((j+1)%3==0){
                    // System.out.println("NEXT COL");
                    a=x;
                    b++;
                }
                else{
                    a++;
                }

            }
            if(x+3>=9){
                x=0;
                y+=3;
            }
            else{
                x+=3;
            }
            // System.out.println("next 3X3 BOX->>");


        }

        return true;

    }
}
