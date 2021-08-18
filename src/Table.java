public class Table {
	int reservations=0;
	Time[] startTime =  new Time[100];
	Time[] endTime = new Time[100];
	
	public Table(Time st, Time et)
	{
		startTime[reservations] = st;
		endTime[reservations]=et;
	}
}
