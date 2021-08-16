public class Table {
	int reservations=0;
	int tableNo;
	Time[] startTime =  new Time[100];
	Time[] endTime = new Time[100];

	
	public Table(Time st, Time et)
	{
		startTime[reservations] = st;
		endTime[reservations]=et;
	}

	public Table()
	{
		startTime[reservations] = null;
		endTime[reservations] = null;
	}
}
