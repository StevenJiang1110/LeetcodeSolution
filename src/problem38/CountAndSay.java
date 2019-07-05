package problem38;

public class CountAndSay {


    public String countAndSay(int n) {
        String s = "1";
        for (int i = 0; i < n - 1; i++) {
            s = nextString(s);
        }
        return s;
    }

    public String nextString(String cur){
        int len = cur.length();
        StringBuilder builder = new StringBuilder();
        char pre = cur.charAt(0);
        int count = 1;

        if(len == 1){
            builder.append(count);
            builder.append(pre);
        }

        for (int i = 1; i < len; i++) {
            char c = cur.charAt(i);
            if(c == pre){
                count++;
                if( i == len - 1){
                    builder.append(count);
                    builder.append(pre);
                }
            }else{
                builder.append(count);
                builder.append(pre);

                pre = c;
                count = 1;
                if(i == len - 1){
                    builder.append(count);
                    builder.append(pre);
                }
            }
        }

        return builder.toString();
    }

    public static void main(String... args){
        System.out.println(new CountAndSay().countAndSay(5));
    }
}
