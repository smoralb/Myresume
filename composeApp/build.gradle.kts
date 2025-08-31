import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
}

kotlin {
    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        moduleName = "composeApp"
        browser {
            val rootDirPath = project.rootDir.path
            val projectDirPath = project.projectDir.path
            commonWebpackConfig {
                outputFileName = "composeApp.js"
                devServer = (devServer ?: KotlinWebpackConfig.DevServer()).apply {
                    static = (static ?: mutableListOf()).apply {
                        // Serve sources to debug inside browser
                        add(rootDirPath)
                        add(projectDirPath)
                    }
                }
            }
        }
        binaries.executable()
    }
    
    sourceSets {
        
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodel)
            implementation(libs.androidx.lifecycle.runtime.compose)
            implementation(libs.decompose)
            implementation(libs.decompose.extensions.compose)
        }
    }
}

tasks.register<Copy>("publishWasmToDocs") {
    group = "kotlin browser"
    description = "Genera el bundle WASM y copia los artefactos al directorio /docs conservando CNAME"

    dependsOn(tasks.named("wasmJsBrowserDistribution"))

    val docsDir = project.rootDir.resolve("docs")

    // Primero limpiar todo excepto CNAME
    doFirst {
        docsDir.listFiles()
            ?.filter { it.name != "CNAME" }
            ?.forEach { file ->
                if (file.isDirectory) file.deleteRecursively() else file.delete()
            }
    }

    // Copiar nuevos artefactos
    from(layout.buildDirectory.dir("dist/wasmJs/productionExecutable"))
    into(docsDir)
}


