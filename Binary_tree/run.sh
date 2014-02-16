#!/bin/bash

javac -cp .:../LinkedList/junit-4.11.jar:../LinkedList/hamcrest-core-1.3.jar:/Library/Java/JavaVirtualMachines/jdk1.7.0_45.jdk/Contents/Home/jre/lib/jfxrt.jar *.java -Xlint:unchecked
java -cp .:../LinkedList/junit-4.11.jar:../LinkedList/hamcrest-core-1.3.jar:/Library/Java/JavaVirtualMachines/jdk1.7.0_45.jdk/Contents/Home/jre/lib/jfxrt.jar org.junit.runner.JUnitCore TestBinaryTree
