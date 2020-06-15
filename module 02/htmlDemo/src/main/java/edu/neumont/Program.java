package edu.neumont;

import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class Program {

    public static void main(String[] args) throws Exception {

        String name = "Joe";
        String address = "123 main street";

        String template = "<html><body> <h1>%s</h1><p>%s</p> </html>";

        String finalHtml = String.format(template, name, address);

        try (OutputStream os = new FileOutputStream("pdf/test.pdf")) {
            PdfRendererBuilder builder = new PdfRendererBuilder();
            builder.useFastMode();
            //builder.withUri("file:///C:/Repos/CS180%202020%20Q2%20-%20Java/module%2002/htmlDemo/html/test.html");
            builder.withUri("file:html/test.html");
            builder.toStream(os);
            builder.run();
        }
    }

}
