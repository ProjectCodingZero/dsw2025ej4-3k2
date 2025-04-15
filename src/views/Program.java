package views;

import data.Persistencia;
import domain.TipoAlimentacion;

import javax.swing.*;
import java.util.InvalidPropertiesFormatException;

public class Program {

    public static void main(String[] args) throws IllegalArgumentException, InvalidPropertiesFormatException {
        Persistencia.inicializar();
        ListarAnimalesView view = new ListarAnimalesView();
        view.setVisible(true);
        data.Persistencia.inicializar(); // borra animales generados por código
        views.IngresoAnimalView.mostrarFormulario(); // agrega uno nuevo

    }
}
