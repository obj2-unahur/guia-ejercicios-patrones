package ar.edu.unahur.obj2.ejercicio3;

public class LinkTagExtractor implements NodeExtractor {
    @Override
    public void extract(Node node, StringBuffer text) {
        text.append(((LinkTag)node).getLabel());
    }
}
