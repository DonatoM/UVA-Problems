A - Newspaper

Time Limit: 1 sec 
Memory Limit: 16MB

News agency pays money for articles according to some rules. Each character has its own value (some characters may have value equals to zero). Author gets his payment as a sum of all character's values in the article. You have to determine the amount of money that news agency must pay to an author.

INPUT:

The first line contains integer N (0 < N <= 5), it is a number of tests. Each test describes an integer K (0 < K <= 100), the number of paid characters. On next K lines there are table of paid characters and its values (character values are written in cents). If character can not be found in the table, then its value is equal to zero. Next, there is integer M (0 < M <= 150000). Next M lines contain an article itself. Each line can be up to 10000 characters length. Be aware of a large input size, the whole input file is about 7MB.
OUTPUT:

For each test print how much money publisher must pay for an article in format "x.yy$". Where "x" is a number of dollars without leading zeros, and "yy" number of cents with one leading zero if necessary. Examples: "3.32$", "13.07$", "71.30$", "0.09$".
SAMPLE INPUT:

1
7
a 3
W 10
A 100
, 10
k 7
. 3
I 13
7
ACM International Collegiate Programming Contest (abbreviated
as ACM-ICPC or just ICPC) is an annual multi-tiered competition
among the universities of the world. The ICPC challenges students
to set ever higher standards of excellence for themselves
through competition that rewards team work, problem analysis,
and rapid software development.
From Wikipedia.

SAMPLE OUTPUT:

3.74$
