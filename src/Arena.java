
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Arena implements Serializable {

    @Serial
    private static final long serialVersionUID = -6747922884334679808L;
    //Var
    List<Personnage> lstFighters = new ArrayList<>();

    String saveName = this.getClass().getSimpleName() + "Save";
    String autoSaveName = this.getClass().getSimpleName() + "AutoSave";

    //Construct


    //Methode
    public void addFighter(Personnage Fighter) {
        lstFighters.add(Fighter);
    }

    public void fight(byte nbRound) {
        int nbFighters = lstFighters.size() -1;
        int indexFighter1, indexFighter2 = -1;
        Personnage Fighter1, Fighter2;
        Dice indexRandom = new Dice(nbFighters - 1);

        if (nbFighters > 1) {
            do {
                indexFighter1 = indexRandom.lancerDe();
                Fighter1 = lstFighters.get(indexFighter1);
            }while (Fighter1.getPointVie() == 0);

            while (indexFighter2 == -1 || indexFighter2 == indexFighter1){
                do {
                    indexFighter2 = indexRandom.lancerDe();
                    Fighter2 = lstFighters.get(indexFighter2);
                }while (Fighter2.getPointVie() == 0);

            lstFighters.get(indexFighter1).fight(Fighter2);
            lstFighters.get(indexFighter2).fight(Fighter1);
            }
        } else
            System.out.println(
                    "Il faut au minimum 2 combatants dans l'arène, nombre de combatants présents: " + nbFighters);
    }

    public void printArenaFightersStatus(){
        //TODO
    }

    public void saveManual(){
        save(saveName);
    }

    public void saveAuto(){
        save(autoSaveName);
    }

    private void save(String saveName) {
        IOException error = null;
        try (
                final FileOutputStream save = new FileOutputStream(saveName);
                ObjectOutputStream oos = new ObjectOutputStream(save);
        ) {
            oos.writeObject(this);
            oos.flush();

        }
        catch (final IOException e) {
            error = e;
            e.printStackTrace();
        }
        finally {
            if (error == null){
                System.out.println("La sauvegarde " + saveName + " a été effectuée" );

            }else System.out.println("Sauvegarde error");
        }
    }

    public Arena loadArena(){
        IOException error = null;
        Arena Arena = null;
        try (
            FileInputStream fis = new FileInputStream(saveName);
            ObjectInputStream ois = new ObjectInputStream(fis);
        ){
            Arena = (Arena) ois.readObject();


        } catch (IOException | ClassNotFoundException e) {
            assert e instanceof IOException;
            error = (IOException) e;
            e.printStackTrace();
        }
        finally {
            if (error == null){
                System.out.println("Dernière sauvegarde " + saveName + " , chargée" );


            }else System.out.println("Loading error");
        }
        return Arena;
    }
}
