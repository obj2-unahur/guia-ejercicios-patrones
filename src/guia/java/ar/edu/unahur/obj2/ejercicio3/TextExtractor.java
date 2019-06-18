package ar.edu.unahur.obj2.ejercicio3;

public class TextExtractor {

    public String extractText(Parser parser) {
        StringBuffer text = new StringBuffer();
        for (Node node : parser.nodes()) {
            if(node instanceof LinkTag) {
                extractLinkTag(node, text);
            } else if(node instanceof Tag) {
                extractTag(node, text);
            } else if(node instanceof StringNode) {
                extractStringNode(node, text);
            } else {
                throw new RuntimeException("Tipo de Nodo no soportado");
            }
        }
        return text.toString();
    }

    private void extractStringNode(Node node, StringBuffer text) {
        text.append(((StringNode)node).getText());
    }

    private void extractTag(Node node, StringBuffer text) {
        text.append(((Tag)node).getValue());
    }

    private void extractLinkTag(Node node, StringBuffer text) {
        text.append(((LinkTag)node).getLabel());
    }

}
