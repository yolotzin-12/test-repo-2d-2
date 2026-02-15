import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EstacionamientoService servicio = new EstacionamientoService();

        System.out.println("Horas estacionado:");

        if (!sc.hasNextInt()) {
            System.out.println("Entrada inválida");
            return;
        }

        int horas = sc.nextInt();

        if (!servicio.validarHoras(horas)) {
            System.out.println("Horas inválidas");
            return;
        }

        System.out.println("Tarifa por hora:");

        if (!sc.hasNextDouble()) {
            System.out.println("Entrada inválida");
            return;
        }

        double tarifa = sc.nextDouble();

        if (!servicio.validarTarifa(tarifa)) {
            System.out.println("Tarifa inválida");
            return;
        }

        System.out.println("¿Tiene boleto de descuento? (true/false)");

        if (!sc.hasNextBoolean()) {
            System.out.println("Entrada inválida");
            return;
        }

        boolean tieneBoleto = sc.nextBoolean();

        double subtotal = servicio.calcularSubtotal(horas, tarifa);

        double totalConDescHoras = servicio.aplicarDescuentoHoras(subtotal, horas);

        double totalFinal = servicio.aplicarDescuentoBoleto(totalConDescHoras, tieneBoleto);

        double descuentoTotal = subtotal - totalFinal;

        if (totalFinal > 1000) {
            System.out.println("Requiere autorización");
        }

        System.out.printf("Subtotal: %.2f\n", subtotal);
        System.out.printf("Descuento total: %.2f\n", descuentoTotal);
        System.out.printf("Total final: %.2f\n", totalFinal);
    }
}
