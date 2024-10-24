package charset;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Set;
import java.util.SortedMap;

public class AvailableCharsetsMain {

    public static void main(String[] args) {
        // 이용 가능한 모든 Charset 자바 + OS
        SortedMap<String, Charset> stringCharsetSortedMap = Charset.availableCharsets();
        for (String charsetName : stringCharsetSortedMap.keySet()) {
            System.out.println("charsetName = " + charsetName);
        }

        System.out.println("========");
        // 문자로 조히(대소문자 구분X)
        Charset charsetA = Charset.forName("unicode");
        System.out.println("charset = " + charsetA.name());
        // 별칭 조회
        Set<String> aliases = charsetA.aliases();
        for(String alias : aliases) {
            System.out.println("alias = " + alias);
        }

        // UTF-8 문자로 조회
        Charset charsetB = Charset.forName("UTF-8");
        System.out.println("charsetB = " + charsetB);

        Charset utf8 = StandardCharsets.UTF_8;
        System.out.println("utf8 = " + utf8);

        // 시스템의 기본 Charset 조회
        Charset charsetC = Charset.defaultCharset();
        System.out.println("charsetC = " + charsetC);
    }
}
