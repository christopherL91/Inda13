#!/bin/bash

javac -cp .:../lib *.java && java -cp .:../lib -ea Postfix 
