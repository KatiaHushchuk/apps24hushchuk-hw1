package ua.edu.ucu.apps.tempseries;

import java.util.Arrays;
import java.util.InputMismatchException;

public class TemperatureSeriesAnalysis {
    public double[] arr;
    public int size;
    public int capacity;

    public TemperatureSeriesAnalysis() {
        this.arr = new double[0];
        this.size = 0;
        this.capacity = 0;
    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        for (double el: temperatureSeries){
            if (el < -273) {
                throw new InputMismatchException();
            }
        }
        this.arr = temperatureSeries;
        this.size = temperatureSeries.length;
        this.capacity = temperatureSeries.length;
    }

    public double average() {
        if (size == 0) {
            throw new IllegalArgumentException();
        }
        int quantity = 0;
        double sum = 0;
        for (double el:arr) {
            quantity++;
            sum += el;
        }
        return sum / quantity;
    }

    public double deviation() {
        if (size == 0) {
            throw new IllegalArgumentException();
        }
        double aver = average();
        double sum = 0;
        int quantity = 0;
        for (double el:arr) {
            quantity ++;
            sum += Math.pow((el - aver), 2);
        }
        return Math.sqrt(sum / quantity);
    }

    public double min() {
        if (size == 0) {
            throw new IllegalArgumentException();
        }
        double minVal = arr[0];
        for (double el:arr) {
            if (el < minVal) {
                minVal = el;
            }
        }
        return minVal;
    }

    public double max() {
        if (size == 0) {
            throw new IllegalArgumentException();
        }
        double maxVal = arr[0];
        for (double el:arr) {
            if (el > maxVal) {
                maxVal = el;
            }
        }
        return maxVal;
    }

    public double findTempClosestToZero() {
        if (size == 0) {
            throw new IllegalArgumentException();
        }
        double res = arr[0];
        for (double el:arr) {
            if (Math.abs(el) < Math.abs(res) || 
            (Math.abs(el) == Math.abs(res) && el > res)) {
                res = el;
            }
        }
        return res;
    }

    public double findTempClosestToValue(double tempValue) {
        if (size == 0) {
            throw new IllegalArgumentException();
        }
        double res = arr[0];
        double diff = Math.abs(tempValue - res);
        for (double el:arr) {
            if (Math.abs(tempValue - el) < diff) {
                res = el;
                diff = Math.abs(tempValue - el);
            }
            else if (Math.abs(tempValue - el) == diff && el > res) {
                res = el;
            }
        }
        return res;
    }

    public double[] findTempsLessThen(double tempValue) {
        if (size == 0) {
            throw new IllegalArgumentException();
        }
        double[] res = new double[size]; 
        int counter = 0;
        for (int i = 0; i < size; i++) {
            if (arr[i] < tempValue) {
                res[counter] = arr[i];
                counter++;
            }
        }
        double[] finalResult = new double[counter];
        System.arraycopy(res, 0, finalResult, 0, counter);
        return finalResult;
    }

    public double[] findTempsGreaterThen(double tempValue) {
        if (size == 0) {
            throw new IllegalArgumentException();
        }
        double[] res = new double[size]; 
        int counter = 0;
        for (int i = 0; i < size; i++) {
            if (arr[i] > tempValue) {
                res[counter] = arr[i];
                counter++;
            }
        }
        double[] finalResult = new double[counter];
        System.arraycopy(res, 0, finalResult, 0, counter);
        return finalResult;
    }

    public double[] findTempsInRange(double lowerBound, double upperBound) {
        if (size == 0) {
            throw new IllegalArgumentException();
        }
        double[] res = new double[size]; 
        int counter = 0;
        for (int i = 0; i < size; i++) {
            if (arr[i] >= lowerBound && arr[i] <= upperBound) {
                res[counter] = arr[i];
                counter++;
            }
        }
        double[] finalResult = new double[counter];
        System.arraycopy(res, 0, finalResult, 0, counter);
        return finalResult;
    }

    public void reset() {
        arr = new double[0];
        size = 0;
        capacity = 0;
    }

    public double[] sortTemps() {
    if (size <= 1) {
        return arr;
    }
    double[] sortedArr = Arrays.copyOf(arr, size);
    quickSort(sortedArr, 0, sortedArr.length - 1);
    return sortedArr;
    }

    private void quickSort(double[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    private int partition(double[] array, int low, int high) {
        double pivot = array[high];
        int i = (low - 1);
        
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                double temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        double temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }

    public TempSummaryStatistics summaryStatistics() {
        if (size == 0) {
            throw new IllegalArgumentException();
        }
        double avgTemp = average();
        double devTemp = deviation();
        double minTemp = min();
        double maxTemp = max();
        return new TempSummaryStatistics(avgTemp, devTemp, minTemp, maxTemp);
    }

    public int addTemps(double... temps) {
        if (temps.length == 0) {
            return size;
        }
        if (size + temps.length > capacity) {
            capacity = Math.max(capacity * 2, size + temps.length);
            arr = Arrays.copyOf(arr, capacity);
        }
        for (double temp : temps) {
            if (temp < -273) {
                throw new InputMismatchException();
            }
            arr[size] = temp;
            size++;
        }
        return size;
    }
}
