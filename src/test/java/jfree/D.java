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
* 将PDF文件转换成txt文本文件
* 
* @param fis,源文件的文件输入流
* @param outputPath,输出文件的路径,这里指文件夹的路径
* @param outputFileName,输出文件的文件名,包括文件后缀名
* @return 转换成功返回字符串"OK";转换失败返回失败原因.
*/
public class D {
	public static String convertPdfToTxt(FileInputStream fis,
		    String outputPath, String outputFileName) {
		   // 是否排序
		   boolean sort = false;
		   // 开始提取页数
		   int startPage = 1;
		   // 结束提取页数
		   int endPage = Integer.MAX_VALUE;
		   try {
		    // 内存中存储的PDF Document
		  PDDocument document = PDDocument.load(fis);
		    String outputFile = outputPath + outputFileName + ".txt"; // 组装输出TXT文件的绝对路径
		    FileOutputStream fos = new FileOutputStream(outputFile);
		    OutputStreamWriter writer = new OutputStreamWriter(fos);
		    // PDFTextStripper来提取文本
		    PDFTextStripper stripper = new PDFTextStripper();
		    // 设置是否排序
		    stripper.setSortByPosition(sort);
		    // 设置起始页
		    stripper.setStartPage(startPage);
		    // 设置结束页
		    stripper.setEndPage(endPage);
		    // 调用PDFTextStripper的writeText提取并输出文本
		    stripper.writeText(document, writer);
		    fos.close();
		    writer.close();
		   } catch (FileNotFoundException e) {
		    return "文件不存在!";
		   } catch (IOException e) {
		    return "文件读写错误!";
		   }
		   return "OK";
		}
	public static void main(String[] args) throws FileNotFoundException {
		D.convertPdfToTxt( new FileInputStream("D:/毕业设计/1.pdf"), "D:/毕业设计/", "123");
	}
}
