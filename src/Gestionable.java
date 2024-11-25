public interface Gestionable {
    void añadirAlimento(Alimento alimento);
    void editarAlimento(String nombre, Alimento alimentoModificado);
    void eliminarAlimento(String nombre);
    boolean validarCategoria(String categoria);
}

