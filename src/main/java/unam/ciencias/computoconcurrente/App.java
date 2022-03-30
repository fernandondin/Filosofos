package unam.ciencias.computoconcurrente;

public class App {
    //defining the number of philosophers
    static int numFilo = 5;
    //initializing an array of philosophers with the number of philosophers
    static Filosofo filosofos[] = new Filosofo[numFilo];
    //initializing an array of chosticks with the number of philosophers
    static Tenedor tenedores[] = new Tenedor[numFilo];
    public static void main(String[] a) throws InterruptedException {
        //loop iterates over chopsticks
        for (int i = 0; i < numFilo; i++){
            tenedores[i] = new Tenedor();
        }

        for (int i = 0; i < numFilo; i++) {
            filosofos[i] = new Filosofo(i, tenedores[i], tenedores[(i + 1) % numFilo]);
            //Ejecuta cada filosofo
            filosofos[i].start();
        }
        while (true){
            try {
                //Mandamos a dormir 1 seg
                Thread.sleep(1000);
                // Para checar si hay abrazo mortal (deadlock)
                boolean deadlock = true;
                for (Tenedor cs : tenedores) {
                    //Checa si hay tenedores disponibles
                    if (cs.disponible()){
                        deadlock = false;
                        break;
                    }
                }
                //Abrazo mortal ocurre si el tiempo que se fue a dormir es 1000ms, significa que cada filosofo esta durmiendo.
                if (deadlock) {
                    Thread.sleep(1000);
                    System.out.println("Todos estan comiendo");
                    break;
                } //end of if
            }
            catch (Exception e) {
                e.printStackTrace(System.out);
            }
        }
        System.out.println("Saliendo del programa");
        System.exit(0);
    }
}
