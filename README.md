# BulkTest

```shell
insert               |     batch size           |     elasped time        
------------------------------------------------------------
Regular inserts     |    1         |          30ms (0 s)
Batch inserts       |    1         |          20ms (0 s)
Total gain: 33 %
------------------------------------------------------------
Regular inserts     |    10        |           4ms (0 s)
Batch inserts       |    10        |           2ms (0 s)
Total gain: 50 %
------------------------------------------------------------
Regular inserts     |    100       |          47ms (0 s)
Batch inserts       |    100       |          23ms (0 s)
Total gain: 51 %
------------------------------------------------------------
Regular inserts     |    100       |          47ms (0 s)
Batch inserts       |    100       |          19ms (0 s)
Total gain: 59 %
------------------------------------------------------------
Regular inserts     |    10000     |        2245ms (2 s)
Batch inserts       |    10000     |         881ms (0 s)
Total gain: 60 %
------------------------------------------------------------
Regular inserts     |    100000    |       16215ms (16 s)
Batch inserts       |    100000    |        8741ms (8 s)
Total gain: 46 %
------------------------------------------------------------
Regular inserts     |    1000000   |      167532ms (167 s)
Batch inserts       |    1000000   |       79840ms (79 s)
Total gain: 52 %
```