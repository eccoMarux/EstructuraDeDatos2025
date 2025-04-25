package Parcial2022;
import lineales.dinamicas.*;
public class TestLineales {

    public Lista generarSecuencia(Cola q, int t){
        Cola nuevaq = q.clone();
        Lista nuevaLista = new Lista();
        Pila pila= new Pila();
        Cola colaAux = new Cola();
        int contador = 1, posicion=1;
        if(!nuevaq.esVacia()){
            while (!nuevaq.esVacia()) {
                if(contador%t+1 == 0){
                    //Se vienen cositas...
                    //Llegaron las cositas...
                    //Lista poner primero lo de la pila y liego lo de la cola.
                    while (!(pila.esVacia() && colaAux.esVacia())) {
                        if(!pila.esVacia()){
                            nuevaLista.insertar(pila.obtenerTope(), posicion);
                            pila.desapilar();
                        }else{
                            nuevaLista.insertar(colaAux.obtenerFrente(), posicion);
                            colaAux.sacar();
                        }  
                        posicion++;  
                    }
                    nuevaLista.insertar('$', posicion);
                    posicion++;
                }else{
                    //Apilar
                    pila.apilar(nuevaq.obtenerFrente());
                    //Poner
                    colaAux.poner(nuevaq.obtenerFrente());
                    //sacar de la cola clonada
                    nuevaq.sacar();
                }
                contador++;
            }
        }
        return nuevaLista;
    }
}
