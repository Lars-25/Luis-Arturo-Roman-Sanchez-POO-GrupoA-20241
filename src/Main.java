public class Main {
    public static void main(String[] args) {
        Hexagono hexagono1 = new Hexagono(3, 5);
        hexagono1.mostrarInfo();
        hexagono1.calcularArea();
        hexagono1.calcularPerimetro();

        System.out.println("==========================================");
        
        Triangulo triangulo1 = new Triangulo(3, 5);
        triangulo1.mostrarInfo();
        triangulo1.calcularArea();
        triangulo1.calcularPerimetro();

        System.out.println("==========================================");
    
        Cuadrado cuadro1 = new Cuadrado(3);
        cuadro1.mostrarInfo();
        cuadro1.calcularArea();
        cuadro1.calcularPerimetro();

        System.out.println("==========================================");

        Circulo circulo1 = new Circulo(3);
        circulo1.mostrarInfo();
        circulo1.calcularArea();
        circulo1.calcularPerimetro();
    }
    }



