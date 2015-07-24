#!/bin/bash

rm -fr bin/* obj/*

#the install path of android sdk
export ANDROID_HOME=/home/xin/android-sdk-linux/
export PATH=$PATH:$ANDROID_HOME/build-tools/22.0.1:$ANDROID_HOME/tools:$ANDROID_HOME/platform-tools

#create R.java file
aapt package -v -f -m -S res/ -J src/ -M AndroidManifest.xml -I $ANDROID_HOME/platforms/android-22/android.jar

#compile all .java files
javac -verbose -d obj -classpath $ANDROID_HOME/platforms/android-22/android.jar:./obj/ -sourcepath ./src/ ./src/com/convert/package1/*.java

#generate .dex file
dx --dex --verbose --output=bin/classes.dex obj/ lib/

#generate unsigned apk
aapt package -v -f -M ./AndroidManifest.xml -S ./res/ -I $ANDROID_HOME/platforms/android-22/android.jar -F ./bin/Converter.unsigned.apk ./bin/

#generate key
keytool -genkeypair -validity 10000 -dname "CN=Angela, OU=Android, L=bethlehem, S=PA, C=01" -keystore Converter.keystore -storepass 123456 -keypass 123456 -alias ConverterKey -keyalg RSA -v

#sign apk using key
jarsigner -verbose -keystore ./Converter.keystore -storepass 123456 -keypass 123456 -signedjar ./bin/Converter.signed.apk ./bin/Converter.unsigned.apk ConverterKey

zipalign -v -f 4 ./bin/Converter.signed.apk ./bin/Converter.apk
