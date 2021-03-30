package es.codeurjc.SeibiExperiencieServices.PDFService;
import java.awt.Color;
import java.io.IOException;
import java.util.List;
 
import javax.servlet.http.HttpServletResponse;
 
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;

public class PDFExporter {
	public String pedido;
	//public Orderz orderz;
	public PDFExporter(String pedido) {
		this.pedido = pedido;
	}
	/*
	public PDFExporter(Orderz orderz) {
		this.orderz = orderz;
	}
	*/
	
	private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);
         
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);
         
        cell.setPhrase(new Phrase("Producto", font));
         
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Actividades", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Descripción", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Precio", font));
        table.addCell(cell);
              
    }
     
    private void writeTableData(PdfPTable table) {
            table.addCell("Sevilla");
            table.addCell("Ole");
            table.addCell("Ole");
            table.addCell("Ole");
            /*
            table.addCell(user.getFullName());
            table.addCell(user.getRoles().toString());
            table.addCell(String.valueOf(user.isEnabled()));
            */
    }
     
    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
         
        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLUE);
         
        Paragraph p = new Paragraph("Detalles del pedido", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);
         
        document.add(p);
        
        p = new Paragraph("User name", font);
        p.setAlignment(Paragraph.ALIGN_LEFT);
         
        document.add(p);
         
        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {2.5f, 4.0f, 4.0f, 1.5f});
        table.setSpacingBefore(10);
         
        writeTableHeader(table);
        writeTableData(table);
         
        document.add(table);
         
        document.close();
         
    }
}

