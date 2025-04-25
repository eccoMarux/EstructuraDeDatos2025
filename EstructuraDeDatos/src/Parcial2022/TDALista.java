package Parcial2022;

public class TDALista {
    private Nodo cabecera;
    private int longitud;

    public TDALista() {
        this.cabecera = null;
        this.longitud = 0; // Devuelve la cantidad de elementos
    }

    public void agregarElem(Object nuevo, int x){
        //O(n) -> orden lineal pues hace un unico recorrido.
        if(this.longitud >0){
            //Nueva cabecera 
            Nodo nuevaCabecera= new Nodo(nuevo, this.cabecera);
            this.cabecera= nuevaCabecera;
            this.longitud++;


            Nodo nodoRecorre= this.cabecera.getEnlace();
            Nodo aux= this.cabecera;
            Nodo nodoInsertado = new Nodo(nuevo, null);
            int contador=1;
            
            while(nodoRecorre != null){
                if(contador%(x+1) ==0){//Condicion para que salte 
                    //Insertar   
                    aux.setEnlace(nodoInsertado);
                    nodoInsertado.setEnlace(nodoRecorre);
                    this.longitud++;
                    // aux = nodoRecorre;
                    nodoRecorre.getEnlace();
                    aux.getEnlace().getEnlace();
                    nodoInsertado = new Nodo(nuevo, null);
                }else{
                    //siguiente nodo en ambos.
                    nodoRecorre.getEnlace();
                    aux.getEnlace();
                }
                contador++;
            }
        }else{
            this.cabecera= new Nodo(nuevo, null);
            this.longitud++;
        }
    }


}
