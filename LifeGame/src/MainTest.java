import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.regex.Pattern;

import org.junit.Test;

/*
David Souza Rodrigues, Nº USP 4461180
Edilson Bunicenha Junior, Nº USP 9762935
Otávio Luis de Aguiar, Nº USP 9293518
Oton Papa, Nº USP 9292883
 */

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
			String[] lines = out.toString().split(System.lineSeparator());
			assertTrue(Pattern.matches("((\\|(0|1)){6}\\|\\n){6}Aperte enter para a próxima geração\\.", lines[0]));
			assertTrue(Pattern.matches("Digite \"sair\" para encerrar o programa\\.", lines[1]));
			assertTrue(Pattern.matches("((\\|(0|1)){6}\\|\\n){6}", lines[2]));
		} finally {		
			System.setIn(sysInput);
			System.setOut(sysOutput);
		}

	}

}
