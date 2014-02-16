#!/bin/bash

javac -cp .:/afs/nada.kth.se/home/n/u1qfoj5n/Private/Programmering/Java/Junit/junit-4.11.jar:/afs/nada.kth.se/home/n/u1qfoj5n/Private/Programmering/Java/Junit/hamcrest-core-1.3.jar *java
java -cp .:/afs/nada.kth.se/home/n/u1qfoj5n/Private/Programmering/Java/Junit/junit-4.11.jar:/afs/nada.kth.se/home/n/u1qfoj5n/Private/Programmering/Java/Junit/hamcrest-core-1.3.jar org.junit.runner.JUnitCore TestBinaryTree
