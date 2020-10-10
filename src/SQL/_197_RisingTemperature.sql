SELECT wt1.Id
FROM Weather wt1, Weather wt2
WHERE wt1.Temperature > wt2.Temperature AND
      TO_DAYS(wt1.recordDate)-TO_DAYS(wt2.recordDate)=1;


SELECT w2.Id  FROM Weather w1,Weather w2
WHERE w2.recordDate = DATE_ADD(w1.recordDate, INTERVAL 1 DAY)
AND w2.Temperature > w1.Temperature;
