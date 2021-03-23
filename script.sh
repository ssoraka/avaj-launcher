#!/bin/bash


find . -name "*.java" > sources.txt
javac @sources.txt
java -cp ./src/main/java ex/Simulator ./src/main/resources/scenario.txt
exit

#rm -rf sources.txt ./src/main/java/ex/*.class ./src/main/java/ex/aircraft/*.class


rm -rf MyJar.jar

## перемещаемся в пакет
cd src/main/java

## компилируем проект
javac ex/*.java

## собираем архив
echo "Manifest-Version: 1.0
Main-Class: ex.Simulator" >> Main.mf
jar cmvf Main.mf MyJar.jar ex/*

## все удаляем
rm -rf Main.mf
rm -rf ex/*.class ex/aircraft/*.class

## перемещаемся в корень
cd -
mv src/main/java/MyJar.jar MyJar.jar

## запускаем
java -jar MyJar.jar ./src/main/resources/scenario.txt

## извлечение содержимого
#jar xf MyJar.jar

## посмотреть содержимое
#jar tf MyJar.jar