<img src="https://user-images.githubusercontent.com/45483768/143955773-61ec00b4-47ca-4973-a013-35aaaf7f1f65.png" align="left"/>

# Riskrieg | Palette

[![License: MIT](https://img.shields.io/badge/License-MIT-white.svg)](https://github.com/Riskrieg/palette/blob/main/LICENSE)
[![Maven Central](https://img.shields.io/maven-central/v/com.riskrieg/palette.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22com.riskrieg%22%20AND%20a:%22palette%22)
[![Donate](https://img.shields.io/badge/Donate-PayPal-lightgreen.svg)](https://paypal.me/aaronjyoder)

Looking for the core Riskrieg repository? Find it [here](https://github.com/Riskrieg/core).

## About

This repository hosts the code for the color palette portion of the project. It also contains the current definition of the RKP file format.

## Download
[![Maven Central](https://img.shields.io/maven-central/v/com.riskrieg/palette.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22com.riskrieg%22%20AND%20a:%22palette%22)

**Maven**
```xml
<dependency>
  <groupId>com.riskrieg</groupId>
  <artifactId>palette</artifactId>
  <version>1.1.0-0.2206</version>
</dependency>
```

**Gradle**
```kotlin
repositories {
    mavenCentral()
}

dependencies {
    implementation("com.riskrieg:palette:1.1.0-0.2206")
}
```

## RKP File Format

First, to understand the RKP file format, you need to know what an `RkpColor` is:
An `RkpColor` consists of the following:
* A 32-bit signed integer `order` that defines the relative ordering of the color.
* A name string, encoded to UTF-8.
* A 32-bit signed integer `r`, representing the red channel of the color. Valid values between 0-255 inclusive, on either end.
* A 32-bit signed integer `g`, representing the green channel of the color. Valid values between 0-255 inclusive, on either end.
* A 32-bit signed integer `b`, representing the blue channel of the color. Valid values between 0-255 inclusive, on either end.
* Alpha channels are explicitly and purposefully unsupported at this time.

The RKP file format is a simple JSON format that contains the following:
* A name string, encoded to UTF-8.
* Six `RkpColor` objects that define static element colors of map images, such as text color, border color, territory color, land color, water color, and connection color. Order and name do not matter for these colors, so the `order` element should be set to `-1`, and the `name` element should be set to `"Unnamed"`.
* A sorted set of `RkpColor` objects, with a size of between 2 and 16. The `order` element of each `RkpColor` object in the set should be immediately sequential.

This all comes together to form the `RkpPalette` object. You can find a Java implementation of an encoder and decoder in the [codec](https://github.com/Riskrieg/codec) repository.

All RKP files should have the `.rkp` file extension.

While this is not currently a binary file format, it could easily be made into one, and may be in the future.

## Contribute

Join our Discord server: [Riskrieg Discord](https://discord.gg/weU8jYDbW4)

## License

The code in this repository is licensed under the MIT license.
