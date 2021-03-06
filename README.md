# memetic-algorithm-framework [![Build Status](https://travis-ci.org/TickleThePanda/memetic-algorithm-framework.svg?branch=master)](https://travis-ci.org/TickleThePanda/memetic-algorithm-framework)
A memetic (and genetic) algorithm framework.

## Features
 - Simple setup
   - Default general optimal configuration
   - Load EUC_2D from TSPLIB file
   - Pseudo-Boolean Functions
 - Framework for [implementing solutions to additional problems](implementing_solutions_to_additional_problems)

## Requirements
 - [TODO]

## Implementing solutions to additional problems
 - [TODO]

## Technical information
To evaluate the performance of this algorithm on TSP, a selection of TSPLIB problems were optimised by a memetic algorithm using the default configuration, each problem was solved 10 times, each instance of the algorithm was limited to 600 seconds.

Across solutions of sizes between 100 and 1500, there's a mean of 2.85% error between the actual optimal and the algorithms optimal. For solutions that are smaller than 500, the error is 1.19%. For solutions smaller than 200, 0.52% error.

NAME       |SIZE |% ERROR|TIME|% SOLUTIONS OPTIMAL
-----------|----:|------:|-------:|---------------------:
lin105     |105  |0.00   |  2.53  |100
ch130      |130  |0.61   |  5.60  |20
ch150      |150  |0.29   |  4.66  |0
u159       |159  |0.75   |  7.49  |0
rat195     |195  |0.93   | 16.12  |0
ts225      |225  |0.00   | 15.77  |100
tsp225     |225  |1.20   | 31.90  |0
pr264      |264  |0.04   | 39.42  |60
pr299      |299  |0.20   | 69.46  |0
linhp318   |318  |2.71   | 83.26  |0
rd400      |400  |1.14   |187.26  |0
fl417      |417  |0.24   |182.53  |0
gr431      |431  |3.59   | 81.49  |0
pr439      |439  |5.19   | 50.16  |0
pcb442     |442  |0.88   |258.74  |0
d493       |493  |1.22   |413.99  |0
ali535     |535  |4.84   |457.83  |0
u574       |574  |1.88   |539.40  |0
p654       |654  |3.74   |206.60  |0
d657       |657  |1.81   |600.00  |0
gr666      |666  |5.09   |285.70  |0
u724       |724  |2.17   |600.60  |0
rat783     |783  |3.12   |600.00  |0
pr1002     |1002 |4.60   |600.00  |0
u1060      |1060 |5.93   |582.23  |0
vm1084     |1084 |6.36   |600.00  |0
pcb1173    |1173 |6.24   |600.00  |0
d1291      |1291 |5.18   |600.00  |0
rl1304     |1304 |7.79   |600.00  |0
nrw1379    |1379 |4.91   |600.00  |0
u1432      |1432 |5.74   |600.00  |0
**MAX**    |     |7.79   |600.00  |
**MEAN**   |     |2.85   |307.19  |

 - **NAME** is the name of the problem in TSPLIB.
 - **SIZE** is the number of cities in the problem.
 - **% ERROR** is the average percentage error of the optimal solutions found by the algorithm to the *actual* optimal solution according to TSPLIB.
 - **TIME** is the time in average running time for the problems.
 - **% SOLUTIONS OPTIMAL** is the percentage solutions that were generated by the algorithm that were the *actual* optimal
