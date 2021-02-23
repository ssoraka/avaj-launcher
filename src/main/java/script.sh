#!/bin/bash

rm -rf MyJar.jar com/z/*.class com/z/aircraft/*.class
javac com/z/*.java
jar cmvf Main.mf MyJar.jar com/z/*
java -jar MyJar.jar /Users/ssoraka/IdeaProjects/avaj-launcher/src/main/resources/scenario.txt