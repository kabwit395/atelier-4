import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Banque banque = new Banque();
        Scanner scanner = new Scanner(System.in);
        boolean continuer = true;

        while (continuer) {
            System.out.println("Choisissez une opération:");
            System.out.println("1. Ajouter un compte bancaire");
            System.out.println("2. Supprimer un compte bancair&é1e");
            System.out.println("3. Modifier un compte bancaire par son identifiant");
            System.out.println("4. Rechercher un compte bancaire par nom de titulaire");
            System.out.println("5. Lister les comptes bancaires en saisissant une lettre alphabétique");
            System.out.println("6. Afficher le nombre de comptes bancaires par type");
            System.out.println("7. Afficher les comptes par type");
            System.out.println("8. Afficher les détails d'un compte par son identifiant");
            System.out.println("9. Transférer des fonds entre comptes");
            System.out.println("10. Mettre à jour les informations du titulaire");
            System.out.println("11. Quitter");

            int choix = scanner.nextInt();
            scanner.nextLine();  // Consommer la nouvelle ligne

            switch (choix) {
                case 1:
                    System.out.println("Ajouter un compte bancaire:");
                    System.out.print("Type de compte (1: Courant, 2: Épargne): ");
                    int type = scanner.nextInt();
                    scanner.nextLine();  // Consommer la nouvelle ligne
                    System.out.print("Numéro de compte: ");
                    String numero = scanner.nextLine();
                    System.out.print("Nom du titulaire: ");
                    String nom = scanner.nextLine();
                    System.out.print("Solde initial: ");
                    double solde = scanner.nextDouble();
                    if (type == 1) {
                        System.out.print("Découvert autorisé: ");
                        double decouvert = scanner.nextDouble();
                        banque.ajouterCompte(new CompteCourant(numero, nom, solde, decouvert));
                    } else if (type == 2) {
                        System.out.print("Taux d'intérêt: ");
                        double taux = scanner.nextDouble();
                        banque.ajouterCompte(new CompteEpargne(numero, nom, solde, taux));
                    }
                    break;
                case 2:
                    System.out.println("Supprimer un compte bancaire:");
                    System.out.print("Numéro de compte: ");
                    numero = scanner.nextLine();
                    banque.supprimerCompte(numero);
                    break;
                case 3:
                    System.out.println("Modifier un compte bancaire par son identifiant:");
                    // Implémentation de la modification
                    break;
                case 4:
                    System.out.println("Rechercher un compte bancaire par nom de titulaire:");
                    System.out.print("Nom du titulaire: ");
                    nom = scanner.nextLine();
                    CompteBancaire compte = banque.rechercherCompteParNom(nom);
                    if (compte != null) {
                        compte.afficherDetails();
                    } else {
                        System.out.println("Compte non trouvé.");
                    }
                    break;
                case 5:
                    System.out.println("Lister les comptes bancaires en saisissant une lettre alphabétique:");
                    System.out.print("Lettre: ");
                    char lettre = scanner.nextLine().charAt(0);
                    banque.afficherComptesParLettre(lettre);
                    break;
                case 6:
                    System.out.println("Afficher le nombre de comptes bancaires par type:");
                    banque.afficherNombreComptesParType();
                    break;
                case 7:
                    System.out.println("Afficher les comptes par type:");
                    System.out.print("Type de compte (1: Courant, 2: Épargne): ");
                    type = scanner.nextInt();
                    if (type == 1) {
                        banque.afficherComptesParType(CompteCourant.class);
                    } else if (type == 2) {
                        banque.afficherComptesParType(CompteEpargne.class);
                    }
                    break;
                case 8:
                    System.out.println("Afficher les détails d'un compte par son identifiant:");
                    System.out.print("Numéro de compte: ");
                    numero = scanner.nextLine();
                    banque.afficherDetailsCompte(numero);
                    break;
                case 9:
                    System.out.println("Transférer des fonds entre comptes:");
                    System.out.print("Numéro de compte source: ");
                    String source = scanner.nextLine();
                    System.out.print("Numéro de compte destination: ");
                    String destination = scanner.nextLine();
                    System.out.print("Montant à transférer: ");
                    double montant = scanner.nextDouble();
                    banque.transfererFonds(source, destination, montant);
                    break;
                case 10:
                    System.out.println("Mettre à jour les informations du titulaire:");
                    System.out.print("Numéro de compte: ");
                    numero = scanner.nextLine();
                    System.out.print("Nouveau nom du titulaire: ");
                    String nouveauNom = scanner.nextLine();
                    banque.mettreAJourTitulaire(numero, nouveauNom);
                    break;
                case 11:
                    continuer = false;
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }

        scanner.close();
    }
}
