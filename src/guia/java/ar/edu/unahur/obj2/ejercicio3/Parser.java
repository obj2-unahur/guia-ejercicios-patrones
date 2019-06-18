package ar.edu.unahur.obj2.ejercicio3;

import java.util.List;

public class Parser {

    private List<Node> nodes;

    public Parser(List<Node> nodes) {
        this.nodes = nodes;
    }

    public List<Node> nodes() {
        return nodes;
    }
}
