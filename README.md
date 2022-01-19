# Spartronics 4915's Test Bed 2022

## Provenance

This set of Test Bed code was prepared from the [Spartronics Template](https://github.com/Spartronics4915/Template).

 - Updated WPILib to latest (as of 1.18.22 version 2022.2.1), and updated CTRE and REV Robotics libraries.
 - Forked the Template into 2022-Template, and cloned a local copy.
 - Copied the 'lib' portion of [SpartonicsLib](https://github.com/Spartronics4915/SpartronicsLib) under 'Spartronics4915' in the cloned copy.
 - Based on a couple of pre-attempts, there seem to be a need for a lot of changes in the 'math' portion of the library, so removed the 'math' subdirectory.
 - Opened 2022-Template in WPILib VSCode, and performed the Gradle import - into 2022-TestRobot.
 - Worked through issues around changes between 2021 and 2022 in CTRE and REV Robotics library.
 - Removed 'estimator' subdirectory from SpartronicsLib section, as we're not using LIDAR at the moment.
 - Removed 'SpartronicsAnalogEncoder' for now - as there is an error on deprecated createDouble that is not clear how to resolve.
 - Added Troy's Joystick code.

## Usage

### Prerequisites

Ensure you have Java 11 installed on your computer and added to `$PATH`.
Visual Studio Code, Git, and the WPILib extension are also helpful for development.

The (highly) recommended way to install these is through [the WPILib installer](https://docs.wpilib.org/en/latest/docs/zero-to-robot/step-2/wpilib-setup.html
).

### Installation

Once your development environment is set up, `clone` this repository to your computer.

Run `./gradlew tasks` to list available Gradle options.

Run `./gradlew build` or use the WPILib extension's `Build Robot Code` option to build or compile the codebase.

Run `./gradlew deploy` or use the WPILib extension's `Deploy Robot Code` option while connected to the robot to build and deploy your code.

## Style Guide

- **Indentation**: Four spaces, no tabs.
- **Braces**: Each brace goes on its own line.
  - This is verbose, but intentionally so - brace errors are common,
    often difficult-to-diagnose, and have caused problems at bad times in the past.
- Line length: Eighty characters or less, as a rule of thumb.
  - This improves legibility and makes it easier to view files side-by-side.
  - The formatter doesn't actually enforce this until lines are 120 characters,
    to give you flexibility around how you'd like to wrap your lines.
- Variable names: `camelCase`.
  - **Member variables**: Prefix with `m`, ex. `mMemberVariable`.
  - **Final constants**: Prefix with `k`, ex. `kFinalConstant`.
  - Parameters: No prefix.
- Class and file names: `PascalCase`.
- Folder names: `lowercase`.
- **Package structure**: `com.spartronics4915.frcXXXX`

(differences from WPILib are in **bold**)

A relatively unopinionated Eclipse-style formatter is included in the `.settings` folder.
This can be run at any time by opening Visual Studio Code's Command Palette (`Ctrl+Shift+P`) and selecting `Format Document`.
