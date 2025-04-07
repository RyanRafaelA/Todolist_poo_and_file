package repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

import model.Task;

public class TaskRepository {
	private final static String FILE_TASK = Paths.get(System.getProperty("user.dir"), "fileTask.txt").toString();
	
	public static void fileWriting(Task task) {
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_TASK))){
			bw.write(task.toString());
			bw.close();
		}
		catch (IOException e) {
			System.err.println("Erro no arquivo. "+e.getMessage());
		}
	}
	
	public static void readFile() {
		try(BufferedReader br = new BufferedReader(new FileReader(FILE_TASK))){
			String lineRead;
			
			lineRead = br.readLine();
			
			while(lineRead != null) {
				System.out.println(lineRead);
				lineRead = br.readLine();
			}
			
			br.close();
		}
		catch(IOException e) {
			System.err.println("Erro no arquivo. "+e.getMessage());
		}
	}
}
