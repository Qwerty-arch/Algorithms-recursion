public class Main {

    static int[] cost = new int[] {548, 154, 367, 451, 117};
    static int[] weight = new int[] {7, 5, 9, 1, 20};
    static int backpackVolume = 25;

    public static void main(String[] args) {
        System.out.println(recPow(2,0));
        System.out.println(recPow(10,3));
        System.out.println(recPow(2, -2));
        System.out.println(recPow(-2,3));

        System.out.println(backpack(cost.length - 1, backpackVolume));
    }

    /**
     *
     * @param value input number
     * @param powValue input power of a number
     * @return Returns the result of a number raised to a power.
     */
    private static double recPow(double value, int powValue) {
        if (powValue == 0) {
            return 1;
        } else if (powValue > 0) {
            return recPow(value, powValue-1) * value;
        } else {
            powValue = Math.abs(powValue);
            return 1/(recPow(value, powValue-1) * value);
        }
    }

    private static int backpack(int i, int _backpackVolume) {
        if (i < 0) {
            return 0;
        }
        if (weight[i] > _backpackVolume) {
            return backpack(i-1, _backpackVolume);
        } else {
            return Math.max(backpack(i-1, _backpackVolume), backpack(i-1, _backpackVolume - weight[i]) + cost[i]);
        }
    }
}
