package test;

import java.lang.reflect.Field;
import java.util.Map;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Maps;

public class Test01 {




    enum OrderSource {
        LC(1, "11");


        private final int code;
        private final String message;
        private static final Map<Integer, OrderSource> CODE_OS_MAP = Maps.newHashMap();

        private OrderSource(int code, String description) {
            this.code = code;
            this.message = description;
        }

        public static OrderSource getByCode(int code) {
            return CODE_OS_MAP.containsKey(code) ? (OrderSource)CODE_OS_MAP.get(code) : null;
        }

        public int getCode() {
            return this.code;
        }

        public String getMessage() {
            return this.message;
        }

        public String toString() {
            return MoreObjects.toStringHelper(this).add("code", this.code).add("message", this.message).toString();
        }

        static {
            OrderSource[] var0 = values();
            int var1 = var0.length;

            for(int var2 = 0; var2 < var1; ++var2) {
                OrderSource orderSource = var0[var2];
                CODE_OS_MAP.put(orderSource.code, orderSource);
            }

        }
    }

    public static void main(String[] args) {
        OrderSource[] values = OrderSource.values();
        StringBuilder sb = new StringBuilder();
        for (OrderSource value : values) {
            sb.append("a.put(" +value.getCode()+ ",\"" + value.getMessage() + "\");\n");
        }
        System.out.println(sb);
    }

    public static void main1(String[] args) throws IllegalAccessException {
        Field[] fields = Test01.class.getFields();
        StringBuilder sb = new StringBuilder();
        for (Field field : fields) {
            sb.append("a.put(" +field.getLong(new Test01())+ ",\"" + field.getName() + "\");\n");
        }
        System.out.println(sb);

    }
}
