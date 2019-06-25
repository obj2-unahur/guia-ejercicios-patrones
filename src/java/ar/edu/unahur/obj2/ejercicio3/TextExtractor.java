package ar.edu.unahur.obj2.ejercicio3;

import java.util.Map;

public class TextExtractor {

    private Map<String, NodeExtractor> extractors;

    public TextExtractor(Map<String, NodeExtractor> extractors) {
        this.extractors = extractors;
    }

    public String extractText(Parser parser) {
        StringBuffer text = new StringBuffer();
        parser.nodes().stream()
                .forEach(n -> extractors.get(n.nodeName()).extract(n, text));
        return text.toString();
    }

}
