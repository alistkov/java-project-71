.PHONY: build lint test

install-dist:
	make clean && ./gradlew installDist

run-dist:
	./build/install/app/bin/app

check-updates:
	./gradlew dependencyUpdates

clean:
	./gradlew clean

lint:
	./gradlew spotlessCheck

lint-fix:
	./gradlew spotlessApply

test:
	./gradlew test

test-coverage:
	./gradlew jacocoTestCoverageVerification

build:
	./gradlew clean build
