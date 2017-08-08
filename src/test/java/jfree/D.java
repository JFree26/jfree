package jfree;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.MalformedURLException;
import java.net.URL;

import org.pdfbox.pdmodel.PDDocument;
import org.pdfbox.util.PDFTextStripper;

/**
* ��PDF�ļ�ת����txt�ı��ļ�
* 
* @param fis,Դ�ļ����ļ�������
* @param outputPath,����ļ���·��,����ָ�ļ��е�·��
* @param outputFileName,����ļ����ļ���,�����ļ���׺��
* @return ת���ɹ������ַ���"OK";ת��ʧ�ܷ���ʧ��ԭ��.
*/
public class D {
	public static String convertPdfToTxt(FileInputStream fis,
		    String outputPath, String outputFileName) {
		   // �Ƿ�����
		   boolean sort = false;
		   // ��ʼ��ȡҳ��
		   int startPage = 1;
		   // ������ȡҳ��
		   int endPage = Integer.MAX_VALUE;
		   try {
		    // �ڴ��д洢��PDF Document
		  PDDocument document = PDDocument.load(fis);
		    String outputFile = outputPath + outputFileName + ".txt"; // ��װ���TXT�ļ��ľ���·��
		    FileOutputStream fos = new FileOutputStream(outputFile);
		    OutputStreamWriter writer = new OutputStreamWriter(fos);
		    // PDFTextStripper����ȡ�ı�
		    PDFTextStripper stripper = new PDFTextStripper();
		    // �����Ƿ�����
		    stripper.setSortByPosition(sort);
		    // ������ʼҳ
		    stripper.setStartPage(startPage);
		    // ���ý���ҳ
		    stripper.setEndPage(endPage);
		    // ����PDFTextStripper��writeText��ȡ������ı�
		    stripper.writeText(document, writer);
		    fos.close();
		    writer.close();
		   } catch (FileNotFoundException e) {
		    return "�ļ�������!";
		   } catch (IOException e) {
		    return "�ļ���д����!";
		   }
		   return "OK";
		}
	public static void main(String[] args) throws FileNotFoundException {
		D.convertPdfToTxt( new FileInputStream("D:/��ҵ���/1.pdf"), "D:/��ҵ���/", "123");
	}
}
