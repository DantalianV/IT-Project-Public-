
public class Restaurant {

	final String name;
	private String[] address;
    final String city;
    final String type;
	final double rating;
	private final String timing;
	private String review;
	final Menu menu;
	Table[] tables;

	
	public Restaurant(String a, String[] b, String p, String e, double r, String c, String d, Menu m, Table[] t) {
		name = a;
		address = b;
		city = p;
		type = e;
		rating = r;
		timing = c;
		review = d;
		menu = m;
		tables = t;
	}

	public Restaurant() {
		name = null;
		address = null;
		city = null;
		type = null;
		rating = 0;
		timing = null;
		review = null;
		menu = null;
		tables = null;
	}

	public String[] getAddress() {
		return this.address;
	}
	
	public void updateReview(String string) {
		this.review = string;
	}
	
	public String getReview() {
		return this.review;
	}
	
	public String toString() {
		if(this.name.equals("Not Found"))
			return this.name;
		return this.name + "\n" + this.rating + "\n" + this.type + "\n" ;
	}
}
