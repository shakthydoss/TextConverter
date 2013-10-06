package com.shakthydoss.documentConverter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.odftoolkit.odfdom.converter.pdf.PdfConverter;
import org.odftoolkit.odfdom.converter.pdf.PdfOptions;
import org.odftoolkit.odfdom.doc.OdfTextDocument;

/**
 * @author sakthidasans
 * 
 */
public class ODTtoPDFConverter {

	/**
	 * @param odt
	 *            the original odt
	 * 
	 * @param pdf
	 *            the resulting pdf
	 * 
	 * @throws Exception
	 */
	public void parseODT(String odt, String pdf) throws Exception {

		// 1) Load ODT into ODFDOM OdfTextDocument
		InputStream in = new FileInputStream(new File(odt));
		OdfTextDocument document = OdfTextDocument.loadDocument(in);

		// 2) Prepare Pdf options
		PdfOptions options = PdfOptions.create();

		// 3) Convert OdfTextDocument to PDF via IText
		OutputStream out = new FileOutputStream(new File(pdf));
		PdfConverter.getInstance().convert(document, out, options);

		out.flush();
		out.close();
		in.close();

	}

}
