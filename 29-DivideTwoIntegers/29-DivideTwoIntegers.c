// Last updated: 7/16/2026, 4:11:02 PM
int divide(int dividend, int divisor)
{
    long long a = dividend;
    long long b = divisor;
    if ((a / b) > 2147483647)
        return (2147483647);
    if ((a / b) < -2147483648)
        return (-2147483648);
    return (dividend / divisor);
}