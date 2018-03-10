import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import org.junit.Before;
import org.junit.Test;

public class TestLargestDataFile {
	static BufferedReader rdr;
	String line;

	@Before
	public void setUp() throws FileNotFoundException {
		rdr = new BufferedReader(new FileReader("test/test.txt"));
	}

	@Test
	public void testFromFile() throws Exception {
		while ((line = rdr.readLine()) != null) {
			if (line.startsWith("#")) {
				continue;
			}

			StringTokenizer st = new StringTokenizer(line);
			if (!st.hasMoreTokens()) {
				continue;
			}

			String val = st.nextToken();
			int expected = Integer.valueOf(val).intValue();
			ArrayList<Integer> argumentList = createArrayList(st);

			assertEquals(expected, Largest.largest(convertArrayToInts(argumentList)));
		}
	}

	private int[] convertArrayToInts(ArrayList<Integer> argumentList) {
		int[] arguments = new int[argumentList.size()];
		for (int i = 0; i < argumentList.size(); i++) {
			arguments[i] = ((Integer) argumentList.get(i)).intValue();
		}
		return arguments;
	}

	private ArrayList<Integer> createArrayList(StringTokenizer st) {
		ArrayList<Integer> argumentList = new ArrayList<Integer>();
		while (st.hasMoreTokens()) {
			argumentList.add(Integer.valueOf(st.nextToken()));
		}
		return argumentList;
	}

}
