
/************* Autores ***********
Maria Elvira Monserrat Vidal, Legajo FAI-1829 
Jonathan Maximiliano Cabrera, Legajo 108666
Randal Pereda, Legajo FAI-2389
*/

package lineales.dinamicas;
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
        if (this.tope != null) {
            this.tope = this.tope.getEnlace();  // Avanza al siguiente nodo
            exito = true;
        }
        return exito;
    }

    // ObtenerTope: devuelve el elemento en el tope - O(1)
    public Object obtenerTope() {
        Object elem = null;
        if (this.tope != null) {
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
        if (this.tope != null) { 
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

    /* El de Jonathan.
    public Pila clon() {

        Pila clon = new Pila();
        Nodo aux1, aux2;
        aux1 = this.tope;
        clon.tope = new Nodo(aux1.getElemento(), null);
        aux1 = aux1.getEnlace();
        aux2 = clon.tope;

        while (aux1 != null) {
            aux2.setEnlace(new Nodo(aux1.getElemento(), null));
            aux1 = aux1.getEnlace();
            aux2 = aux2.getEnlace();
        }

        return clon;

    }
    */

    // toString: para depuración (muestra los elementos) - O(n)
    @Override
    public String toString() {
        String cadena = "";
        if (this.tope == null) {
            cadena = "[]";
        } else {
            Nodo aux = this.tope;
            while (aux != null) {
                cadena += aux.getElemento().toString();
                if (aux.getEnlace() != null) {
                    cadena += ",";
                }
                aux = aux.getEnlace();
            }
            cadena="[" + cadena + "]";
        }
        return cadena;
    }
}