
import java.util.Scanner;



public class IslandPerimeter463{

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

        for(int i = 0 ; i < rows ; i++){
            for(int j = 0 ;  j < col ; j++){
                grid[i][j] = sc.nextInt();
            }
        }

        IslandPerimeter463 obj = new IslandPerimeter463();
        int res = obj.perimeter(grid);
        System.out.println("Perimeter of the island is: " + res);
        sc.close();
    }
}