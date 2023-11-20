plugins {
    id("java")
}

group = "org.cbit.giovanni"

/*
 * 1 = Release version: alpha
 * 0 = Major
 * 1 = minor
 * 0 = patch
 */
version = "1.0.1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("net.dv8tion:JDA:5.0.0-beta.18")
    implementation("ch.qos.logback:logback-classic:1.2.8")
    implementation("io.github.cdimascio:dotenv-java:3.0.0")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}