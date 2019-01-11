plugins {
  id("org.metaborg.coronium.repository") version "develop-SNAPSHOT"
}

repository {
  featureProject(":spoofax.eclipse.feature", categoryName = "spoofax.eclipse.category")
  featureProject(":spoofax.eclipse.meta.feature", categoryName = "spoofax.eclipse.meta.category")
}
