import java.util.Random;

public class DNAGenerator {

   private char[] nucleotides = new char[] { 'A', 'C', 'G', 'T' };
   private Random r = new Random();

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
