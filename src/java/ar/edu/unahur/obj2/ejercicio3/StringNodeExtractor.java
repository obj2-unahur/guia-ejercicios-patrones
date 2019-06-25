package ar.edu.unahur.obj2.ejercicio3;

public class StringNodeExtractor implements NodeExtractor {
    @Override
    public void extract(Node node, StringBuffer text) {
        text.append(((StringNode)node).getText());
    }
}
