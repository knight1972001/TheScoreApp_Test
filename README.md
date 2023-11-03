# TheScore Smoke Test
The Sport Android platform

## Getting started
### Prerequisites
Please make sure you have installed [Appium1.22.3](https://appium.io/docs/en/2.1/quickstart/install/) and [Java 11 SDK](https://www.oracle.com/ca-en/java/technologies/javase/jdk11-archive-downloads.html).

### IDE
I am using [IntelliJ IDE](https://www.jetbrains.com/idea/download/) and some plugins like [Cucumber for Java](https://plugins.jetbrains.com/plugin/7212-cucumber-for-java) and [Gherkin](https://plugins.jetbrains.com/plugin/9164-gherkin). In addition, I also use **Prettier+** and **Dracula Theme** for the best visualization.

### Android SDK Tool

You need [emulator](https://developer.android.com/tools) or a real device using [Vysor](https://www.vysor.io/). In my case, I am using an emulator for easier installation and to avoid overheating the real device.
- You need to install [Android SDK Tool](https://developer.android.com/tools)
- Setting up PATH in [Edit the system environment variables](https://stackoverflow.com/questions/23042638/how-do-i-set-android-sdk-home-environment-variable). In my case, I set it as `ANDROID_HOME`

### Project setup
- Clone the project ``
- Import the project into IntelliJ using `build.gradle.kt`
- Ready [The Score Apk file](https://apkpure.com/thescore-sports-news-scores/com.fivemobile.thescore) from [Apkpure](https://m.apkpure.com/) or any source you prefer.

#### How to Launch an Emulator? {#emulator}
- Running emulator through Terminal
```bash
cd "$env:ANDROID_HOME"
cd .\emulator\
.\emulator.exe -list-avds
```
- The list of  _Android Virtual Device_
- Run the emulator using
```bash
.\emulator.exe -avd [device name]
```
For example
```bash
.\emulator.exe -avd Pixel_7_Pro_API_34
```

#### Running Test
- Make sure your emulator is ready. How {#emulator}
- Run Appium Server
- Launch IntelliJ, Open _Run/Debug Configurations_
- Select the module whose classpath: `theScore.test`
- Select `TestRunner` for a class that contains tests
- Select Apply -> Ok.
- Run the Test.

##### Or
- [Gradle Test](https://docs.gradle.org/current/userguide/custom_tasks.html)
  ` ./gradlew cucumber`

#### Human readable test specification
- The test using [Cucumber](https://cucumber.io/) focuses on defining and testing the behaviour of an application from a user's perspective

#### Test result
Test result automatic generated through **_./target/cucumber-reports/report.html_**

#### Showcase
![image](https://github.com/knight1972001/TheScoreApp_Test/assets/60019805/98b8e6e4-826f-46e3-9fba-b657525d24b6)

[Video automate test run](https://youtu.be/_Urv78OKnf8)

