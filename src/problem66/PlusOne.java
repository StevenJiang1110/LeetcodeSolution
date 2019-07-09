package problem66;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        if(len == 0) return digits;
        int carried = (digits[len - 1] + 1) / 10;
        digits[len - 1] = (digits[len - 1] + 1) % 10;

        if(carried == 0){
            return digits;
        }

        for(int i = len - 2; i >= 0; i--){
            int oldCarried = carried;
            carried = (digits[i] + carried) / 10;
            digits[i] = (digits[i] + oldCarried) % 10;
            if(carried == 0){
                return digits;
            }
        }

        int[] res = new int[len + 1];
        res[0] = carried;

        for (int i = 0; i < len; i++) {
            res[i + 1] = digits[i];
        }
        return res;
    }
}
