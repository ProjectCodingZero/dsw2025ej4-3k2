package views;

import data.Persistencia;
import domain.TipoAlimentacion;

import javax.swing.*;
import java.util.InvalidPropertiesFormatException;

public class Program {

    public static void main(String[] args) throws IllegalArgumentException, InvalidPropertiesFormatException {
        Persistencia.inicializar();
        ListarAnimalesView view = new ListarAnimalesView();
        AltaAnimalViewModel view2 = new AltaAnimalViewModel();
        view2.setVisible(true);
        view.setVisible(true);
        data.Persistencia.inicializar(); // borra animales generados por código
        views.IngresoAnimalView.mostrarFormulario(); // agrega uno nuevo

    }
}
