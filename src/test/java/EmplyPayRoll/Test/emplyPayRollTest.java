package EmplyPayRoll.Test;

import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;
import Service.emplyPayRollMain;

/**
 * Unit test for simple App.
 */
public class emplyPayRollTest {
	/**
	 * Rigorous Test
	 * 
	 * @throws IOException
	 */
	@Test
	public void readEmpyPayRollTest() {
		boolean addedemply = emplyPayRollMain.addReadEmpyPayRoll();
		Assert.assertEquals(true, addedemply);
	}

	@Test
	public void readEmpyPayRollTosFileTest() throws IOException {
		boolean c = emplyPayRollMain.addFileDelectFileOperation();
		Assert.assertEquals(true, c);
	}
	@Test
	public void findFilesInsideFolderTest() throws IOException {
		boolean files =	emplyPayRollMain.findFilesWithExtension("C:\\Users\\hp\\OneDrive\\BridgeLabz\\eclipse-workspace\\EmplyPayRollNew\\src\\main");
		Assert.assertEquals(true, files);
	}
	@Test
	public void countEntriesMadeEmpyPayRollIntoFileTest() throws IOException {
		emplyPayRollMain.addEmpyPayRollIntoFile();
		long countEntries = emplyPayRollMain.countEntires();
		Assert.assertEquals(3, countEntries);
	}

	@Test
	public void readEmpyPayRollFromFileTest() throws IOException {
		emplyPayRollMain.addEmpyPayRollIntoFile();
		emplyPayRollMain.printData();
		long countEntries = emplyPayRollMain.countEntires();
		Assert.assertEquals(3, countEntries);
	}
}
