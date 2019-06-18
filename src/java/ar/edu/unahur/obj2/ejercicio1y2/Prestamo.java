package ar.edu.unahur.obj2.ejercicio1y2;

import java.util.Date;

public class Prestamo {

    private SistemaDeAmortizacion estrategia;
    private float hipoteca;
    private float excepcional;
    private int rating;
    private Date expiry;
    private Date madurez;



    public Prestamo(float hipoteca, float excepcional,
                    int rating, Date expiry) {
        this.estrategia = new SistemaFrances(this);
        this.hipoteca = hipoteca;
        this.excepcional = excepcional;
        this.rating = rating;
        this.expiry = expiry;
    }
    public Prestamo(float hipoteca, float excepcional,
                    int rating, Date expiry, Date madurez) {
        this.estrategia = new SistemaFrances(this);
        this.hipoteca = hipoteca;
        this.excepcional = excepcional;
        this.rating = rating;
        this.expiry = expiry;
        this.madurez = madurez;
    }

    public Prestamo(SistemaDeAmortizacion strategy, float hipoteca, float excepcional,
                    int rating, Date expiry, Date madurez) {
        this.estrategia = strategy;
        this.hipoteca = hipoteca;
        this.excepcional = excepcional;
        this.rating = rating;
        this.expiry = expiry;
        this.madurez = madurez;
    }

    public double getCompromiso() {
        return hipoteca*rating;
    }

    public double getPorcentajeNoUtilizado() {
        return excepcional*rating;
    }
}