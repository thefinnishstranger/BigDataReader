import java.io.*;

public class ReadFile1 {
    public static void main(String[] args) throws IOException {

        double highestTemperature = -300;
        double lowestTemperature = 300;
        int totalDataLines = 0;
        int totalTexasDataLines = 0;

        TexasDataList head = null;
        TexasDataList tail = null;
        


        String path = "/Users/nikolasgustavson/city_temperature.csv/";
        String line = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));


            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                totalDataLines++;
                String region = values[0];
                String country = values[1];
                String state = values[2];
                String city = values[3];
                String month = values[4];
                String day = values[5];
                String year = values[6];
                String avgTemperature = values[7];

                if (state.equals("Texas")) {
                    totalTexasDataLines++;
                    double avgTemperatureDouble = Double.parseDouble(avgTemperature);

                        if (avgTemperatureDouble >= -50 && avgTemperatureDouble <= 150) {
                            TexasDataList TexasData1 = new TexasDataList(region, country, state, city, month, day, year, avgTemperature);

                            if (head == null) {
                                head = TexasData1;
                                tail = head;
                            } else {
                                tail.next = TexasData1;
                                tail = TexasData1;
                            }

                            if (avgTemperatureDouble > highestTemperature) {
                                highestTemperature = avgTemperatureDouble;
                            }
                            if (avgTemperatureDouble < lowestTemperature) {
                                lowestTemperature = avgTemperatureDouble;
                            }
                        }


                }

            }
            System.out.println("The highest temperature out of the data set is: " + highestTemperature);
            System.out.println("The lowest temperature out of the data set is: " + lowestTemperature);
            System.out.println("The total data lines in data: " + totalDataLines);
            System.out.println("The total Texas data lines in data: " + totalTexasDataLines);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
        writer.write("The highest temperature out of the data set is: " + highestTemperature);
        writer.write("\nThe lowest temperature out of the data set is: " + lowestTemperature);
        writer.write("\nThe total data lines in data: " + totalDataLines);
        writer.write("\nThe total Texas data lines in data: " + totalTexasDataLines);
        writer.close();

    }
}










