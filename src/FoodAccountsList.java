import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FoodAccountsList {

    FoodAccount[] list = new FoodAccount[1000];
    int count;

    public FoodAccountsList(){
        
        String filename = "accounts.txt";
            int i = 0;
            File myObj = new File(filename);
            Scanner myReader;
            try {
                myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    String[] s = data.split(":");
                    this.list[i] = new FoodAccount(Integer.parseInt(s[0]),s[1],s[2],Double.parseDouble(s[3]),s[4],Integer.parseInt(s[5]),s[6]);
                    i++;
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            this.count = i; 
    }

    public String getUserId(int i){
        return this.list[i].userId;
    }

    public String getPassword(int i){
        return this.list[i].password;
    }
}
