rootProject.name = "spoofax.eclipse"

pluginManagement {
  repositories {
    maven(url = "http://home.gohla.nl:8091/artifactory/all/")
    gradlePluginPortal()
  }
}

include("spoofax.eclipse.plugin")
include("spoofax.eclipse.meta.plugin")
include("spoofax.eclipse.feature")
include("spoofax.eclipse.meta.feature")
include("spoofax.eclipse.repository")
include("spoofax.eclipse.externaldeps")

project(":spoofax.eclipse.plugin").projectDir = file("plugin")
project(":spoofax.eclipse.meta.plugin").projectDir = file("meta.plugin")
project(":spoofax.eclipse.feature").projectDir = file("feature")
project(":spoofax.eclipse.meta.feature").projectDir = file("meta.feature")
project(":spoofax.eclipse.repository").projectDir = file("repository")
project(":spoofax.eclipse.externaldeps").projectDir = file("externaldeps")
