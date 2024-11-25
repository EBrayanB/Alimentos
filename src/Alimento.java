public class Alimento {
    private String nombre;
    private String categoria;
    private String descripcion;
    private double caloriasPorPorcion;
    private double pesoPorPorcion;

    public Alimento(String nombre, String categoria, String descripcion, double caloriasPorPorcion, double pesoPorPorcion) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.caloriasPorPorcion = caloriasPorPorcion;
        this.pesoPorPorcion = pesoPorPorcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getCaloriasPorPorcion() {
        return caloriasPorPorcion;
    }

    public void setCaloriasPorPorcion(double caloriasPorPorcion) {
        this.caloriasPorPorcion = caloriasPorPorcion;
    }

    public double getPesoPorPorcion() {
        return pesoPorPorcion;
    }

    public void setPesoPorPorcion(double pesoPorPorcion) {
        this.pesoPorPorcion = pesoPorPorcion;
    }
}

