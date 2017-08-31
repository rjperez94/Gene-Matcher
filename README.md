# Gene-Matcher

## Compiling Java files using Eclipse IDE

1. Download this repository as ZIP
2. Create new `Java Project` in `Eclipse`
3. Right click on your `Java Project` --> `Import`
4. Choose `General` --> `Archive File`
5. Put directory where you downloaded ZIP in `From archive file`
6. Put `ProjectName/src` in `Into folder`
7. Click `Finish`

## Linking the jUnit library

8. Right click on your `Java Project` --> `Build Path` --> `Add Libraries`
9. Choose `jUnit` --> `Next`
10. Choose `jUnit 4` as the version
11. Click `Finish`

## Running the program

1. Right click on your `Java Project` --> `Run As` --> `Java Application`

## Overview

Perhaps the most remarkable scientific achievements of the last fifty years have been in the area of biochemical genetics; specifically, the discovery that every inherited characteristic of all Earth's life-forms is encoded in DNA by surprisingly simple sequences of just four chemical compounds, called bases. Furthermore, biochemists have been able to decipher large parts of this code, and can now reliably decsribe large parts of the genotype of many living things by listing appropriate sequences of bases.

The four bases that make up DNA are guanine (G), adenine (A), cytosine (C), and thymine (T). A gene is a long string of (typically several thousand of) these bases. The presence or absence of particular bases, and their order, are significant.

A small but important tool in cracking the genetic code is the determination of how similar two different sequences are. One metric for determining similarity is described in Cormen, Leiserson, Rivest, and Stein

## Notes

- `Testing.java` produces a file `test_results.csv` which shows the `average running times` in `ms` of the program using different parameters
- See program design <a href='https://github.com/rjperez94/Gene-Matcher/blob/master/classdiagram.png'>here</a>
- See proof, results and algorithm <a href='https://github.com/rjperez94/Gene-Matcher/blob/master/Report.pdf'>here</a>
