package lineales.dinamicas;
/**
 * Clase Nodo (para estructuras dinámicas)
 * Unidad básica de almacenamiento para estructuras enlazadas (listas, pilas, colas).
 * - Almacena: Un elemento genérico (Object) y un enlace al siguiente nodo.
 * - Propósito: Permitir la construcción de estructuras de datos flexibles y dinámicas.
 * - Overhead: Cada nodo consume memoria adicional para el enlace (trade-off por flexibilidad).
 * - Nota: El tipo 'Object' permite almacenar cualquier objeto, pero requiere casting al recuperar.
 */
class Nodo {
    private Object elem;
    private Nodo enlace;

    // Constructor
    public Nodo(Object elem, Nodo enlace) {
        this.elem = elem;
        this.enlace = enlace;
    }

    // Observadores
    public Object getElemento() {
        return elem;
    }

    public Nodo getEnlace() {
        return enlace;
    }

    // Modificador
    public void setEnlace(Nodo enlace) {
        this.enlace = enlace;
    }
}