import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class MazeSolverRecursivoCompleoBT implements MazeSolve {
    private List<Cell> path;
    private Set<Cell> visited;
    private boolean[][] grid;
    private Cell end;
    private Cell current;

    public MazeSolverRecursivoCompleoBT() {
        this.path = new ArrayList<>();
        this.visited = new TreeSet<>();
    }

    @Override
    public MazeResult getPath(boolean[][] grid, Cell current, Cell end) {
        path.clear();
        visited.clear();
        this.current = current;
        this.end = end;
        if (grid == null || grid.length == 0) {
            return new MazeResult(path, visited); // o null
        }

        if (findPath(current)) {
            System.out.println("RUTA VISITADA");
            System.out.println(visited);
            System.out.println("RUTA OPTIMA");
            System.out.println(path);
            return new MazeResult(path, visited);
        }

        return new MazeResult(new ArrayList<>(), new HashSet<>());
    }

    private boolean findPath(Cell current) {
        if (!isInMaze(current)) {
            return false;
        }
        if (!isValid(current)) {
            return false;
        }
        if (isInVisited(current)) {
            return false;
        }
        path.add(current);
        visited.add(current);
        // Llega al final
        if (current.equals(end)) {
            return true;
        }
        // 4 direcciones
        if (findPath(new Cell(current.row, current.col + 1))
                || findPath(new Cell(current.row + 1, current.col))
                || findPath(new Cell(current.row, current.col - 1))
                || findPath(new Cell(current.row - 1, current.col))) {
            return true;
        }
        // Backtracking
        path.remove(current);
        return false;
    }

    private boolean isInVisited(Cell current) {
        return visited.contains(current);
    }

    private boolean isValid(Cell current) {
        int row = current.row;
        int col = current.col;
        if (!grid[row][col] || visited.contains(current)) {
            return false;
        }
        return true;
    }

    private boolean isInMaze(Cell start) {
        int row = current.row;
        int col = current.col;
        return row > 0 && row < grid.length && col > 0 && col < grid[0].length;
    }
}
