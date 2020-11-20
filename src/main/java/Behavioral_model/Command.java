package Behavioral_model;

public interface Command {
    public void execute();
}

class TextEditer {
    private StringBuilder buffer = new StringBuilder();

    public void copy() {

    }

    public void paste() {
        String text = getFromClipBoard();
        add(text);
    }

    private String getFromClipBoard() {
        return null;
    }

    public void add(String s) {
        buffer.append(s);
    }

    public void delete() {
        if (buffer.length() > 0) {
            buffer.deleteCharAt(buffer.length() - 1);
        }
    }

    public String getState() {
        return buffer.toString();
    }
}

class CopyCommand implements Command {

    private TextEditer receiver;

    public CopyCommand(TextEditer receiver) {
        this.receiver = receiver;

    }

    public void execute() {
        receiver.copy();
    }
}

class PasteCommand implements Command{
    private TextEditer receiver;

    public PasteCommand(TextEditer receiver){
        this.receiver=receiver;
    }

    @Override
    public void execute() {
        receiver.paste();
    }
}

//class Main{
//    public static void main(String[] args){
//        TextEditer editor=new TextEditer();
//        editor.add("Command pattern in text editor.\n");
//
//        Command copy =new CopyCommand(editor);
//        copy.execute();
//        editor.add("----\n");
//
//        Command paste=new PasteCommand(editor);
//        paste.execute();
//        System.out.println(editor.getState());
//
//
//    }
//}