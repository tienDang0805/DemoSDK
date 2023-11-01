# DemoSDK
> step 1 : add jitpack repo to build file
```gradle
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}
```
>  Step 2. Add the dependency
``` gradle
dependencies {
	        implementation 'com.github.tienDang0805:DemoSDK:Tag'
	}
