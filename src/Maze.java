import java.util.List;
import java.util.Set;

public class Maze {
    private boolean[][] matriz;

    public Maze(boolean[][] matriz) {
        this.matriz = matriz;
    }

    public void printMaze() {
        for (boolean[] row : matriz) {
            for (boolean cell : row) {
                System.out.print(cell ? " - " : " * ");
            }
            System.out.println();
        }
    }

    public void printMaze(List<Cell> path) {
        for (int row = 0; row < matriz.length; row++) {
            for (int col = 0; col < matriz[row].length; col++) {
                // Verifica si la celda actual está en el path
                Cell cell = new Cell(row, col);
                if (path.contains(cell)) {
                    // Imprime ' o ' para la ruta
                    System.out.print(" o ");
                } else {
                    System.out.print(matriz[row][col] ? " - " : " * ");
                }
            }
            System.out.println();
        }
    }

    public void printMaze(Set<Cell> visited) {
        for (Cell cell:visited) {
                if (visited.contains(cell)) {
                    System.out.print(" > ");
                } else {
                    System.out.print(cell[cell.row][cell.col] ? " - " : " * ");
                }
            System.out.println();
        }
    }

    public boolean[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(boolean[][] matriz) {
        this.matriz = matriz;
    }
}
