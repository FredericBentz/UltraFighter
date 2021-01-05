public class Dice {
    private final int nbFace;

    //Constructor
    public Dice(int nbFace) {
        this.nbFace = nbFace;
    }

    //Methode
    public int lancerDe(){
        return ((int) (Math.random() * (nbFace)) +1);
    }
    //Get

    //Set

}
