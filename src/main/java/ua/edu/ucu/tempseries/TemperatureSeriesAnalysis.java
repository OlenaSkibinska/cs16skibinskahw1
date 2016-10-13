package ua.edu.ucu.tempseries;

import java.util.InputMismatchException;

public class TemperatureSeriesAnalysis {
    private double[] temperatureSeries;

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        this.temperatureSeries = temperatureSeries;
    }

    public double average() throws IllegalArgumentException {
        int sum = 0;
        if (temperatureSeries.length == 0) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < temperatureSeries.length; ++i) {
            sum += temperatureSeries[i];

        }
        double average = sum / temperatureSeries.length;

        return average;
    }

    public double deviation() throws IllegalArgumentException {
        if (temperatureSeries.length == 0) {
            throw new IllegalArgumentException();
        }
        double ner = 0;
        for (int i = 0; i < temperatureSeries.length; ++i) {

           ner += Math.pow(temperatureSeries[i] - average(), 2);
        }
        double ytr = Math.sqrt(ner / temperatureSeries.length);

        return ytr;
    }

    public double min() throws IllegalArgumentException {
        if (temperatureSeries.length == 0) {
            throw new IllegalArgumentException();
        }
        double theMin = temperatureSeries[0];
        for (int i = 0; i < temperatureSeries.length; ++i) {
            if (temperatureSeries[i] < theMin) {
                theMin = temperatureSeries[i];
            }
        }
        return theMin;
    }

    public double max() throws IllegalArgumentException {
        if (temperatureSeries.length == 0) {
            throw new IllegalArgumentException();
        }
        double theMax = temperatureSeries[0];
        for (int i = 0; i < temperatureSeries.length; ++i) {
            if (temperatureSeries[i] > theMax) {
                theMax = temperatureSeries[i];
            }
        }

        return theMax;
    }

    public double findTempClosestToZero() throws IllegalArgumentException {
        if (temperatureSeries.length == 0) {
            throw new IllegalArgumentException();
        }
        double closestToZero = temperatureSeries[0];
        for (int i = 0; i < temperatureSeries.length; ++i) {
            if (Math.abs(closestToZero) == Math.abs(temperatureSeries[i]) && temperatureSeries[i] > 0) {
                closestToZero = temperatureSeries[i];
            }
            else if (Math.abs(temperatureSeries[i]) < Math.abs(closestToZero)) {
                closestToZero = temperatureSeries[i];

            }
        }

        return closestToZero;
    }

    public double findTempClosestToValue(double tempValue) throws IllegalArgumentException {
        if (temperatureSeries.length == 0) {
            throw new IllegalArgumentException();
        }
        double closestToValue = temperatureSeries[0];
        for (int i = 0; i < temperatureSeries.length; ++i) {
            if (Math.abs(closestToValue - tempValue) > Math.abs(temperatureSeries[i] - tempValue)) {
                closestToValue = temperatureSeries[i];
            }
            else if (Math.abs(closestToValue - tempValue) == Math.abs(temperatureSeries[i] - tempValue) && temperatureSeries[i] > tempValue) {
                closestToValue = temperatureSeries[i];
            }

        }


        return closestToValue;
    }

    public double[] findTempsLessThen(double tempValue) {
        int c  = 0;
        for (int i = 0; i < temperatureSeries.length; ++i) {
            if (temperatureSeries[i] < tempValue) {
                c++;
            }
        }
        double[] newList = new double[c];
        c = 0;
        for (int i = 0; i < temperatureSeries.length; ++i) {
            if (temperatureSeries[i] < tempValue) {
                newList[c] = temperatureSeries[i];
                c++;
            }
        }
        return newList;
    }

    public double[] findTempsGreaterThen(double tempValue) {
        int k  = 0;
        for (int i = 0; i < temperatureSeries.length; ++i) {
            if (temperatureSeries[i] >= tempValue) {
                k++;
            }
        }
        double[] newList = new double[c];
       k = 0;
        for (int i = 0; i < temperatureSeries.length; ++i) {
            if (temperatureSeries[i] >= tempValue) {
                newList[k] = temperatureSeries[i];
                k++;

            }
        }

        return newList;
    }
    public TempSummaryStatistics summaryStatistics() throws IllegalArgumentException {
        if (temperatureSeries.length == 0) {
            throw new IllegalArgumentException();
        }
        TempSummaryStatistics myEx = new TempSummaryStatistics(this.average(), this.deviation(), this.min(), this.max());

        return null;
    }

    public int addTemps(double... temps) throws InputMismatchException {
        for (int i = 0; i < temps.length; ++i) {
            if (temps[i] < -273) {
                throw new InputMismatchException();
            }
        }
        double[] listAddTemps = new double[Math.max(temperatureSeries.length + temps.length, temperatureSeries.length*2)];
        for (int i = 0; i < temperatureSeries.length; ++i) {
            listAddTemps[i] = temperatureSeries[i];
        }
        for (int i = 0; i < temps.length; ++i) {
            listAddTemps[i + temperatureSeries.length] = temps[i];
        }
        int finalList = temperatureSeries.length + temps.length;
        return finalList;
    }
}
