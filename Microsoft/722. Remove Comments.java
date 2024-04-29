class Solution {
    private static final char slash = '/', asterisk = '*';

    public List<String> removeComments(String[] source) {
        // 存储去除注释后的代码行
        List<String> uncommentedSource = new ArrayList<>();
        // 存储单行去除注释后的代码
        StringBuilder uncommentedLine = new StringBuilder();
        // 标记是否处于块注释中
        boolean isBlockCodeComment = false;

        // 遍历源代码数组中的每一行
        for (String commentedLine : source) {
            // 将当前行转换为字符数组
            char[] line = commentedLine.toCharArray();
            int length = line.length;

            // 遍历当前行中的每个字符
            for (int index = 0; index < length; ++index) {
                // 如果当前不在块注释中，且遇到了块注释的起始符号 "/*"
                if (!isBlockCodeComment && line[index] == slash && index + 1 < length && line[index + 1] == asterisk) {
                    // 进入块注释状态
                    isBlockCodeComment = true;
                    index++;
                }
                // 如果当前在块注释中，且遇到了块注释的结束符号 "*/"
                else if (isBlockCodeComment && line[index] == asterisk && index + 1 < length
                        && line[index + 1] == slash) {
                    // 退出块注释状态
                    isBlockCodeComment = false;
                    index++;
                }
                // 如果当前不在块注释中，且遇到了单行注释的起始符号 "//"
                else if (!isBlockCodeComment && line[index] == slash && index + 1 < length
                        && line[index + 1] == slash) {
                    // 跳过当前行剩余部分，因为是单行注释
                    break;
                }
                // 如果当前不在块注释中，且当前字符不是注释符号
                else if (!isBlockCodeComment) {
                    // 将当前字符添加到去除注释后的代码行中
                    uncommentedLine.append(line[index]);
                }
            }

            // 如果不在块注释中且去除注释后的代码行不为空，则将其添加到结果列表中
            if (!isBlockCodeComment && uncommentedLine.length() != 0) {
                uncommentedSource.add(uncommentedLine.toString());
                // 重置当前行的去注释内容
                uncommentedLine.setLength(0);
            }
        }

        // 返回去除注释后的代码
        return uncommentedSource;
    }

}