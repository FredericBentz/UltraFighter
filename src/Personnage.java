import java.io.Serializable;
import java.nio.file.Paths;

public class Personnage {
    Race Race;
    Classe Classe;
//    Historique Historique;
    int niveau;

    private int force, dexterite,  constitution, intelligence, sagesse, charisme;
    private int pointVieBase, pointVie;
    String nom, sexe, alignement;
    int age;
    float taille;
    float poids;
    int pointExperience;

//    int pointMagieBase;
//    int pointMagie;






    public Personnage(){
        nom = "Inconnu";
        pointVieBase = 10;
        pointVie = pointVieBase;
//        pointMagieBase = 5;
//        pointMagie = pointMagieBase;
        this.force =10;

        System.out.println("Personnage par défaut créé");
    }

    public Personnage(String nom, int pointVieBase, int pointVie, int force) {
        this.nom = nom;
        this.pointVieBase = pointVieBase;
        this.pointVie = pointVie;
//        this.pointMagie = pointMagie;
        this.force = force;

        System.out.println("Personnage " + nom + " créé !");
    }



    //Methode
    public void repos(){
        int recup = (int) (Math.random() * (9 +1));
        // Assure de ne pas dépasser les points de vie de base
        setPointVie(Math.min(getPointVie() + recup, getPointVieBase()));
        System.out.println(
                getNom() + " a récupéré " + recup + " points de vie, il a maintenant "
                + getPointVie() + " points de vie.");
    }

    public void fight(Personnage Opponent){
        Opponent.setPointVie(Opponent.getPointVie() - Opponent.getForce());
        if (Opponent.getPointVie() > 0){
            setPointVie(getPointVie() - Opponent.getForce());
        }
    }

    //Getter
    public String getNom() {
        return nom;
    }

    public int getPointVieBase() {
        return pointVieBase;
    }

    public int getPointVie() {
        return pointVie;
    }

    public int getForce() {
        return force;
    }

    //Setter


    public void setPointVie(int pointVie) {
        if (pointVie > pointVieBase) {
            this.pointVie = pointVieBase;
        }
        else this.pointVie = Math.max(pointVie, 0);

    }
}
