import org.jetbrains.compose.compose

plugins {
  kotlin("multiplatform") version "1.6.10"
  id("org.jetbrains.compose") version "1.0.1"
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
      commonWebpackConfig {
        cssSupport.enabled = true
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
