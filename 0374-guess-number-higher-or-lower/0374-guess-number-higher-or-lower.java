/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int a = 1;
        int b = n;

        while (a <= b) {
            int c = a + (b - a) / 2;
            int d = guess(c);

            if (d == 0) {
                return c;
            } else if (d < 0) {
                b = c - 1;
            } else {
                a = c + 1;
            }
        }

        return -1;
    }
}