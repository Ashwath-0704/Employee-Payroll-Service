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
}
