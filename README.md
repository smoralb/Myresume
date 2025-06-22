# Welcome to MyResume! 

This is a Kotlin Multiplatform project targeting Web.

All the documentation to create, build and deploy a website is [here](https://kotlinlang.org/docs/wasm-get-started.html)

## Architecture of the project

This project is a static website so there`s only view logic. This view layer is differentiated in different sections:

### All the folders under 'commonMain'
- Contains all the logic for the  common resources (drawable, fonts and strings)
### All the folders under 'wasmJsMain' 
- The main folder (contains all the visual parts of the UI like Header, content and Footer).
- The `ui` folder, that contains all the code related to the common code like (Theme, colors, spacing, etc.)

## Cheatsheet

- ./gradlew wasmJsBrowserDevelopmentRun -t -> Run the app locally
- ./gradlew wasmJsBrowserDistribution -> Create the deployment package