package ar.edu.unahur.obj2.ejercicio3;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.testng.Assert.*;

public class TextExtractorTest {

    private Tag tag;
    private StringNode stringNode;
    private LinkTag linkTag;
    private Parser parser;


    @BeforeMethod
    public void setUp() {
        tag = new Tag("texto1");
        stringNode = new StringNode("texto2");
        linkTag = new LinkTag("texto3");
        parser = new Parser(Stream.of(tag, stringNode, linkTag).collect(Collectors.toList()));
    }

    @Test
    public void testExtractText() {
        TextExtractor textExtractor = new TextExtractor();
        String resultado = textExtractor.extractText(parser);
        String esperado = "texto1" + "texto2" + "texto3";
        assertEquals(resultado, esperado);
    }
}