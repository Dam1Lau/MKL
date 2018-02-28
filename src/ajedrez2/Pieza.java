package ajedrez2;

/**
 *
 * @author dam1
 */
public abstract class Pieza {

    protected String color;
    protected String nombre;
    protected int puntos;

    //Constructores
    /**
     * Constructor por defecto para una pieza cualquiera.
     */
    public Pieza() {
        color = "blanca";
        nombre = "test";
    }

    /**
     * Constructor para generar una pieza cualquiera.
     *
     * @param color - Para ideantificar si la pieza es blanca o negra
     */
    public Pieza(String color) {
        this.color = color;
    }

    //getset
    /**
     * Get color - devuelve el color de la pieza.
     *
     * @return
     */
    public String getColor() {
        return color;
    }

    /**
     * Set color - permite cambiar el color de la pieza.
     *
     * @param color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Get color - devuelve el nombre de la pieza.
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Set nombre - permite cambiar el nombre de la pieza.
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Get color - devuelve los puntos de la pieza.
     *
     * @return
     */
    public int getPuntos() {
        return puntos;
    }

    // Métodos
    
    /**
     * Método por el que cada pieza nos dirá si puede moverse en el tablero
     * dependiendo de su forma de moverse. Método abstracto que cambiará en cada
     * clase que herede de pieza.
     *
     * @param movimiento introducido por el usuario y que queremos saber si es
     * correcto según el tipo de pieza que movamos. El método es implementado
     * por cada pieza individualmente.
     * @return true = si se puede mover, false = si tiene otras piezas
     * bloqueando su movimiento.
     */
    public abstract boolean puedeMoverse(Movimiento movimiento, Tablero tab);

    /**
     * Pintar pieza: Cada pieza devolverá un símbolo unicode que representa a su
     * subclase.
     *
     * @return
     */
    public abstract String pintarPieza();

    /**
     * Método que devuelve un string con los atributos de la pieza.
     *
     * @return string con los atributos de la pieza: nombre, color y su valor en
     * puntos
     */
    @Override
    public String toString() {
        return "Pieza" + this.getClass().getSimpleName() + " " + color + " y vale" + puntos + "punto/s";
    }
}
