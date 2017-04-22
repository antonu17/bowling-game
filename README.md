Bowling game
============

[![Build Status](https://travis-ci.org/antonu17/bowling-game.svg?branch=master)](https://travis-ci.org/antonu17/bowling-game)

## Some general ideas about bowling game app

* Configurable rounds (10), pins (10) quantity
* Strike - all pins are bowled in the first toss
* Spare - all pins are bowled in two tosses
* In the very last round a player may have bonus toss in case of strike or spare
* Strike and spare rounds has bonuses.
* Score of spare round calculated as 10 + pins bowled in next toss
* Score of strike round calculated as 10 + pins bowled in next 2 tosses
* Total Score recalculated after each toss

## How to test console app

git clone && cd workdir

```
./gradlew build
```
Extract `console-ui/build/distributions/console-ui-1.0.zip` somewhere and launch bin/console-ui(.bat in case of windows)

## TODO

* Add Spring Boot
* Add REST interface
