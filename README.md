
---
<p align="center">
  <img width="300"  src="https://raw.githubusercontent.com/lu-cs-sde/IntraJ/main/resources/logo.png">
</p>

This repository contains the artifact of the following two papers:

*Paper I: __IntraJ: an On-demand Framework For Intraprocedural Java Code Analysis__, _[Idriss Riouak 🔗](https://orcid.org/0000-0003-3520-2262), [Görel Hedin 🔗](https://orcid.org/0000-0002-3003-2623), [Niklas Fors 🔗](https://orcid.org/0000-0003-2714-9457), and [Christoph Reichenbach 🔗](https://orcid.org/0000-0003-0608-7023),_. Submitted to the Journal of System and Software.



*Paper II:  __[A Precise Framework for Source-Level Control-Flow Analysis](https://github.com/lu-cs-sde/IntraJSCAM2021/blob/main/intraj-preprint.pdf)__, _[Idriss Riouak 🔗](https://orcid.org/0000-0003-3520-2262), [Christoph Reichenbach 🔗](https://orcid.org/0000-0003-0608-7023), [Görel Hedin 🔗](https://orcid.org/0000-0002-3003-2623) and [Niklas Fors 🔗](https://orcid.org/0000-0003-2714-9457)_. _To appear at the 21st IEEE International Working Conference on Source Code Analysis & Manipulation, 2021 ([SCAM 2021 🔗](http://www.ieee-scam.org/2021))._


The repository contains:

* _IntraJ-LSP_: an _LSP_-based plugin for the [VSCode](https://code.visualstudio.com) editor, which allows you to run IntraJ on Java source code.

* **IntraJ**: a static analyser for Java source code and all its submodules:
	- [IntraCFG](https://github.com/lu-cs-sde/IntraCFG): a language-independent framework for control-flow analysis
	- [ExtendJ](https://extendj.org): a Java compiler implemented using JastAdd
	- [JastAdd](https://jastadd.org): a metacompiler supporting reference attribute grammars



---
# Get the IntraJ-LSP artifact
We provide two different ways of getting and running **IntraJ-LSP**:
  * Install _IntraJ-LSP_ as a VSCode extension from the [VSCode Marketplace](https://marketplace.visualstudio.com/items?itemName=IdrissRiouak.IntraJ). (Recommended)
  * Build _IntraJ-LSP_ from the artifact source code.

## Install IntraJ as a VSCode extension (i.e., IntraJ-LSP)
To install IntraJ as a VSCode extension, follow these steps:

1. Install the [VSCode](https://code.visualstudio.com) editor.
	1. Install the extension from the [VSCode Marketplace](https://marketplace.visualstudio.com/items?itemName=IdrissRiouak.IntraJ).
 	2. Alternatively, search for `IntraJ` in the VSCode Extensions Marketplace.

[See instruction video on YouTube](https://www.youtube.com/watch?v=0sGQnrybMjY&ab_channel=IdrissRiouak)



# Build IntraJ-LSP from the source code
## Prerequisites

To build __IntraJ-LSP__ the following tools are required:

*  **Java SDK version 8**. (tested with  SDK 1.8.0_275. See [sdkman](https://sdkman.io)).
*  **VSCode Editor**. (tested with 1.79.2. See [VSCode](https://code.visualstudio.com)).


## Build
To clone the **IntraJ** code, run, in your working directory:
```
git clone https://github.com/IdrissRio/IntraJ-LSP.git
```

Move to the **IntraJ-LSP** directory:

```
cd IntraJ-LSP
```

Recusively clone all the submodule

```
git submodule update --init --recursive
```


Build the extension using the following command:

```
./gradlew vsce
```

---

[See instruction video  on YouTube](https://www.youtube.com/watch?v=FykUksYD7D4&feature=youtu.be&ab_channel=IdrissRiouak)



### The _IntraJ-LSP_ folder
The directory is structured as follow:

```
IntraJ-LSP
    ├── build                                # Compiled files
    ├── IntraJ                               # IntraJ source code
    ├── src/java                             # IntraJ source code
    |    ├── magpiebridge                    # MagpieBridge source code  
    |    └── java
    |          └── IntraJPlugin.java         # Entry point for the plugin   (Paper I §3)
    ├── tools                                # IntraJ source code
    |    └── magpiebridge.jar                # Custom version of Jastadd    (Paper I §3)
    ├── vscode                               # VSCode extension source code (Paper I §3)
    |    ├── intraj.jar 		     # IntraJ jar file
    |    └── package.json  		     # VSCode extension manifest
    ├── LICENSE
    └── README.md
```


### The _IntraJ_ folder
The directory is structured as follow:

    .
    ├── build                                # Compiled files
    ├── extendj                              # ExtendJ source code
    ├── resources                            # Scripts and logo
    ├── src                                  # IntraJ source code
    |    ├── jastadd                  
    |    |     ├── CFG                       # CFG spec in Jastadd
    |    |     ├── StaticAnalysis            # Folder containing code-smells and data-flow analyses
    |    |     └── utils                     # Helpers for IntraJ
    |    └── java
    |          ├── utils                     # General helpers for visualisation
    |          └── test                      # JUnit test spec
    ├── tools                                # IntraJ source code
    |    └── jastadd-2.3.6-custom            # Custom version of Jastadd
    ├── testfiles                            # Automated test files
    |    ├── DataFlow
    |    └── CFG
    ├── eval.sh                              # Evaluation entry point
    ├── LICENSE
    └── README.md



### The _jastadd_ folder

    .
    └── jastadd
         ├── CFG
         |    ├── IntraCFG
         |    |    ├── CFG.ast                           # Lang-independent nodes
         |    |    └── IntraCFG.jrag                     # IntraCFG spec in Jastadd 
         |    ├── java4                                  #                          (Paper II §3)
         |    |    ├── Cache.jrag                        # Cache settings
         |    |    ├── Exception.jrag                    # Exception spec           (Paper II §3.c)
         |    |    ├── Initializer.jrag                  # Initializers spec        (Paper II §3.b)
         |    |    ├── Java4.jrag                        # Java4 spec
         |    |    └── ImplictNodes.ast                  # Reified nodes
         |    ├── java5                                  #                          (Paper II §3)
         |    |     └── Java5.jrag                       # Java5 spec
         |    └── java7                                  #                          (Paper II §3)
         |    |      └── Java7.jrag                      # Java7 spec
	 |    └── java8                                  #                         
         |          └── Java8.jrag                       # Java8 spec
         └── StaticAnalysis                              # Data flow analyses spec  (Paper II §4)
               ├── CodeSmells                            # CodeSmells
               └── DataFlow                              # Dataflow Analyses
			├── DeadAssignment.jrag              #                       (Paper II §4.c)
			├── ImplicitDeadAssignment.jrag      #                       (Paper II §4.c)
			├── LiveVariableAnalysis.jrag        #                       (Paper II §4.c)
			├── NullAnalysis.jrag                #                       (Paper II §4.c)	
               		└── ReachingDefintion.jrag           #                       (Paper II §4.c)

---


# Other IntraJ's Use Cases
## Use IntraJ as a standalone tool
To use IntraJ as a standalone tool, visit the [IntraJ repository](https://github.com/lu-cs-sde/IntraJ) and follow the instructions in the [README.md](https://github.com/lu-cs-sde/IntraJ/README.md) .

## Integration of IntraJ in CodeProber
To use IntraJ in CodeProber, visit the following [webpage](https://zenodo.org/record/7185243) and follow
the following instructions:
- Download the file named `artifact.zip` and unzip it.
- Follow the instruction in the README.pdf. 
- `Figure 6` in the README.pdf shows how to use show visualise the CFGs generated by __IntraJ__ in CodeProber.





# Related repository repositories/links 🔗
 - 🗄 **[IntraJ](https://github.com/lu-cs-sde/IntraJ)**: main repository for IntraJ (control-flow analysis for Java)
 - 🗄 **[IntraCFG](https://github.com/lu-cs-sde/IntraCFG)**: main repository for IntraCFG (language-independent framework for control-flow analysis)
 - 🔗 **[JastAdd](https://jastadd.org)**: meta-compilation system that supports Reference Attribute Grammars. We used a custom [JastAdd](https://bitbucket.org/jastadd/jastadd2/src/f00c118684f4cc9b42931b5a491046e41d68b6bf/) version which better supports interfaces.
 - 🔗 **[ExtendJ](https://extendj.org)**: extensible Java compiler built using JastAdd. We built **IntraJ** as an Static Analysis Extension of ExtendJ. More can be found [here](https://bitbucket.org/extendj/analysis-template/src/master/). 

# Awards 
__IntraJ__ was awarded with the Research Object Badge (ROR) and the Open Research Badge  
and the Open Research Badge (ORO) at ROSE Track of ICSME 2021.

|_**Repository**_|[![DOI](https://zenodo.org/badge/DOI/10.5281/zenodo.5296618.svg)](https://doi.org/10.5281/zenodo.5296618)|
|:------------|---------------|
|_**Docker image**_|[![DOI](https://zenodo.org/badge/DOI/10.5281/zenodo.5296449.svg)](https://doi.org/10.5281/zenodo.5296449)|
|_**Reserarch Object Badge**_ | <a href="https://icsme2021.github.io/cfp/AEandROSETrack.html">  <img  width="70"  src="https://icsme2021.github.io/img/badges/Open_Research.png"> </a>|
|_**Open Research Badge**_| <a href="https://icsme2021.github.io/cfp/AEandROSETrack.html"><img width="70"  src="https://icsme2021.github.io/img/badges/Research_Objects.png"> </a>|

