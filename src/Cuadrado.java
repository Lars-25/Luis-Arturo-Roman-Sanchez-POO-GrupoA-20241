public class Cuadrado extends Shape {
    double lado;

    public Cuadrado(double lado){
        this.lado = lado;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Cuadrado");
        System.out.println("Lado: " + lado);
    }

    @Override
    public void calcularArea() {
        System.out.println("Área del cuadrado: " + Math.pow(lado, 4));
    }

    @Override
    public void calcularPerimetro() {
        System.out.println("Perímetro del cuadrado: " + lado * 4);
    }
    
}
