all: modules/net.pijcke.nim.rules.jar \
 	modules/net.pijcke.nim.mainconsole.jar \
	modules/net.pijcke.nim.aione.jar

modules/net.pijcke.nim.rules.jar:
	javac -d net.pijcke.nim.rules/target @net.pijcke.nim.rules/classes --module-path modules
	mkdir -p modules
	jar --create --file $@ -C net.pijcke.nim.rules/target .

modules/net.pijcke.nim.aione.jar:
	javac -d net.pijcke.nim.aione/target @net.pijcke.nim.aione/classes --module-path modules
	mkdir -p modules
	jar --create --file $@ -C net.pijcke.nim.aione/target .

modules/net.pijcke.nim.mainconsole.jar:
	javac -d net.pijcke.nim.mainconsole/target @net.pijcke.nim.mainconsole/classes --module-path modules
	mkdir -p modules
	jar --create --main-class net.pijcke.nim.mainconsole.Main --file $@ -C net.pijcke.nim.mainconsole/target .

run: all run-console

run-console:
	java --module-path modules --add-modules ALL-MODULE-PATH -jar modules/net.pijcke.nim.mainconsole.jar

clean:
	rm -rf modules
	rm -rf */target

.PHONY: clean run run-console
