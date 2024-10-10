//package com.king.open_api.util;
//
//
//import cn.hutool.extra.tokenizer.Result;
//import cn.hutool.extra.tokenizer.TokenizerEngine;
//import cn.hutool.extra.tokenizer.TokenizerUtil;
//import cn.hutool.extra.tokenizer.Word;
//
//import com.kennycason.kumo.CollisionMode;
//import com.kennycason.kumo.WordCloud;
//import com.kennycason.kumo.WordFrequency;
//import com.kennycason.kumo.bg.RectangleBackground;
//import com.kennycason.kumo.font.KumoFont;
//import com.kennycason.kumo.font.scale.SqrtFontScalar;
//import com.kennycason.kumo.nlp.FrequencyAnalyzer;
//
//import com.kennycason.kumo.nlp.tokenizers.ChineseWordTokenizer;
//import com.kennycason.kumo.palette.ColorPalette;
//
//import java.awt.*;
//import java.io.*;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//public class JiebaUtil {
//    public static void main(String[] args) throws IOException, FontFormatException {
//
//        String s = "孙颖莎亚锦赛单项退赛。独子出走30年 父母离世后要继承遗产。潘宏训狗名场面大赏。郑钦文与对手爆发争执。国足怎么总被逆转。江秋莲回应骗捐质疑。孙颖莎退出亚锦赛。孙颖莎：胳膊肌肉出现明显反应。孙颖莎退出亚锦赛单项比赛。跑步入场的00后3天赚了3万。韩正被聘请为中国红十字会名誉会长。国乒男团vs中国台北队。主人回应狗狗在长沙走丢独自回家。徐霞客劝大家安全为首勿涉险地。民营经济促进法公开征求意见。任敏好灵。网球传奇纳达尔宣布退役。外交部回应坎贝尔相关言论。台湾从来不是也绝不可能成为一个国家。数字人民币平台发布辟谣。田姥爷去世。TES横扫DK晋级八强。日本梅毒病例激增 东京市政府出手。网球巨星纳达尔宣布退役。12306回应24元坐商务座送55元饭食。倪妮杂志封面是真蛇。加沙已是人间炼狱。孙颖莎赛中大口喘气狂捏手臂。官方辟谣三类牙膏原料成分不安全。券商人员绩效考核不得与开户数挂钩。澳大利亚3:1国足。民营经济促进法草案公开征求意见。赵露思直播间状态。3连败！国足1-3遭澳大利亚逆转。王楚钦vs高承睿。李强会见日本首相石破茂。台湾绝不可能成为一个国家！。有平台发放数字资产红利？谣言。迪丽热巴陈飞宇花海吻戏。12306回应女子高铁车厢吃螺蛳粉。到底谁还有闪电麦昆啊。香港药房没人扫货了。特斯拉发布会。习言道｜文脉越千年。女子12小时内心脏停跳20多次。郑钦文晋级八强。林高远王艺迪1比3林钟勋申裕斌。鄂LD06335死死顶住失控车辆。教育局回应小学教室翻新要家长掏钱。国乒男团vs中国台北。";
//        //去掉字符中的标点符号
//
//        List<String> strings = Arrays.asList(s.split("。"));
//         String imagePath = "C:\\Users\\12613\\Desktop\\无标题.png";
//        getWordCloud2(strings);
//
//        TokenizerEngine t = TokenizerUtil.createEngine();
//        Result r = t.parse(s);
//        List<String> list = new ArrayList<>();
//        for (Word word : r) {
//
//            list.add(word.getText());
//
//            System.out.println(word.getText());
//        }
//        System.out.println(r);
//
//
//
//    }
//
//    public static String getWordCloud2(List<String> words) throws IOException, FontFormatException {
//        FrequencyAnalyzer frequencyAnalyzer = new FrequencyAnalyzer();
//        frequencyAnalyzer.setWordFrequenciesToReturn(600);
//
//
//        // 引入中文解析器
//        frequencyAnalyzer.setWordTokenizer(new ChineseWordTokenizer());
//
//        final List<WordFrequency> wordFrequencyList = frequencyAnalyzer.load(words);
//
//        int i = words.size();
//        for (String s:words){
//            wordFrequencyList.add(new WordFrequency(s,i--));
//        }
//
//
//        // 设置图片分辨率940x400
//        Dimension dimension = new Dimension(940, 400);
//        // 此处的设置采用内置常量即可，生成词云对象
//        WordCloud wordCloud = new WordCloud(dimension, CollisionMode.PIXEL_PERFECT);
//
//        FileInputStream is =new FileInputStream(new File("" +
//                "H:\\jetbrains\\java\\open_api\\src\\main\\resources\\static\\LXGWWenKaiMono-Bold.ttf"));
//        BufferedInputStream bis = new BufferedInputStream(is);
//        java.awt.Font font = Font.createFont(Font.TRUETYPE_FONT, is);
//
//        wordCloud.setKumoFont(new KumoFont(font));
//        wordCloud.setPadding(3);
//        wordCloud.setColorPalette(new ColorPalette(new Color(0xed1941), new Color(0xf26522), new Color(0x845538), new Color(0x8a5d19), new Color(0x7f7522), new Color(0x5c7a29), new Color(0x1d953f), new Color(0x007d65), new Color(0x65c294)));
//        wordCloud.setBackground(new RectangleBackground(dimension));
//        wordCloud.setFontScalar(new SqrtFontScalar(12, 45));
//        wordCloud.setBackgroundColor(new Color(255, 255, 255));
//        // 生成词云
//        wordCloud.build(wordFrequencyList);
//        wordCloud.writeToFile("wordcloud_gradient_redbluegreen.png");
////
//        return null;
//    }
//
//
//}
//
