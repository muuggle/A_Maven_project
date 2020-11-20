package Design_mode.Structural_model;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public interface Node {
    Node add(Node node);

    List<Node> children();

    String toxml();
}

class ElementNode implements Node {
    private String name;
    private List<Node> list = new ArrayList<>();

    public ElementNode(String name) {
        this.name = name;
    }

    @Override
    public Node add(Node node) {
        list.add(node);
        return this;
    }

    @Override
    public List<Node> children() {
        return list;
    }

    @Override
    public String toxml() {
        String start = "<" + name + ">\n";
        String end = "</" + name + ">\n";
        StringJoiner sj = new StringJoiner("", start, end);
        list.forEach(node -> {
            sj.add(node.toxml() + "\n");
        });
        return sj.toString();
    }
}

class TextNode implements Node {
    private String text;

    public TextNode(String text) {
        this.text = text;
    }

    @Override
    public Node add(Node node) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Node> children() {
        return List.of();
    }

    @Override
    public String toxml() {
        return text;
    }
}

class CommentNode implements Node {
    private String text;

    public CommentNode(String text) {
        this.text = text;
    }

    public Node add(Node node) {
        throw new UnsupportedOperationException();
    }

    public List<Node> children() {
        return List.of();
    }

    public String toxml() {
        return "<!-- " + text + " -->";
    }
}


class Main {
    public static void main(String[] args) {
        Node root = new ElementNode("School");
        root.add(new ElementNode("class A")
                .add(new TextNode("Tom"))
                .add(new TextNode("Alice")));
        root.add(new ElementNode("classB")
                .add(new TextNode("Bob"))
                .add(new TextNode("Grace"))
                .add(new CommentNode("comment...")));
        System.out.println(root.toxml());
    }
}