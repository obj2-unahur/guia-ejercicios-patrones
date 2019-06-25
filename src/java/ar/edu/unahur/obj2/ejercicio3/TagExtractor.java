package ar.edu.unahur.obj2.ejercicio3;

public class TagExtractor implements NodeExtractor {
    @Override
    public void extract(Node node, StringBuffer text) {
        text.append(((Tag)node).getValue());
    }
}
