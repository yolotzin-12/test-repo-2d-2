import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BibliotecaService service = new BibliotecaService();

        int totalValidos = 0;
        int permitidos = 0;
        int denegados = 0;

        while (true) {

            System.out.println("Ingresa codigo (o SALIR):");
            String codigo = sc.nextLine();

            if (codigo.equals("SALIR")) {
                break;
            }

            if (!service.esCodigoValido(codigo)) {
                System.out.println("Codigo invalido");
                continue;
            }

            totalValidos++;

            System.out.println("Es alumno? (true/false)");

            if (!sc.hasNextBoolean()) {
                System.out.println("Tipo invalido");
                return;
            }

            boolean esAlumno = sc.nextBoolean();

            System.out.println("Hora de entrada:");

            if (!sc.hasNextInt()) {
                System.out.println("Hora invalida");
                return;
            }

            int hora = sc.nextInt();
            sc.nextLine();

            if (hora < 0 || hora > 23) {
                System.out.println("Hora invalida");
                return;
            }

            if (hora >= 21) {
                System.out.println("Biblioteca cerrada");
                break;
            }

            if (service.esHorarioPermitido(hora, esAlumno)) {
                System.out.println("Permitido");
                permitidos++;
            } else {
                System.out.println("Denegado");
                denegados++;
            }
        }

        System.out.println("Total validos: " + totalValidos);
        System.out.println("Permitidos: " + permitidos);
        System.out.println("Denegados: " + denegados);

        if (totalValidos > 0) {
            double porcentaje = (permitidos * 100.0) / totalValidos;
            System.out.printf("Porcentaje permitidos: %.2f%%\n", porcentaje);
        }
    }
}
