plugins {
  id("org.metaborg.coronium.feature") version "develop-SNAPSHOT"
}

feature {
  bundleProject(":spoofax.eclipse.meta.plugin")
}