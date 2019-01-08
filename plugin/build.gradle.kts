import mb.coronium.plugin.BundleExtension

plugins {
  id("org.metaborg.coronium.bundle") version "develop-SNAPSHOT"
}

configure<BundleExtension> {
  bundleApiTargetPlatform("org.eclipse.ui")
  bundleApiTargetPlatform("org.eclipse.core.runtime")
  bundleApiProvidedProject(":spoofax.eclipse.externaldeps")
}
