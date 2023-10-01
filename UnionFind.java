/**
 * Implementation of the Union-Find ADT.
 */
public class UnionFind {

   private int up[];
   private int weight[];
   int numSets;


   /**
    * Constructor - initializes up and weight arrays.
    *
    * @param numElements initial number of singleton sets.
    */
   public UnionFind(int numElements) {
      //your code comes here
      this.numSets = numElements ;
      this.up = new int[numElements];
      this.weight = new int[numElements];
      for (int i = 0; i < numElements; i++) {
         this.up[i] = -1;
         this.weight[i] = 1;
      }
   }

   /**
    * Unites two sets using weigthed union.
    *
    * @param i representative of first set.
    * @param j representative of second set.
    *          If i or j are not representative elements - throw an IllegalArgumentException
    */
   public void union(int i, int j) {
      //your code comes here
      if (up[i] != -1 || up[j] != -1)
         throw new IllegalArgumentException();
      if (this.weight[i] >= this.weight[j]) {
         this.up[j] = i;
         this.weight[i] += this.weight[j];

      } else {
         this.up[i] = j;
         this.weight[j] += this.weight[i];
      }
      this.numSets--;
   }

   /**
    * Finds the set representative, and applies path compression.
    *
    * @param i the element to search.
    * @return the representative of the group that contains i.
    */
   public int find(int i) {
      //your code comes here
      int representative = i;
      while (this.up[representative] != -1) {
         representative = this.up[representative];
      }
      if (i!= representative){
         int k = up[i];
         while (k!=representative){
            up[i]=representative;
            i=k;
            k=up[k];
         }
      }
      return representative;
   }

   /**
    * Find the current number of sets.
    *
    * @return the number of set.
    */
   public int getNumSets() {
      //your code comes here
      return this.numSets;
   }

   /**
    * Prints the contents of the up array.
    */
   private void debugPrintUp() {

      System.out.print("up:     ");
      for (int i = 0; i < up.length; i++)
         System.out.print(up[i] + " ");
      System.out.println("");
   }

   /**
    * Prints the results of running find on all elements.
    */
   private void debugPrintFind() {
      System.out.print("find:   ");
      for (int i = 0; i < up.length; i++)
         System.out.print(find(i) + " ");
      System.out.println("");
   }

   /**
    * Prints the contents of the weight array.
    */
   private void debugPrintWeight() {

      System.out.print("weight: ");
      for (int i = 0; i < weight.length; i++)
         System.out.print(weight[i] + " ");
      System.out.println("");
   }

   /**
    * Various tests for the Union-Find functionality.
    *
    * @param args command line arguments - not used.
    */
   public static void main(String[] args) {

      UnionFind uf = new UnionFind(10);

      uf.debugPrintUp();
      uf.debugPrintFind();
      uf.debugPrintWeight();
      System.out.println("Number of sets: " + uf.getNumSets());
      System.out.println("");

      uf.union(2, 1);
      uf.union(3, 2);
      uf.union(4, 2);
      uf.union(5, 2);

      uf.debugPrintUp();
      uf.debugPrintFind();
      uf.debugPrintWeight();
      System.out.println("Number of sets: " + uf.getNumSets());
      System.out.println();

      uf.union(6, 7);
      uf.union(8, 9);
      uf.union(6, 8);

      uf.debugPrintUp();
      uf.debugPrintFind();
      uf.debugPrintWeight();
      System.out.println("Number of sets: " + uf.getNumSets());
      System.out.println();

      System.out.println(uf.up[9]);
      System.out.println(uf.find(8));
      System.out.println(uf.up[9]);
      System.out.println();

      uf.debugPrintUp();
      uf.debugPrintFind();
      uf.debugPrintWeight();
      System.out.println("Number of sets: " + uf.getNumSets());
      System.out.println();
   }
}