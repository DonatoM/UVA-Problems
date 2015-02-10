Calendars control our daily lives. For people like me, who are bad at multitasking, it is important to have at most one task planned for any minute of my life. Your job is to make sure that my calendar is free of conflicts for the next one million minutes (just over 99 weeks) of my life. To keep things simple, all times are expressed in minutes from a fixed time 0 representing ``now".


In this calendar, there are two types of tasks: one-time tasks and repeating tasks. One-time tasks have a start time and an end time. Repeating tasks have a start time and an end time for their first occurrence, and a repetition interval. Repeating tasks are assumed to keep repeating forever without end. For example, a repeating task with start time 5, end time 8 and repetition interval 100 would be occurring at time intervals [5..8], [105..108], [205..208], ...
Tasks are considered to be in conflict if and only if their time intervals overlap, for example [2..5] and [4..6] overlap. ``Touching" is OK, for example [2..5] and [5..6] do not overlap.

Input 
There are approximately 30 test cases. The first line of each test case contains two numbers n and m. n is the number of one-time tasks and m the number of repeating tasks. The following n lines contain two numbers each, the start and end times respectively of a one-time task. Afterward, m more lines similarly describe the repeating tasks by giving their start times, end times, and repetition intervals. Both n and m are at most 100.
All numbers are integers in the range [0..1000000]. For each task, the end time is guaranteed to be larger than the start time, and the repetition interval is larger than 0.
Input terminates with a line containing `0 0' which should not be processed.

Output 
For each test case, print a single line containing either the words ` NO CONFLICT' if there are no overlaps between any tasks for minutes 0..1000000, or ` CONFLICT' if there is at least one overlap.

Sample Input 
2 0
10 20
20 30
2 0
10 30
20 21
1 1
1000 2000
0 10 1000
0 0

Sample Output 

NO CONFLICT
CONFLICT
CONFLICT
