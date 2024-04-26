public class Circulo implements Shape{
    double radio;
    final double PI = 3.1416;

    public Circulo(int radio){
        this.radio = radio;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Circulo");
        System.out.println("Radio: " + radio);
        System.out.println("Diametro: "+ radio * 2);
    }

    @Override
    public void calcularArea() {
        System.out.println("Área del circulo: " + PI * Math.pow(radio, 2));
    }

    @Override
    public void calcularPerimetro() {
        System.out.println("Perímetro del circulo: " + 2 * PI * radio);
    }

    
}