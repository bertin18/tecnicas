public class PontoPlano {
    protected double x, y;

    public PontoPlano() {
        this.x = 0;
        this.y = 0;
    }

    public PontoPlano(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setCoordenadas(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public String getCoordenadas() {
        return "(" + x + ", " + y + ")";
    }

    public double distancia(PontoPlano outro) {
        return Math.sqrt(Math.pow(x - outro.x, 2) + Math.pow(y - outro.y, 2));
    }

    @Override
    public String toString() {
        return getCoordenadas();
    }
}