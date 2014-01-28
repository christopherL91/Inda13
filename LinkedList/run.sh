#!/bin/bash

javac -cp .:junit-4.11.jar:hamcrest-core-1.3.jar:/Library/Java/JavaVirtualMachines/jdk1.7.0_45.jdk/Contents/Home/jre/lib/jfxrt.jar *.java
java -cp .:junit-4.11.jar:hamcrest-core-1.3.jar:/Library/Java/JavaVirtualMachines/jdk1.7.0_45.jdk/Contents/Home/jre/lib/jfxrt.jar Main
