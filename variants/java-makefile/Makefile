MODULES := rules aione
MODULES_MAIN := mainconsole # TODO Can we build this list automatically when we spot the prefix "main"?

QUALIFIED_MODULES := $(addprefix net.pijcke.nim.,$(MODULES))
QUALIFIED_MODULES_MAIN := $(addprefix net.pijcke.nim.,$(MODULES_MAIN))

JARS := $(addprefix modules/,$(addsuffix .jar,$(QUALIFIED_MODULES)))
JARS_MAIN := $(addprefix modules/,$(addsuffix .jar,$(QUALIFIED_MODULES_MAIN)))

all: $(JARS) $(JARS_MAIN)
	echo $(JARS)

$(JARS_MAIN): modules/%.jar:
	javac -d $*/target @$*/classes --module-path modules
	mkdir -p modules
	jar --create --main-class $*.Main --file $@ -C $*/target .

$(JARS): modules/%.jar:
	javac -d $*/target @$*/classes --module-path modules
	mkdir -p modules
	jar --create --file $@ -C $*/target .

run: all run-console

run-console:
	java --module-path modules --add-modules ALL-MODULE-PATH -jar modules/net.pijcke.nim.mainconsole.jar

clean:
	rm -rf modules
	rm -rf net.pijcke.nim.rules/target
	rm -rf net.pijcke.nim.mainconsole/target

.PHONY: clean run run-console
