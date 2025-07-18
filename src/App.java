import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        // runEjerciciosPD();
        runMaze();

    }

    private static void runEjerciciosPD() {
        EjerciciosPD ejerciciosPD = new EjerciciosPD();
        System.out.println("Fibonacci Recursivo");
        long start = System.nanoTime();
        Long resultado = ejerciciosPD.getFibonacci(50);
        long end = System.nanoTime();
        long duration = end - start;
        System.out.println("Resultado =" + resultado + " en tiempo = " + duration);

        System.out.println("Fibonacci Recursivo Caching");
        start = System.nanoTime();
        resultado = ejerciciosPD.getFibonacciPD(50);
        end = System.nanoTime();
        duration = end - start;
        System.out.println("Resultado =" + resultado + " en tiempo = " + duration);
    }

    private static void runMaze() {
        boolean[][] predefinedMaze = {
                { true, true, true, true },
                { false, true, true, true },
                { true, true, false, false },
                { true, true, true, true }
        };

        // CLASE MAZE con variable global predefinedMaze
        Maze maze = new Maze(predefinedMaze);
        System.out.println("Laberinto Cargado");
        maze.printMaze();
        Cell start = new Cell(0, 0);
        Cell end = new Cell(3, 3);

        List<MazeSolve> solvers = Arrays.asList(
                new MazeSolverRecursivo(),
                new MazeSolverRecursivoCompleto(),
                new MazeSolverRecursivoCompleoBT());
        MazeSolve solver = solvers.get(2);
        MazeResult resultado = solver.getPath(maze.getMatriz(), start, end);
        // MazeSolve solver = solvers.get(0);
        // MazeSolve solver2 = solvers.get(1);
        // MazeSolve solver3 = solvers.get(2);
        List<Cell> path = resultado.getPath();
        Set<Cell> visited = resultado.getVisited();
        // path = solver.getPath(maze.getMatriz(), start, end);
        // System.out.println(path);
        // path2 = solver2.getPath(maze.getMatriz(), start, end);
        // System.out.println(path2);
        System.out.println("Camino encontrado");
        System.out.println(path);
        System.out.println("Caminio de visitadas");
        System.out.println(visited);
        System.out.println("Laberinto con las celdas visitadas");
        maze.printMaze(visited);
        System.out.println("Laberinto con el camino recorrido");
        maze.printMaze(path);
    }
}
