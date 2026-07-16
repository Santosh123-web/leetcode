-- Last updated: 7/16/2026, 4:08:09 PM
SELECT
    score,
    DENSE_RANK() OVER (ORDER BY score DESC) AS `rank`
    -- Note: SQL Server Use `[rank]` instead of `rank`.
FROM Scores
ORDER BY score DESC;