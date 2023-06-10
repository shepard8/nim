all: modules/net.pijcke.nim.rules.jar modules/net.pijcke.nim.mainconsole.jar

# TODO define modules and make generic rules

modules/net.pijcke.nim.mainconsole.jar:
	javac -d net.pijcke.nim.mainconsole/target @net.pijcke.nim.mainconsole/classes --module-path modules
	mkdir -p modules
	jar --create --main-class net.pijcke.nim.mainconsole.Main --file modules/net.pijcke.nim.mainconsole.jar -C net.pijcke.nim.mainconsole/target .

modules/net.pijcke.nim.rules.jar:
	javac -d net.pijcke.nim.rules/target @net.pijcke.nim.rules/classes --module-path modules
	mkdir -p modules
	jar --create --file modules/net.pijcke.nim.rules.jar -C net.pijcke.nim.rules/target .

run: all run-console

run-console:
	java --module-path modules --add-modules ALL-MODULE-PATH -jar modules/net.pijcke.nim.mainconsole.jar

clean:
	rm -rf modules
	rm -rf net.pijcke.nim.rules/target
	rm -rf net.pijcke.nim.mainconsole/target

.PHONY: clean run run-console
