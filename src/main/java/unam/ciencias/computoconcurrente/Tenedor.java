package unam.ciencias.computoconcurrente;

import java.util.concurrent.Semaphore;

public class Tenedor {
    public Semaphore mutex = new Semaphore(1);
    //Toma el tenedor
    void toma() {
        try {
            //Obtiene el permiso del semaforo
            mutex.acquire();
        }
        catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
    //Suelta el tenedor
    void suelta() {
        //Sede el persmiso del semaforo y permit incremetar el numero disponible de tenedores en 1
        mutex.release();
    }
    //Verifica si un tenedor esta disponible
    boolean disponible() {
        //El metodo regresa el numero actual de permisos disponible en el semaforo.
        //regresa verdadero si los permisos disponibles son mayor que cero.
        return mutex.availablePermits() > 0;
    }
}
