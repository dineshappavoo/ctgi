ALGORITHMS:

1. Write code to sum 2 integer but u cant use a+b method, you have to use either ++ or --. How you will handle negative numbers [com.ctgi.apple.problems.SumIntegersUsingSpecialOperator]
2. There are several words in a file. Get the occurrence of every word and sort it based on the occurrence, if more than one word is having same occurrence than sort it alphabetically. [com.ctgi.apple.problems.SortListBasedOnOccurrance]

TEST
1.

DESIGN:
1. How can we divide a large file between multi threads to process it? If we are running a multi threaded application and input is a large file and we have to provide each thread a part of the file to make it fast. How we can achieve it in java?
    ANSWER:use fork/join, keep dividing the file based on lines and invoking the fork.
        Was to partition data in threads/pipelines
        1) Round robin (fastest and uniformly distributed)
        2) Randomly assign to each thread (uniformly distributed but relatively slow as we have to generate random numbers)
        3) Hashing (good to group duplicates together but slow because of hashing)
2. There is a test automation running and fails 14%, say 1/7 times? How you will debug? There is no code change or test code change.
    ANSWER:Look at the failures in the logs, in general, it will be the health of the server to be checked, if the server performance is slow(timeout errors, ObjectNotFound Exceptions), if there is an OutOfMemoryException is thrown in one of the test case or even outside this testSuite, need to be cleaned out.


References:
1. http://steve-yegge.blogspot.com/2008/03/get-that-job-at-google.html