#!/bin/sh

set -e -u -x

export ORG_GRADLE_PROJECT_version=$(cat version/version)
cd bowling-game
./gradlew --no-daemon assemble
