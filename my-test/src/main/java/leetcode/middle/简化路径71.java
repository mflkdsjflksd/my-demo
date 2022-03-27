package leetcode.middle;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: xs
 * @describe:
 * @date 2022/3/27 13:51
 */
public class 简化路径71 {
    @Test
    public void main() {
        simplifyPath("/home//foo/");
    }

    public String simplifyPath(String path) {
        String[] split = path.split("/");
        Deque<String> stack = new LinkedList<>();
        stack.push("/");
        for (String str : split) {
            if (str.equals("..")) {
                if (stack.size() > 1)
                    stack.pop();
            } else if ("/".equals(str)) {
                continue;
            } else if (!".".equals(str) && !"".equals(str)) {
                stack.push(str);
            }
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            String s = stack.pollLast();
            builder.append(s);
            if (!stack.isEmpty() &&!s.equals("/")) builder.append("/");
        }
        System.out.println(builder);
        return builder.toString();
    }
}
