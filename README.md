# Guia de ejercicios de patrones

## Ejercicio 1:

### En una sesión de code review se detecta el siguiente código. Se pide que proponga un refactor.

```
public class Prestamo {
    
    private EstrategiaDeCapital estrategia;
    private float hipoteca;
    private float excepcional;
    private int rating;
    private Date expiry;
    private Date madurez;

    
    public Prestamo(float hipoteca, float excepcional,
                    int rating, Date expiry) {
        this.estrategia = new SistemaFrances();
        this.hipoteca = hipoteca;
        this.excepcional = excepcional;
        this.rating = rating;
        this.expiry = expiry;
    }
    public Prestamo(float hipoteca, float excepcional,
                    int rating, Date expiry, Date madurez) {
        this.estrategia = new SistemaFrances();
        this.hipoteca = hipoteca;
        this.excepcional = excepcional;
        this.rating = rating;
        this.expiry = expiry;
        this.madurez = madurez;
    }

    public Prestamo(EstrategiaDeCapital strategy, float hipoteca, float excepcional,
                    int rating, Date expiry, Date madurez) {
        this.estrategia = strategy;
        this.hipoteca = hipoteca;
        this.excepcional = excepcional;
        this.rating = rating;
        this.expiry = expiry;
        this.madurez = madurez;
    }
}
```

## Ejercicio 2:

Se cuenta con el siguiente diseño para el cálculo del monto máximo a entregar en un préstamo según el método de amortización. 

![](/ejercicio1y2.png)

Proponga una mejora para evitar la repetición de código:

```
public class SistemaFrances extends SistemaDeAmortizacion {

    public SistemaFrances(Prestamo prestamo) {
        super(prestamo);
    }

    @Override
    public double capital(Prestamo prestamo) {
        return prestamo.getCompromiso()*
                prestamo.getPorcentajeNoUtilizado() *
                duracion(prestamo)*
                factorDeRiesgo();
    }
}
```

```
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
```

## Ejercicio 3:

Para un módulo de extracción de texto de markup se construyó la siguiente solución y ha pasado a revisión para mejorar el diseño. ¿Qué alternativa de diseño podría proponer para mejorar esta solución?

![](/ejercicio3.jpeg)

Donde el método extractText quedó como se indica:

```
public String extractText(Parser parser) {
    StringBuffer text = new StringBuffer();
    for (Node node : parser.nodes()) {
         if(node instanceof LinkTag) {
         extractLinkTag(node, text);
         } else if(node instanceof Tag) {
         extractTag(node, text);
         } else if(node instanceof StringNode) {
         extractStringNode(node, text);
         } else if(node instanceof ...) {
         [...]
         }
    }
    return text.toString();
}
```

## Ejercicio 4:

Se propone la siguiente problemática para la que debe proponer una solución usando correctamente los patrones de diseño que corresponda.

*
Una empresa de venta de productos deportivos comenzó con mas de 80 años en el mercado y con varios locales en el país comenzó a comerciales sus productos de forma online en su propio canal de ventas.
Quieren modificar su sistema informatica para que pueda ser utilizado en los locales a la calle como en el sitio web.
El códido que procesa actualmente las ordenes es el siguiente:

```
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

```

![](/ejercicio4.png)


Se solicita hacer los cambios necesarios para soportar las ventas hechas por el sitio web. La lógica para procesar una orden por el sitio es esencialmente igual a la de la venta en locales con las siguientes diferencias:

* La selección del producto se realiza agregandola al carrito de compras, indicando además si se quiere que se envuelva para regalo y a que dirección se requiere el envío.
* Al momento de pagar, solo se puede hacer por Transferencia bancaria o tarjeta de crédito.
* La entrega del producto es siempre con envío al domicilio indicado.

## Ejercicio 5:

Se propone la siguiente problemática para la que debe proponer una solución usando correctamente los patrones de diseño que corresponda.

*Su empresa quiere lanzar un nuevo portón para cocheras propietarias de edificios, que se manejan con un control remoto de un único botón. Como es de esperarse, cuando el portón está cerrado, el botón activa el mecanismo de apertura, y cuando está abierto, activa el mecanismo de cierre. En caso que se oprima el botón mientras se esté abriendo,  deberá interrumpir la apertura para iniciar el cierre desde el punto donde se encuentra, y viceversa en el caso de que se esté cerrando, que deberá pasar a abrirse. Por otra parte, los motores tienen indicadores de límites, que son configurables en posiciones del portón, y se usarán para demarcar la posición donde se considera `cerrado` y donde se considera completamente `abierto`.
Además, los sistemas, contarán con un timer de cerrado, para evitar que los portones queden abiertos si un usuario por olvido, o descuido, dejara de oprimir el botón para cerrar el portón. Si bien esta sería el único propósito del timer, es deseable que luego se puedan incorporar nuevas acciones disparadas por tiempo.
Para trabajar, considere que se estableció una interfaz que cuenta con una clase ‘EngineControl’ con al menos dos métodos, uno para el mensaje de botón presionado, y otro para el mensaje de posición marcada alcanzada. El control deberá actuar y arrancar
o detener el motor en uno de sus dos sentidos, OPEN_SIDE y CLOSE_SIDE.*
