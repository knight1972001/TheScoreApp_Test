# TheScore Smoke Test
The Sport Android platform

## Getting started
### Prerequisites
Please make sure you have installed [Appium1.22.3](https://appium.io/docs/en/2.1/quickstart/install/) and [Java 11 SDK](https://www.oracle.com/ca-en/java/technologies/javase/jdk11-archive-downloads.html).

### IDE
I am using [IntelliJ IDE](https://www.jetbrains.com/idea/download/) and some plugins like [Cucumber for Java](https://plugins.jetbrains.com/plugin/7212-cucumber-for-java) and [Gherkin](https://plugins.jetbrains.com/plugin/9164-gherkin). In addition, I also use **Prettier+** and **Dracular Theme** for the best visualization.

### Android SDK Tool

You need [emulator](https://developer.android.com/tools) or real device using [Vysor](https://www.vysor.io/). In my case, I am using emulator for easier installation and avoid overheat real device.
- You need to install [Android SDK Tool](https://developer.android.com/tools)
- Setting up PATH in [Edit the system environment variables](https://stackoverflow.com/questions/23042638/how-do-i-set-android-sdk-home-environment-variable). In my case, I set it as `ANDROID_HOME`

### Project setup
- Clone the project ``
- Import the project into IntelliJ using `build.gradle.kt`
- Ready [The Score Apk file](https://apkpure.com/thescore-sports-news-scores/com.fivemobile.thescore) from [Apkpure](https://m.apkpure.com/) or any source you prefer.

#### How to Launch emulator?
- Running emulator through Terminal
```bash
cd "$env:ANDROID_HOME"
cd .\emulator\
.\emulator.exe -list-avds
```
- Then list of  _Android Virtual Device_
- Run the emulator using
```bash
.\emulator.exe -avd [device name]
```
For example
```bash
.\emulator.exe -avd Pixel_7_Pro_API_34
```

#### Running Test
- Make sure your emulator ready.
- Run Appium Server
- Lauch IntelliJ, Open _Run/Debug Configurations_
- Select the module whose classpath: `theScore.test`
- Select `TestRunner` for class that contains tests
- Select Apply -> Ok.
- Run the Test.

##### Or
- [Gradle Test](https://docs.gradle.org/current/userguide/custom_tasks.html)
  ` ./gradlew cucumber`

#### Human readable test specification
- The test using [Cucumber](https://cucumber.io/) focuses on defining and testing the behavior of an application from a user's perspective

#### Test result
Test result automatic generated through **_./target/cucumber-reports/report.html_**

