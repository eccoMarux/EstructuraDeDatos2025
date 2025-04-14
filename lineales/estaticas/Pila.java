/**
 * TDA Pila (Implementación Estática)
 * Estructura LIFO (Last In First Out) que almacena elementos en un arreglo de tamaño fijo.
 * - Operaciones principales: apilar (push), desapilar (pop), obtenerTope (peek).
 * - Ventaja: Acceso rápido (O(1)) a operaciones básicas.
 * - Desventaja: Tamaño limitado (puede llenarse).
 * - Uso típico: Algoritmos con profundidad acotada (ej: evaluar expresiones, backtracking).
 */
public class Pila {
    private Object[] arreglo;
    private int tope;
    private static final int TAMANIO = 20;

    // Constructor: crea una pila vacía
    public Pila() {
        this.arreglo = new Object[TAMANIO];
        this.tope = -1;  // Pila vacía
    }

    // Apilar: agrega un elemento al tope - O(1)
    public boolean apilar(Object nuevoElem) {
        boolean exito = false;
        if (this.tope + 1 < TAMANIO) {  // Si hay espacio
            this.tope++;
            this.arreglo[tope] = nuevoElem;
            exito = true;
        }
        return exito;  // False si la pila está llena
    }

    // Desapilar: elimina el elemento del tope - O(1)
    public boolean desapilar() {
        boolean exito = false;
        if (!this.esVacia()) {  // Si la pila no está vacía
            this.arreglo[tope] = null;  // Opcional (para liberar memoria)
            this.tope--;
            exito = true;
        }
        return exito;
    }

    // ObtenerTope: devuelve el elemento en el tope (sin sacarlo) - O(1)
    public Object obtenerTope() {
        Object elem = null;
        if (!this.esVacia()) {
            elem = this.arreglo[tope];
        }
        return elem;  // Precondición: !esVacia()
    }

    // Verifica si la pila está vacía
    public boolean esVacia() {
        return this.tope == -1;
    }

    // Vaciar: elimina todos los elementos
    public void vaciar() {
        this.tope = -1;
        // Opcional: this.arreglo = new Object[TAMANIO];
    }

    // Clone: devuelve una copia exacta de la pila - O(n)
    public Pila clone() {
        Pila clon = new Pila();
        clon.tope = this.tope;
        for (int i = 0; i <= this.tope; i++) {
            clon.arreglo[i] = this.arreglo[i];
        }
        return clon;
    }

    // toString: para depuración (muestra los elementos)
    @Override
    public String toString() {
        String cadena = "";
        if (this.esVacia()) {
            cadena = "Pila vacía";
        } else {
            for (int i = 0; i <= this.tope; i++) {
                cadena += this.arreglo[i].toString();
                if (i < this.tope){
                    cadena += ", ";
                }
            }
        }
        return "[" + cadena + "]";
    }
}

