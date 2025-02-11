import org.jetbrains.compose.compose

plugins {
  kotlin("multiplatform") version "2.1.0"
  alias(libs.plugins.jetbrainsCompose)
  alias(libs.plugins.compose.compiler)
}

group = "com.rocketraman.testkt50958"
version = "1.0"

repositories {
  google()
  mavenCentral()
}

kotlin {
  jvm {
    withJava()
    testRuns["test"].executionTask.configure {
      useJUnitPlatform()
    }
  }
  js(IR) {
    binaries.executable()
    browser {
      runTask {
        sourceMaps = false
      }
    }
  }
  sourceSets {
    val commonMain by getting {
      dependencies {
        api(compose.runtime)
        api(compose.web.core)
      }
    }
    val commonTest by getting {
      dependencies {
        implementation(kotlin("test"))
      }
    }
    val jsMain by getting {
      dependencies {
      }
    }
    val jsTest by getting
  }
}
