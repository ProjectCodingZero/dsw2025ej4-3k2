package domain;

public enum TipoAlimentacion {
    CARNIVORO,
    HERBIVORO,
    OMNIVORO;

    public boolean esCarnivoro () {
        return this == CARNIVORO;
    }

    public boolean esHerbivoro(){
        return this == HERBIVORO;
    }
    public TipoAlimentacion getTipo(String string){
        if(string.equals(CARNIVORO.toString())){
            return this.CARNIVORO;
        }else if(string.equals(HERBIVORO.toString())){
            return this.HERBIVORO;
        }else{
            return this.OMNIVORO;
        }
    }
    
}
