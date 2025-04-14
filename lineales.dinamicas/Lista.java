/**
 * TDA Lista (Implementación Dinámica)
 * Estructura lineal basada en nodos enlazados, sin límite de tamaño.
 * - Operaciones principales: insertar, eliminar, recuperar, localizar.
 * - Ventaja: Tamaño flexible y eficiencia en inserciones/eliminaciones (O(1) en cabeza).
 * - Desventaja: Acceso por posición es O(n) y consumo extra de recursos de memoria por nodos.
 * - Uso típico: Cuando el tamaño es variable o se realizan muchas inserciones/eliminaciones.
 */
public class Lista {
    private Nodo cabecera;

    public Lista() {
        this.cabecera = null;
    }

    // Insertar: agrega un elemento en la posición indicada - O(n) (búsqueda de posición)
    public boolean insertar(Object nuevoElem, int pos) {
        boolean exito = false;
        if (pos >= 1 && pos <= this.longitud() + 1) {
            if (pos == 1) {
                cabecera = new Nodo(nuevoElem, cabecera);
            } else {
                Nodo aux = cabecera;
                for (int i = 1; i < pos - 1; i++) {
                    aux = aux.getEnlace();
                }
                Nodo nuevo = new Nodo(nuevoElem, aux.getEnlace());
                aux.setEnlace(nuevo);
            }
            exito = true;
        }
        return exito;
    }

    // Eliminar: remueve el elemento en la posición indicada - OO(n) (búsqueda de posición)
    public boolean eliminar(int pos) {
        boolean exito = false;
        if (pos >= 1 && pos <= this.longitud()) {
            if (pos == 1) {
                cabecera = cabecera.getEnlace();
            } else {
                Nodo aux = cabecera;
                for (int i = 1; i < pos - 1; i++) {
                    aux = aux.getEnlace();
                }
                aux.setEnlace(aux.getEnlace().getEnlace());
            }
            exito = true;
        }
        return exito;
    }

    // Recuperar: devuelve el elemento en la posición indicada - O(n)
    public Object recuperar(int pos) {
        Object elem = null;
        if (pos >= 1 && pos <= this.longitud()) {
            Nodo aux = cabecera;
            for (int i = 1; i < pos; i++) {
                aux = aux.getEnlace();
            }
            elem = aux.getElemento();
        }
        return elem;
    }

    // Localizar: devuelve la posición de la primera ocurrencia del elemento
    public int localizar(Object elem) {
        int pos = -1;
        Nodo aux = cabecera;
        int i = 1;
        while (aux != null && pos == -1) {
            if (aux.getElemento().equals(elem)) {
                pos = i;
            }
            aux = aux.getEnlace();
            i++;
        }
        return pos;
    }

    // Devuelve la cantidad de elementos
    public int longitud() {
        int contador = 0;
        Nodo aux = cabecera;
        while (aux != null) {
            contador++;
            aux = aux.getEnlace();
        }
        return contador;
    }

    // Verifica si la lista está vacía
    public boolean esVacia() {
        return cabecera == null;
    }

    // Vaciar: reinicia la lista
    public void vaciar() {
        cabecera = null;
    }

    // toString: para depuración
    @Override
    public String toString() {
        String cadena = "";
        if (this.esVacia()) {
            cadena = "Lista vacía";
        } else {
            Nodo aux = cabecera;
            while (aux != null) {
                cadena += aux.getElemento().toString();
                aux = aux.getEnlace();
                if (aux != null) cadena += ", ";
            }
        }
        return "[" + cadena + "]";
    }
}