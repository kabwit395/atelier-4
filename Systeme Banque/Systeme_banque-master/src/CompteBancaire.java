public abstract class CompteBancaire {
    protected String numeroCompte;
    protected String nomTitulaire;
    protected double solde;

    public CompteBancaire(String numeroCompte, String nomTitulaire, double solde) {
        this.numeroCompte = numeroCompte;
        this.nomTitulaire = nomTitulaire;
        this.solde = solde;
    }

    public String getNumeroCompte() {
        return numeroCompte;
    }

    public String getNomTitulaire() {
        return nomTitulaire;
    }

    public double getSolde() {
        return solde;
    }

    public abstract void afficherDetails();
}
