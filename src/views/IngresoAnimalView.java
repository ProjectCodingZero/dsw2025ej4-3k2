/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;


import domain.*;
import data.Persistencia;

import javax.swing.*;

/**
 *
 * @author DELL
 */
public class IngresoAnimalView {
    
    public static void mostrarFormulario() {
        try {
            String especieNombre = JOptionPane.showInputDialog("Especie (Ej: León):");
            String tipoAlim = JOptionPane.showInputDialog("Tipo alimentación (CARNIVORO / HERBIVORO):");
            double proporcionCarne = Double.parseDouble(JOptionPane.showInputDialog("Proporción de carne (0 si es herbívoro):"));
            double peso = Double.parseDouble(JOptionPane.showInputDialog("Peso del animal (kg):"));
            int edad = Integer.parseInt(JOptionPane.showInputDialog("Edad del animal (años):"));

            // Creamos especie si no existe
            TipoAlimentacion tipo = TipoAlimentacion.valueOf(tipoAlim.toUpperCase());
            Especie especie = new Especie(especieNombre, tipo, proporcionCarne);
            Persistencia.getEspecies().add(especie);

            // Buscamos un sector disponible con ese tipo de alimentación
            Sector sectorCompatible = Persistencia.getSectores().stream()
                    .filter(s -> s.getTipo().equals(tipo))
                    .findFirst().orElse(null);

            if (sectorCompatible == null) {
                JOptionPane.showMessageDialog(null, "No hay sector compatible disponible.");
                return;
            }

            Mamifero nuevoAnimal;
            if (tipo == TipoAlimentacion.CARNIVORO) {
                nuevoAnimal = new Carnivoro(edad, peso, especie, sectorCompatible);
            } else {
                int altura = Integer.parseInt(JOptionPane.showInputDialog("Altura del herbívoro (cm):"));
                nuevoAnimal = new Herbivoro(edad, peso, especie, sectorCompatible, altura);
            }

            Persistencia.getAnimales().add(nuevoAnimal);
            JOptionPane.showMessageDialog(null, "Animal agregado correctamente al zoológico.");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al ingresar los datos: " + e.getMessage());
        }
    }
    
    
    
    
}
