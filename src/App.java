public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        runEjerciciosPD();

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
}
