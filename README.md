# Weather Clean Architecture

[![Codacy Badge](https://app.codacy.com/project/badge/Grade/404946db725448b89bcee7807e96a92f)](https://www.codacy.com/gh/hungnd-vnse/Weather-Clean-Architecture/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=hungnd-vnse/Weather-Clean-Architecture&amp;utm_campaign=Badge_Grade)

A weather android app demonstrates Clean Architecture and is written in Kotlin.

## Introduction

Follow Clean Architecture recommended for building robust, high-quality apps.

* User Interface built with [Jetpack Compose](https://developer.android.com/jetpack/compose)
* A single-activity architecture
* A **presentation layer** that contains a Compose screen (View) and a **ViewModel** per screen (or
  feature).
* Reactive UIs using **Flow** and **Coroutines** for asynchronous operations.
* A **data layer** with repositories and data sources (local using Room and a api service).
* Dependency injection
  using [Hilt](https://developer.android.com/training/dependency-injection/hilt-android)

## Screenshot

<img src="./screenshot/weather_info.jpg" height="480"/>
<img src="./screenshot/saved_locations.jpg" height="480"/>
<img src="./screenshot/suggestion_locations.jpg" height="480"/>

