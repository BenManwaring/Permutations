# Binaries
At time of writing GitHub packages only support authenticated usage, see thread on confirmation here:
https://github.community/t5/GitHub-API-Development-and/Download-from-Github-Package-Registry-without-authentication

Your `GITHUB_USERNAME` is your GitHub username.
You can generate a `GITHUB_TOKEN` using you GitHub personal account setting area, it will need access to packages.

```
repositories {
    maven {
        name = "GitHubPackages"
        url = "https://maven.pkg.github.com/BenManwaring/Permutations"
        credentials {
            username = System.getenv("GITHUB_USERNAME")
            password = System.getenv("GITHUB_TOKEN")
        }
    }
}

dependencies {
    implementation 'com.benmanwaring:permutations:1.0.2'
}
```
# Sample Usage
## For CharArray to String permutations
### Fixed length
#### Code
```
val stringPermutations = "AB".permutations(2)

for (stringPermutation in stringPermutations) {
    System.out.println(stringPermutation)
}
```
#### Output
```
AA
AB
BA
BB
```
### Range of lengths
#### Code
```
val stringPermutations = "AB".permutations(1..3)

for (stringPermutation in stringPermutations) {
    System.out.println(stringPermutation)
}
```
#### Output
```
A
B
AA
AB
BA
BB
AAA
AAB
ABA
ABB
BAA
BAB
BBA
BBB
```
## Generic permutations
### Fixed length
#### Code
```
val binaryPermutations = arrayOf(0, 1).permutations(2)

for (binaryPermutation in binaryPermutations) {
    System.out.println(binaryPermutation.joinToString(separator = ", "))
}
```
#### Output
```
0, 0
0, 1
1, 0
1, 1
```
### Range of lengths
#### Code
```
val binaryPermutations = arrayOf(0, 1).permutations(1..3)

for (binaryPermutation in binaryPermutations) {
    System.out.println(binaryPermutation.joinToString(separator = ", "))
}
```
#### Output
```
0
1
0, 0
0, 1
1, 0
1, 1
0, 0, 0
0, 0, 1
0, 1, 0
0, 1, 1
1, 0, 0
1, 0, 1
1, 1, 0
1, 1, 1
```
# License

    Copyright 2020 Ben Manwaring

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
