package ua.edu.ucu.tempseries;

import static org.junit.Assert.*;

import java.util.InputMismatchException;

import org.junit.Test;

import ua.edu.ucu.apps.tempseries.TempSummaryStatistics;
import ua.edu.ucu.apps.tempseries.TemperatureSeriesAnalysis;

public class TemperatureSeriesAnalysisTest {

    @Test
    public void test() {
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = 
        new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        double actualResult = seriesAnalysis.average();
        assertEquals(expResult, actualResult, 0.00001);
    }

   @Test
   public void testAverageWithOneElementArray() {
       // setup input data and expected result
       double[] temperatureSeries = {-1.0};
       TemperatureSeriesAnalysis seriesAnalysis = 
       new TemperatureSeriesAnalysis(temperatureSeries);
       double expResult = -1.0;

       // call tested method
       double actualResult = seriesAnalysis.average();

       // compare expected result with actual result
       assertEquals(expResult, actualResult, 0.00001);
   }

   @Test(expected = IllegalArgumentException.class)
   public void testAverageWithEmptyArray() {
       double[] temperatureSeries = {};
       TemperatureSeriesAnalysis seriesAnalysis = 
       new TemperatureSeriesAnalysis(temperatureSeries);

       // expect exception here
       seriesAnalysis.average();
   }

   @Test
   public void testAverage() {
       double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
       TemperatureSeriesAnalysis seriesAnalysis = 
       new TemperatureSeriesAnalysis(temperatureSeries);
       double expResult = 1.0;

       double actualResult = seriesAnalysis.average();

       assertEquals(expResult, actualResult, 0.00001);
   }

   @Test
    public void testDeviationWithOneElementArray() {
        double[] temperatureSeries = {19.0};
        TemperatureSeriesAnalysis seriesAnalysis =
        new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 0.0;
        double actualResult = seriesAnalysis.deviation();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeviationWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis =
        new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.deviation();
    }

    @Test
    public void testDeviation() {
        double[] temperatureSeries = {-1.0, 0.0, 1.0, 2.0};
        TemperatureSeriesAnalysis seriesAnalysis =
        new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = Math.sqrt(1.25);
        double actualResult = seriesAnalysis.deviation();
        assertEquals(expResult, actualResult, 0.00001);
    }
    
    @Test
    public void testMinWithOneElementArray() {
        double[] temperatureSeries = {10.0};
        TemperatureSeriesAnalysis seriesAnalysis =
        new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 10.0;
        double actualResult = seriesAnalysis.min();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMinWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis =
        new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.min();
    }

