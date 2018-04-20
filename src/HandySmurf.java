
public class HandySmurf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Smurf papa = new Smurf("Papa");
		System.out.println(papa.getName());
		papa.eat();
		System.out.println(papa.isGirlOrBoy());

		Smurf smurfette = new Smurf("Smurfette");
		System.out.println(smurfette.getName());
		smurfette.eat();
		System.out.println(smurfette.isGirlOrBoy());

	}

}
