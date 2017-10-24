#!/bin/sh

export VERSION=$(cat ../version/${VERSION_FILE})
sed -e "s/^\(version=\).*$/\1${VERSION}/" -i gradle.properties

./gradlew assemble
