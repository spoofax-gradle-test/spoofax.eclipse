plugins {
  id("org.metaborg.gradle.config.root-project") version "0.5.0"
  id("org.metaborg.gitonium") version "0.3.0"
}

subprojects {
  metaborgConfig {
    configureSubProject()
  }
}
