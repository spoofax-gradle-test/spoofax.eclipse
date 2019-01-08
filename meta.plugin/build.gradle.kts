import mb.coronium.plugin.BundleExtension

plugins {
  id("org.metaborg.coronium.bundle") version "develop-SNAPSHOT"
}

configure<BundleExtension> {
  bundleImplementationTargetPlatform("org.eclipse.ui")
  bundleImplementationTargetPlatform("org.eclipse.core.runtime")
  bundleImplementationProject(":spoofax.eclipse.plugin")
  bundleImplementationProvidedProject(":spoofax.eclipse.externaldeps")
}
