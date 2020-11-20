package Design_mode;

import org.mortbay.util.IO;

import java.io.IOException;
import java.nio.file.Path;

public interface Abstract_Fac {
    HtmlDocument createHtml(String md);

    WorldDocument createWord(String md);
}

interface HtmlDocument {
    String toHtml();

    void save(Path path) throws IOException;

}

interface WorldDocument {
    void save(Path path) throws IOException;
}

class FastFactory implements Abstract_Fac {
    public HtmlDocument createHtml(String md) {
        return new FastHtmlDocument(md);
    }


    public WorldDocument createWord(String md) {
        return new FastWordDocument(md);
    }
}

class FastHtmlDocument implements HtmlDocument {
    public FastHtmlDocument(String md) {
    }

    public String toHtml() {
        return null;
    }

    public void save(Path path) throws IOException {

    }
}

class FastWordDocument implements WorldDocument {
    public FastWordDocument(String md) {
    }

    public void save(Path path) throws IOException {

    }
}

