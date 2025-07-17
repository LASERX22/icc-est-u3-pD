import java.util.ArrayList;
import java.util.List;

public class MazeSolverRecursivoCompleto implements MazeSolve {
    @Override
    public List<Cell> getPath(boolean[][] grid, Cell start, Cell end) {
        if (grid==null || grid.length==0) {
            return new ArrayList<>(); //o null
        }
        List<Cell> path=new ArrayList<>();
        if(findPath(grid,start,end,path)){
            return path;
        }

        return new ArrayList<>();
    }

    private boolean findPath(boolean[][] grid, Cell start, Cell end, List<Cell> path) {
        //Primero que sean 0,0 hasta el limite del grid
        // Que la celda en cuestion sea false
        int row=start.row;
        int col=start.col;
        if (row<0||col<0||row>=grid.length || col>=grid[0].length || !grid[row][col]) {
            return false;
        }

        //Validar el final de lcamino
        if(row==end.row && col==end.col){
            path.add(start);
            return true;
        }
        if(findPath(grid,new Cell(row+1, col),end,path)){
            path.add(start);
            return true;
        }
        if(findPath(grid, new Cell(row, col+1), end, path)){
            path.add(start);
            return true;
        }
        if(findPath(grid, new Cell(row, col-1), end, path)){
            path.add(start);
            return true;
        }
        if(findPath(grid, new Cell(row-1, col), end, path)){
            path.add(start);
            return true;
        }
        return false;

    }
}
