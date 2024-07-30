public class CompteEpargne extends CompteBancaire {
    private double tauxInteret;

    public CompteEpargne(String numeroCompte, String nomTitulaire, double solde, double tauxInteret) {
        super(numeroCompte, nomTitulaire, solde);
        this.tauxInteret = tauxInteret;
    }

    @Override
    public void afficherDetails() {
        System.out.println("Compte Épargne: " + numeroCompte + ", Titulaire: " + nomTitulaire + ", Solde: " + solde + ", Taux d'Intérêt: " + tauxInteret);
    }
}
