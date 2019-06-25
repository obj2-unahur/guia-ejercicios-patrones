package ar.edu.unahur.obj2.ejercicio1y2;

public abstract class SistemaDeAmortizacion {

    private Prestamo prestamo;

    public SistemaDeAmortizacion(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

    public final double capital(Prestamo prestamo) {
        return prestamo.getCompromiso()*
                porcentajeNoUtilizado(prestamo) *
                duracion(prestamo)*
                factorDeRiesgo();
    }

    protected abstract int duracion(Prestamo prestamo);

    protected abstract boolean usaPorcentajeNoUtilizado();

    private double porcentajeNoUtilizado(Prestamo prestamo) {
        if (usaPorcentajeNoUtilizado()) {
            return prestamo.getPorcentajeNoUtilizado();
        } else {
            return 1;
        }
    }

    protected double factorDeRiesgo() {
        return 1.8;
    }

}
