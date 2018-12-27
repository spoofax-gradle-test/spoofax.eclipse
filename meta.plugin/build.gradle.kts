import mb.coronium.plugin.BundleExtension

// HACK: load our plugin via buildscript classpath and apply to work around IntelliJ bug which prevents custom plugins in composite builds.
buildscript {
  repositories {
    flatDir { dirs("../../coronium/build/libs") }
    mavenCentral()
    jcenter()
  }
  dependencies {
    classpath("org.metaborg", "coronium", "develop-SNAPSHOT")
    classpath("org.apache.maven.resolver:maven-resolver-api:1.1.1")
    classpath("org.apache.maven.resolver:maven-resolver-impl:1.1.1")
    classpath("org.apache.maven.resolver:maven-resolver-connector-basic:1.1.1")
    classpath("org.apache.maven.resolver:maven-resolver-transport-file:1.1.1")
    classpath("org.apache.maven:maven-resolver-provider:3.5.4")
    classpath("org.apache.commons:commons-compress:1.18")
  }
}
apply {
  plugin("org.metaborg.coronium.bundle")
}

configure<BundleExtension> {
  bundleImplementationTargetPlatform("org.eclipse.ui")
  bundleImplementationTargetPlatform("org.eclipse.core.runtime")
  bundleImplementationProject(":spoofax.eclipse.plugin")
  bundleImplementationProvidedProject(":spoofax.eclipse.externaldeps")
}
