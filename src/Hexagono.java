public class Hexagono implements Shape {
    double lado;
    double apotema;

    public Hexagono(int lado, int apotema){
        this.lado = lado;
        this.apotema = apotema;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Hexagono");
        System.out.println("Lado: " + lado);
        System.out.println("Apotema: " + apotema);
    }

    @Override
    public void calcularArea() {
        System.out.println("Área del hexagono: " + ((lado * 6)*(apotema)) / 2);
    }

    @Override
    public void calcularPerimetro() {
        System.out.println("Perímetro del hexagono: " + lado * 6);
    }
    
}
