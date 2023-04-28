package Main;

import it.unimi.dsi.fastutil.ints.IntArrayList;

    public class Individu {
        public static int n;
        private IntArrayList  Solution;
        private int fitness,longevite;

        public int getLongevite() {
            return longevite;
        }
        public void setLongevite(int longevite) {
            this.longevite = longevite;
        }
        public int getFitness() {
            return fitness;
        }
        public void setFitness() {
            this.fitness = this.evaluation2();
        }
        public void setSolution(IntArrayList Solution) {
            this.Solution = Solution;
        }
        public Individu(int longevite,IntArrayList Solution) {
            this.Solution = Solution;
            this.longevite=longevite;
        }
        public Individu(IntArrayList Solution) {
            this.Solution = Solution;
        }
        public int evaluation2(){
            int c=0;
            for (int i = 0; i <Solution.size(); i++) {
                for (int j = i + 1; j < Solution.size(); j++) {
                    if (j - i == Math.abs(Solution.getInt(i) - Solution.getInt(j)))  c++;
                    if (Solution.getInt(i) == Solution.getInt(j)) c++;
                }
            }
            return c;
        }
        public IntArrayList getSolution() {
            return Solution;
        }

    }




