package com.shakthydoss.documentConverter;

import java.io.File;
import java.io.IOException;

public class ConvertionManager {

	public void readDirectory(File file) {
		if (file.isDirectory()) {
			File[] folder = file.listFiles();
			for (File f : folder) {
				readDirectory(f);
			}
		} else {

			if (file.getName().endsWith(".pdf")) {
				System.out.println(file.getName());
				try {
					new PDFtoTEXTConverter().parsePdf(file.getPath(), file
							.getPath().replaceAll(".pdf", ".txt"));
				} catch (IOException e) {
					System.err.println("Error: " + e.getMessage());
				}
			}

			if (file.getName().endsWith(".docx")) {
				System.out.println(file.getName());
				try {
					new DOCXtoPDFconverter().parseDocx(file.getPath(), file
							.getPath().replaceAll(".docx", ".pdf"));
					new PDFtoTEXTConverter().parsePdf(file.getPath()
							.replaceAll(".docx", ".pdf"), file.getPath()
							.replaceAll(".docx", ".txt"));
					deleteTempFile(file.getPath().replaceAll(".docx", ".pdf"));
				} catch (IOException e) {
					System.err.println("Error: " + e.getMessage());
				}
			}
			
			
			if (file.getName().endsWith(".odt")) {
				System.out.println(file.getName());
				try {
					new ODTtoPDFConverter().parseODT(file.getPath(), file.getPath().replaceAll(".odt", ".pdf"));
					new PDFtoTEXTConverter().parsePdf(file.getPath()
							.replaceAll(".odt", ".pdf"), file.getPath()
							.replaceAll(".odt", ".txt"));
					deleteTempFile(file.getPath().replaceAll(".odt", ".pdf"));
				} catch (Exception e) {
					System.err.println("Error: " + e.getMessage());
				}
			}
		}
	}

	public void deleteTempFile(String path) {
		File file = new File(path);
		file.delete();
	}

	public static void main(String args[]) throws IOException {
		
		/*if (args.length != 1){
			System.err.println("Specify corpus directory path.");
			System.out.println("Exit.");
			System.exit(0);
		}*/
		
		String path  = "/home/shakthydoss/DocConverter/";
		File file = new File(path);
		new ConvertionManager().readDirectory(file);
		System.out.println("Finished....");
	}
}
