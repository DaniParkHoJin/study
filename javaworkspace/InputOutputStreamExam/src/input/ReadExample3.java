package input;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ReadExample3 {

	public static void main(String[] args) {
		try {
			Reader reader = null;

			// 1 문자씩 읽기

			reader = new FileReader("D:/javaproject/javaworkspace/InputOutputStreamExam/Temp/test2.db");
			while (true) {
				int data = reader.read();
				if (data == -1)
					break;
				System.out.print((char) data);
			}
			reader.close();
			System.out.println();

			// 문자 배열로 읽기

			reader = new FileReader("D:/javaproject/javaworkspace/InputOutputStreamExam/Temp/test2.db");
			char[] data = new char[100];

			while (true) {
				int num = reader.read(data);
				if (num == -1)
					break;
				for (int i = 0; i < num; i++) {
					System.out.print(data[i]);

				}

			}
			reader.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
