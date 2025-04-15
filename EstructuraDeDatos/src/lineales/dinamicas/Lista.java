package lineales.dinamicas;
/**
 * TDA Lista (Implementación Dinámica)
 * Estructura lineal basada en nodos enlazados, sin límite de tamaño.
 * - Operaciones principales: insertar, eliminar, recuperar, localizar.
 * - Ventaja: Tamaño flexible y eficiencia en inserciones/eliminaciones (O(1) en
 * cabeza).
 * - Desventaja: Acceso por posición es O(n) y consumo extra de recursos de
 * memoria por nodos.
 * - Uso típico: Cuando el tamaño es variable o se realizan muchas
 * inserciones/eliminaciones.
 */
public class Lista {
    private Nodo cabecera;
    private int longitud;

    public Lista() {
        this.cabecera = null;
        this.longitud = 0; // Devuelve la cantidad de elementos
    }

    // Insertar: agrega un elemento en la posición indicada - O(n) (búsqueda de
    // posición)
    public boolean insertar(Object nuevoElem, int pos) {
        boolean exito = false;
        if (pos >= 1 && pos <= this.longitud + 1) {
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
            this.longitud++;
            exito = true;
        }
        return exito;
    }

    public int longitud() {
        return this.longitud;
    }

    // Eliminar: remueve el elemento en la posición indicada - OO(n) (búsqueda de
    // posición)
    public boolean eliminar(int pos) {
        boolean exito = false;
        if (pos >= 1 && pos <= this.longitud) {
            if (pos == 1) {
                cabecera = cabecera.getEnlace();
            } else {
                Nodo aux = cabecera;
                for (int i = 1; i < pos - 1; i++) { //Consultar.
                    aux = aux.getEnlace();
                }
                /*Sugerido Jonathan y Randal.
                 * int i=1;
                 * while(i<pos-1){
                 * aux = aux.getEnlace();
                 * i++;
                 * }
                 */
                aux.setEnlace(aux.getEnlace().getEnlace());
            }
            this.longitud--;
            exito = true;
        }
        return exito;
    }

    // Recuperar: devuelve el elemento en la posición indicada - O(n)
    public Object recuperar(int pos) {
        Object elem = null;
        if (pos >= 1 && pos <= this.longitud) {
            Nodo aux = this.cabecera;
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
        if (this.cabecera != null) {
            Nodo aux = this.cabecera;
            int i = 1;
            boolean corta = false;
            while (aux != null && !corta) {
                if (aux.getElemento().equals(elem)) {
                    pos = i;
                    corta = true;
                }
                aux = aux.getEnlace();
                i++;
            }
        }
        return pos;
    }

    /* Resolucion de Jonathan.
    public int localizar(Object elemento) {//recuepera primera aparición en que aparece el elemento
        int pos = 1;
          int cant = this.longitud;
        
        if(this.cabecera!=null){
            
        Nodo aux = this.cabecera;
       
        
        while (aux != null) {
            if (!aux.getElemento().equals(elemento)) {
                aux = aux.getEnlace();
                pos++;
            } else {
                aux = null;
            }
        }
        
        }
        
        if (pos > cant) {
            pos = -1;
        }
        return pos;
    }
    */

    // Verifica si la lista está vacía
    public boolean esVacia() {
        return cabecera == null;
    }

    // Vaciar: reinicia la lista
    public void vaciar() {
        cabecera = null;
        longitud = 0;
    }

    /**
     * Crea y devuelve una copia profunda (clone) de esta lista
     * Retorna Nueva instancia con los mismos elementos pero nodos independientes
     */
    public Lista clone() {
        Lista clon = new Lista();
        if (cabecera != null) {
            // Clonamos el primer nodo
            Nodo original = this.cabecera;
            Nodo copiaCabecera = new Nodo(original.getElemento(), null);
            clon.cabecera = copiaCabecera;
            clon.longitud = this.longitud;

            // Clonamos el resto de nodos
            Nodo copiaActual = copiaCabecera;
            original = original.getEnlace();

            while (original != null) {
                Nodo nuevoNodo = new Nodo(original.getElemento(), null);
                copiaActual.setEnlace(nuevoNodo);
                copiaActual = nuevoNodo;
                original = original.getEnlace();
            }
        }
        return clon;
    }
    
    /* Clone recursivo - Jonathan
    public Lista clon() {

        Lista clon = new Lista();
        if (this.cabecera != null) {
            clon.cabecera = cloneAux(this.cabecera);
        }
        clon.longitud = this.longitud;
        return clon;
    }

    private Nodo cloneAux(Nodo nodo) {
        Nodo nuevo;
        nuevo = new Nodo(nodo.getElemento(), null);
        if (nodo.getEnlace() != null) {
            nuevo.setEnlace(cloneAux(nodo.getEnlace()));
        }
        return nuevo;
    }
    */

    // toString: para depuración
    @Override
    public String toString() {
        String cadena = "";
        if (this.cabecera == null) {
            cadena = "[]";
        } else {
            Nodo aux = cabecera;
            while (aux != null) {
                cadena += aux.getElemento().toString();
                aux = aux.getEnlace();
                if (aux != null)
                    cadena += ",";
            }
            cadena = "[" + cadena + "]";
        }
        return cadena;
    }
}