public class Hexagono extends Shape {
    double lado;
    double apotema;
    double perimetro = lado * 6; 

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
        System.out.println("Área del hexagono: " + ((perimetro)*(apotema)) / 2);
    }

    @Override
    public void calcularPerimetro() {
        System.out.println("Perímetro del hexagono: " + perimetro);
    }
    
}
