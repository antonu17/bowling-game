#!/bin/sh

set -e -x

export ORG_GRADLE_PROJECT_version=$(cat version/current-version)
cd bowling-game
./gradlew --no-daemon assemble
