Bowling game
============

## Some general ideas about bowling game app

Configurable rounds (10), pins (10) quantity
Strike - all pins are bowled in the first toss
Spare - all pins are bowled in two tosses
In the very last round a player may have bonus toss in case of strike or spare
Strike and spare rounds has bonuses.
Score of spare round calculated as 10 + pins bowled in next toss
Score of strike round calculated as 10 + pins bowled in next 2 tosses
Total Score recalculated after each toss

## How to test console app

git clone && cd workdir

```
./gradlew build
tar xf console-ui/build/distributions/console-ui-1.0-SNAPSHOT.tar
./console-ui-1.0-SNAPSHOT/bin/console-ui
```

## TODO

Add Spring Boot
Add REST interface
