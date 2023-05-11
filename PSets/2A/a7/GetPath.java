package a7;

import java.util.ArrayList;

public class GetPath {

    //Fill in your answer for this method
    public static boolean getPath (int r, int c, ArrayList<Point> path, final int [][] grid) {
        // Base case
        if (grid[r][c] == 1) { return false; }
        else if (r==0 && c==0) {
            addPoint(0, 0, path);
            return true;
        }

        // Recursive case
        if (r-1 >= 0 && grid[r-1][c] == 0) {
            if (getPath(r-1, c, path, grid)) {
                addPoint(r, c, path);
                return true;
            }
        }
        if (c-1 >= 0 && grid[r][c-1] == 0) {
            if (getPath(r, c-1, path, grid)) {
                addPoint(r, c, path);
                return true;
            }
        }
        return false;
    }

    public static void addPoint(int r, int c, ArrayList<Point> path) {
        Point dest = new Point(r, c);
        path.add(dest);
    }
}

/* HINT:
Your solution ought to work with a grid that is not square.
Here is the grid for Test Case 8:

            final int[][] grid = {
                    {0,0,0,1},
                    {0,1,0,0},
                    {0,1,1,1},
                    {0,0,0,1},
                    {1,1,0,0},
                    {1,1,1,0}
            };

If the destination is r = 5, c = 3, then getPath() returns true.
If the destination is r = 2, c = 3, then getPath() returns false.

*/
