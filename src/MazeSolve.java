import java.util.List;

public interface MazeSolve {
    List<Cell> getPath(boolean[][] grid, Cell start, Cell end);
}
