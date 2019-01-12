plugins {
  id("org.metaborg.coronium.bundle") version "develop-SNAPSHOT"
}

bundle {
  bundleApiTargetPlatform("org.eclipse.ui")
  bundleApiTargetPlatform("org.eclipse.core.runtime")
  bundleApiProvidedProject(":spoofax.eclipse.externaldeps")
}
