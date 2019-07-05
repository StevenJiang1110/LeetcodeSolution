package problem43;

public class Multiply {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";

        int len1 = num1.length();
        int len2 = num2.length();

        if(len1 > len2) return multiply(num2, num1);

        String res = "0";
        for (int i = 0; i < len1; i++) {
            char c1 = num1.charAt(len1 - 1 - i);
            if(c1 == '0') continue;
            String multiple = multiply(num2, c1);
            multiple += copyZero(i);
            res = add(res, multiple);
        }
        return res;
    }

    public String copyZero(int times){
        if(times == 0) return "";
        return new String(new char[times]).replace("\0","0");
    }

    public String multiply(String num1, char num2){
        if(num2 == '0' || num1.equals("0")) return "0";
        StringBuilder builder = new StringBuilder();
        int len1 = num1.length();
        int carried = 0;
        for (int i = 0; i < len1; i++) {
            char c1 = num1.charAt(len1 - 1 - i);
            int multiple = (c1 - '0') * (num2 - '0') + carried;

            carried = multiple / 10;
            multiple = multiple % 10;
            builder.append(multiple);
        }

        if(carried != 0){
            builder.append(carried);
        }
        return builder.reverse().toString();

    }

    public String add(String num1, String num2){
        if(num1.equals("0")) return num2;
        if(num2.equals("0")) return num1;
        int len1 = num1.length();
        int len2 = num2.length();

        int carried = 0;
        StringBuilder builder = new StringBuilder();
        int commonLen = Math.min(len1, len2);

        for (int i = 0; i < commonLen; i++) {
            char c1 = num1.charAt(len1 -1 - i);
            char c2 = num2.charAt(len2 -1 - i);
            int sum = c1 - '0' + c2 - '0' + carried;

            carried = sum / 10;
            sum = sum % 10;

            builder.append(sum);
        }

        for(int i = commonLen; i < len1; i++){
            char c1 = num1.charAt(len1 -1 - i);
            int sum = c1 - '0' + carried;
            carried = sum / 10;
            sum = sum % 10;

            builder.append(sum);
        }

        for (int i = commonLen; i < len2; i++) {
            char c2 = num2.charAt(len2-1 -i);
            int sum = c2 - '0' + carried;

            carried = sum / 10;
            sum = sum % 10;

            builder.append(sum);
        }


        if(carried != 0){
            builder.append(carried);
        }
        return builder.reverse().toString();

    }

    public static void main(String... args){
        String num1str = "123";
        String num3str = "456";
        String res = new Multiply().multiply(num1str, num3str);
        System.out.println(res);
    }
}
