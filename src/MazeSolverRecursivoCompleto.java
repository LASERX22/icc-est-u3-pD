import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MazeSolverRecursivoCompleto implements MazeSolve {
    @Override
    public List<Cell> getPath(boolean[][] grid, Cell current, Cell end) {
        if (grid == null || grid.length == 0) {
            return new ArrayList<>(); // o null
        }
        Set<Cell> visited = new HashSet<>();
        List<Cell> path = new ArrayList<>();
        if (findPath(grid, current, end, path, visited)) {
            return path;
        }

        return new ArrayList<>();
    }

    private boolean findPath(boolean[][] grid, Cell current, Cell end, List<Cell> path, Set<Cell> visited) {
        // Primero que sean 0,0 hasta el limite del grid
        // Que la celda en cuestion sea false
        int row = current.row;
        int col = current.col;
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || !grid[row][col]) {
            return false;
        }

        // Validar el final de lcamino
        if (row == end.row && col == end.col) {
            path.add(current);
            return true;
        }
        if (findPath(grid, new Cell(row + 1, col), end, path, visited)) {
            path.add(current);
            return true;
        }
        if (findPath(grid, new Cell(row, col + 1), end, path, visited)) {
            path.add(current);
            return true;
        }
        if (findPath(grid, new Cell(row, col - 1), end, path, visited)) {
            path.add(current);
            return true;
        }
        if (findPath(grid, new Cell(row - 1, col), end, path, visited)) {
            path.add(current);
            return true;
        }
        return false;

    }
}
