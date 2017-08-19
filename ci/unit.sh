#!/usr/bin/env bash

set -e -x

pushd bowling-game
    ./gradlew --no-daemon test
popd

