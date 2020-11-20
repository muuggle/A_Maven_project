package Design_mode;

//public class Builder {
//    private HeadingBuilder headingBuider = new HeadingBuilder();
//    private HrBuilder hrBuilder = new HrBuilder();
//    private ParagraphBuilder paragraphBuilder = new ParagraphBuilder();
//    private QuoteBuilder quoteBuilder = new QuoteBuilder();
//
//    public String toHtml(String markdown) {
//        StringBuilder buffer = new StringBuilder();
//        markdown.lines().forEach(line -> {
//            if (line.startsWith("#")) {
//                buffer.append(headingBuider.buildHeading(line)).append("\n");
//            } else if (line.startsWith(">")) {
//                buffer.append(quoteBuilder.buildQuote(line)).append('\n');
//            } else if (line.startsWith("---")) {
//                buffer.append(hrBuilder.buildHr(line)).append('\n');
//            } else {
//                buffer.append(paragraphBuilder.buildParagraph(line)).append('\n');
//            }
//        });
//        return buffer.toString();
//    }
//}
//
//class HeadingBuilder{
//    public String buildHeading(String line){
//        int n=0;
//        while (line.charAt(0) == '#'){
//            n++;
//            line=line.substring(1);
//        }
//        return String.format("<h%d>%s</h%d>", n, line.strip(), n);
//    }
//}