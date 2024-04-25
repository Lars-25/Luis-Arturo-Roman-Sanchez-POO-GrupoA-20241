public class Triangulo extends Shape {
    double base;
    double altura;

    public Triangulo(double base, double altura){
        this.base = base;
        this.altura = altura;
    }

    @Override
    public void mostrarInfo(){
        System.out.println("Triangulo");
        System.out.println("Base: " + base);
        System.out.println("Altura: " + altura);
    }

    @Override
    public void calcularArea() {
        System.out.println("Área del triangulo: " + (base * altura) / 2);
    }

    @Override
    public void calcularPerimetro() {
        System.out.println("Perímetro del triangulo: " + base * 3);   
    }



    
}
