package ar.edu.unahur.obj2.ejercicio1y2;

public class SistemaFrances extends SistemaDeAmortizacion {

    public SistemaFrances(Prestamo prestamo) {
        super(prestamo);
    }

    @Override
    protected int duracion(Prestamo prestamo)  {
        return 180;
    }

    @Override
    protected boolean usaPorcentajeNoUtilizado() {
        return true;
    }
}
