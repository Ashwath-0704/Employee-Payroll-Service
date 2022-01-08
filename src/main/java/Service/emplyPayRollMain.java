package Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import Model.emplyPayRoll;

public class emplyPayRollMain {
	final static String FILE_PATH = "C:\\Users\\hp\\OneDrive\\BridgeLabz\\eclipse-workspace\\EmplyPayRollNew\\src\\main\\EmployeePayrollServiceOutput.txt";

	public enum IOService {
		CONSOLE_IO, FILE_IO, DB_IO, REST_IO
	}

	static ArrayList<emplyPayRoll> emplyDate = new ArrayList<>();

	public static boolean addReadEmpyPayRoll() {
		emplyPayRoll emply1 = new emplyPayRoll("ashwath", 1, 2500);
		emplyPayRoll emply2 = new emplyPayRoll("krishna", 2, 25000);
		emplyPayRoll emply3 = new emplyPayRoll("Reddy", 3, 30000);
		emplyDate.add(emply1);
		emplyDate.add(emply2);
		emplyDate.add(emply3);
		System.out.printf("The number of entries are : %d\n\n", emplyDate.size());
		emplyDate.size();
		return true;
	}

	/*
	 * UC2 and UC3
	 * 
	 */
	public static boolean addFileDelectFileOperation() {
		File f = new File(
				"C:\\Users\\hp\\OneDrive\\BridgeLabz\\eclipse-workspace\\EmplyPayRollNew\\src\\main\\Output1.txt");

		if (f.exists()) {
			f.deleteOnExit();
			System.out.println("File has deleted ");
		} else {
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("File have created");
		}
		return true;
	}

	/*
	 * UC3 : Create a Watch Service to watch particular directory along with all
	 * Files and Sub Directories - Using File IO Count Number of Entries in the File
	 */
	public static void findFilesWithExtension(String string) {
		try (Stream<Path> walk = Files.walk(Paths.get(string))) {
			List<String> result = walk.filter(p -> !Files.isDirectory(p)) // not a directory
					.map(p -> p.toString().toLowerCase()) // convert path to string
					.filter(f1 -> f1.endsWith("txt")) // check end with
					.collect(Collectors.toList()); // collect all matched to a List
			System.out.println(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * UC4 :- Employee Payroll Service to store Employee Payroll into a File
	 */
	public static boolean addEmpyPayRollIntoFile() throws IOException {
		addReadEmpyPayRoll();
		addArrayListInToFile(emplyDate);
		return true;
	}

	public static <T> boolean addArrayListInToFile(ArrayList<T> emplyDate) throws IOException {
		FileWriter writer = new FileWriter(FILE_PATH);
		emplyDate.forEach(data -> {
			try {
				writer.write(data + System.lineSeparator());
			} catch (IOException e) {
				e.printStackTrace();
				System.err.println("Invaid input");
			}
		});
		writer.close();
		return true;
	}

	/*
	 * UC5 Count the number of entries made inside file
	 */
	public static long countEntires() throws IOException {
		long entries = Files.lines(new File(FILE_PATH).toPath()).count();
		return entries;
	}

	/*
	 * UC6 Read the data for File
	 */
	public static void printData() throws IOException {
		Files.lines(new File(FILE_PATH).toPath()).map(Line -> Line.trim()).forEach(line -> System.out.println(line));
	}

	public static void main(String[] args) {
		addFileDelectFileOperation();
		findFilesWithExtension("C:\\Users\\hp\\OneDrive\\BridgeLabz\\eclipse-workspace\\EmplyPayRollNew\\src\\main");
	}
}
