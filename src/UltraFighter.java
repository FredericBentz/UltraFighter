import java.util.Scanner;

public class UltraFighter {
    public static void main(String[] args) {
        //VAR
        boolean quit = false;
        Scanner scan = new Scanner(System.in);
        String input;
        byte roundRandom = (byte) new Dice(10).lancerDe();

        Arena coliseum = new Arena();

        Personnage ken = new Personnage();
        Personnage conan = new Personnage("Conan", 10 ,5, 20);
        Personnage hulk = new Personnage("Hulk", 30, 50, 50);
        Personnage spiderman = new Personnage("Spiderman", 10, 9, 30 );
        Personnage batman = new Personnage("batman", 10, 10, 10);

        coliseum.addFighter(ken);
        coliseum.addFighter(conan);
        coliseum.addFighter(hulk);
        coliseum.addFighter(spiderman);
        coliseum.addFighter(batman);


// Demander
        while (!quit) {
            System.out.println("--------------------------------------------------------------");
            System.out.println(
                    "Que souhaitez vous faire ? (Entrez le numéro correspondant)\n" +
                            "1 : Charger\n" +
                            "2 : Sauvegarder\n" +
                            "3 : Lancer un combat dans le Coliseum\n" +
                            "4 : Afficher la liste des combatants\n" +
                            "5 : Quitter");
            input = scan.nextLine();
            switch (input){
                case "1" -> coliseum = coliseum.loadArena();

                case "2" -> coliseum.saveManual();

                case "3" -> coliseum.fight(roundRandom);

                case "4" -> coliseum.printArenaFightersStatus();

                case "5" -> quit = true;

                default -> System.out.println("Vous n'avez pas entré un choix valide, recommencez");

            }
            System.out.println();
        }








////        System.out.println(conan.hashCode());
//        conan.repos();
//        Method[] methodes = conan.getClass().getMethods();
//        for (Method m : methodes) {
////            System.out.println(m);
//        }






    }
}
