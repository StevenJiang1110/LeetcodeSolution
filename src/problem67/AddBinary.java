package problem67;

public class AddBinary {
    public String addBinary(String a, String b) {
        int len1 = a.length();
        if(len1 == 0) return b;
        int len2 = b.length();
        if(len2 == 0) return a;
        int totalLen = Math.min(len1, len2);
        int carried = 0;
        StringBuilder builder = new StringBuilder();
        int i = 0;
        for (; i < totalLen; i++) {
            int ai = a.charAt(len1 - 1 - i) - '0';
            int bi = b.charAt(len2 - 1 - i) - '0';
            int res = (ai + bi + carried) % 2;
            carried = (ai + bi + carried) / 2;
            builder.append(res);
        }

        for(; i < len1; i ++){
            int ai = a.charAt(len1 - 1 - i) - '0';
            int res = (ai + carried) % 2;
            carried = (ai + carried) / 2;
            builder.append(res);
        }

        for(; i < len2; i++){
            int bi = b.charAt(len2 - 1 - i) - '0';
            int res = (bi + carried) % 2;
            carried = (bi + carried) / 2;
            builder.append(res);
        }

        if(carried != 0) builder.append(carried);

        return new String(builder.reverse());
    }
}
