plugins {
    java
    application
}

repositories {
    jcenter()
}

dependencies {
    testCompile("org.junit.jupiter:junit-jupiter-api:5.4.2")
    testCompile("org.junit.jupiter:junit-jupiter-params:5.4.2")
    testImplementation("org.hamcrest:hamcrest-library:2.1")
    testRuntime("org.junit.jupiter:junit-jupiter-engine:5.4.2")
}

tasks.test {
	useJUnitPlatform()
	testLogging {
		events("passed", "skipped", "failed")
	}
}

tasks.jar {
    manifest {
        attributes["Main-Class"] = "dj.App"
    }
}

application {
    mainClassName = "dj.App"
}
