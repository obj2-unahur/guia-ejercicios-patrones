package ar.edu.unahur.obj2.ejercicio1y2;

public class SistemaAleman extends SistemaDeAmortizacion {

    public SistemaAleman(Prestamo prestamo) {
        super(prestamo);
    }

    @Override
    public double capital(Prestamo prestamo) {
        return prestamo.getCompromiso()*
                duracion(prestamo)*
                factorDeRiesgo();
    }

    @Override
    public int duracion(Prestamo prestamo) {
        return 360;
    }
}
