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
        if ((fin + 1) % TAMANIO != frente) {  // Si no está llena
            arreglo[fin] = nuevoElem;
            fin = (fin + 1) % TAMANIO;
            exito = true;
        }
        return exito;
    }

    // Sacar: elimina el elemento del frente - O(1) 
    public boolean sacar() {
        boolean exito = false;
        if (!this.esVacia()) {
            arreglo[frente] = null;
            frente = (frente + 1) % TAMANIO;
            exito = true;
        }
        return exito;
    }

    // ObtenerFrente: devuelve el primer elemento - O(1) 
    public Object obtenerFrente() {
        Object elem = null;
        if (!this.esVacia()) {
            elem = arreglo[frente];
        }
        return elem;
    }

    // Verifica si la cola está vacía
    public boolean esVacia() {
        return frente == fin;
    }

    // Vaciar: reinicia los punteros
    public void vaciar() {
        frente = 0;
        fin = 0;
    }

    // toString: para depuración
    @Override
    public String toString() {
        String cadena = "";
        if (this.esVacia()) {
            cadena = "Cola vacía";
        } else {
            int i = frente;
            while (i != fin) {
                cadena += arreglo[i].toString();
                i = (i + 1) % TAMANIO;
                if (i != fin) {
                    cadena += ", ";
                }
            }
        }
        return "[" + cadena + "]";
    }
}