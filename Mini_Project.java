import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
// Starting Of The Program
public class Mini_Project {
    public static void main(String[] args) {
        String filePath = "Students.csv";
        String[] columnNames = null;  // To Store Header Fields
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line;
            int StudentNumber = 0;

            // First Read The Header Row
            if ((line = br.readLine()) != null) {
                columnNames = line.split(",");
            }

            //Reading Each Students Data
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                // Starting Of the Output
                if (columnNames != null && data.length == columnNames.length) {
                    StudentNumber++;
                    System.out.println("\n");
                    System.out.println("Student Number #" + StudentNumber);
                    System.out.println("\n");
                    for (int i = 0; i < columnNames.length; i++) {
                        System.out.println(columnNames[i] + ": " + data[i]);
                    }
                    System.out.println("________________________________");
                    // Delay The Output Printing Speed
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        System.out.println("Delay interrupted");
                    }
                } else {
                    System.out.println("Skipping Malformed Line: " + line);
                }
            }
            // End Of The Output
            br.close();
            // Doing Exception Handling If The Reading Csv File Is Not Successful
        } catch (IOException e) {
            System.out.println("Error Reading Your File: " + e.getMessage());
        }
    }
}
