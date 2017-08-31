import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

public class Testing {
	private DNAGenerator generator = new DNAGenerator();
	private static final int LOOP = 15;
	
	//helper vars
	private static int currentHashID = 1;
	private static HashMap<Integer, ArrayList<Long>> times = new HashMap<>();

	@Before
	public void makeArray() {
		times.put(currentHashID, new ArrayList<Long>());
	}

	@After
	public void incrementID() {
		currentHashID++;
	}
	
//	@AfterClass
//	public static void printTimes() {
//		for(Map.Entry<Integer, ArrayList<Long>> entry: times.entrySet()){
//			System.out.println("SET ID "+entry.getKey());
//			for (long l : entry.getValue()) {
//				System.out.println(l);
//			}
//		}
//	}

	@AfterClass
	public static void printTimes() throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(new File("test_results.csv"));
        StringBuffer buf = new StringBuffer();
        buf.append("id,times\n");
        
		for(Map.Entry<Integer, ArrayList<Long>> entry: times.entrySet()){
			buf.append(entry.getKey()+",");
			for (long l : entry.getValue()) {
				buf.append(l+",");
			}
			buf.append('\n');
		}
		
		pw.write(buf.toString());
        pw.close();
	}

	// helper
	private String reverse(String s) {
		return new StringBuffer(s).reverse().toString();
	}

	@Test
	public void test100Mutated() {
		for (int i = 0; i < LOOP; i++) {
			String dna = generator.generate(100);
			int mutationCounter = 10;
			String descendant = generator.mutate(dna, mutationCounter);

			long start = System.currentTimeMillis();
			DynamicProgramming dpr = new DynamicProgramming(dna, descendant);
			times.get(currentHashID).add(System.currentTimeMillis() - start);
			System.out.println(dpr.alignmentScore());

			mutationCounter += 10;
		}
	}

	@Test
	public void test1000Mutated() {
		for (int i = 0; i < LOOP; i++) {
			String dna = generator.generate(1000);
			int mutationCounter = 10;
			String descendant = generator.mutate(dna, mutationCounter);
			
			long start = System.currentTimeMillis();
			DynamicProgramming dpr = new DynamicProgramming(dna, descendant);
			times.get(currentHashID).add(System.currentTimeMillis() - start);
			System.out.println(dpr.alignmentScore());

			mutationCounter += 10;
		}
	}

	@Test
	public void test2000Mutated() {
		for (int i = 0; i < LOOP; i++) {
			String dna = generator.generate(2000);
			int mutationCounter = 10;
			String descendant = generator.mutate(dna, mutationCounter);

			long start = System.currentTimeMillis();
			DynamicProgramming dpr = new DynamicProgramming(dna, descendant);
			times.get(currentHashID).add(System.currentTimeMillis() - start);
			System.out.println(dpr.alignmentScore());

			mutationCounter += 10;
		}
	}

	@Test
	public void test3000Mutated() {
		for (int i = 0; i < LOOP; i++) {
			String dna = generator.generate(3000);
			int mutationCounter = 10;
			String descendant = generator.mutate(dna, mutationCounter);

			long start = System.currentTimeMillis();
			DynamicProgramming dpr = new DynamicProgramming(dna, descendant);
			times.get(currentHashID).add(System.currentTimeMillis() - start);
			System.out.println(dpr.alignmentScore());

			mutationCounter += 10;
		}
	}

	@Test
	public void test3500Mutated() {
		for (int i = 0; i < LOOP; i++) {
			String dna = generator.generate(3500);
			int mutationCounter = 10;
			String descendant = generator.mutate(dna, mutationCounter);

			long start = System.currentTimeMillis();
			DynamicProgramming dpr = new DynamicProgramming(dna, descendant);
			times.get(currentHashID).add(System.currentTimeMillis() - start);
			System.out.println(dpr.alignmentScore());

			mutationCounter += 10;
		}
	}

	@Test
	public void test100Same() {
		for (int i = 0; i < LOOP; i++) {
			String dna = generator.generate(100);

			long start = System.currentTimeMillis();
			DynamicProgramming dpr = new DynamicProgramming(dna, dna);
			times.get(currentHashID).add(System.currentTimeMillis() - start);
			System.out.println(dpr.alignmentScore());
		}
	}

	@Test
	public void test1000Same() {
		for (int i = 0; i < LOOP; i++) {
			String dna = generator.generate(1000);

			long start = System.currentTimeMillis();
			DynamicProgramming dpr = new DynamicProgramming(dna, dna);
			times.get(currentHashID).add(System.currentTimeMillis() - start);
			System.out.println(dpr.alignmentScore());
		}
	}

	@Test
	public void test2000Same() {
		for (int i = 0; i < LOOP; i++) {
			String dna = generator.generate(2000);

			long start = System.currentTimeMillis();
			DynamicProgramming dpr = new DynamicProgramming(dna, dna);
			times.get(currentHashID).add(System.currentTimeMillis() - start);
			System.out.println(dpr.alignmentScore());
		}
	}

	@Test
	public void test3000Same() {
		for (int i = 0; i < LOOP; i++) {
			String dna = generator.generate(3000);

			long start = System.currentTimeMillis();
			DynamicProgramming dpr = new DynamicProgramming(dna, dna);
			times.get(currentHashID).add(System.currentTimeMillis() - start);
			System.out.println(dpr.alignmentScore());
		}
	}

	@Test
	public void test3500Same() {
		for (int i = 0; i < LOOP; i++) {
			String dna = generator.generate(3500);

			long start = System.currentTimeMillis();
			DynamicProgramming dpr = new DynamicProgramming(dna, dna);
			times.get(currentHashID).add(System.currentTimeMillis() - start);
			System.out.println(dpr.alignmentScore());
		}
	}

	@Test
	public void test100Reversed() {
		for (int i = 0; i < LOOP; i++) {
			String dna = generator.generate(100);
			String reversed = reverse(dna);

			long start = System.currentTimeMillis();
			DynamicProgramming dpr = new DynamicProgramming(dna, reversed);
			times.get(currentHashID).add(System.currentTimeMillis() - start);
			System.out.println(dpr.alignmentScore());
		}
	}

	@Test
	public void test1000Reversed() {
		for (int i = 0; i < LOOP; i++) {
			String dna = generator.generate(1000);
			String reversed = reverse(dna);

			long start = System.currentTimeMillis();
			DynamicProgramming dpr = new DynamicProgramming(dna, reversed);
			times.get(currentHashID).add(System.currentTimeMillis() - start);
			System.out.println(dpr.alignmentScore());
		}
	}

	@Test
	public void test2000Reversed() {
		for (int i = 0; i < LOOP; i++) {
			String dna = generator.generate(2000);
			String reversed = reverse(dna);

			long start = System.currentTimeMillis();
			DynamicProgramming dpr = new DynamicProgramming(dna, reversed);
			times.get(currentHashID).add(System.currentTimeMillis() - start);
			System.out.println(dpr.alignmentScore());
		}
	}

	@Test
	public void test3000Reversed() {
		for (int i = 0; i < LOOP; i++) {
			String dna = generator.generate(3000);
			String reversed = reverse(dna);

			long start = System.currentTimeMillis();
			DynamicProgramming dpr = new DynamicProgramming(dna, reversed);
			times.get(currentHashID).add(System.currentTimeMillis() - start);
			System.out.println(dpr.alignmentScore());
		}
	}

	@Test
	public void test3500Reversed() {
		for (int i = 0; i < LOOP; i++) {
			String dna = generator.generate(3500);
			String reversed = reverse(dna);

			long start = System.currentTimeMillis();
			DynamicProgramming dpr = new DynamicProgramming(dna, reversed);
			times.get(currentHashID).add(System.currentTimeMillis() - start);
			System.out.println(dpr.alignmentScore());
		}
	}

	@Test
	public void test100Random() {
		for (int i = 0; i < LOOP; i++) {
			String dna = generator.generate(100);
			String dna2 = generator.generate(dna.length() / 2);

			long start = System.currentTimeMillis();
			DynamicProgramming dpr = new DynamicProgramming(dna, dna2);
			times.get(currentHashID).add(System.currentTimeMillis() - start);
			System.out.println(dpr.alignmentScore());
		}
	}

	@Test
	public void test1000Random() {
		for (int i = 0; i < LOOP; i++) {
			String dna = generator.generate(1000);
			String dna2 = generator.generate(dna.length() / 2);

			long start = System.currentTimeMillis();
			DynamicProgramming dpr = new DynamicProgramming(dna, dna2);
			times.get(currentHashID).add(System.currentTimeMillis() - start);
			System.out.println(dpr.alignmentScore());
		}
	}

	@Test
	public void test2000Random() {
		for (int i = 0; i < LOOP; i++) {
			String dna = generator.generate(2000);
			String dna2 = generator.generate(dna.length() / 2);

			long start = System.currentTimeMillis();
			DynamicProgramming dpr = new DynamicProgramming(dna, dna2);
			times.get(currentHashID).add(System.currentTimeMillis() - start);
			System.out.println(dpr.alignmentScore());
		}
	}

	@Test
	public void test3000Random() {
		for (int i = 0; i < LOOP; i++) {
			String dna = generator.generate(3000);
			String dna2 = generator.generate(dna.length() / 2);

			long start = System.currentTimeMillis();
			DynamicProgramming dpr = new DynamicProgramming(dna, dna2);
			times.get(currentHashID).add(System.currentTimeMillis() - start);
			System.out.println(dpr.alignmentScore());
		}
	}

	@Test
	public void test3500Random() {
		for (int i = 0; i < LOOP; i++) {
			String dna = generator.generate(3500);
			String dna2 = generator.generate(dna.length() / 2);

			long start = System.currentTimeMillis();
			DynamicProgramming dpr = new DynamicProgramming(dna, dna2);
			times.get(currentHashID).add(System.currentTimeMillis() - start);
			System.out.println(dpr.alignmentScore());
		}
	}
}
