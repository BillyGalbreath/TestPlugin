plugins {
  `java-library`
  id("io.papermc.paperweight.userdev") version "1.3.3"
}

group = "my.test"
version = "1.0"
description = "Test plugin"

java {
  toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

dependencies {
  paperDevBundle("1.18.1-R0.1-SNAPSHOT")
}

tasks {
  assemble {
    dependsOn(reobfJar)
  }

  compileJava {
    options.encoding = Charsets.UTF_8.name()
    options.release.set(17)
  }

  processResources {
    expand(
      "name" to rootProject.name,
      "group" to project.group,
      "version" to project.version,
      "description" to project.description,
    )
  }
}
