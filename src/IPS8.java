
import java.io.File;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class IPS8 {

    public static void welcomeUser() {
        System.out.println("Welcome.");
        System.out.println("Type 'v' to View All Logs, type 'a' to Add New Log, or 'e' to Exit");
    }
    
    public static void viewLogs() {
        try
        {
            File file = new File("src/myFile.txt"); 

            Scanner in = new Scanner(file);     

            while(in.hasNextLine()) 
            {                       
                System.out.println(in.nextLine()); 
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage()); 
        }
    }
    
    public static void addLog() {
        Scanner scan = new Scanner(System.in);
        
        Date date = new Date();             
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        
        System.out.println("What kind of workout did you do? Type 's' for swimming, 'r' for running, or 'w' for weight lifting.");
        char userInput = scan.next().charAt(0);
        
        if (userInput == 's')
        {
            System.out.println("How many laps did you swim?");
            int numLaps = scan.nextInt();

            try
            {
                File file = new File("src/myFile.txt"); 

                Scanner in = new Scanner(file);     
                int numEntries = 1; //initializes log entry number
                while(in.hasNextLine())  
                {                       
                    String line = in.nextLine();  
                    numEntries++;     //adds one to numEntries for every 
                }
                
                FileWriter out = new FileWriter("src/myFile.txt", true);    
                out.write(numEntries + ". Swimming: " + numLaps + " laps " + dateFormat.format(date) + "\n");
                out.close();                
            }
            catch(Exception e)
            {
                System.out.println(e.getMessage()); 
            }
        }
        else if (userInput == 'r')
        {
            System.out.println("How many miles did you run?");
            int numMiles = scan.nextInt();
            
            try
            {
                File file = new File("src/myFile.txt"); 

                Scanner in = new Scanner(file);     
                int numEntries = 1; //initializes log entry number
                while(in.hasNextLine())  
                {                       
                    String line = in.nextLine();  
                    numEntries++;     //adds one to numEntries for every 
                }
                
                FileWriter out = new FileWriter("src/myFile.txt", true);    
                out.write("Running: " + numMiles + " miles " + dateFormat.format(date) + "\n");
                out.close();
            }
            catch(Exception e)
            {
                System.out.println(e.getMessage()); 
            }
        }
        else if (userInput == 'w')
        {
            System.out.println("How many reps did you complete?");
            int numReps = scan.nextInt();
            
            try
            {
                File file = new File("src/myFile.txt"); 

                Scanner in = new Scanner(file);     
                int numEntries = 1; //initializes log entry number
                while(in.hasNextLine())  
                {                       
                    String line = in.nextLine();  
                    numEntries++;     //adds one to numEntries for every 
                }
                
                FileWriter out = new FileWriter("src/myFile.txt", true);    
                out.write("Weight lifting: " + numReps + " reps " + dateFormat.format(date) + "\n");
                out.close();                
            }
            catch(Exception e)
            {
                System.out.println(e.getMessage()); 
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); 
        boolean quitProgram = false;
        
        welcomeUser();
        
        char userInput = scan.next().charAt(0);
        
        while(!quitProgram)
        {
            if (userInput == 'v')
            {
                viewLogs();
                quitProgram = true;
            }
            else if (userInput == 'a')
            {
                addLog();
                quitProgram = true;
            }
            else if (userInput == 'e')
            {
                quitProgram = true;
            }
        }
    }
}
