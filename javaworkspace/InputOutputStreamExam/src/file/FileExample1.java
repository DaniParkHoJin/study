package file;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileExample1 {

	public static void main(String[] args) throws Exception {
		// File ��ü ����
		File dir = new File("D:\\javaproject\\javaworkspace\\InputOutputStreamExam\\images");
		File file1 = new File("D:/javaproject/javaworkspace/InputOutputStreamExam/Temp/file1.txt");
		File file2 = new File("D:/javaproject/javaworkspace/InputOutputStreamExam/Temp/file2.txt");
		File file3 = new File("D:/javaproject/javaworkspace/InputOutputStreamExam/Temp/file3.txt");

		// �������� ������ ���丮 �Ǵ� ���� ����
		if (dir.exists() == false) {
			dir.mkdirs();
		}
		if (file1.exists() == false) {
			file1.createNewFile();
		}
		if (file2.exists() == false) {
			file2.createNewFile();
		}
		if (file3.exists() == false) {
			file3.createNewFile();
		}

		// Temp ������ ������ ���
		File temp = new File("D:\\javaproject\\javaworkspace\\InputOutputStreamExam");
		File[] contents = temp.listFiles();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a HH:mm");
		for (File file : contents) {
			System.out.printf("%-25s", sdf.format(new Date(file.lastModified())));
			if (file.isDirectory()) {
				System.out.printf("%-10s%-20s", "<DIR>", file.getName());
			} else {
				System.out.printf("%-10s%-20s", file.length(), file.getName());
			}
			System.out.println();
		}
	}

}