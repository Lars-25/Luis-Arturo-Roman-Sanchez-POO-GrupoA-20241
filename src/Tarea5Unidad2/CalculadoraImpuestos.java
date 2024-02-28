public class CalculadoraImpuestos {
    public double calcularImpuestos(int ingresos) {
        return ingresos + 0.15;
    }

    public double calcularImpuestos(int ingresos, double porcentajeImpuestos) {
        return ingresos * porcentajeImpuestos/100;
    }

    public double calcularImpuestos(int ingresos, double porcentajeImpuestos, double dividendos, double exencion) {

        double impuestos = dividendos * (porcentajeImpuestos / 100);
        if (impuestos > exencion){
            return impuestos - exencion;
        }
        return 0;

    }


}
