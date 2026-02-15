public class EstacionamientoService {

    public boolean validarHoras(int horas) {
        return horas >= 0;
    }

    public boolean validarTarifa(double tarifa) {
        return tarifa > 0;
    }

    public double calcularSubtotal(int horas, double tarifa) {
        return horas * tarifa;
    }

    public double aplicarDescuentoHoras(double total, int horas) {

        if (horas > 10) {
            return total * 0.88;  // 12% descuento
        }

        return total;
    }

    public double aplicarDescuentoBoleto(double total, boolean tieneBoleto) {

        if (tieneBoleto) {
            return total * 0.95;  // 5% descuento
        }

        return total;
    }
}
