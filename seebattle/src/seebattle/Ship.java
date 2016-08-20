package seebattle;

public class Ship {
	int motor;
	int[] state;
	int st = 0;
   Ship (int mot) {
	   motor = mot;
	   state = new int[motor];
	   for (int i = 0; i < motor; i++)
		   state[i] = motor;
   }
   void checkState () {
   	for (int i = 0;i < motor; i++ )
   		if (state[i] != motor)
   		   st++;
   	System.out.println(st);
   }
}