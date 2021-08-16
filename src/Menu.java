public class Menu {
	
	String[] menu;
	int[] price;
	
	public Menu(String[] menu, int[] price) {
		this.menu = menu;
		this.price = price;
	}
	
	public void displayMenu() {
		
		System.out.println("MENU");
		for(int i=0;i<24;i++) {
			System.out.println(this.menu[i]+"------------>  ₹ "+price[i]);
		}
	}
}