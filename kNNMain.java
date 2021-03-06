import java.util.List;
import java.io.FileNotFoundException;
import java.util.Arrays;



public class kNNMain{

  public static void main(String... args) throws FileNotFoundException{

double[] storePrecision = new double[1000];
for (int i=0; i < storePrecision.length; ++i) {

    // TASK 1: Use command line arguments to point DataSet.readDataSet method to
    // the desired file. Choose a given DataPoint, and print its features and label

List<DataPoint> dpa = DataSet.readDataSet("data/breastCancer.csv");

    //TASK 2:Use the DataSet class to split the fullDataSet into Training and Held Out Test Dataset

List<DataPoint> TestSet = DataSet.getTestSet(dpa, 0.3);
List<DataPoint> TrainingSet = DataSet.getTrainingSet(dpa, 0.7);


    // TASK 3: Use the DataSet class methods to plot the 2D data (binary and multi-class)


    // TASK 4: write a new method in DataSet.java which takes as arguments to DataPoint objects,
    // and returns the Euclidean distance between those two points (as a double)

double Dist = DataSet.distanceEuclid(dpa.get(0), dpa.get(1));

    // TASK 5: Use the KNNClassifier class to determine the k nearest neighbors to a given DataPoint,
    // and make a print a predicted target label

KNNClassifier classifier = new KNNClassifier(3); //will give 3 closest datapoints 
DataPoint[] nearestNeighbors = classifier.getNearestNeighbors(dpa, dpa.get(0));

for(int j=0; j < nearestNeighbors.length; j++){
printDataPoint(nearestNeighbors[j]); // commented out to speed up program
}

    // TASK 6: loop over the datapoints in the held out test set, and make predictions for Each
    // point based on nearest neighbors in training set. Calculate accuracy of model.

int truePositive = 0;
for(int j=0; j < TestSet.size(); j++){

DataPoint dp = TestSet.get(j);
if(classifier.predict(TrainingSet, dp).equals(dp.getLabel())){

truePositive++;
}
}
storePrecision[i] = (double)(truePositive) / TestSet.size();

  }

  public static double mean(double[] arr){
    /*
    Method that takes as an argument an array of doubles
    Returns: average of the elements of array, as a double
    */
    double sum = 0.0;

    for (double a : arr){
      sum += a;
    }
    return (double)sum/arr.length;
  }

  public static double standardDeviation(double[] arr){
    /*
    Method that takes as an argument an array of doubles
    Returns: standard deviation of the elements of array, as a double
    Dependencies: requires the *mean* method written above
    */
    double avg = mean(arr);
    double sum = 0.0;
    for (double a : arr){
      sum += Math.pow(a-avg,2);
    }
    return (double)sum/arr.length;
  }

}
