package lab4;
import java.util.ArrayList;
import java.util.Arrays;
import lab4.Die;
public class Roller {
	
	private int quantity_of_dice=0;
	private int sides=6;
	private ArrayList<Die> dice_collection;
	private ArrayList<int[]> stat;
	private int mode=0;
	private int range=0;
	private float accuracy=0;
	private int num_of_rolls;
	
	public Roller(){
		dice_collection = new ArrayList<Die>();
		stat = new ArrayList<int[]>();
	}
	
	public void giveDie(Die die){
		dice_collection.add(die);
		sides = die.sides();
		quantity_of_dice += 1;
		
	}
	
	public void rollDice(int t){
		num_of_rolls = t;
		for(int i=0;i<quantity_of_dice;i++){
			int[] data = new int[dice_collection.get(i).sides()];
			for(int j=0; j<t; j++){
				int num = dice_collection.get(i).roll();
				data[num-1] += 1;				
			}
		stat.add(data);	
		}
	}
	public void analyse(){
		
		for(int i=0;i<quantity_of_dice;i++){
			int highest = stat.get(i)[0];
			int highest_ind = 1;
			int smallest = stat.get(i)[0];
			for(int j=0;j<dice_collection.get(i).sides();j++){
				
				if (stat.get(i)[j]>highest){
					highest = stat.get(i)[j];
					highest_ind = j+1;
				}
				if (stat.get(i)[j]<smallest){
					smallest = stat.get(i)[j];
				}
			}
			mode = highest_ind;
			range = highest - smallest;
			accuracy = (float)range/(float)num_of_rolls;
			System.out.println(String.format("Die %s : %s mode : %d range : %d accuracy : %,.3f",i, Arrays.toString(stat.get(i)), mode, range, accuracy));
		}
	}

	public static void main(String[] args) {
		Player p1 = new Player(100.0);
		p1.hit(new Card("Tester", 1));
		System.out.println(p1.score());
		p1.hit(new Card("Tester", 20));
		System.out.println(p1.score());
		}
}