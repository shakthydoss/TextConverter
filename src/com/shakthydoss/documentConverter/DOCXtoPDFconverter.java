package com.shakthydoss.documentConverter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.poi.xwpf.converter.pdf.PdfConverter;
import org.apache.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

/**
 * @author sakthidasans
 *
 */
public class DOCXtoPDFconverter {

	/**
	 * @param docx
	 * 				 the original docx
	 * 
	 * @param pdf
	 * 				the resulting pdf
	 * 
	 * @throws IOException
	 */
	public void parseDocx(String docx, String pdf) throws IOException {

		// 1) Load DOCX into XWPFDocument
		InputStream in= new FileInputStream(new File(docx));
		XWPFDocument document = new XWPFDocument(in);

		// 2) Prepare Pdf options
		PdfOptions options = PdfOptions.create();

		// 3) Convert XWPFDocument to Pdf
		OutputStream out = new FileOutputStream(new File(pdf));
		PdfConverter.getInstance().convert(document, out, options);		
		
		out.flush();
		out.close();
		in.close();

	}

}