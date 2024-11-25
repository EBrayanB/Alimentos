import CategoriaInvalidaException.CategoriaInvalidaException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interfaz extends JFrame {
    private JTextField nombreField, categoriaField, descripcionField, valorField;
    private JButton addButton, editarButton, eliminarButton;
    private Sistema sistema;

    public Interfaz(Sistema sistema) {
       this.sistema = sistema;

        nombreField = new JTextField(20);
        categoriaField = new JTextField(20);
        descripcionField = new JTextField(20);
        valorField = new JTextField(20);

        addButton = new JButton("Añadir Alimento");
        editarButton = new JButton("Editar Alimento");
        eliminarButton = new JButton("Eliminar Alimento");

        setLayout(new java.awt.FlowLayout());
        add(new JLabel("Nombre:"));
        add(nombreField);
        add(new JLabel("Categoría:"));
        add(categoriaField);
        add(new JLabel("Descripción:"));
        add(descripcionField);
        add(new JLabel("Valor Nutricional:"));
        add(valorField);
        add(addButton);
        add(editarButton);
        add(eliminarButton);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreField.getText();
                String categoria = categoriaField.getText();
                String descripcion = descripcionField.getText();
                try {
                    double valor = Double.parseDouble(valorField.getText());
                    Alimento nuevoAlimento = null;

                    if (categoria.equalsIgnoreCase("Frutas y Verduras")) {
                        nuevoAlimento = new FrutasYVerduras(nombre, descripcion, valor, 100);
                    } else if (categoria.equalsIgnoreCase("Grasas")) {
                        nuevoAlimento = new Grasas(nombre, descripcion, valor, 100);
                    } else if (categoria.equalsIgnoreCase("Hidratos de Carbono")) {
                        nuevoAlimento = new HidratosDeCarbono(nombre, descripcion, valor, 100);
                    }

                    if (nuevoAlimento != null) {
                        if (categoria.equalsIgnoreCase("Frutas y Verduras") && !categoria.equals("Frutas y Verduras")) {
                            throw new CategoriaInvalidaException("No puedes añadir una fruta en esta categoría");
                        }
                        sistema.añadirAlimento(nuevoAlimento);
                        System.out.printf("alimento añadido" + nuevoAlimento.getNombre());
                        JOptionPane.showMessageDialog(null, "Alimento añadido exitosamente.");
                    }

                    nombreField.setText("");
                    categoriaField.setText("");
                    descripcionField.setText("");
                    valorField.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor ingrese un valor numérico válido.");
                } catch (CategoriaInvalidaException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
        editarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreField.getText();
                String categoria = categoriaField.getText();
                String descripcion = descripcionField.getText();
                try {
                    double valor = Double.parseDouble(valorField.getText());
                    Alimento alimentoModificado = null;

                    if (categoria.equalsIgnoreCase("Frutas y Verduras")) {
                        alimentoModificado = new FrutasYVerduras(nombre, descripcion, valor, 100);
                    } else if (categoria.equalsIgnoreCase("Grasas")) {
                        alimentoModificado = new Grasas(nombre, descripcion, valor, 100);
                    } else if (categoria.equalsIgnoreCase("Hidratos de Carbono")) {
                        alimentoModificado = new HidratosDeCarbono(nombre, descripcion, valor, 100);
                    }

                    if (alimentoModificado != null) {
                        System.out.printf("alimeto editado" + alimentoModificado.getNombre());
                        sistema.editarAlimento(nombre, alimentoModificado);
                    }

                    nombreField.setText("");
                    categoriaField.setText("");
                    descripcionField.setText("");
                    valorField.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor ingrese un valor numérico válido.");
                }
            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreField.getText();
                if (nombre != null && !nombre.isEmpty()) {
                    sistema.eliminarAlimento(nombre);
                    nombreField.setText("");
                    categoriaField.setText("");
                    descripcionField.setText("");
                    valorField.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor ingrese el nombre del alimento a eliminar.");
                }
            }
        });



        setTitle("Gestión de Alimentos");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}

