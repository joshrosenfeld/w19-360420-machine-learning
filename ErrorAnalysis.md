# Report: Error Analysis
## 360-420-DW section 02
## Josh Rosenfeld 1742296

## Distributions of Model Accuracy

1. Each time the code is run, the data is cut randomly due to the 'shuffle' method given in lines 148-150 in DataSet.java. This randomly takes elements in a given string, giving the model a different portion of the data set each time. Different sections of the data will give different results in terms of accuracy.

2. The performance will vary a little bit on each section of data each time the classification model is run, given that there is a different set of data on each trial. That being said, the mean was relatively high, and the standard deviation was very low, both suggesting that the performance is quite good and quite similar in each trial.

 Mean: 0.9716463982
 Standard Deviation: 0.0009584392078
 
 3. In DataSet.java, line 200 refers to a method that indicates the frequency of a given label. We may conclude that the number of positives in each trial should be very closer to the frequency of the positives in the data set.
 
## Analysis of different error types

4. A false positive is the medical world is when the patient is projected to have some problem, but in reality does not. In this situation, a false positive would suggest that the patient has breast cancer, although really does not.

A false negative is the exact opposite, where the patient is projected to be free of breast cancer, but really does have it. This situation is worse in the field of medicine as the patient will opt out of treatment, making it worse.


5. a) It is the fraction of the number of true positives over the total number of relevant elements.

Mean Recall: 0.9510587348

Precision is the ability of a measurement to be reproduced. It is fraction of the number of true positives over the number of selected elements.

Mean Precision: 0.9482579305

Recall and Precision are different measures, because they calculate different proportions of the data. In general, the ratio of these two measures are similar, because the total number of positives should be approximately equal to the number of predicted positives.

b) A sensible baseline for the both of these numbers should be 1. The closer the ratio of the numbers is to 1, the better the results should be. This is because the number of predicted positives should be very closer to the total number of positives. 

6. The hyper-parameter K refers to the the number of closest neighbours to a given data point. The K number is very important because as it goes up, there are more neighbours to consider. You want the right number of neighbours to consider: something too low may lead to an outlier, while something too high may be considering the neighbours that are not part of the same class. K should also be odd to avoid ties. 