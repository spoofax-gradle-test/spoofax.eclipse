import mb.coronium.plugin.FeatureExtension

plugins {
  id("org.metaborg.coronium.feature") version "develop-SNAPSHOT"
}

configure<FeatureExtension> {
  bundleProject(":spoofax.eclipse.plugin")
  bundleProject(":spoofax.eclipse.externaldeps")
}