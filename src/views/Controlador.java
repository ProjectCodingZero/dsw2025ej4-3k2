package views;

import data.Persistencia;
import domain.*;

import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;
import java.util.List;

public class Controlador {
    public static TipoAlimentacion[] getTiposAlimentacion(){
        return  TipoAlimentacion.values();
    }
    public static ArrayList<Especie> getEspecies(){
        return Persistencia.getEspecies();
    }
    public static ArrayList<Sector> getSectores(){
        return Persistencia.getSectores();
    }
    
    public static ArrayList<AnimalViewModel> getAnimales(){
        ArrayList<AnimalViewModel> animales = new ArrayList<>();
        for(Mamifero animal : Persistencia.getAnimales()){
            animales.add(new AnimalViewModel(animal));
        }
        return animales;
    }
    public static void agregarAnimal(Mamifero mamifero){
        double edad = mamifero.getEdad();
        double peso = mamifero.getPeso();
        if(!(edad >= 0 && peso > 0)){ 
            System.err.printf("La edad: %.2f\nEl peso: %.2f\n", edad, peso);
            return;
        }
        try {
            if(mamifero.getEspecie() == null)
                throw new java.lang.NullPointerException();
            if(mamifero.getSector() == null)
                throw new java.lang.NullPointerException();
            
        }catch (java.lang.Exception e){
            System.err.println("Se produjo un error al intentar agregar");
            return;
        }
        Persistencia.agregarAnimal(mamifero);
    }
    public static ComidaViewModel  calcularComida(){
        double totalCarnivoros = Persistencia.getTotalComida(TipoAlimentacion.CARNIVORO);
        double totalHerbivoros = Persistencia.getTotalComida(TipoAlimentacion.HERBIVORO);
        return new ComidaViewModel(totalCarnivoros, totalHerbivoros);
    }
}
