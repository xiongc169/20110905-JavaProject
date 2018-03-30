package org.practice.cheguo;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipUtils2 {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		byte[] zipByte;
		zipByte = FileUtils.fileToBytes("E:\\test2.zip");
		byte[] pdfByte = uncompress(zipByte);
		FileUtils.bytesToFile(pdfByte, "E:\\", "1234.pdf");
	}

	/**
	 * 使用GZIPInputStream进行GZIP解压缩
	 * 
	 * @param bytes
	 * @return
	 */
	public static byte[] uncompress(byte[] bytes) {
		if (bytes == null || bytes.length == 0) {
			return null;
		}
		ByteArrayInputStream in = new ByteArrayInputStream(bytes);
		ZipInputStream zip = null;
		ByteArrayOutputStream out = null;
		try {
			zip = new ZipInputStream(in);
			out = new ByteArrayOutputStream();
			ZipEntry entry;
			while ((entry = zip.getNextEntry()) != null && !entry.isDirectory()) {
				int n;
				byte[] buffer = new byte[256];
				while ((n = zip.read(buffer, 0, buffer.length)) >= 0) {
					out.write(buffer, 0, n);
				}
				out.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			close(in, zip, out);
		}
		return out.toByteArray();
	}

	/**
	 * 关闭流
	 * 
	 * @param closeableList
	 */
	private static void close(Closeable... closeableList) {
		if (closeableList != null) {
			for (Closeable closeable : closeableList) {
				if (closeable != null) {
					try {
						closeable.close();
					} catch (IOException e) {
					}
				}
			}
		}
	}
}
