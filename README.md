# Pattern-Generator

Internship assignment. Pattern generator app that generates a pattern based on the reference input.

## Installation

To run the program you need to execute the "compile_n_run.bat" file or compile and run it with cmd.
 
After that you enter the input formated as
```
<number_of_rows>;<color_of_pixel_1>;<color_of_pixel_2>;<color_of_pixel_3>;<color_of_pixel_4>;<color_of_pixel_5>;<color_of_pixel_6>...
``` 
Example:
```
10;0;0;1;0;1;1;1;0;1
``` 

You can also run the program by taking the two files, "Functions.java" and "PatternGenerator.java" and place them in a empty java project and running it from your
IDE.

## The Problem


The task is to create an image base by pattern of rules and a reference data for the image.

The program receives the number of the rows to generate and the reference row as the input. The input is
formatted as 
```
<number_of_rows>;<color_of_pixel_1>;<color_of_pixel_2>;<color_of_pixel_3>;<color_of_pixel_4>;<color_of_pixel_5>;<color_of_pixel_6>...
``` 
A real test input for 10 rows with 7 columns could be like
```
10;0;0;1;0;1;1;1;0;1
``` 

Valid output is generated pixel data in a matrix of ones and zeros representing the colors. 
Optionally you can generate a png file of the resulting image for extra fashion points.
The problem can be solved in a language of your choise, please provide the program and a _readme.md_ file with instructions to run the solution.


## Pattern rules

1. Only generated rows form the resulting image, the reference data row is not a part of it.
2. By default the color of the pixel to draw is the same as the color of the pixel directly above (reference pixel), unless 50% of the 2 pixels to the left and right from the reference pixel are of the same color with the reference pixel.
3. When comparing pixels close to borders area to check can be 1 or 0 pixels on the other side of the reference pixel.

## Examples


Color stays the same:

| A | B | C | D | E | F | G |
|---|---|---|---|---|---|---|
| **0** | **0** | *1* | **0** | **1** | 1 | 1 |
|   |   | ? |  |  |  |  |  
  
1 of 4 (25%) pixels are 1, no change to reference pixel color.

| A | B | C | D | E | F | G |
|---|---|---|---|---|---|---|
| 0 | 0 | 1 | 0 | 1 | 1 | 1 |
|   |   | 1 |   |   |   |   |


Color changes:

| A | B | C | D | E | F | G |
|---|---|---|---|---|---|---|
| 0 | **0** | **1** | *1* | **1** | **1** | 1 |
|   |   |   | ? |   |   |   |

3 of 4 (75%) pixels are 1, reference pixel color must be changed.

| A | B | C | D | E | F | G |
|---|---|---|---|---|---|---|
| 0 | 0 | 1 | 1 | 1 | 1 | 1 |
|   |   |   | 0 |   |   |   |


Close to border:

| A | B | C | D | E | F | G |
|---|---|---|---|---|---|---|
| **1** | *1* | **0** | **1** | 1 | | |
|   | ? |   |   |   |   |   |

2 of 3 (67%) pixels are 1, reference pixel color must be changed.

| A | B | C | D | E | F | G |
|---|---|---|---|---|---|---|
| 1 | 1 | 0 | 1 | 1 | 0 | 1 |
|   | 0 |   |   |   |   |   |
