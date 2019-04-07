# String-Matching-Plagiarism-Detection-Java-code

Main Class : 

PlagiarismDetector.java

Other Classes :

BoyerMoore.java
KMP.java
LeastCommonSubsequence.java
NaiveSearch.java

Input: filename.txt (plagiarized file to be searched against a list of files for patterns or strings in common)
Folder Directory (containing list of files or documents).



Output:
Naive String Search: 

txt[] =  "AABAACAADAABAABA"

pat[] =  "AABA"

Pattern found at index 0.

Along with this 2 files are generated which are length.txt(to measure the input size) and time.txt(to measure the execution/performance time). These files are generated for each of the four algorithms implemented(BoyerMoore.java, KMP.java, LeastCommonSubsequence.java, NaiveSearch.java). Also these are given as input to the python script file(graph_plotter.py) which runs and plots the individual and combined graphs all together for the 4 algorithms implemented.

Program : 
graph_plotter.py

This basically is a python program to plot the values for a graphical representation of analyzing which among the algorithms[BoyerMoore.java, KMP.java, LeastCommonSubsequence.java, NaiveSearch.java] is best for plagiarism detection.
