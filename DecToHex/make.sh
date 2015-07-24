#!/bin/bash

rm -fr bin/* obj/*

#the install path of android sdk
export ANDROID_HOME=/home/xin/android-sdk-linux/
export PATH=$PATH:$ANDROID_HOME/build-tools/22.0.1:$ANDROID_HOME/tools:$ANDROID_HOME/platform-tools

#create R.java file
aapt package  -f -m -S res/ -J src/ -M AndroidManifest.xml -I $ANDROID_HOME/platforms/android-22/android.jar

#compile all .java files
javac -d obj -classpath $ANDROID_HOME/platforms/android-22/android.jar:./obj/ -sourcepath ./src/ ./src/com/convert/package1/*.java

#generate .dex file
dx --dex  --output=bin/classes.dex obj/ lib/ > /dev/null

#generate unsigned apk
aapt package  -f -M ./AndroidManifest.xml -S ./res/ -I $ANDROID_HOME/platforms/android-22/android.jar -F ./bin/Converter.unsigned.apk ./bin/ > /dev/null

#generate key
keytool -genkeypair -validity 10000 -dname "CN=Angela, OU=Android, L=bethlehem, S=PA, C=01" -keystore Converter.keystore -storepass 123456 -keypass 123456 -alias ConverterKey -keyalg RSA > /dev/null

#sign apk using key
jarsigner -keystore ./Converter.keystore -storepass 123456 -keypass 123456 -signedjar ./bin/Converter.signed.apk ./bin/Converter.unsigned.apk ConverterKey > /dev/null 2> /dev/null

zipalign  -f 4 ./bin/Converter.signed.apk ./bin/Converter.apk

#generate java docs
javadoc  -d docs -sourcepath src/ -classpath $ANDROID_HOME/platforms/android-22/android.jar:./obj/ -author -package -use -splitIndex -version -windowtitle 'Converter' -doctitle 'Converter' ./src/com/convert/package1/*.java > /dev/null

