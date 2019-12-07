package com.luban.demo;



import com.luban.common.utils.AssertUtils;
import net.javacrumbs.jsonunit.JsonAssert;
import org.testng.annotations.Test;

import java.io.StringReader;

import static net.javacrumbs.jsonunit.JsonAssert.assertJsonPartEquals;


/**
 * @author shijin.huang
 * @date 2019-10-24
 * @content
 */
public class JsonAssertTest {

    @Test
    public void t1() {
        JsonAssert.assertJsonEquals("{\"additionName\":\"双份奶1\",\"amount\":0,\"code\":\"169\",\"count\":0,\"isMeteringLimit\":0,\"price\":0.01,\"remarkId\":169,\"showStr\":\"双份奶1\",\"typeId\":2,\"unitName\":\"\"}",
                "{\"additionName\":\"双份奶12\",\"amount\":0,\"code\":\"169\",\"count\":0,\"isMeteringLimit\":0,\"price\":0.01,\"remarkId\":169,\"showStr\":\"双份奶1\",\"typeId\":3,\"unitName\":\"\"}");
    }
    @Test
    public void t2() {
        JsonAssert.assertJsonPartNotEquals("{\"additionName\":\"双份奶1\",\"amount\":0,\"code\":\"169\",\"count\":0,\"isMeteringLimit\":0,\"price\":0.01,\"remarkId\":169,\"showStr\":\"双份奶1\",\"typeId\":2,\"unitName\":\"\"}",
                "{\"additionName\":\"双份奶1\",\"amount\":0,\"code\":\"169\",\"count\":0,\"isMeteringLimit\":123,\"price\":0.01,\"remarkId\":169,\"showStr\":\"双份奶1\",\"typeId\":3,\"unitName\":\"\"}",
                "typeId,isMeteringLimit");
    }


    @Test
    public void assertJsonTest01(){
        String json1 ="{\n" +
                "  \"array\": [\n" +
                "    1,\n" +
                "    2,\n" +
                "    3\n" +
                "  ],\n" +
                "  \"boolean\": true,\n" +
                "  \"null\": null,\n" +
                "  \"number\": 123,\n" +
                "  \"object\": {\n" +
                "    \"a\": \"b\",\n" +
                "    \"c\": \"d\",\n" +
                "    \"e\": \"f\"\n" +
                "  },\n" +
                "  \"string\": \"Hello World\"\n" +
                "}";

        String json2 ="{\n" +
                "    \"array\": [\n" +
                "        1,\n" +
                "        2,\n" +
                "        3\n" +
                "    ],\n" +
                "    \"null\": null,\n" +
                "    \"number\": 1,\n" +
                "    \"boolean\": true,\n" +
                "    \"object\": {\n" +
                "        \"a\": \"1\",\n" +
                "        \"c\": \"f\",\n" +
                "        \"e\": \"g\"\n" +
                "    },\n" +
                "    \"string\": \"Hello World\"\n" +
                "}";

//        AssertUtils.assertJsonEquals(json1,json2);
        AssertUtils.assertJsonEquals(json1,json2,"object.c","object.e","number");
//        ConfigurableJsonMatcher c=  JsonMatchers.jsonPartEquals("object.e",json2).whenIgnoringPaths("object.c","object.e");
//        JsonAssert.assertJsonEquals(json1,json2);



//        Configuration configuration=Configuration.empty().whenIgnoringPaths("object.c","object.e");
//        JsonAssert.assertJsonEquals(json1,json2, JsonAssert.whenIgnoringPaths("object.c","object.e"));
    }


    @Test
    void testAssertPartOk() {
        assertJsonPartEquals("1", "{\"test\":{\"value\":1}}", "test.value");
    }

    @Test
    void testAssertPartOkNumber() {
        assertJsonPartEquals(1, "{\"test\":{\"value\":1}}", "test.value");
    }

    @Test
    void testAssertPartOkFloat() {
        assertJsonPartEquals(1.1, "{\"test\":{\"value\":1.1}}", "test.value");
    }

    @Test
    void testAssertPartOkDouble() {
        assertJsonPartEquals(1.1d, "{\"test\":{\"value\":1.1}}", "test.value");
    }

    @Test
    void testAssertPartOkReaders() {
        assertJsonPartEquals(new StringReader("1"), new StringReader("{\"test\":{\"value\":1}}"), "test.value");
    }

    @Test
    void testAssertPartOkString() {
        assertJsonPartEquals("a b", "{\"test\":{\"value\":\"a b\"}}", "test.value");
    }
}
