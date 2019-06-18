package ar.edu.unahur.obj2.ejercicio4;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.testng.Assert.*;

public class ProcesadorDeOrdenesTest {

    // Guardo el System.out original antes de modificarlo
    private final PrintStream originalStdOut = System.out;
    private ByteArrayOutputStream consoleContent = new ByteArrayOutputStream();


    @BeforeMethod
    public void beforeTest()
    {
        // Guardo el System.out en consoleContent
        System.setOut(new PrintStream(this.consoleContent));
    }

    @org.testng.annotations.Test
    public void testProcesarOrdenRegalo() {
        ProcesadorDeOrdenes procesadorDeOrdenes = new ProcesadorDeOrdenes();
        procesadorDeOrdenes.procesarOrden(true);

        String consola = this.consoleContent.toString();

        assertTrue(consola.indexOf("Se seleccionar el producto en el local")!=-1);
        assertTrue(consola.indexOf("Se envuelve para regalo el producto")!=-1);
        assertTrue(consola.indexOf("Se Paga el producto con efecto o posnet")!=-1);
        assertTrue(consola.indexOf("Se entrega el producto en el mostrador")!=-1);

    }

    @org.testng.annotations.Test
    public void testProcesarOrdenNoRegalo() {
        ProcesadorDeOrdenes procesadorDeOrdenes = new ProcesadorDeOrdenes();
        procesadorDeOrdenes.procesarOrden(false);

        String consola = this.consoleContent.toString();
        assertTrue(consola.indexOf("Se seleccionar el producto en el local")!=-1);
        assertTrue(consola.indexOf("Se envuelve para regalo el producto")==-1);
        assertTrue(consola.indexOf("Se Paga el producto con efecto o posnet")!=-1);
        assertTrue(consola.indexOf("Se entrega el producto en el mostrador")!=-1);

    }


    @AfterMethod
    public void afterTest()
    {
        // Guardo el System.out original
        System.setOut(this.originalStdOut);

        // Clear the consoleContent.
        this.consoleContent = new ByteArrayOutputStream();
    }

}