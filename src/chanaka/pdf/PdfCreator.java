package chanaka.pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class PdfCreator {

    public void createPDF(String a, String b) throws FileNotFoundException, DocumentException {

        Document document = new Document();

        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("test.pdf"));

        document.open();

        document.add(new Paragraph(a));
        document.add(new Paragraph(b));

        document.close();

        writer.close();


    }
}
