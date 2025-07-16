import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        //runEjerciciosPD();
        runMaze();

    }
    private  static void runEjerciciosPD(){
        EjerciciosPD ejerciciosPD=new EjerciciosPD();
        System.out.println("Fibonacci Recursivo");
        long start=System.nanoTime();
        Long resultado=ejerciciosPD.getFibonacci(50);
        long end=System.nanoTime();
        long duration=end-start;
        System.out.println("Resultado ="+resultado+" en tiempo = "+duration);

        System.out.println("Fibonacci Recursivo Caching");
        start=System.nanoTime();
        resultado=ejerciciosPD.getFibonacciPD(50);
        end=System.nanoTime();
        duration=end-start;
        System.out.println("Resultado ="+resultado+" en tiempo = "+duration);
    }
    private static void runMaze(){
        boolean[][] predefinedMaze={
            {true,true,true,true},
            {false,true,true,true},
            {true,true,false,false},
            {true,true,true,true}
        };

        //CLASE MAZE con variable global predefinedMaze
        Maze maze=new Maze(predefinedMaze);
        System.out.println("Laberinto Cargado");
        maze.printMaze();
        Cell start=new Cell(0, 0);
        Cell end=new Cell(3, 3);

        List<MazeSolve> solvers=Arrays.asList(
            new MazeSolverRecursivo(),
            new MazeSolverRecursivoCompleto()
        );
        MazeSolve solver=solvers.get(0);
        List<Cell> path;
        path=solver.getPath(maze.getMatriz(), start, end);
        System.out.println(path);
    }
}
