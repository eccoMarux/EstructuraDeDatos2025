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
        if (this.esVacia()) {
            frente = nuevoNodo;
        } else {
            fin.setEnlace(nuevoNodo);
        }
        fin = nuevoNodo;
        return true;
    }

    // Sacar: elimina el frente  - O(1) 
    public boolean sacar() {
        boolean exito = false;
        if (!this.esVacia()) {
            frente = frente.getEnlace();
            if (frente == null) {
                fin = null;  // Caso especial: cola vacía
            }
            exito = true;
        }
        return exito;
    }

    // ObtenerFrente - O(1) 
    public Object obtenerFrente() {
        Object elem = null;
        if (!this.esVacia()) {
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

    // toString
    @Override
    public String toString() {
        String cadena = "";
        if (this.esVacia()) {
            cadena = "Cola vacía";
        } else {
            Nodo aux = frente;
            while (aux != null) {
                cadena += aux.getElemento().toString();
                aux = aux.getEnlace();
                if (aux != null){
                    cadena += ", ";
                } 
            }
        }
        return "[" + cadena + "]";
    }
}