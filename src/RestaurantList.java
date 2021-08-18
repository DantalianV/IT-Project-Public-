import java.util.ArrayList;

public class RestaurantList extends Details{

	private Restaurant[] restaurants;
	
	public RestaurantList() {          // constructor for Restaurant array
		super();
		Restaurant[] res = new Restaurant[1002];
		for(int i = 0; i<1002; i++) {
			res[i] = new Restaurant(names[i], address[i], city[i], type[i], rating[i], timing[i], review[i], menus[i]);
			
		}
		restaurants = res;
	}
	
	public Restaurant[] searchByLocation(String city) {
		ArrayList<Restaurant> list = new ArrayList<Restaurant>();  
		 for(int i = 0; i<1002; i++) {
			 if(this.restaurants[i].city.equalsIgnoreCase(city)) //restaurant.city == city
					 list.add(this.restaurants[i]);
		 }
		 
		 Restaurant[] resByLocation = new Restaurant[list.size()];
		 resByLocation = list.toArray(resByLocation);
		 return resByLocation;
	}
	
	public Restaurant[] searchByRating(double rate) {
		ArrayList<Restaurant> list = new ArrayList<Restaurant>();
		for(int i = 0; i<1002; i++) {
			if(this.restaurants[i].rating>=rate)
				list.add(this.restaurants[i]);
		}
		
		Restaurant[] resByRating = new Restaurant[list.size()];
		resByRating = list.toArray(resByRating);
		return resByRating;
	}
	
	public Restaurant searchByName(String s) {
		for(int i = 0; i<1002; i++) {
			if(this.restaurants[i].name.equalsIgnoreCase(s))
				return this.restaurants[i];
		}
		return new Restaurant("Not Found", null, null, null, 0, null, null, null);
	}

	public String byName(String s) {
		for(int i = 0; i<1002; i++) {
			if(this.restaurants[i].name.equalsIgnoreCase(s))
				return this.restaurants[i].toString();
		}
		return "Not Found";
	}
	
	public Restaurant[] searchByType() {
		ArrayList<Restaurant> list1 = new ArrayList<Restaurant>();
		ArrayList<Restaurant> list2 = new ArrayList<Restaurant>();
		ArrayList<Restaurant> list3 = new ArrayList<Restaurant>();
		ArrayList<Restaurant> list4 = new ArrayList<Restaurant>();
		String[] type = {"Punjabi","Italian","Fast Food","South Indian"};
		System.out.println();
		for(int i = 0; i<4; i++) {
			StdOut.println((i+1) + "] " + type[i]);
		}
		for(int i = 0; i<1002; i++) {
			if(this.restaurants[i].type.equals(type[0]))
					list1.add(this.restaurants[i]);
			else if(this.restaurants[i].type.equals(type[1]))
					list2.add(this.restaurants[i]);
			else if (this.restaurants[i].type.equals(type[2])) 
					list3.add(this.restaurants[i]);
			else {
				list4.add(this.restaurants[i]);
			}
		}
		
		Restaurant[] resByType1 = new Restaurant[list1.size()];
		resByType1 = list1.toArray(resByType1);
		
		Restaurant[] resByType2 = new Restaurant[list2.size()];
		resByType2 = list2.toArray(resByType2);
		
		Restaurant[] resByType3 = new Restaurant[list3.size()];
		resByType3 = list3.toArray(resByType3);
		
		Restaurant[] resByType4 = new Restaurant[list4.size()];
		resByType4 = list4.toArray(resByType4);

		System.out.println();
		int n = StdIn.readInt();
		if(n==1)
			return resByType1;
		if(n==2)
			return resByType2;
		if(n==3)
			return resByType3;
		else
			return resByType4;
	}

	public static void printRes(Restaurant[] res) {
		int i = 0;
		for (Restaurant m: res) {
			System.out.println(i+1 + ") " + m);
			i++;
		}
	}
}