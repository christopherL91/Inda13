#!/bin/bash

./compile.sh
java -cp .:/Users/christopher/Documents/Programmering/Java/Junit/junit-4.11.jar:/Users/christopher/Documents/Programmering/Java/Junit/hamcrest-core-1.3.jar org.junit.runner.JUnitCore HashGraphTest
