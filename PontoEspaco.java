public class PontoEspaco extends PontoPlano {
    private double z;

    public PontoEspaco() {
        super();
        this.z = 0;
    }

    public PontoEspaco(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    public void setCoordenadas(double x, double y, double z) {
        super.setCoordenadas(x, y);
        this.z = z;
    }

    @Override
    public String getCoordenadas() {
        return "(" + x + ", " + y + ", " + z + ")";
    }

    public double distancia(PontoEspaco outro) {
        return Math.sqrt(Math.pow(x - outro.x, 2) +
                         Math.pow(y - outro.y, 2) +
                         Math.pow(z - outro.z, 2));
    }

    @Override
    public String toString() {
        return getCoordenadas();
    }
}