    @Test
    public void testMin() {
        double[] temperatureSeries = {15.0, -3.0, 7.0, 12.0};
        TemperatureSeriesAnalysis seriesAnalysis =
        new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -3.0;
        double actualResult = seriesAnalysis.min();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testMaxWithOneElementArray() {
        double[] temperatureSeries = {15.0};
        TemperatureSeriesAnalysis seriesAnalysis =
        new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 15.0;
        double actualResult = seriesAnalysis.max();
        assertEquals(expResult, actualResult, 0.00001);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testMaxWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis =
        new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.max();
    }

    @Test
    public void testMaxWithMixedValues() {
        double[] temperatureSeries = {0.0, -2.5, 5.5, -3.0, 7.0};
        TemperatureSeriesAnalysis seriesAnalysis =
        new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 7.0;
        double actualResult = seriesAnalysis.max();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempClosestToZeroWithOneElementArray() {
        double[] temperatureSeries = {5.0};
        TemperatureSeriesAnalysis seriesAnalysis =
        new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 5.0;
        double actualResult = seriesAnalysis.findTempClosestToZero();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindTempClosestToZeroWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis =
        new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.findTempClosestToZero();
    }

    @Test
    public void testFindTempClosestToZero() {
        double[] temperatureSeries = {9.0, -2.5, 2.5, -1.5, 1.5};
        TemperatureSeriesAnalysis seriesAnalysis =
        new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 1.5;
        double actualResult = seriesAnalysis.findTempClosestToZero();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempClosestToValueWithOneElement() {
        double[] temperatureSeries = {5.0};
        TemperatureSeriesAnalysis seriesAnalysis =
        new TemperatureSeriesAnalysis(temperatureSeries);
        double tempValue = 3.0;
        double expected = 5.0;
        double actual = seriesAnalysis.findTempClosestToValue(tempValue);
        assertEquals(expected, actual, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindTempClosestToValueWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis =
        new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.findTempClosestToValue(1.0);
    }

    @Test
    public void testFindTempClosestToValueWithTempEqualToTempValue() {
        double[] temperatureSeries = {1.0, 2.0, 1.5, 2.9};
        TemperatureSeriesAnalysis seriesAnalysis =
        new TemperatureSeriesAnalysis(temperatureSeries);
        double tempValue = 2.0;
        double expected = 2.0;
        double actual = seriesAnalysis.findTempClosestToValue(tempValue);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void testFindTempClosestToValue() {
        double[] temperatureSeries = {1.0, 2.5, 1.5, 2.9};
        TemperatureSeriesAnalysis seriesAnalysis =
        new TemperatureSeriesAnalysis(temperatureSeries);
        double tempValue = 2.0;
        double expected = 2.5;
        double actual = seriesAnalysis.findTempClosestToValue(tempValue);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void testFindTempsLessThenWithOneElement() {
        double[] temperatureSeries = {5.0};
        TemperatureSeriesAnalysis seriesAnalysis =
        new TemperatureSeriesAnalysis(temperatureSeries);
        double tempValue = 10.0;
        double[] expected = {5.0};
        double[] actual = seriesAnalysis.findTempsLessThen(tempValue);
        assertArrayEquals(expected, actual, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindTempsLessThenWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis =
        new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.findTempsLessThen(1.0);
    }

    @Test
    public void testFindTempsLessThen() {
        double[] temperatureSeries = {1.0, 2.5, 3.5, 0.5, -1.0};
        TemperatureSeriesAnalysis seriesAnalysis =
        new TemperatureSeriesAnalysis(temperatureSeries);
        double tempValue = 2.0;
        double[] expected = {1.0, 0.5, -1.0};
        double[] actual = seriesAnalysis.findTempsLessThen(tempValue);
        assertArrayEquals(expected, actual, 0.00001);
    }

    @Test
    public void testFindTempsLessThenWithNoTemperaturesLessThanValue() {
        double[] temperatureSeries = {3.0, 4.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis =
        new TemperatureSeriesAnalysis(temperatureSeries);
        double tempValue = 2.0;
        double[] expected = {};
        double[] actual = seriesAnalysis.findTempsLessThen(tempValue);
        assertArrayEquals(expected, actual, 0.00001);
    }

    @Test
    public void testFindTempsGreaterThenWithValueOneElement() {
        double[] temperatureSeries = {5.0};
        TemperatureSeriesAnalysis seriesAnalysis =
        new TemperatureSeriesAnalysis(temperatureSeries);
        double tempValue = 3.0;
        double[] expected = {5.0};
        double[] actual = seriesAnalysis.findTempsGreaterThen(tempValue);
        assertArrayEquals(expected, actual, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindTempsGreaterThenValueWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis =
        new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.findTempsGreaterThen(1.0);
    }

    @Test
    public void testFindTempsGreaterThenValue() {
        double[] temperatureSeries = {1.0, 2.5, 3.5, 0.5, 4.0};
        TemperatureSeriesAnalysis seriesAnalysis =
        new TemperatureSeriesAnalysis(temperatureSeries);
        double tempValue = 2.0;
        double[] expected = {2.5, 3.5, 4.0};
        double[] actual = seriesAnalysis.findTempsGreaterThen(tempValue);
        assertArrayEquals(expected, actual, 0.00001);
    }

    @Test
    public void testFindTempsGreaterThenValueWithNoTemperaturesGreaterThanValue() {
        double[] temperatureSeries = {1.0, 2.0, 3.0};
        TemperatureSeriesAnalysis seriesAnalysis =
        new TemperatureSeriesAnalysis(temperatureSeries);
        double tempValue = 3.0;
        double[] expected = {};
        double[] actual = seriesAnalysis.findTempsGreaterThen(tempValue);
        assertArrayEquals(expected, actual, 0.00001);
    }

    @Test
    public void testFindTempsInRangeWithOneElementInRange() {
        double[] temperatureSeries = {5.0};
        TemperatureSeriesAnalysis seriesAnalysis =
        new TemperatureSeriesAnalysis(temperatureSeries);
        double lowerBound = 3.0;
        double upperBound = 7.0;
        double[] expected = {5.0};
        double[] actual = seriesAnalysis.findTempsInRange(lowerBound, upperBound);
        assertArrayEquals(expected, actual, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindTempsInRangeWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis =
        new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.findTempsInRange(0.0, 10.0);
    }

    @Test
    public void testFindTempsInRange() {
        double[] temperatureSeries = {1.0, 2.5, 3.5, 0.5, 4.0};
        TemperatureSeriesAnalysis seriesAnalysis =
        new TemperatureSeriesAnalysis(temperatureSeries);
        double lowerBound = 1.0;
        double upperBound = 3.0;
        double[] expected = {1.0, 2.5};
        double[] actual = seriesAnalysis.findTempsInRange(lowerBound, upperBound);
        assertArrayEquals(expected, actual, 0.00001);
    }

    @Test
    public void testFindTempsInRangeWithNoTemperaturesInRange() {
        double[] temperatureSeries = {1.0, 2.0, 3.0};
        TemperatureSeriesAnalysis seriesAnalysis =
        new TemperatureSeriesAnalysis(temperatureSeries);
        double lowerBound = 4.0;
        double upperBound = 5.0;
        double[] expected = {};
        double[] actual = seriesAnalysis.findTempsInRange(lowerBound, upperBound);
        assertArrayEquals(expected, actual, 0.00001);
    }

    @Test
    public void testReset() {
        double[] temperatureSeries = {1.0, 2.0, 3.0};
        TemperatureSeriesAnalysis seriesAnalysis =
        new TemperatureSeriesAnalysis(temperatureSeries);
        assertEquals(3, seriesAnalysis.size);
        seriesAnalysis.reset();
        assertEquals(0, seriesAnalysis.size);
        assertEquals(0, seriesAnalysis.arr.length);
        assertEquals(0, seriesAnalysis.capacity);
    }

    @Test
    public void testResetWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis =
        new TemperatureSeriesAnalysis(temperatureSeries);
        assertEquals(0, seriesAnalysis.size);
        seriesAnalysis.reset();
        assertEquals(0, seriesAnalysis.size);
        assertEquals(0, seriesAnalysis.arr.length);
        assertEquals(0, seriesAnalysis.capacity);
    }

    @Test
    public void testResetAfterAddingTemps() {
        TemperatureSeriesAnalysis seriesAnalysis =
        new TemperatureSeriesAnalysis();
        seriesAnalysis.addTemps(1.0, 8.0, -3.0);
        assertEquals(3, seriesAnalysis.size);
        seriesAnalysis.reset();
        assertEquals(0, seriesAnalysis.size);
        assertEquals(0, seriesAnalysis.arr.length);
        assertEquals(0, seriesAnalysis.capacity);
    }

    @Test
    public void testSortTempsWithOneElement() {
        double[] temperatureSeries = {5.0};
        TemperatureSeriesAnalysis seriesAnalysis =
        new TemperatureSeriesAnalysis(temperatureSeries);
        double[] sortedTemps = seriesAnalysis.sortTemps();
        assertArrayEquals(new double[]{5.0}, sortedTemps, 0.00001);
    }

    @Test
    public void testSortTemps_withEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis =
        new TemperatureSeriesAnalysis(temperatureSeries);
        double[] sortedTemps = seriesAnalysis.sortTemps();
        assertArrayEquals(new double[]{}, sortedTemps, 0.00001);
    }

    @Test
    public void testSortTempsWithAlreadySortedArray() {
        double[] temperatureSeries = {1.0, 2.0, 3.0, 4.0};
        TemperatureSeriesAnalysis seriesAnalysis =
        new TemperatureSeriesAnalysis(temperatureSeries);
        double[] sortedTemps = seriesAnalysis.sortTemps();
        assertArrayEquals(new double[]{1.0, 2.0, 3.0, 4.0}, sortedTemps, 0.00001);
    }

    @Test
    public void testSortTemps() {
        double[] temperatureSeries = {3.0, 1.0, 4.0, 2.0};
        TemperatureSeriesAnalysis seriesAnalysis =
        new TemperatureSeriesAnalysis(temperatureSeries);
        double[] sortedTemps = seriesAnalysis.sortTemps();
        assertArrayEquals(new double[]{1.0, 2.0, 3.0, 4.0}, sortedTemps, 0.00001);
    }

    @Test
    public void testSortTemps_withDuplicates() {
        double[] temperatureSeries = {2.0, 3.0, 2.0, 1.0, 3.0};
        TemperatureSeriesAnalysis seriesAnalysis =
        new TemperatureSeriesAnalysis(temperatureSeries);
        double[] sortedTemps = seriesAnalysis.sortTemps();
        assertArrayEquals(new double[]{1.0, 2.0, 2.0, 3.0, 3.0}, sortedTemps, 0.00001);
    }

    @Test
    public void testSummaryStatisticsWithOneElement() {
        double[] temperatureSeries = {10.0};
        TemperatureSeriesAnalysis seriesAnalysis =
        new TemperatureSeriesAnalysis(temperatureSeries);
        TempSummaryStatistics stats = seriesAnalysis.summaryStatistics();
        assertEquals(10.0, stats.getAvgTemp(), 0.00001);
        assertEquals(0.0, stats.getDevTemp(), 0.00001);
        assertEquals(10.0, stats.getMinTemp(), 0.00001);
        assertEquals(10.0, stats.getMaxTemp(), 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSummaryStatisticsWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis =
        new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.summaryStatistics();
    }

    @Test
    public void testSummaryStatistics() {
        double[] temperatureSeries = {-1.0, 0.0, 1.0, 2.0};
        TemperatureSeriesAnalysis seriesAnalysis =
        new TemperatureSeriesAnalysis(temperatureSeries);
        TempSummaryStatistics stats = seriesAnalysis.summaryStatistics();
        assertEquals(0.5, stats.getAvgTemp(), 0.00001);
        assertEquals(1.11803, stats.getDevTemp(), 0.00001);
        assertEquals(-1.0, stats.getMinTemp(), 0.00001);
        assertEquals(2.0, stats.getMaxTemp(), 0.00001);
    }

    @Test
    public void testSummaryStatisticsWithAllEqualValues() {
        double[] temperatureSeries = {2.0, 2.0, 2.0, 2.0};
        TemperatureSeriesAnalysis seriesAnalysis =
        new TemperatureSeriesAnalysis(temperatureSeries);
        TempSummaryStatistics stats = seriesAnalysis.summaryStatistics();
        assertEquals(2.0, stats.getAvgTemp(), 0.00001);
        assertEquals(0.0, stats.getDevTemp(), 0.00001);
        assertEquals(2.0, stats.getMinTemp(), 0.00001);
        assertEquals(2.0, stats.getMaxTemp(), 0.00001);
    }

    @Test
    public void testAddTempsWithNoTemps() {
        double[] temperatureSeries = {1.0, 2.0};
        TemperatureSeriesAnalysis seriesAnalysis =
        new TemperatureSeriesAnalysis(temperatureSeries);
        int result = seriesAnalysis.addTemps();
        assertEquals(2, result);
    }

    @Test
    public void testAddTempsWithOneTemp() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis =
        new TemperatureSeriesAnalysis(temperatureSeries);
        int result = seriesAnalysis.addTemps(25.0);
        assertEquals(1, result);
    }

    @Test
    public void testAddTemps() {
        double[] temperatureSeries = {15.0, 20.0};
        TemperatureSeriesAnalysis seriesAnalysis =
        new TemperatureSeriesAnalysis(temperatureSeries);
        int result = seriesAnalysis.addTemps(25.0, 30.0);
        assertEquals(4, result);
    }

    @Test
    public void testAddTempsWithCapacityIncrease() {
        double[] temperatureSeries = {15.0, 20.0};
        TemperatureSeriesAnalysis seriesAnalysis =
        new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.addTemps(25.0, 30.0);
        int result = seriesAnalysis.addTemps(35.0, 40.0, 45.0);
        assertEquals(7, result);
    }

    @Test(expected = InputMismatchException.class)
    public void testAddTempsWithInvalidTemp() {
        double[] temperatureSeries = {0.0};
        TemperatureSeriesAnalysis seriesAnalysis =
        new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.addTemps(-300.0);
    }

}
