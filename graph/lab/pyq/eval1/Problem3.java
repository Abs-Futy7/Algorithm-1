
import java.util.Scanner;



public class Problem3{

    public int perimeter(int[][] grid){
        int perimeter = 0;
        int m = grid.length;
        int n = grid[0].length;

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == 1){
                    if(i==0 || (i > 0 && grid[i-1][j] == 0)) perimeter++;
                    if(i==m-1 || (i < m-1 && grid[i+1][j] == 0)) perimeter++;
                    if(j==0 || (j > 0 && grid[i][j-1] == 0)) perimeter++;
                    if(j==n-1 || (j < n-1 && grid[i][j+1] == 0)) perimeter++;
                }
            }
        }
        return perimeter;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rows = sc.nextInt();
        int col = sc.nextInt();
        int[][] grid = new int[rows][col];

        for (int i = 0; i < rows; i++) {
            String line = sc.next(); // reads the full line like "0,1,0,0"
            String[] parts = line.split(",");
            for (int j = 0; j < col; j++) {
                grid[i][j] = Integer.parseInt(parts[j]);
            }
        }

        Problem3 obj = new Problem3();
        int res = obj.perimeter(grid);
        System.out.println(res);
        sc.close();
    }
}