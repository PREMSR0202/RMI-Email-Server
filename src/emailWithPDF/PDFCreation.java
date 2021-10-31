package emailWithPDF;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class PDFCreation {

	private static final String filename = "PDFCreation.pdf";

	private static final String content = "PDF Successfully Created";

	private static final PDFont pdfFont = PDType1Font.TIMES_ROMAN;

	public void create() {

		try {

			PDDocument doc = new PDDocument();
			PDPage page = new PDPage();
			doc.addPage(page);

			PDPageContentStream cs = new PDPageContentStream(doc, page);

			cs.setFont(pdfFont, 26);
			cs.beginText();
			cs.newLineAtOffset(220, 750);
			cs.showText(content);
			cs.endText();
			cs.close();
			doc.save(filename);
			doc.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}