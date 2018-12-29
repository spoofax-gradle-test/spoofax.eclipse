import mb.gitonium.GitoniumExtension

// HACK: load our plugin via buildscript classpath and apply to work around IntelliJ bug which prevents custom plugins in composite builds.
buildscript {
  repositories {
    flatDir { dirs("../gitonium/build/libs") }
    mavenCentral()
    jcenter()
  }
  dependencies {
    classpath("org.metaborg", "gitonium", "develop-SNAPSHOT")
    classpath("org.eclipse.jgit:org.eclipse.jgit:5.2.0.201812061821-r")
  }
}
apply {
  plugin("org.metaborg.gitonium")
}
val gitVersion = the<GitoniumExtension>().version

subprojects {
  group = "org.metaborg"
  version = gitVersion
  repositories {
    mavenCentral()
    jcenter()
  }
}
tasks {
  register("buildAll") {
    dependsOn(subprojects.map { it.tasks["build"] })
  }
  register("cleanAll") {
    dependsOn(subprojects.map { it.tasks["clean"] })
  }
}
