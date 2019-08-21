package arsw.threads;

/**
 * Un galgo que puede correr en un carril
 *
 * @author rlopez
 *
 */
public class Galgo extends Thread {

    private boolean isPause = false;
    private int paso;
    private Carril carril;
    RegistroLlegada regl;

    public void doPause() {
        if (isPause){
            isPause = false;
        }else{
            isPause = true;
        }
        
    }

    public Galgo(Carril carril, String name, RegistroLlegada reg) {
        super(name);
        this.carril = carril;
        paso = 0;
        this.regl = reg;
    }

    public void corra() throws InterruptedException {
        while (paso < carril.size()) {
            if (isPause) {
                pause();
            } else {
                Thread.sleep(100);
                carril.setPasoOn(paso++);
                carril.displayPasos(paso);
                if (paso == carril.size()) {
                    synchronized (regl) {
                        carril.finish();
                        int ubicacion = regl.getUltimaPosicionAlcanzada();
                        regl.setUltimaPosicionAlcanzada(ubicacion + 1);
                        System.out.println("El galgo " + this.getName() + " llego en la posicion " + ubicacion);
                        if (ubicacion == 1) {
                            regl.setGanador(this.getName());

                        }
                    }
                }

            }
        }
    }

    @Override
    public void run() {

        try {
            corra();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void pause() throws InterruptedException {
        if (isPause) {
            synchronized (MainCanodromo.getReg()) {
                try {
                    MainCanodromo.getReg().wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else {
            isPause = false;
        }

    }
}
