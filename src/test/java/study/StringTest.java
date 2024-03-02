package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    void test1() {

        // 요구사항 1
        String str1 = "1,2";
        String[] split1 = str1.split(",");
        assertThat(split1).contains("1");
        assertThat(split1).contains("2");

        String str2 = "1";
        String[] split2 = str2.split(",");
        assertThat(split2.length).isEqualTo(1);
        assertThat(split2).contains("1");
    }

    @Test
    void test2() {
        // 요구사항 2
        String str3 = "(1,2)";
        String substring = str3.substring(1, 5);
        assertThat(substring).isEqualTo("1,2");
    }


    @Test
    void test3() {
        // 요구사항 3
        // 아오 익셉션시치 ㅋㅋ
//        String str4 = "abc";
//        assertThatThrownBy((str4.charAt()) -> { throw new Exception("boom!"); })
//                .isInstanceOf(Exception.class)
//                .hasMessageContaining("boom");
    }
}
