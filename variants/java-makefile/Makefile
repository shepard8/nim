all: modules/net.pijcke.nim.rules.jar

modules/net.pijcke.nim.rules.jar:
	javac -d net.pijcke.nim.rules/target @net.pijcke.nim.rules/classes
	mkdir -p modules
	jar --create --file modules/net.pijcke.nim.rules.jar -C net.pijcke.nim.rules/target .

clean:
	rm -rf modules
	rm -rf net.pijcke.nim.rules/target

.PHONY: clean
