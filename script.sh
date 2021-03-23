#!/bin/bash

rm -rf MyJar.jar

## перемещаемся в пакет
cd src/main/java

## компилируем проект
javac com/z/*.java

## собираем архив
echo "Manifest-Version: 1.0
Main-Class: com.z.Simulator" >> Main.mf
jar cmvf Main.mf MyJar.jar com/z/*

## все удаляем
rm -rf Main.mf
rm -rf com/z/*.class com/z/aircraft/*.class

## перемещаемся в корень
cd -
mv src/main/java/MyJar.jar MyJar.jar

## запускаем
java -jar MyJar.jar ./src/main/resources/scenario.txt

## извлечение содержимого
#jar xf MyJar.jar

## посмотреть содержимое
#jar tf MyJar.jar