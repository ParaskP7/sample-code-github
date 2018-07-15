# Sample Code: GitHub

This repository contains sample code. 

Its purpose being, to quickly demonstrate Android, Kotlin and software development in general. More so and amongst others, 
the main focus of this project is:
- Setup and Gradle configuration, 
- Gradle modules,
- Clean architecture,
- Clean code,
- Best practices,
- Testing and 
- All those other must know goodies.

Below is a list of skills that are showcased:

1. Architectural Pattern
    1. [MVVM](https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93viewmodel) ```(Model View ViewModel)```
    2. [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) ```(Architecture Components 
    ViewModel Class)```
    3. [LivaData](https://developer.android.com/topic/libraries/architecture/livedata) ```(Architecture Components 
    LiveData Class)```
2. Libraries
    1. [Dagger](https://github.com/google/dagger) ```(A fast dependency injector for Android and Java)```
    2. [RxJava](https://github.com/ReactiveX/RxJava) ```(RxJava – Reactive Extensions for the JVM – a library for 
    composing asynchronous and event-based programs using observable sequences for the Java VM)```
    3. [Retrofit](https://github.com/square/retrofit) ```(Type-safe HTTP client for Android and Java by Square, Inc.)```
    4. [GSON](https://github.com/google/gson) ```(A Java serialization/deserialization library to convert Java Objects into 
    JSON and back)```
    5. [Glide](https://github.com/bumptech/glide) ```(An image loading and caching library for Android focused on smooth 
    scrolling)```
    6. [Dart](https://github.com/f2prateek/dart) ```(Extras binding and intent builders for Android apps)```
    7. [Timber](https://github.com/JakeWharton/timber) ```(A logger with a small, extensible API which provides utility on 
    top of Android's normal Log class)```
3. Android Support
    1. [Constraint Layout](https://developer.android.com/reference/android/support/constraint/ConstraintLayout) ```(A 
    ConstraintLayout is a ViewGroup which allows you to position and size widgets in a flexible way)```
    2. [Card View](https://developer.android.com/reference/android/support/v7/widget/CardView.html) ```(A FrameLayout with a 
    rounded corner background and shadow)```
    3. [Recycler View](https://developer.android.com/reference/android/support/v7/widget/RecyclerView.html) ```(A flexible 
    view for providing a limited window into a large data set)```
    4. [Shared Element Transition](https://developer.android.com/training/material/animations.html#Transitions) ```(Activity 
    transitions in material design apps provide visual connections between different states through motion and 
    transformations between common elements)```
4. Code Quality
    1. [Android Lint](https://developer.android.com/studio/write/lint.html) ```(The lint tool checks your Android project 
    source files for potential bugs and optimization improvements for correctness, security, performance, usability, 
    accessibility, and internationalization)```
    2. [Detekt](https://github.com/arturbosch/detekt) ```(Static code analysis for Kotlin)```
5. Tests
    1. [JUnit](https://github.com/junit-team/junit4) ```(A programmer-oriented testing framework for Java)```
    2. [AssertJ](https://github.com/joel-costigliola/assertj-core) ```(AssertJ is a library providing easy to use rich typed 
    assertions)```
    3. [Mockito Kotlin](https://github.com/nhaarman/mockito-kotlin) ```(Using Mockito with Kotlin)```
    4. [Robolectric](https://github.com/robolectric/robolectric) ```(Android Unit Testing Framework)```
6. Debug
    1. [LeakCanary](https://github.com/square/leakcanary) ```(A memory leak detection library for Android and Java)```
    1. [Strict Mode](https://developer.android.com/reference/android/os/StrictMode) ```(StrictMode is a developer tool which 
    detects things you might be doing by accident and brings them to your attention so you can fix them)```
7. Plugin
    1. [Gradle Versions](https://github.com/ben-manes/gradle-versions-plugin) ```(Gradle plugin to discover dependency 
    updates)```
    2. [Dexcount Gradle](https://github.com/KeepSafe/dexcount-gradle-plugin) ```(A Gradle plugin to report the number of 
    method references in your APK on every build)```

# Usage

Use the below command to build the project in order to install it on an Android device for demonstration:
```
gradlew clean build -x check
```

Or faster yet and targeting a specific build type (in our case the debug build type):
```
gradlew clean assembleDebug
```

Open an emulator or connect a physical device to experiment with the sample app, use the below command, which first 
uninstalls and then installs the sample app:
```
gradlew uninstallDebug | gradlew installDebug
```

Or faster yet and targeting a specific device (in our case an emulator):
```
adb -s emulator-5554 uninstall io.petros.github | 
adb -s emulator-5554 install presentation\build\outputs\apk\debug\presentation-debug.apk
```

Use this command in order to run the static code analysis for the project:
```
gradlew check -x test
```

Or even run the below commands to run a specific code quality tool in isolation:
```
gradlew lintDebug
gradlew detektCheck
```

Run the project unit tests using this command (this includes Robolectric):
```
gradlew test
```

Or even run the below commands to run specific tests (per module):
```
gradlew domain:test
gradlew data:testDebugUnitTest
gradlew presentation:testDebugUnitTest
```

# Future

Below is a list of all those future goodies that can further help demonstrate additional skills:
1. Espresso tests (preferable with the Robot pattern). See `MET` comment which stands for `Missing Espresso Tests`
2. Integration tests (preferable with MockWebServer). See `MIT` comment which stands for `Missing Integration Tests`
3. Pagination for infinite scrolling through all the possible results.
4. Smaller and larger screens considerations.
5. Lifecycle edge case events.

**THANK YOU**
