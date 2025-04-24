package ClasesRepaso;

public class FechaInt {
    //Clave compuesta: dia, mes, año. No deberian tener set.
    public int dia;
    public int mes;
    public int anio;


    public FechaInt(int unDia, int unMes, int unAnio){
        this.dia = unDia;
        this.mes = unMes;
        this.anio = unAnio;
    }

    // Observadores

    public int getDia() {
      return this.dia;
    }

    public int getMes() {
      return this.mes;
    }
   
    public int getAnio() {
      return this.anio;
    }
}
