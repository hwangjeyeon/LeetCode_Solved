select
    FORMAT(t1.trans_date, 'yyyy-MM') [month],
    t1.country,
    count(1) [trans_count],
    sum(iif(t1.state = 'approved', 1, 0)) [approved_count],
    sum(ISNULL(t1.amount, 0)) [trans_total_amount],
    sum(iif(t1.state = 'approved', ISNULL(t1.amount, 0), 0)) [approved_total_amount]
from
    Transactions t1
group by
    FORMAT(t1.trans_date, 'yyyy-MM'), t1.country