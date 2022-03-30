package unam.ciencias.computoconcurrente;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
/**
 *  Cada filósofo se ejecuta en un hilo.
 */
public class Filosofo extends Thread {
        public static int DEFAULT_TABLE_SIZE = 5;
        protected int id;
        //representa el tenedor izquierdo
        public Tenedor tenedorIzquierdo;
        //representa el tenedor derecho
        public Tenedor tenedorDerecho;
        Filosofo(int id, Tenedor izquierdo, Tenedor derecho) {
            this.id = id;
            tenedorIzquierdo = izquierdo;
            tenedorDerecho = derecho;
        }
        public void run()
        {
            while (true)
            {
                //Filosofo toma el tenedor cuando esta libre.
                tenedorIzquierdo.toma();
                System.out.println("Filosofo " + (id+1) + " toma el tenedor izquierdo.");
                tenedorDerecho.toma();
                System.out.println("Filosodo " + (id+1) + " toma el tenedor derecho.");
                //El filosofo hambriento empieza a comer.
                come();
                //Suelta ambos tenedores cuando ya no esta hambriento
                tenedorIzquierdo.suelta();
                System.out.println("Filosofo " + (id+1) + " Suelta el tenedor izquierdo.");
                tenedorDerecho.suelta();
                System.out.println("Filosofo " + (id+1) + " Suelta el tenedor derecho.");
            }
        }
        //Este metodo se llama despues de tomar los dos tenedores
        void come() {
            try {
                //determina un número aleatorio entre 0 y 1000 que representa el tiempo de dormir en mili segundos
                int sleepTime = ThreadLocalRandom.current().nextInt(0, 1000);
                System.out.println("Filosofo " + (id+1) + " come por " + sleepTime +"ms");
                //Manda a dormir el hilo por el tiempo aleatorio especificado.
                Thread.sleep(sleepTime);
            }
            catch (Exception e)
            {
                e.printStackTrace(System.out);
            }
        }
    }

