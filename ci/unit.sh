#!/bin/bash

set -e -x

pushd bowling-game
    ./gradlew --no-daemon test
popd

