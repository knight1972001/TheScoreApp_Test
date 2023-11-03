import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.21"
    application
}

group = "org.theScore"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("junit:junit:4.13.1")
    testImplementation(kotlin("test"))
    // https://mvnrepository.com/artifact/junit/junit
    testImplementation("junit:junit:4.13.2")
    // https://mvnrepository.com/artifact/io.appium/java-client
    implementation("io.appium:java-client:9.0.0")
    // https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java
    implementation("org.seleniumhq.selenium:selenium-java:4.14.1")
    // https://mvnrepository.com/artifact/org.seleniumhq.webdriver/webdriver-selenium
    implementation("org.seleniumhq.webdriver:webdriver-selenium:0.9.7376")
    // https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-core
    implementation("org.apache.logging.log4j:log4j-core:2.21.1")
    // https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-api
    implementation("org.apache.logging.log4j:log4j-api:2.21.1")
    // https://mvnrepository.com/artifact/io.cucumber/cucumber-junit
    testImplementation("io.cucumber:cucumber-junit:7.14.0")
    // https://mvnrepository.com/artifact/io.cucumber/cucumber-java
    implementation("io.cucumber:cucumber-java:7.14.0")
    // https://mvnrepository.com/artifact/org.testng/testng
    testImplementation("org.testng:testng:7.8.0")

}

configurations {
    create("cucumberRuntime") {
        extendsFrom(configurations.getByName("testImplementation"))
    }
}

tasks.register("cucumberCli") {
    dependsOn("assemble", "testClasses")
    doLast {
        javaexec {
            setMain("io.cucumber.core.cli.Main")
            classpath = configurations["cucumberRuntime"] + sourceSets["main"].output + sourceSets["test"].output
            args = listOf(
                "--plugin", "pretty",
                "--plugin", "html:target/cucumber-reports/report.html",
                "--glue", "TheScoreTest",
                "src/test/resources/Features"
            )
        }
    }
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("MainKt")
}