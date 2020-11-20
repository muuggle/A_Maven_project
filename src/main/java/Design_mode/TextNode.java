package Design_mode;


public interface TextNode {
    //设置Text
    void setText(String text);

    //获取text
    String getText();
}


class SpanNode implements TextNode {

    private String text;

    public void setText(String text) {
        this.text = text;

    }

    public String getText() {
        return "<span>" + text + "</span>";
    }
}

abstract class NodeDecorator implements TextNode {
    protected final TextNode target;

    protected NodeDecorator(TextNode target) {
        this.target = target;

    }

    public void setText(String text) {
        this.target.setText(text);
    }
}

class BoldDecorator extends NodeDecorator {
    public BoldDecorator(TextNode target) {
        super(target);
    }

    public String getText() {
        return "<b>" + target.getText() + "</b>";
    }
}
