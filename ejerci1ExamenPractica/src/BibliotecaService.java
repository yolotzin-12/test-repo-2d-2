public class BibliotecaService {

    public boolean esCodigoValido(String codigo) {

        if (codigo == null) {
            return false;
        }

        if (codigo.trim().isEmpty()) {
            return false;
        }

        if (codigo.length() != 6) {
            return false;
        }

        return true;
    }

    public boolean esHorarioPermitido(int hora, boolean esAlumno) {

        if (esAlumno) {
            if (hora >= 8 && hora <= 20) {
                return true;
            } else {
                return false;
            }
        } else {
            if (hora >= 10 && hora <= 18) {
                return true;
            } else {
                return false;
            }
        }
    }
}
