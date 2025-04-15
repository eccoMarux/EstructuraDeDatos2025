package lineales.dinamicas;
/************* Autores ***********
Maria Elvira Monserrat Vidal, Legajo FAI-1829 
Jonathan Maximiliano Cabrera, Legajo 108666
Randal Pereda, Legajo FAI-2389
*/


/**
 * TDA Cola (Implementación Dinámica)
 * Estructura FIFO (First In First Out) basada en nodos enlazados.
 * - Operaciones principales: poner, sacar, obtenerFrente.
 * - Ventaja: Sin límite de tamaño y operaciones O(1).
 * - Desventaja: Consumo extra de recursos de memoria por nodos.
 * - Uso típico: Sistemas donde el tamaño es variable o desconocido.
 */
public class Cola {
    private Nodo frente;
    private Nodo fin;

    public Cola() {
        this.frente = null;
        this.fin = null;
    }

    // Poner: agrega al final (siempre exitoso) - O(1)
    public boolean poner(Object nuevoElem) {
        Nodo nuevoNodo = new Nodo(nuevoElem, null);
        if (this.frente == null) {
            frente = nuevoNodo;
        } else {
            fin.setEnlace(nuevoNodo);
        }
        fin = nuevoNodo;
        return true;
    }

    // Sacar: elimina el frente - O(1)
    public boolean sacar() {
        boolean exito = false;
        if (this.frente != null) {
            frente = frente.getEnlace();
            if (frente == null) {
                fin = null; // Caso especial: cola vacía
            }
            exito = true;
        }
        return exito;
    }

    // ObtenerFrente - O(1)
    public Object obtenerFrente() {
        Object elem = null;
        if (this.frente != null) {
            elem = frente.getElemento();
        }
        return elem;
    }

    // Verifica si está vacía
    public boolean esVacia() {
        return frente == null;
    }

    // Vaciar
    public void vaciar() {
        frente = null;
        fin = null;
    }

    /**
     * Crea y devuelve una copia exacta de la cola original.
     * Retorna nueva instancia de Cola con los mismos elementos.
     */
    public Cola clone() {
        Cola clon = new Cola();
        if (this.frente != null) {
            Nodo aux = this.frente;
            Nodo nuevoNodo = new Nodo(aux.getElemento(), null); // Crea el primer nodo
            clon.frente = nuevoNodo;
            clon.fin = nuevoNodo;
            aux = aux.getEnlace();

            while (aux != null) {
                Nodo siguienteNodo = new Nodo(aux.getElemento(), null); // Crea nodos subsiguientes
                clon.fin.setEnlace(siguienteNodo);
                clon.fin = siguienteNodo;
                aux = aux.getEnlace();
            }
        }
        return clon;
    }

    // toString
    @Override
    public String toString() {
        String cadena = "";
        if (this.frente == null) {
            cadena = "[]";
        } else {
            Nodo aux = frente;
            while (aux != null) {
                cadena += aux.getElemento().toString();
                aux = aux.getEnlace();
                if (aux != null) {
                    cadena += ",";
                }
            }
            cadena = "[" + cadena + "]";
        }
        return cadena;
    }
}