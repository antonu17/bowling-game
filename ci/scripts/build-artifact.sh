#!/bin/sh

export VERSION=$(cat ../version/version)
sed -e "s/^\(version=\).*$/\1${VERSION}/" -i gradle.properties

./gradlew assemble
bzip2 ./console-ui/build/distributions/console-ui-*.tar

mv ./console-ui/build/distributions/console-ui-*.* ../artifacts/
