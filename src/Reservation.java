import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Reservation {
	
	static RestaurantList restDetails = new RestaurantList();

	public Reservation() {
		File file = new File("reservationrecords.txt");
    	Scanner myReader;
    	try {
			myReader = new Scanner(file);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				String[] sarr = data.split("\\|");
				
				if (sarr.length != 5)
					continue;
				
				Restaurant r = restDetails.searchByName(sarr[0]);
				int tableNo = Integer.parseInt(sarr[1]);
				int reservationNum = Integer.parseInt(sarr[4]);
				String[] stemp = sarr[2].split(":");
				String[] etemp = sarr[3].split(":");

				Time stime = new Time(Integer.parseInt(stemp[0]),Integer.parseInt(stemp[1]));
				Time etime = new Time(Integer.parseInt(etemp[0]),Integer.parseInt(etemp[1]));
				
				if(r.tables[tableNo-1]==null)
				{
					r.tables[tableNo-1]=new Table(stime,etime);
				}	
				
				r.tables[tableNo-1].startTime[reservationNum-1]=stime;
				r.tables[tableNo-1].endTime[reservationNum-1]=etime;
				r.tables[tableNo-1].reservations=reservationNum;


				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void reserve(Time st,Time et,Restaurant chosenRestaurant,FoodAccount use) {
		
		String finame = "reservationrecords.txt";
		boolean ifSuccessful =false;

		
		System.out.println("checking for vacant tables..");
		for(int i = 0;i<4;i++)
		{
			if(chosenRestaurant.tables[i]==null)
			{
				chosenRestaurant.tables[i]=new Table(st,et);
				
				chosenRestaurant.tables[i].reservations++;
				System.out.println("Table found,your reservation was successful");
				System.out.println("Table number = "+(i+1)+"\nStart Time = "+st+"\nEnd Time = "+et);
				ifSuccessful=true;
				
				String reslt = chosenRestaurant.name+"|"+(i+1)+"|"+st.toString()+"|"+et.toString()+"|"+chosenRestaurant.tables[i].reservations;
				 try {
			            BufferedWriter out = new BufferedWriter(new FileWriter(finame,true));
			            out.write(reslt+"\n");
			            out.close();
			        }
			        catch (IOException e) {
			            System.out.println("Exception Occurred" + e);
			        }
				 break;

			}
			
			int noOfReservations=chosenRestaurant.tables[i].reservations;
			
			

			for(int j=0;j<=noOfReservations;j++)
			{
				if(Time.intersects(chosenRestaurant.tables[i].startTime[j], chosenRestaurant.tables[i].endTime[j], st, et)==false)
				{
					//noOfReservations++;
					chosenRestaurant.tables[i].startTime[noOfReservations]=st;
					chosenRestaurant.tables[i].endTime[noOfReservations]=et;
					chosenRestaurant.tables[i].reservations++;
					System.out.println("Table found,your reservation was successful");
					System.out.println("Table number = "+(i+1)+"\nStart Time = "+st+"\nEnd Time = "+et);
					ifSuccessful=true;
					
					String reslt = chosenRestaurant.name+"|"+(i+1)+"|"+st.toString()+"|"+et.toString()+"|"+chosenRestaurant.tables[i].reservations;
					 try {
				            BufferedWriter out = new BufferedWriter(new FileWriter(finame,true));
				            out.write(reslt+"\n");
				            out.close();
				        }
				        catch (IOException e) {
				            System.out.println("Exception Occurred" + e);
				        }
					 
					 return;

				}
				else
				{
					break;
				}
				
		
	
			}
			
		}
		
		if(ifSuccessful==false)
		{
			System.out.println("All tables are full");
			start(use);
		}
		
		
		
		
		
	}

	public void start(FoodAccount user) {
		
		int choice;
		
		Restaurant chosen = new Restaurant();
		
		System.out.println("1]Search restaurant 2]Search by location");
		choice = StdIn.readInt();
		if(choice==1) 
		{
			String resname,searchResult;
			System.out.println("Enter restaurant name");
			resname=StdIn.readString();
			searchResult= restDetails.byName(resname);
			System.out.println(searchResult);
			if(searchResult.equals("Not Found"))
			{
				start(user);
			}
			else
			{
				chosen = restDetails.searchByName(resname);
			}
			Time starttime,endtime;
			System.out.println("Enter start time and end time for your reservation (HH:MM)");
			String inp1,inp2;
			String[] temp;
			int hour,min;
			inp1 = StdIn.readString();
			temp = inp1.split(":");
			hour = Integer.parseInt(temp[0]);
			min = Integer.parseInt(temp[1]);
			starttime = new Time(hour,min);
			
			inp2 = StdIn.readString();
			temp = inp2.split(":");
			hour = Integer.parseInt(temp[0]);
			min = Integer.parseInt(temp[1]);
			endtime = new Time(hour,min);
			
			reserve(starttime,endtime,chosen,user);
			
			
		}
		
		if(choice==2) 
		{
			
			System.out.println("Search by location: 1]My city 2]Enter location");
			
			choice= StdIn.readInt();
			if(choice==1)
			{
				Restaurant[] restInCity = restDetails.searchByLocation(user.city);
				RestaurantList.printRes(restInCity);
				System.out.println("choose restuarant");
				choice = StdIn.readInt();
				chosen  = restInCity[choice-1];
				Time starttime,endtime;
				System.out.println("Enter start time and end time for your reservation (HH:MM)");
				String inp1,inp2;
				String[] temp;
				int hour,min;
				inp1 = StdIn.readString();
				temp = inp1.split(":");
				hour = Integer.parseInt(temp[0]);
				min = Integer.parseInt(temp[1]);
				starttime = new Time(hour,min);
				
				inp2 = StdIn.readString();
				temp = inp2.split(":");
				hour = Integer.parseInt(temp[0]);
				min = Integer.parseInt(temp[1]);
				endtime = new Time(hour,min);
				
				reserve(starttime,endtime,chosen,user);
				
				
				
			}
			if(choice==2)
			{
				String city;
				city=StdIn.readString();
				Restaurant[] restInCity = restDetails.searchByLocation(city);
				RestaurantList.printRes(restInCity);
				System.out.println("choose restuarant");
				choice = StdIn.readInt();
				chosen  = restInCity[choice-1];
				Time starttime,endtime;
				System.out.println("Enter start time and end time for your reservation (HH:MM)");
				String inp1,inp2;
				String[] temp;
				int hour,min;
				inp1 = StdIn.readString();
				temp = inp1.split(":");
				hour = Integer.parseInt(temp[0]);
				min = Integer.parseInt(temp[1]);
				starttime = new Time(hour,min);
				
				inp2 = StdIn.readString();
				temp = inp2.split(":");
				hour = Integer.parseInt(temp[0]);
				min = Integer.parseInt(temp[1]);
				endtime = new Time(hour,min);
				
				reserve(starttime,endtime,chosen,user);
				
			}
			else 
			{
				start(user);
			}
			
		}
		
	}
}