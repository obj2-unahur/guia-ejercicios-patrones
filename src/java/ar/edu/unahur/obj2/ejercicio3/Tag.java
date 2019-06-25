package ar.edu.unahur.obj2.ejercicio3;

public class Tag  extends Node {

    private String value;

    public Tag(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String nodeName() {
        return "Tag";
    }
}
