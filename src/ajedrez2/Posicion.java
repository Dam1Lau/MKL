package ajedrez2;

public class Posicion {

    private int fila;
    private int columna;

    /**
     * Constructor por defecto para una Posición.
     */
    public Posicion() {
    }

    /**
     * Constructor para crear una posición. Podemos introducir la posición como
     * un conjunto de fila y columna (y,x)
     *
     * @param fila - primer punto de la posición.
     * @param columna - segundo punto de la posición.
     */
    public Posicion(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    /**
     * Get fila - devuelve el valor del atributo fila de la clase Posición.
     *
     * @return
     */
    public int getFila() {
        return fila;
    }

    /**
     * Set fila - Cambia el valor del atributo fila de la clase Posición.
     *
     * @param fila
     */
    public void setFila(int fila) {
        this.fila = fila;
    }

    /**
     * Get fila - devuelve el valor del atributo columna de la clase Posición.
     *
     * @return
     */
    public int getColumna() {
        return columna;
    }

    /**
     * Set fila - Cambia el valor del atributo columna de la clase Posición.
     *
     * @param columna
     */
    public void setColumna(int columna) {
        this.columna = columna;
    }
    ////metodos

    /**
     * Devuelve el contenido de los atributos de la clase Posición. Se compone
     * de fila y columna.
     *
     * @return
     */
    @Override
    public String toString() {
        return "Posicion{" + "fila=" + fila + ", columna=" + columna + '}';
    }

}
