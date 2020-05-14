import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.Test;


public class MainTest {

	@Test
	public void testMain() {
		assertNotNull(new Main());
		
		InputStream sysInput = System.in;
		PrintStream sysOutput = System.out;
		
		String simulatedInput = System.lineSeparator() + "sair";
		ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		
		try {
			Main.main(null);
		} catch (Exception e){
			fail();
		}
		
		try { 
			assertEquals(3, out.toString().split(System.lineSeparator()).length);
		} finally {		
			System.setIn(sysInput);
			System.setOut(sysOutput);
		}

		
	}

}
