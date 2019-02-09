plugins {
  `java-library`
  id("biz.aQute.bnd.builder") version "4.1.0"
  id("org.metaborg.coronium.embedding") version "develop-SNAPSHOT"
}

// Add dependencies to JVM (non-OSGi) libraries. Must use `compileOnly` configuration for `coronium.embedding` plugin.
dependencies {
  compileOnly("org.metaborg:log.slf4j:develop-SNAPSHOT")
  compileOnly("org.metaborg:pie.runtime:develop-SNAPSHOT")
  compileOnly("org.metaborg:spoofax.runtime:develop-SNAPSHOT")
  compileOnly("org.metaborg:spoofax.pie:develop-SNAPSHOT")
}

// Use bnd to create a single OSGi bundle JAR that includes all dependencies.
val exports = listOf(
  "mb.*",
  "org.slf4j.*;provider=mb;mandatory:=provider",
  "kotlin.*;-split-package:=first;provider=mb;mandatory:=provider"
)
tasks {
  "jar"(Jar::class) {
    manifest {
      attributes(Pair("Export-Package", exports.joinToString(", ")))
      attributes(Pair("Import-Package", "")) // No imports needed
      attributes(Pair("Bundle-Version", embedding.bundleVersion))
    }
  }
}
