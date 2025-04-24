package ClasesRepaso;

public class FechaString {
    private String fecha; // Ejemplo: "19951010" (10 de octubre de 1995)

    public FechaString(int dia, int mes, int anio) {
        this.fecha = "" + anio + "" + mes + "" + dia;
    }

    // Observadores
    public int getAnio() {
        return Integer.parseInt(fecha.substring(0, 4));
    }

    public int getMes() {
        return Integer.parseInt(fecha.substring(4, 6));
    }

    public int getDia() {
        return Integer.parseInt(fecha.substring(6, 8));
    }

    public String toString() {
        String anio = fecha.substring(0, 4);
        String mes = fecha.substring(4, 6);
        String dia = fecha.substring(6, 8);
        return dia + "/" + mes + "/" + anio;
    }

}
