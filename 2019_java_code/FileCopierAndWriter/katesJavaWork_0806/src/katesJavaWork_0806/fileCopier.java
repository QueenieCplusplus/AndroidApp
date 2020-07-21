package katesJavaWork_0806;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class fileCopier {
	public void copyFile(File src, File dest) throws IOException {
		InputStream input = null;
		OutputStream output = null;
		try {
			input = new FileInputStream(src);
			output = new FileOutputStream(dest);
			
			byte[] buf = new byte[1024];
			int bytesRead;
			while((bytesRead = input.read(buf)) > 0){
				 output.write(buf, 0, bytesRead);
			}
		}finally {
			input.close();
			output.close();
		}
	}
	public static void main(String[] args) throws Exception {
		File beforeF = new File("/Users/katesapp2019/Desktop/here.txt");
		File afterF = new File("/Users/katesapp2019/Downloads/here.txt");	
		FileInputStream fis = new FileInputStream(beforeF);
		FileOutputStream fos = new FileOutputStream(afterF);
		// 檔案快取區域
		byte[] b = new byte[1024];
		// 將檔案流資訊讀取 於檔案快取區，如果讀取不為 -1，代表檔案尚未讀取完畢。
		while(fis.read(b)!=-1) {
			fos.write(b);
			fos.flush();
		}
		fileCopier fc = new fileCopier();
		fc.copyFile(beforeF, afterF);
	}
}

//https://www.itread01.com/article/1530059695.html
