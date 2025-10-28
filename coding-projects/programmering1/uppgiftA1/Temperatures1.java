// Temperatures1.java
// proccessing measurement data
/**********************************************************************
  A problem: processing measurement data
  Temperature measurements are taken in one and the same place for a
  couple
  of weeks. The measurements are taken regularly the same number of
  measurements each week. At the end of the measurement period the
  collected
  data is to be processed: for each week the least, the greatest and the
  average temperature is to be determined. The least, greatest and
  average temperature for the whole period is also to be computed.
  A solution to the problem
  This program reads the temperatures and displays them. Then the least,
  greatest and average temperature for each week is computed and stored.
  These results are printed on the standard output device. Finally, the
  least, greatest and average temperature over the whole measurement
  period is decided. These results are also printed on the standard
  output device.
Author: Fadil Galjic
 **********************************************************************/
import java.util.*; // Scanner, Locale
import static java.lang.System.out;

class Temperatures1 {
    public static void main (String[] args) {
        out.println("TEMPERATURES\n");
        // input tool
        Scanner in = new Scanner(System.in);
        in.useLocale(Locale.US);
        // enter the number of weeks and measurements
        out.print("number of weeks: ");
        int nofWeeks = in.nextInt();
        out.print("number of measurements per week: ");
        int nofMeasurementsPerWeek = in.nextInt();
        // storage space for temperature data
        double[][] t = new double[nofWeeks + 1]
            [nofMeasurementsPerWeek + 1];
        // read the temperatures
        for (int week = 1; week <= nofWeeks; week++)
        {
            out.println("temperatures - week " + week + ":");
            for (int measurement = 1;
                    measurement <= nofMeasurementsPerWeek;
                    measurement++)
                t[week][measurement] = in.nextDouble();
        }
        out.println("");
        // show the temperatures
        out.println("the temperatures");
        for (int week = 1; week <= nofWeeks; week++)
        {
            for (int measurement = 1;
                    measurement <= nofMeasurementsPerWeek;
                    measurement++)
                out.print(t[week][measurement] + " ");
            out.println("");
        }
        out.println("");
        // the least, greatest and average temperatures - weekly
        double[] minT = new double[nofWeeks + 1];
        double[] maxT = new double[nofWeeks + 1];
        double[] sumT = new double[nofWeeks + 1];
        double[] avgT = new double[nofWeeks + 1];
        // add code here
        
        // loop over weeks, finding the extremes
        for (int week = 1; week <= nofWeeks; week++) {
            // add initial values
            minT[week] = t[week][1];
            maxT[week] = t[week][1];
            avgT[week] = t[week][1];
            sumT[week] = t[week][1];
            
            // if there is only one measurement per week the values are 
            // already correct
            if (nofMeasurementsPerWeek > 0) {
                // start looping at measurement 2 since measurement 1
                // has already been assigned
                for (int measurement = 2; 
                        measurement <= nofMeasurementsPerWeek;
                        measurement++){
                    // replace minT if a smaller measurement is found
                    if (t[week][measurement] < minT[week]) {
                        minT[week] = t[week][measurement];
                    }
                    // replace maxT if a larger measurement is found
                    else if (t[week][measurement] > maxT[week]){
                        maxT[week] = t[week][measurement];
                    }
                    // add the measurement to the sum
                    sumT[week] += t[week][measurement];
                }
                // compute the average of all measurements across one week
                avgT[week] = sumT[week] / nofMeasurementsPerWeek;
            }
        }
        // show the least, greatest and average temperatures
        out.println("the least, greatest and average temperatures"
                + " - weekly");
        out.println();
        for (int week = 1; week <= nofWeeks; week++)
            out.print(minT[week] + " ");
        out.println();
        for (int week = 1; week <= nofWeeks; week++)
            out.print(maxT[week] + " ");
        out.println();
        for (int week = 1; week <= nofWeeks; week++)
            out.print(avgT[week] + " ");
        out.println();
        out.println();
        // the least, greatest and average temperatures - whole period
        double minTemp = minT[1];
        double maxTemp = maxT[1];
        double sumTemp = sumT[1];
        double avgTemp = avgT[1];
        
        // if there is only one week the values are already correct
        if (nofWeeks > 1){
            // loop over weeks starting at 2 since week 1 values
            // are already assigned
            for (int n = 2; n <= nofWeeks; n++) {
                // replace minTemp if a week has a smaller minimum measurement
                if (minT[n] < minTemp) {
                    minTemp = minT[n];
                }
                // replace maxTemp if a week has a larger maximum measurement
                if (maxT[n] > maxTemp) {
                    maxTemp = maxT[n];
                }
                // add the sum temp of the week to sumTemp
                sumTemp += sumT[n];
            }
            // compute the average temperature across all weeks
            avgTemp = sumTemp / (nofWeeks * nofMeasurementsPerWeek);
        }
        // show the least, greatest and average temperature for
        // the whole period
        out.println("the least, greatest and average temperature"
                + " - whole period");
        out.println(minTemp + "\n" + maxTemp + "\n" + avgTemp);
        in.close();
    }
}
