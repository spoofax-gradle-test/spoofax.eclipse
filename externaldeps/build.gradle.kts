import mb.coronium.plugin.EmbeddingExtension

// HACK: load our plugin via buildscript classpath and apply to work around IntelliJ bug which prevents custom plugins in composite builds.
buildscript {
  repositories {
    flatDir { dirs("../../coronium/build/libs") }
    maven(url = "http://home.gohla.nl:8091/artifactory/all/")
  }
  dependencies {
    classpath("org.metaborg", "coronium", "develop-SNAPSHOT")
    classpath("org.apache.maven.resolver:maven-resolver-api:1.1.1")
    classpath("org.apache.maven.resolver:maven-resolver-impl:1.1.1")
    classpath("org.apache.maven.resolver:maven-resolver-connector-basic:1.1.1")
    classpath("org.apache.maven.resolver:maven-resolver-transport-file:1.1.1")
    classpath("org.apache.maven:maven-resolver-provider:3.5.4")
    classpath("org.apache.commons:commons-compress:1.18")
    classpath("biz.aQute.bnd:biz.aQute.bnd.gradle:4.1.0")
  }
}
apply {
  plugin("org.metaborg.coronium.embedding")
  plugin("biz.aQute.bnd.builder")
}

// Add dependencies to JVM (non-OSGi) libraries
plugins {
  `java-library`
}

dependencies {
  compileOnly("org.metaborg:log.slf4j:develop-SNAPSHOT")
  compileOnly("org.metaborg:pie.runtime:develop-SNAPSHOT")
  compileOnly("org.metaborg:spoofax.runtime:develop-SNAPSHOT")
  compileOnly("org.metaborg:spoofax.pie:develop-SNAPSHOT")
}

// Use bnd to create a single OSGi bundle that includes all dependencies.
val exports = listOf(
  "mb.*",
  "org.slf4j.*;provider=mb;mandatory:=provider",
  "kotlin.*;-split-package:=first;provider=mb;mandatory:=provider"
)
val bundleVersion = the<EmbeddingExtension>().bundleVersion // DO NOT INLINE: 'the' is executed in the context of the project.
val jar: Jar by tasks
jar.apply {
  manifest {
    attributes(Pair("Export-Package", exports.joinToString(", ")))
    attributes(Pair("Import-Package", "")) // No imports needed
    attributes(Pair("Bundle-Version", bundleVersion))
  }
}
