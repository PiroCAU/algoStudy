import java.math.*;
// https://www.youtube.com/watch?v=LZ94TH5L--8 이거 참고했습니다...
class Solution {
    public long solution(int w, int h) {
        long lw = (long) w;
        long lh = (long) h;
        long gcd = BigInteger.valueOf(lw).gcd(BigInteger.valueOf(lh)).longValue();
        return lw * lh - (lw + lh - gcd);
    }
}