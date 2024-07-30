import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Banque {
    private Map<String, CompteBancaire> comptes = new HashMap<>();

    public void ajouterCompte(CompteBancaire compte) {
        comptes.put(compte.getNumeroCompte(), compte);
        try{
            FileWriter f = new FileWriter("data.txt", true);
            f.write(compte.getNumeroCompte() + " " + compte.getNomTitulaire() + " " + compte.getSolde() + "\n");
            f.close();
            System.out.println("Le compte a été enregistré avec succès !");
        } catch (IOException e) {
            System.out.println("L'enregistrement du compte a echoué");
        }
    }

    public void supprimerCompte(String numeroCompte) throws CompteNonTrouveException {
        if (comptes.remove(numeroCompte) == null) {
            throw new CompteNonTrouveException("Compte non trouvé.");
        }
        System.out.println("Le compte a été supprimé avec succès !");
    }

    public CompteBancaire rechercherCompteParNom(String nomTitulaire) throws CompteNonTrouveException {
        for (CompteBancaire compte : comptes.values()) {
            if (compte.getNomTitulaire().equalsIgnoreCase(nomTitulaire)) {
                return compte;
            }
        }
        throw new CompteNonTrouveException("Compte non trouvé.");
    }

    public void afficherComptesParLettre(char lettre) {
        for (CompteBancaire compte : comptes.values()) {
            if (compte.getNomTitulaire().charAt(0) == lettre) {
                compte.afficherDetails();
            }
        }
    }

    public void afficherNombreComptesParType() {
        int nbCourant = 0, nbEpargne = 0;
        for (CompteBancaire compte : comptes.values()) {
            if (compte instanceof CompteCourant) {
                nbCourant++;
            } else if (compte instanceof CompteEpargne) {
                nbEpargne++;
            }
        }
        System.out.println("Nombre de Comptes Courants: " + nbCourant);
        System.out.println("Nombre de Comptes Épargne: " + nbEpargne);
    }

    public void afficherComptesParType(Class<?> type) {
        for (CompteBancaire compte : comptes.values()) {
            if (type.isInstance(compte)) {
                compte.afficherDetails();
            }
        }
    }

    public void afficherDetailsCompte(String numeroCompte) {
        CompteBancaire compte = comptes.get(numeroCompte);
        if (compte != null) {
            compte.afficherDetails();
        } else {
            System.out.println("Compte non trouvé.");
        }
    }

    // Fonctions supplémentaires

    public void transfererFonds(String numeroCompteSource, String numeroCompteDestination, double montant) {
        CompteBancaire source = comptes.get(numeroCompteSource);
        CompteBancaire destination = comptes.get(numeroCompteDestination);

        if (source != null && destination != null && source.getSolde() >= montant) {
            source.solde -= montant;
            destination.solde += montant;
            System.out.println("Transfert réussi de " + montant + " de " + numeroCompteSource + " à " + numeroCompteDestination);
        } else {
            System.out.println("Transfert échoué.");
        }
    }

    public void mettreAJourTitulaire(String numeroCompte, String nouveauNom) {
        CompteBancaire compte = comptes.get(numeroCompte);
        if (compte != null) {
            compte.nomTitulaire = nouveauNom;
            System.out.println("Nom du titulaire mis à jour.");
        } else {
            System.out.println("Compte non trouvé.");
        }
    }
}
