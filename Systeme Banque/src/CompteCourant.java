public class CompteCourant extends CompteBancaire {
    private double decouvertAutorise;

    public CompteCourant(String numeroCompte, String nomTitulaire, double solde, double decouvertAutorise) {
        super(numeroCompte, nomTitulaire, solde);
        this.decouvertAutorise = decouvertAutorise;
    }

    @Override
    public void afficherDetails() {
        System.out.println("Compte Courant: " + numeroCompte + ", Titulaire: " + nomTitulaire + ", Solde: " + solde + ", Découvert Autorisé: " + decouvertAutorise);
    }
}
