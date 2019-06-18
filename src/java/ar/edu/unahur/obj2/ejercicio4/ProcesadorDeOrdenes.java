package ar.edu.unahur.obj2.ejercicio4;

public class ProcesadorDeOrdenes {

    public void procesarOrden(boolean regalo) {
        seleccionarProducto();
        pagarProducto();
        if (regalo) {
            envolverParaRegalo();
        }
        entregar();
    }

    protected void seleccionarProducto() {
        System.out.println("Se seleccionar el producto en el local");
    }

    protected void envolverParaRegalo() {
        System.out.println("Se envuelve para regalo el producto");
    }

    protected void pagarProducto() {
        System.out.println("Se Paga el producto con efecto o posnet");
    }

    protected void entregar() {
        System.out.println("Se entrega el producto en el mostrador");
    }
}
