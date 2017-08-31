import java.util.Random;

public class DNAGenerator {

   private char[] nucleotides = new char[] { 'A', 'C', 'G', 'T' };
   private Random r = new Random();

   public static void main(String[] args) {
      DNAGenerator generator = new DNAGenerator();
      String ancestor = generator.generate(8);
      String descendant1 = generator.mutate(ancestor, 4);
      String descendant2 = generator.mutate(ancestor, 12);
      System.out.println("Ancestor:   " + ancestor);
      System.out.println("Descendant: " + descendant1);
      System.out.println("Descendant: " + descendant2);
   }

   public String generate(int length) {
      StringBuffer buf = new StringBuffer(length);
      for (int i = 0; i < length; i++) {
         char randNucleotide = getRandNucleotide();
         buf.append(randNucleotide);
      }

      return buf.toString();
   }

   private char getRandNucleotide() {
      int randInt = r.nextInt(4);
      char randNucleotide = nucleotides[randInt];
      return randNucleotide;
   }

   public String mutate(String dNA, int mutationCount) {
      StringBuffer mutatedBuf = new StringBuffer(dNA);
      for (int i = 0; i < mutationCount; i++) {
         double rand = r.nextDouble();
         int randIndex = r.nextInt(mutatedBuf.length());
         if (rand < 0.5) {
            // do mutation
            mutatedBuf.replace(randIndex, randIndex + 1, ""
                  + getRandNucleotide());
         } else if (rand < 0.75) {
            // do insertion
            mutatedBuf.insert(randIndex, getRandNucleotide());
         } else {
            // do deletion
            mutatedBuf.deleteCharAt(randIndex);
         }
      }

      return mutatedBuf.toString();
   }
}
