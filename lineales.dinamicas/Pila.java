/**
 * TDA Pila (Implementación Dinámica)
 * Estructura LIFO (Last In First Out) basada en nodos enlazados.
 * - Operaciones principales: apilar (push), desapilar (pop), obtenerTope (peek).
 * - Ventaja: Sin límite de tamaño (crece según necesidad).
 * - Desventaja: Consumo extra de recursos de memoria por nodos.
 * - Uso típico: Algoritmos con profundidad variable (ej: recursividad, manejo de memoria dinámica).
 */
public class Pila {
    private Nodo tope;

    // Constructor: pila vacía
    public Pila() {
        this.tope = null;
    }

    // Apilar: agrega un elemento al tope (siempre exitoso) - O(1)
    public boolean apilar(Object nuevoElem) {
        this.tope = new Nodo(nuevoElem, this.tope);
        return true;  // Nunca falla (dinámica)
    }

    // Desapilar: elimina el elemento del tope - O(1)
    public boolean desapilar() {
        boolean exito = false;
        if (!this.esVacia()) {
            this.tope = this.tope.getEnlace();  // Avanza al siguiente nodo
            exito = true;
        }
        return exito;
    }

    // ObtenerTope: devuelve el elemento en el tope - O(1)
    public Object obtenerTope() {
        Object elem = null;
        if (!this.esVacia()) {
            elem = this.tope.getElemento();
        }
        return elem;
    }

    // Verifica si la pila está vacía
    public boolean esVacia() {
        return this.tope == null;
    }

    // Vaciar: elimina todos los elementos
    public void vaciar() {
        this.tope = null;  // El garbage collector libera la memoria
    }

    // Clone: devuelve una copia exacta (profunda) - O(n)
    public Pila clone() {
        Pila clon = new Pila();
        if (!this.esVacia()) {
            Nodo aux = this.tope;
            Pila pilaAux = new Pila();
            // Recorre la pila original y apila en pilaAux (inversión temporal)
            while (aux != null) {
                pilaAux.apilar(aux.getElemento());
                aux = aux.getEnlace();
            }
            // Apila en la clon para restaurar el orden original
            while (!pilaAux.esVacia()) {
                clon.apilar(pilaAux.obtenerTope());
                pilaAux.desapilar();
            }
        }
        return clon;
    }

    // toString: para depuración (muestra los elementos) - O(n)
    @Override
    public String toString() {
        String cadena = "";
        if (this.esVacia()) {
            cadena = "Pila vacía";
        } else {
            Nodo aux = this.tope;
            while (aux != null) {
                cadena += aux.getElemento().toString();
                if (aux.getEnlace() != null) {
                    cadena += ", ";
                }
                aux = aux.getEnlace();
            }
        }
        return "[" + cadena + "]";
    }
}