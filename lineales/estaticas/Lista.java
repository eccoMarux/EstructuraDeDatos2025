/**
 * TDA Lista (Implementación Estática)
 * Estructura lineal que almacena elementos en un arreglo de tamaño fijo.
 * - Operaciones principales: insertar, eliminar, recuperar, localizar.
 * - Ventaja: Acceso rápido (O(1)) a elementos por índice.
 * - Desventaja: Tamaño fijo y desplazamientos costosos (O(n)) al insertar/eliminar.
 * - Uso típico: Cuando el tamaño máximo es conocido y se prioriza el acceso por posición.
 */
public class Lista {
    private Object[] arreglo;
    private int longitud;
    private static final int TAMANIO = 10;

    public Lista() {
        this.arreglo = new Object[TAMANIO];
        this.longitud = 0;
    }

    // Insertar: agrega un elemento en la posición indicada - O(n) (desplazamientos)
    public boolean insertar(Object nuevoElem, int pos) {
        boolean exito = false;
        if (pos >= 1 && pos <= longitud + 1 && longitud < TAMANIO) {
            for (int i = longitud; i >= pos; i--) {
                arreglo[i] = arreglo[i - 1];  // Desplaza elementos
            }
            arreglo[pos - 1] = nuevoElem;
            longitud++;
            exito = true;
        }
        return exito;
    }

    // Eliminar: remueve el elemento en la posición indicada - O(n) (desplazamientos)
    public boolean eliminar(int pos) {
        boolean exito = false;
        if (pos >= 1 && pos <= longitud) {
            for (int i = pos - 1; i < longitud - 1; i++) {
                arreglo[i] = arreglo[i + 1];  // Desplaza elementos
            }
            arreglo[longitud - 1] = null;
            longitud--;
            exito = true;
        }
        return exito;
    }

    // Recuperar: devuelve el elemento en la posición indicada - O(1)
    public Object recuperar(int pos) {
        Object elem = null;
        if (pos >= 1 && pos <= longitud) {
            elem = arreglo[pos - 1];
        }
        return elem;
    }

    // Localizar: devuelve la posición de la primera ocurrencia del elemento
    public int localizar(Object elem) {
        int pos = -1;
        for (int i = 0; i < longitud && pos == -1; i++) {
            if (arreglo[i].equals(elem)) {
                pos = i + 1;
            }
        }
        return pos;
    }

    // Verifica si la lista está vacía
    public boolean esVacia() {
        return longitud == 0;
    }

    // Vaciar: reinicia la lista
    public void vaciar() {
        for (int i = 0; i < longitud; i++) {
            arreglo[i] = null;
        }
        longitud = 0;
    }

    // Devuelve la cantidad de elementos
    public int longitud() {
        return longitud;
    }

    // toString: para depuración
    @Override
    public String toString() {
        String cadena = "";
        if (this.esVacia()) {
            cadena = "Lista vacía";
        } else {
            for (int i = 0; i < longitud; i++) {
                cadena += arreglo[i].toString();
                if (i < longitud - 1) cadena += ", ";
            }
        }
        return "[" + cadena + "]";
    }
}