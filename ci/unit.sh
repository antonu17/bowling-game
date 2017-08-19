#!/bin/sh

set -e -x

cd bowling-game
./gradlew --no-daemon test
