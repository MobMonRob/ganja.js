## Using bash if syntax .. also changed to work on WSL
SHELL = /bin/bash

## Minimalistic, I'm using this on ubuntu, with g++ and mono default installs and node v11
ALL: c hyperbolic dual r2 r3 mink quat r111 spacetime cga pga3d
	@echo "done !"

## Generate all languages by default
GEN_LANG="csharp cpp python rust java"

%:
	@node generate `echo $*| tr "[a-z]" "[A-Z]"`
	@echo "CPP" $* > out1
	@echo "C#" $* > out2
	@echo "PYTHON" $* > out3
	@echo "RUST" $* > out4
	@echo "JAVA" $* > out5
	@echo

## rough clean generated files
clean:
	@echo "cleaning .."
	-@rm {csharp,cpp,python,rust,java}/*{.exe,_cpp,_rust}  -f
	-@rm {csharp,cpp,python,rust,java}/r111*  -f
	-@rm *~ -f
