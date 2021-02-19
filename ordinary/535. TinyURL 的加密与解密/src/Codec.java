/**
 * @Author aries
 * @Data 2021-01-24
 */
public class Codec {
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        StringBuilder stringBuilder = new StringBuilder(longUrl);
        for (int i = 0; i < stringBuilder.length(); i++) {
            stringBuilder.replace(i, i + 1, String.valueOf((char)(stringBuilder.charAt(i) + '0')));
        }
        return stringBuilder.toString();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        StringBuilder stringBuilder = new StringBuilder(shortUrl);
        for (int i = 0; i < stringBuilder.length(); i++) {
            stringBuilder.replace(i, i + 1, String.valueOf((char)(stringBuilder.charAt(i) - '0')));
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        System.out.println(codec.decode(codec.encode("https://leetcode.com/problems/design-tinyurl")));
    }
}
