# Image Resizing (Zooming +/-) – Keeping Aspect Ratio

## Overview

This Java-based application performs image resizing (zooming in/out) while preserving the aspect ratio of the image. The application supports BMP format (24-bit RGB) as input and allows the user to specify a zoom factor via the command line. The project demonstrates several key software engineering principles, including multithreading (using a Producer-Consumer model), OOP concepts (encapsulation, inheritance, polymorphism, and abstraction), and communication between threads via pipes.

## Features

- Zoom BMP images while maintaining the aspect ratio.
- Specify source and destination files, along with the zoom factor, via command-line arguments.
- Multithreaded processing with Producer-Consumer architecture.
- Inter-thread communication using Pipes for data transmission.
- Exception handling for robust file I/O operations and invalid parameters.
- Modular architecture with abstract classes, interfaces, and thread synchronization.

## Requirements

To run the project, you'll need:

- Java SE Development Kit (JDK) 8 or higher.
- A BMP image file (24-bit RGB format) as the input file.

## How to Use

### Running the Application

1. **Compile the Java source files**:
   ```bash
   javac -d . package1/Main.java package2/*.java
