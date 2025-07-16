
public class Maze {
    private boolean[][] matriz;
    public Maze(boolean[][] matriz){
        this.matriz=matriz;
    }

    public void printMaze(){
        for (boolean[] row : matriz) {
            for (boolean cell : row) {
                System.out.print(cell? " - ":" * ");
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
