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
	 * Rigorous Test :-)
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
	public void readEmpyPayRollFromFileTest() throws IOException {
		emplyPayRollMain.addEmpyPayRollIntoFile();
		long countEntries = emplyPayRollMain.countEntires();
		Assert.assertEquals(3, countEntries);
	}
}
