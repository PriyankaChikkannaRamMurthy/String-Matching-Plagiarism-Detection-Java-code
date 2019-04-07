import matplotlib.pyplot as plt
import numpy as np

y = np.loadtxt('C:/Users/Priyanka/Desktop/PlagiarismDetector/time_KMP.txt', delimiter=' ', unpack=True)
x = np.loadtxt('C:/Users/Priyanka/Desktop/PlagiarismDetector/length_KMP.txt', delimiter=' ', unpack=True)
plt.plot(x,y, label='KMP Graph')
plt.ylabel('time')
plt.xlabel('input size')

y1 = np.loadtxt('C:/Users/Priyanka/Desktop/PlagiarismDetector/time_naive.txt', delimiter=' ', unpack=True)
x1 = np.loadtxt('C:/Users/Priyanka/Desktop/PlagiarismDetector/length_naive.txt', delimiter=' ', unpack=True)
plt.plot(x1,y1, label='Naive Graph')
plt.ylabel('time')
plt.xlabel('input size')

y2 = np.loadtxt('C:/Users/Priyanka/Desktop/PlagiarismDetector/time_LCSS.txt', delimiter=' ', unpack=True)
x2 = np.loadtxt('C:/Users/Priyanka/Desktop/PlagiarismDetector/length_LCSS.txt', delimiter=' ', unpack=True)
plt.plot(x2,y2, label='LCSS Graph')
plt.xlabel('input size')
plt.ylabel('time')

y3 = np.loadtxt('C:/Users/Priyanka/Desktop/PlagiarismDetector/time.txt', delimiter=' ', unpack=True)
x3 = np.loadtxt('C:/Users/Priyanka/Desktop/PlagiarismDetector/length.txt', delimiter=' ', unpack=True)
plt.plot(x3, y3, label='BoyerMoore Graph')
plt.ylabel('time')
plt.xlabel('input size')


plt.title('Interesting Graph\nCheck it out')
plt.legend()
plt.show()