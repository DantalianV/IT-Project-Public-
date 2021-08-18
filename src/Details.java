import java.util.Random;

public class Details {
	
	String[] names = new String[1002];
	String[][] address = new String[1002][13];
	String[] city = new String[1002];
	String[] type = new String[1002];
	double[] rating = new double[1002];
	String[] timing = new String[1002];
	String[] review = new String[1002];
	Menu[] menus = new Menu[1002];

	public Details() {
		names = ReadFile.readStrings("names.txt");
		address = ReadFile.readAdd("addresses.txt");
		rating = ReadFile.readDouble("ratings.txt");
		city = ReadFile.readStrings("cities.txt");
		timing = ReadFile.readStrings("timing.txt");
		review = ReadFile.readStrings("review.txt");
		type = typeReturn();
		menus = returnMenu();
	}
	
	private String[] typeReturn() {
		String[] restaurantType = new String[1002];
		String[] typeString = {"Punjabi","Italian","Fast Food","South Indian"};
		
		Random random = new Random(0);
		
		for(int i = 0; i<1002; i++) {
			restaurantType[i] = typeString[random.nextInt(4)];
		}
		return restaurantType;
	}
	
	private Menu[] returnMenu() {
		Menu[] resMenus = new Menu[1002];
		MenuList menuList = new MenuList();
		menuList.buildLibrary();
		
		for(int i = 0; i<1002; i++) {
			if((this.type[i]).equals("Punjabi"))
				resMenus[i] = menuList.menus[0];
			else if((this.type[i]).equals("South Indian"))
				resMenus[i] = menuList.menus[1];
			else if((this.type[i]).equals("Italian"))
				resMenus[i] = menuList.menus[3];
			else
				resMenus[i] = menuList.menus[2];
		}
	
		return resMenus;
	}
}