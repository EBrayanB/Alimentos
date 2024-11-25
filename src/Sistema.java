import java.util.*;

public class Sistema implements Gestionable {
    private List<Alimento> alimentos;

    public Sistema() {
        alimentos = new ArrayList<>();
    }

    @Override
    public void añadirAlimento(Alimento alimento) {
        if (validarCategoria(alimento.getCategoria())) {
            alimentos.add(alimento);
            System.out.println("Alimento añadido: " + alimento.getNombre());
        } else {
            System.out.println("Error: Categoría incorrecta para el alimento.");
        }
    }

    @Override
    public void editarAlimento(String nombre, Alimento alimentoModificado) {
        for (int i = 0; i < alimentos.size(); i++) {
            if (alimentos.get(i).getNombre().equals(nombre)) {
                alimentos.set(i, alimentoModificado);
                System.out.println("Alimento editado: " + alimentoModificado.getNombre());
                return;
            }
        }
        System.out.println("Error: Alimento no encontrado.");
    }

    @Override
    public void eliminarAlimento(String nombre) {
        for (int i = 0; i < alimentos.size(); i++) {
            if (alimentos.get(i).getNombre().equals(nombre)) {
                alimentos.remove(i);
                System.out.println("Alimento eliminado: " + nombre);
                return;
            }
        }
        System.out.println("Error: Alimento no encontrado.");
    }

    @Override
    public boolean validarCategoria(String categoria) {
        return categoria.equalsIgnoreCase("Frutas y Verduras") ||
                categoria.equalsIgnoreCase("Grasas") ||
                categoria.equalsIgnoreCase("Hidratos de Carbono");
    }
}
