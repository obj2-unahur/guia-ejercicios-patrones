package ar.edu.unahur.obj2.ejercicio1y2;

public abstract class SistemaDeAmortizacion {

    private Prestamo prestamo;

    public SistemaDeAmortizacion(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

    public abstract  double capital(Prestamo prestamo);

    public int duracion(Prestamo prestamo)  {
        return 180;
    }

    protected double factorDeRiesgo() {
        return 1.8;
    }


}
