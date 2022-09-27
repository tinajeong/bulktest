# BulkTest
- batch size : 1000
```shell
insert >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
------------------------------------------------------------
Regular inserts     |    1         |          27ms (0 s)
Batch inserts       |    1         |          11ms (0 s)
Total gain: 59 %
------------------------------------------------------------
Regular inserts     |    10        |           4ms (0 s)
Batch inserts       |    10        |           2ms (0 s)
Total gain: 50 %
------------------------------------------------------------
Regular inserts     |    100       |          18ms (0 s)
Batch inserts       |    100       |           7ms (0 s)
Total gain: 61 %
------------------------------------------------------------
Regular inserts     |    1000      |         188ms (0 s)
Batch inserts       |    1000      |          21ms (0 s)
Total gain: 88 %
------------------------------------------------------------
Regular inserts     |    10000     |         893ms (0 s)
Batch inserts       |    10000     |         115ms (0 s)
Total gain: 87 %
```