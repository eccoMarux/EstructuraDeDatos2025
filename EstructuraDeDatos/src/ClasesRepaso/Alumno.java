package ClasesRepaso;

public class Alumno {
    private int legajo; // Podria ser Static Final INT. //No debe tener set.
    private String nombre;
    private String apellido;
    private String tipoDni;
    private int nroDni; // No deberia tener set
    private int telefono;
    private String usuario;
    private String clave; // No debe tener get
    // Puede ser una clase domicilio
    public String calle;
    public int nroCasa;
    public String ciudad;

    // Podrian haber varios contruct, por ejemplo uno vacio.
    public Alumno(int unLegajo, String unNombre, String unApellido, String unTipoDni, int unNroDni, int unTelefono,
            String unUsuario, String unaClave, String unaCalle, int unNroCasa, String unaCiudad) {
        this.legajo = unLegajo;
        this.nombre = unNombre;
        this.apellido = unApellido;
        this.tipoDni = unTipoDni;
        this.nroDni = unNroDni;
        this.telefono = unTelefono;
        this.usuario = unUsuario;
        this.clave = unaClave;
        this.calle = unaCalle;
        this.nroCasa = unNroCasa;
        this.ciudad = unaCiudad;
    }

    // Observadores y modificadores

    public int getLegajo() {
        return this.legajo;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String value) {
        this.nombre = value;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String value) {
        this.apellido = value;
    }

    public String getTipoDni() {
        return this.tipoDni;
    }

    public int getNroDni() {
        return this.nroDni;
    }

    public int getTelefono() {
        return this.telefono;
    }

    public void setTelefono(int value) {
        this.telefono = value;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(String value) {
        this.usuario = value;
    }

    public void setClave(String value) {
        this.clave = value;
    }

    public String getCalle() {
        return this.calle;
    }

    public void setCalle(String value) {
        this.calle = value;
    }

    public int getNroCasa() {
        return this.nroCasa;
    }

    public void setNroCasa(int value) {
        this.nroCasa = value;
    }

    public String getCiudad() {
        return this.ciudad;
    }

    public void setCiudad(String value) {
        this.ciudad = value;
    }

    // ToString
    public String toString() {
        return "Legajo: " + legajo + "\n" +
                "Nombre: " + nombre + "\n" +
                "Apellido: " + apellido + "\n" +
                "Tipo de DNI: " + tipoDni + "\n" +
                "Número de DNI: " + nroDni + "\n" +
                "Teléfono: " + telefono + "\n" +
                "Usuario: " + usuario + "\n" +
                "Domicilio: " + calle + " " + nroCasa + ", " + ciudad;
    }
}