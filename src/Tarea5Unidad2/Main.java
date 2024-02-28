import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Rectangulo rectangulo = new Rectangulo();

        System.out.println("Ingrese la base del rectángulo:");
        double base = scanner.nextDouble();
        System.out.println("Ingrese la altura del rectángulo:");
        double altura = scanner.nextDouble();

        double areaDoubles = rectangulo.calcularArea(base, altura);
        System.out.println("Área del rectángulo: " + areaDoubles);

        double perimetroDoubles = rectangulo.calcularPerimetro(base, altura);
        System.out.println("Perímetro del rectángulo: " + perimetroDoubles);

        Empleado empleado = new Empleado();

        System.out.println("Ingrese el sueldo base del empleado:");
        double sueldoBase = scanner.nextDouble();
        System.out.println("Ingrese la bonificación del empleado:");
        double bonificacion = scanner.nextDouble();
        System.out.println("Ingrese las horas extras del empleado:");
        int horasExtras = scanner.nextInt();

        double salario = empleado.calcularSalario(sueldoBase, bonificacion, horasExtras);
        System.out.println("Salario del empleado: $" + salario);

        CalculadoraImpuestos impuestos = new CalculadoraImpuestos();
        System.out.println("ingresos: " + impuestos.calcularImpuestos(100));
        System.out.println("ventas: " + impuestos.calcularImpuestos(100, 50));
        System.out.println("porcentaje impuestos: " + impuestos.calcularImpuestos(0, 50, 30, 40));
        System.out.println("porcentaje impuestos: " + impuestos.calcularImpuestos(0, 70, 30, 1));

        scanner.close();
    }
}
