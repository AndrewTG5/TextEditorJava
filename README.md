# 251-Assignment1-2022-Andrew-Rachel
![Build Status](https://github.com/andrewthegreat5/251-Assignment1-2022-Andrew-Rachel/actions/workflows/CI.yml/badge.svg)

Andrew Blake - 21009078

Rachel Bell - 20019755

To run the program use the maven goal javafx:run found under Maven -> Plugins -> javafx -> javafx:run

Uses JavaFX 18 for GUI, ODFDOM for .odt reading, and MonacoFX for editing. GitHub Actions compiles and tests with Junit on pushes and pull requests to main branch.
config.yaml found in the java resources folder can change attributes of the editor depending on whether you are editing code or plain text files. 
Language is auto-detected when opening files or can be manually selected. 
The editor also warns when you have unsaved changes. 
Supports printing to real printers or to PDF file.

Significant commits:

9410f0d325be0fd03b91d057f648117beb80b376

d9a554875f70ad87a8afd2ebfd352e8297b8f5a8