package lab4;
import java.util.ArrayList;
import java.util.Random;

public class Die {
	int sides;
	long seed;
	int k=0;
	
	public Die(int i, long l){
		sides = i;
		seed = l;
	}
	
	public Die(int side){
		sides = side;
	}
	public int sides(){
		if (sides <= 0){
			System.out.println(String.format("WARNING: Die has %d sides.", sides));
		}
		return sides;
	}

	public int roll(){
		Random temp = new Random(seed);
		int[] port = new int[k+1];
		for (int j=0; j<k+1; j++){
			int pick = temp.nextInt(sides)+1;
			port[j] = pick;
		}
		int j=k;
		k+=1;
        return port[j];
	}
	public String toString(){  
		String fin = String.format("A Die with %d sides and the seed of %d.", sides, seed);
		return fin;
	}
	public static void main(String[] args) {
		Die d1 = new Die(0);
		d1.sides();
		Die d2 = new Die(12, 232L);
		d2.sides();
		d2.roll();
		d2.roll();
        }
	

}