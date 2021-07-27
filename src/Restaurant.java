
public class Restaurant {

	final String name;
	private String[] address;
    final String city;
    final String type;
	final double rating;
	private final String timing;
	private final String review;
	final Menu menu;
	
	public Restaurant(String a, String[] b, String p, String e, double r, String c, String d, Menu m) {
		name = a;
		address = b;
		city = p;
		type = e;
		rating = r;
		timing = c;
		review = d;
		menu = m;
	}
	
	public String[] getAddress() {
		return this.address;
	}
	
	public String toString() {
		if(this.name.equals("NOT FOUND"))
			return this.name;
		return this.name + "\n" + this.rating + "\n" + this.type + "\n" ;/*+ this.timing + "\n" +this.address[0] + "\n" + this.address[1] + "\n" + this.address[2] + "\n" + this.address[3] + "\n" + this.address[4] + "\n" + this.address[5] + "\n" +this.address[6] + "\n" + this.address[7] + "\n" + this.address[8] + "\n" + this.address[9] + "\n" + this.address[10] + "\n" + this.address[11] + "\n" + this.address[12] + "\n" + this.review;*/
	}
	
}
