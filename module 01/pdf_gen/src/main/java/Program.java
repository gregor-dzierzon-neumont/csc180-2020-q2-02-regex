import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;

public class Program {

    public static void main(String[] args) {
        try {
            OutputStream os = new FileOutputStream("C:/Repos/out/out.pdf");
            PdfRendererBuilder builder = new PdfRendererBuilder();
            builder.useFastMode();
        }
        catch (FileNotFoundException ex) {

        }
    }
}
