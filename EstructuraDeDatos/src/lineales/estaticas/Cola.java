
/************* Autores ***********
Maria Elvira Monserrat Vidal, Legajo FAI-1829 
Jonathan Maximiliano Cabrera, Legajo 108666
Randal Pereda, Legajo FAI-2389
*/

package lineales.estaticas;
/**
 * TDA Cola (Implementación Estática)
 * Estructura FIFO (First In First Out) con arreglo circular de tamaño fijo.
 * - Operaciones principales: poner, sacar, obtenerFrente.
 * - Ventaja: Operaciones O(1) y bajo overhead de memoria.
 * - Desventaja: Tamaño fijo (puede llenarse).
 * - Uso típico: Buffers de tamaño fijo o sistemas con recursos limitados.
 */
public class Cola {
    private Object[] arreglo;
    private int frente;
    private int fin;
    private static final int TAMANIO = 10;

    public Cola() {
        this.arreglo = new Object[TAMANIO];
        this.frente = 0;
        this.fin = 0;
    }

    // Poner: agrega un elemento al final (cola circular) - O(1) (si hay espacio)
    public boolean poner(Object nuevoElem) {
        boolean exito = false;
        if ((fin + 1) % TAMANIO != frente) { // Si no está llena
            arreglo[fin] = nuevoElem;
            fin = (fin + 1) % TAMANIO;
            exito = true;
        }
        return exito;
    }

    // Sacar: elimina el elemento del frente - O(1)
    public boolean sacar() {
        boolean exito = false;
        if (frente != fin) {
            arreglo[frente] = null;
            frente = (frente + 1) % TAMANIO;
            exito = true;
        }
        return exito;
    }

    // ObtenerFrente: devuelve el primer elemento - O(1)
    public Object obtenerFrente() {
        Object elem = null;
        if (frente != fin) {
            elem = arreglo[frente];
        }
        return elem;
    }

    // Verifica si la cola está vacía
    public boolean esVacia() {
        return frente == fin;
    }

    // Vaciar: reinicia los punteros 
    public void vaciar() { //CONSULTAR
        frente = 0;
        fin = 0;
    }

    /* Vaciar hecho por Jonathan y Randal. Verifica posiciones y pone en null. 
    public void vaciar() {
        int i;
        if (this.frente == this.fin) {

        } else {
            if (fin > frente) {

                while(frente<=fin) {
                    arreglo[frente] = null;
                    frente = (this.frente + 1) % this.TAMANIO;
                }
            } else {

                for(i=0;i<frente;i++) {
                    arreglo[i] = null;
                    frente = (this.frente + 1) % this.TAMANIO;
                    
                }
                while(frente<=fin) {
                    arreglo[frente] = null;
                    frente = (this.frente + 1) % this.TAMANIO;}
            }
        frente=0;
        fin=0;
        }
    }
    */

    /**
     * Crea y devuelve una copia exacta de la cola original.
     * @return Nueva instancia de Cola con los mismos elementos.
     */
    @Override
    public Cola clone() {
        Cola clon = new Cola();
        if (frente != fin) {
            clon.arreglo = this.arreglo.clone();
            clon.frente = this.frente;
            clon.fin = this.fin;
        }
        return clon;
    }

    // toString: para depuración
    @Override
    public String toString() {
        String cadena = "";
        if (this.esVacia()) {
            cadena = "[]";
        } else {
            int i = frente;
            while (i != fin) {
                cadena += arreglo[i].toString();
                i = (i + 1) % TAMANIO;
                if (i != fin) {
                    cadena += ",";
                }
            }
            cadena="[" + cadena + "]";
        }
        return cadena;
    }
}